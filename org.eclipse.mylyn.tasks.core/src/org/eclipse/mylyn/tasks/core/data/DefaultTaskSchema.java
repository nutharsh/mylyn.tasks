/*******************************************************************************
 * Copyright (c) 2009, 2010 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.tasks.core.data;

import org.eclipse.mylyn.internal.tasks.core.data.Messages;

/**
 * Specifies types and other properties for commonly used task fields.
 * 
 * @author Steffen Pingel
 * @since 3.5
 */
public final class DefaultTaskSchema extends AbstractTaskSchema {

	private static final DefaultTaskSchema instance = new DefaultTaskSchema();

	public static Field getField(String taskKey) {
		return instance.getFieldByKey(taskKey);
	}

	public static DefaultTaskSchema getInstance() {
		return instance;
	}

	public final Field ADD_SELF_CC = createField(TaskAttribute.ADD_SELF_CC,
			Messages.DefaultTaskSchema_Add_Self_to_CC_Label, TaskAttribute.TYPE_BOOLEAN);

	public final Field ATTACHMENT_AUTHOR = createField(TaskAttribute.ATTACHMENT_AUTHOR,
			Messages.DefaultTaskSchema_Author_Label, TaskAttribute.TYPE_PERSON);

	public final Field ATTACHMENT_CONTENT_TYPE = createField(TaskAttribute.ATTACHMENT_CONTENT_TYPE,
			Messages.DefaultTaskSchema_Content_Type_Label, TaskAttribute.TYPE_SHORT_TEXT);

	public final Field ATTACHMENT_DATE = createField(TaskAttribute.ATTACHMENT_DATE,
			Messages.DefaultTaskSchema_Created_Label, TaskAttribute.TYPE_DATETIME, Flag.READ_ONLY);

	public final Field ATTACHMENT_DESCRIPTION = createField(TaskAttribute.ATTACHMENT_DESCRIPTION,
			Messages.DefaultTaskSchema_Description_Label, TaskAttribute.TYPE_SHORT_RICH_TEXT);

	public final Field ATTACHMENT_FILENAME = createField(TaskAttribute.ATTACHMENT_FILENAME,
			Messages.DefaultTaskSchema_Filename_Label, TaskAttribute.TYPE_SHORT_TEXT);

	public final Field ATTACHMENT_ID = createField(TaskAttribute.ATTACHMENT_ID, Messages.DefaultTaskSchema_ID_Label,
			TaskAttribute.TYPE_SHORT_TEXT, Flag.READ_ONLY);

	public final Field ATTACHMENT_IS_DEPRECATED = createField(TaskAttribute.ATTACHMENT_IS_DEPRECATED,
			Messages.DefaultTaskSchema_Deprecated_Label, TaskAttribute.TYPE_BOOLEAN);

	public final Field ATTACHMENT_IS_PATCH = createField(TaskAttribute.ATTACHMENT_IS_PATCH,
			Messages.DefaultTaskSchema_Patch_Label, TaskAttribute.TYPE_BOOLEAN);

	public final Field ATTACHMENT_REPLACE_EXISTING = createField(TaskAttribute.ATTACHMENT_REPLACE_EXISTING,
			Messages.DefaultTaskSchema_Replace_existing_attachment, TaskAttribute.TYPE_BOOLEAN);

	public final Field ATTACHMENT_SIZE = createField(TaskAttribute.ATTACHMENT_SIZE,
			Messages.DefaultTaskSchema_Size_Label, TaskAttribute.TYPE_LONG, Flag.READ_ONLY);

	public final Field ATTACHMENT_URL = createField(TaskAttribute.ATTACHMENT_URL, Messages.DefaultTaskSchema_URL_Label,
			TaskAttribute.TYPE_URL);

	public final Field COMMENT_ATTACHMENT_ID = createField(TaskAttribute.COMMENT_ATTACHMENT_ID,
			Messages.DefaultTaskSchema_Attachment_ID_Label, TaskAttribute.TYPE_SHORT_TEXT, Flag.READ_ONLY);

	public final Field COMMENT_AUTHOR = createField(TaskAttribute.COMMENT_AUTHOR,
			Messages.DefaultTaskSchema_Author_Label, TaskAttribute.TYPE_PERSON, Flag.READ_ONLY);

	public final Field COMMENT_DATE = createField(TaskAttribute.COMMENT_DATE, Messages.DefaultTaskSchema_Created_Label,
			TaskAttribute.TYPE_DATETIME, Flag.READ_ONLY);

	public final Field COMMENT_HAS_ATTACHMENT = createField(TaskAttribute.COMMENT_HAS_ATTACHMENT,
			Messages.DefaultTaskSchema_Attachment_Label, TaskAttribute.TYPE_BOOLEAN, Flag.READ_ONLY);

	/**
	 * @since 3.6
	 */
	public final Field COMMENT_ISPRIVATE = createField(TaskAttribute.COMMENT_ISPRIVATE,
			Messages.DefaultTaskSchema_Private_Label, TaskAttribute.TYPE_BOOLEAN);

