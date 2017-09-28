/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.vulcan.consumer;

import java.util.Objects;

/**
 * Represents an operation that accepts three input arguments and returns no
 * result. This is the three-arity specialization of {@link
 * java.util.function.Consumer}. Unlike most other functional interfaces, {@code
 * TriConsumer} is expected to operate via side-effects.
 *
 * <p>This is a <a
 * href="http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">functional
 * interface</a>
 * whose functional method is {@link #accept(Object, Object, Object)}.
 *
 * @author Alejandro Hernández
 * @see    java.util.function.Consumer
 * @review
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param  a the first input argument.
	 * @param  b the second input argument.
	 * @param  c the third input argument.
	 * @review
	 */
	public void accept(A a, B b, C c);

	/**
	 * Returns a composed {@code TriConsumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing this operation throws an exception, the
	 * {@code after} operation will not be performed.
	 *
	 * @param  after the operation to perform after this operation
	 * @return a composed {@code TriConsumer} that performs in sequence this
	 *         operation followed by the {@code after} operation
	 * @review
	 */
	public default TriConsumer<A, B, C> andThen(
		TriConsumer<? super A, ? super B, ? super C> after) {

		Objects.requireNonNull(after);

		return (a, b, c) -> {
			accept(a, b, c);
			after.accept(a, b, c);
		};
	}

}