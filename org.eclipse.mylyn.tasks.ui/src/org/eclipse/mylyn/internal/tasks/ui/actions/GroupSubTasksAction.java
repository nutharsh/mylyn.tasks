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

package org.eclipse.mylyn.internal.tasks.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.mylyn.internal.tasks.ui.ITasksUiPreferenceConstants;
import org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin;

/**
 * @author Rob Elves
 * @author Mik Kersten
 */
public class GroupSubTasksAction extends Action {

	public static final String ID = "org.eclipse.mylyn.tasklist.actions.filter.subtasks"; //$NON-NLS-1$

	public GroupSubTasksAction() {
		setText(Messages.GroupSubTasksAction_Group_Subtasks);
		setToolTipText(Messages.GroupSubTasksAction_Group_Subtasks);
		setId(ID);
		setChecked(TasksUiPlugin.getDefault()
				.getPreferenceStore()
				.getBoolean(ITasksUiPreferenceConstants.GROUP_SUBTASKS));
	}

	@Override
	public void run() {
		TasksUiPlugin.getDefault()
				.getPreferenceStore()
				.setValue(ITasksUiPreferenceConstants.GROUP_SUBTASKS, isChecked());
	}

}