	public final Field COMMENT_NUMBER = createField(TaskAttribute.COMMENT_NUMBER,
			Messages.DefaultTaskSchema_Number_Label, TaskAttribute.TYPE_INTEGER, Flag.READ_ONLY);

	public final Field COMMENT_TEXT = createField(TaskAttribute.COMMENT_TEXT,
			Messages.DefaultTaskSchema_Description_Label, TaskAttribute.TYPE_LONG_RICH_TEXT, Flag.READ_ONLY);

	public final Field COMMENT_URL = createField(TaskAttribute.COMMENT_URL, Messages.DefaultTaskSchema_URL_Label,
			TaskAttribute.TYPE_URL, Flag.READ_ONLY);

	public final Field COMPONENT = createField(TaskAttribute.COMPONENT, Messages.DefaultTaskSchema_Component_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.ATTRIBUTE);

	public final Field DATE_COMPLETION = createField(TaskAttribute.DATE_COMPLETION,
			Messages.DefaultTaskSchema_Completion_Label, TaskAttribute.TYPE_DATE, Flag.READ_ONLY);

	public final Field DATE_CREATION = createField(TaskAttribute.DATE_CREATION,
			Messages.DefaultTaskSchema_Created_Label, TaskAttribute.TYPE_DATE, Flag.READ_ONLY);

	public final Field DATE_DUE = createField(TaskAttribute.DATE_DUE, Messages.DefaultTaskSchema_Due_Label,
			TaskAttribute.TYPE_DATE);

	public final Field DATE_MODIFICATION = createField(TaskAttribute.DATE_MODIFICATION,
			Messages.DefaultTaskSchema_Modified_Label, TaskAttribute.TYPE_DATE, Flag.READ_ONLY);

	public final Field DESCRIPTION = createField(TaskAttribute.DESCRIPTION,
			Messages.DefaultTaskSchema_Description_Label, TaskAttribute.TYPE_LONG_RICH_TEXT);

	public final Field KEYWORDS = createField(TaskAttribute.KEYWORDS, Messages.DefaultTaskSchema_Keywords_Label,
			TaskAttribute.TYPE_MULTI_SELECT, Flag.ATTRIBUTE);

	public final Field NEW_COMMENT = createField(TaskAttribute.COMMENT_NEW, Messages.DefaultTaskSchema_Rank_Label,
			TaskAttribute.TYPE_LONG_RICH_TEXT);

	public final Field PRIORITY = createField(TaskAttribute.PRIORITY, Messages.DefaultTaskSchema_Priority_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.ATTRIBUTE);

	public final Field PRODUCT = createField(TaskAttribute.PRODUCT, Messages.DefaultTaskSchema_Product_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.ATTRIBUTE);

	public final Field RANK = createField(TaskAttribute.RANK, Messages.DefaultTaskSchema_Rank_Label,
			TaskAttribute.TYPE_INTEGER, Flag.READ_ONLY);

	public final Field RESOLUTION = createField(TaskAttribute.RESOLUTION, Messages.DefaultTaskSchema_Resolution_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.READ_ONLY);

	public final Field SEVERITY = createField(TaskAttribute.SEVERITY, Messages.DefaultTaskSchema_Severity_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.ATTRIBUTE);

	public final Field STATUS = createField(TaskAttribute.STATUS, Messages.DefaultTaskSchema_Status_Label,
			TaskAttribute.TYPE_SHORT_TEXT, Flag.READ_ONLY);

	public final Field SUMMARY = createField(TaskAttribute.SUMMARY, Messages.DefaultTaskSchema_Summary_Label,
			TaskAttribute.TYPE_SHORT_RICH_TEXT);

	public final Field TASK_KEY = createField(TaskAttribute.TASK_KEY, Messages.DefaultTaskSchema_Key_Label,
			TaskAttribute.TYPE_SHORT_TEXT, Flag.READ_ONLY);

	public final Field TASK_KIND = createField(TaskAttribute.TASK_KIND, Messages.DefaultTaskSchema_Kind_Label,
			TaskAttribute.TYPE_SINGLE_SELECT, Flag.ATTRIBUTE);

	public final Field USER_ASSIGNED = createField(TaskAttribute.USER_ASSIGNED, Messages.DefaultTaskSchema_Owner_Label,
			TaskAttribute.TYPE_PERSON, Flag.PEOPLE);

	public final Field USER_REPORTER = createField(TaskAttribute.USER_REPORTER,
			Messages.DefaultTaskSchema_Reporter_Label, TaskAttribute.TYPE_PERSON, Flag.PEOPLE, Flag.READ_ONLY);

	public final Field TASK_URL = createField(TaskAttribute.TASK_URL, Messages.DefaultTaskSchema_URL_Label,
			TaskAttribute.TYPE_URL, Flag.READ_ONLY);

	/**
	 * @since 3.7
	 */
	public final Field COMMENT_ID = createField(TaskAttribute.COMMENT_ID, Messages.DefaultTaskSchema_ID, TaskAttribute.TYPE_INTEGER,
			Flag.READ_ONLY);

}
