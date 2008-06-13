/*******************************************************************************
 * Copyright (c) 2004, 2007 Mylyn project committers and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.eclipse.mylyn.bugzilla.deprecated;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Platform;
import org.eclipse.mylyn.internal.bugzilla.core.BugzillaCorePlugin;
import org.eclipse.mylyn.internal.bugzilla.core.BugzillaAttribute;
import org.eclipse.mylyn.internal.bugzilla.core.IBugzillaConstants;
import org.eclipse.mylyn.internal.tasks.core.deprecated.AbstractLegacyRepositoryConnector;
import org.eclipse.mylyn.internal.tasks.core.deprecated.AbstractTaskDataHandler;
import org.eclipse.mylyn.internal.tasks.core.deprecated.RepositoryTaskData;
import org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.core.TaskRepository;


/**
 * @author Mik Kersten
 * @author Ian Bull
 */
public class NewBugWizardTest extends TestCase {

	public void testPlatformOptions() throws Exception {

		RepositoryTaskData newReport = new RepositoryTaskData(new BugzillaAttributeFactory(),
				BugzillaCorePlugin.CONNECTOR_KIND, IBugzillaConstants.TEST_BUGZILLA_220_URL, "1");

		TaskRepository repository = new TaskRepository(BugzillaCorePlugin.CONNECTOR_KIND,
				IBugzillaConstants.TEST_BUGZILLA_220_URL);
		AbstractLegacyRepositoryConnector connector = (AbstractLegacyRepositoryConnector) TasksUiPlugin.getRepositoryManager()
				.getRepositoryConnector(repository.getConnectorKind());
		assertNotNull(connector);
		AbstractTaskDataHandler taskDataHandler = connector.getLegacyTaskDataHandler();
		assertNotNull(taskDataHandler);
		taskDataHandler.initializeTaskData(repository, newReport, null);
		BugzillaCorePlugin.getDefault().setPlatformOptions(newReport);

		String os = Platform.getOS();
		if (os.equals("win32")) {
			assertEquals("Windows", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("solaris")) {
			assertEquals("Solaris", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("qnx")) {
			assertEquals("QNX-Photon", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("macosx")) {
			assertEquals("Mac OS", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("linux")) {
			assertEquals("Linux", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("hpux")) {
			assertEquals("HP-UX", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		} else if (os.equals("aix")) {
			assertEquals("AIX", newReport.getAttribute(BugzillaAttribute.OP_SYS.getKey()).getValue());
		}

		String platform = Platform.getOSArch();
		if (platform.equals("x86")) {
			if (os.equals("macosx")) {
				assertEquals("Macintosh", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey())
						.getValue());
			} else {
				assertEquals("PC", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey()).getValue());
			}
		} else if (platform.equals("x86_64")) {
			assertEquals("PC", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey()).getValue());
		} else if (platform.equals("ia64")) {
			assertEquals("PC", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey()).getValue());
		} else if (platform.equals("ia64_32")) {
			assertEquals("PC", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey()).getValue());
		} else if (platform.equals("sparc")) {
			assertEquals("Sun", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey()).getValue());
		} else if (platform.equals("ppc")) {
			if (os.equals("macosx")) {
				assertEquals("Macintosh", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey())
						.getValue());
			} else {
				assertEquals("Power", newReport.getAttribute(BugzillaAttribute.REP_PLATFORM.getKey())
						.getValue());
			}
		}
	}

}