/*
 * @(#)NoSuchElementException.java	1.21 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package pbnj.util;

/**
 * Thrown by the <code>nextElement</code> method of an 
 * <code>Enumeration</code> to indicate that there are no more 
 * elements in the enumeration. 
 *
 * @author  unascribed
 * @version 1.21, 12/19/03
 * @see     pbnj.util.Enumeration
 * @see     pbnj.util.Enumeration#nextElement()
 * @since   JDK1.0
 */
public
class NoSuchElementException extends RuntimeException {
    /**
     * Constructs a <code>NoSuchElementException</code> with <tt>null</tt> 
     * as its error message string.
     */
    public NoSuchElementException() {
	super();
    }

    /**
     * Constructs a <code>NoSuchElementException</code>, saving a reference 
     * to the error message string <tt>s</tt> for later retrieval by the 
     * <tt>getMessage</tt> method.
     *
     * @param   s   the detail message.
     */
    public NoSuchElementException(String s) {
	super(s);
    }
}
