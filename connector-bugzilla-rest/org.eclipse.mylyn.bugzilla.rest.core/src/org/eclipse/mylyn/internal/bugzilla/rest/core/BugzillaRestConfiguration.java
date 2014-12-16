/*******************************************************************************
 * Copyright (c) 2013 Frank Becker and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frank Becker - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.bugzilla.rest.core;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.mylyn.internal.bugzilla.rest.core.response.data.Field;
import org.eclipse.mylyn.internal.bugzilla.rest.core.response.data.Parameters;
import org.eclipse.mylyn.internal.bugzilla.rest.core.response.data.Product;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

public class BugzillaRestConfiguration implements Serializable {

	private static final long serialVersionUID = 4078343382335204804L;

	private final String repositoryId;

	private Map<String, Field> fields;

	private Map<String, Product> products;

	private Parameters parameters;

	public BugzillaRestConfiguration(String repositoryId) {
		this.repositoryId = repositoryId;
	}

	public String getRepositoryId() {
		return repositoryId;
	}

	void setFields(Map<String, Field> fields) {
		Function<Field, String> getName = new Function<Field, String>() {
			public String apply(Field item) {
				return item.getName();
			}
		};
		Function<String, String> comparatorFunction = Functions.compose(getName, Functions.forMap(fields));
		Ordering<String> comparator = Ordering.natural().onResultOf(comparatorFunction);
		this.fields = ImmutableSortedMap.copyOf(fields, comparator);
	}

	public Map<String, Field> getFields() {
		return fields;
	}

	public Field getFieldWithName(String fieldName) {
		return fields.get(fieldName);
	}

	void setProducts(Map<String, Product> products) {
		Function<Product, String> getName = new Function<Product, String>() {
			public String apply(Product item) {
				return item.getName();
			}
		};
		Function<String, String> comparatorFunction = Functions.compose(getName, Functions.forMap(products));
		Ordering<String> comparator = Ordering.natural().onResultOf(comparatorFunction);
		this.products = ImmutableSortedMap.copyOf(products, comparator);
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public Product getProductWithName(String productName) {
		return products.get(productName);
	}

	void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public Parameters getParameters() {
		return parameters;
	}

}
