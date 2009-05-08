/*******************************************************************************
 * Copyright (c) 2004, 2008 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.tasks.core.sync;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.commons.net.Policy;
import org.eclipse.mylyn.internal.tasks.core.ITasksCoreConstants;
import org.eclipse.mylyn.internal.tasks.core.ITasksCoreConstants.MutexSchedulingRule;
import org.eclipse.mylyn.internal.tasks.core.data.TaskDataManager;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.RepositoryResponse;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.AbstractTaskAttachmentHandler;
import org.eclipse.mylyn.tasks.core.data.AbstractTaskAttachmentSource;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.eclipse.mylyn.tasks.core.sync.SubmitJob;

/**
 * @author Steffen Pingel
 */
public class SubmitTaskAttachmentJob extends SubmitJob {

	private final TaskAttribute attachmentAttribute;

	private final String comment;

	private final AbstractRepositoryConnector connector;

	private IStatus error;

	private final AbstractTaskAttachmentSource source;

	private final ITask task;

	private final TaskRepository taskRepository;

	private final TaskDataManager taskDataManager;

	public SubmitTaskAttachmentJob(TaskDataManager taskDataManager, AbstractRepositoryConnector connector,
			TaskRepository taskRepository, ITask task, AbstractTaskAttachmentSource source, String comment,
			TaskAttribute attachmentAttribute) {
		super("Submitting Attachment"); //$NON-NLS-1$
		this.taskDataManager = taskDataManager;
		this.connector = connector;
		this.taskRepository = taskRepository;
		this.task = task;
		this.source = source;
		this.comment = comment;
		this.attachmentAttribute = attachmentAttribute;
		setRule(new MutexSchedulingRule());
	}

	@Override
	public RepositoryResponse getResponse() {
		return null;
	}

	@Override
	public IStatus getStatus() {
		return error;
	}

	@Override
	public ITask getTask() {
		return task;
	}

	@Override
	public IStatus run(IProgressMonitor monitor) {
		final AbstractTaskAttachmentHandler attachmentHandler = connector.getTaskAttachmentHandler();
		if (attachmentHandler == null) {
			error = new Status(IStatus.ERROR, ITasksCoreConstants.ID_PLUGIN,
					"The task repository does not support attachments."); //$NON-NLS-1$
			return Status.OK_STATUS;
		}
		try {
			monitor.beginTask(Messages.SubmitTaskAttachmentJob_Submitting_attachment,
					2 * (1 + getSubmitJobListeners().length) * 100);
			monitor.subTask(Messages.SubmitTaskAttachmentJob_Sending_data);
			attachmentHandler.postContent(taskRepository, task, source, comment, attachmentAttribute,
					Policy.subMonitorFor(monitor, 100));
			fireTaskSubmitted(monitor);
			monitor.subTask(Messages.SubmitTaskAttachmentJob_Updating_task);
			TaskData taskData = connector.getTaskData(taskRepository, task.getTaskId(), Policy.subMonitorFor(monitor,
					100));
			taskDataManager.putUpdatedTaskData(task, taskData, true);
			fireTaskSynchronized(monitor);
		} catch (CoreException e) {
			error = e.getStatus();
		} catch (OperationCanceledException e) {
			return Status.CANCEL_STATUS;
		} finally {
			monitor.done();
		}
		fireDone();
		return Status.OK_STATUS;
	}

}