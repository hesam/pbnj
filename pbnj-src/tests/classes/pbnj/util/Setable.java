/*
 * @(#)Setable.java	1.49 04/06/28
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.

 * Hesam Samimi

 */

package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJSet;

public interface Setable<E>  {
    PBJSet<E> toSet();
}
