package com.oozinoz.util;

import java.util.*;

/*
 * Copyright (c) 2001 Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */
 
/**
 * This is the abstract superclass of iterators that can
 * walk across leaf nodes and composite nodes in a
 * composite structure.
 * <p>
 * The depth of an iterator is, for the current iteration, 
 * the number of iterators above it. A typical iterator 
 * walks over a composite, iterating over each child. Each 
 * child, however, may also be a composite, so iterating 
 * over a child means iterating over a child's children. In 
 * a tree structure, the root iterator will at any point be 
 * iterating over one of its children. This child will be 
 * iterating over its children. This recurses down to 
 * component that is either a leaf or it a node that has 
 * been visited before. The depth of iteration, then, is 
 * the depth of a subiterator plus one.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class ComponentIterator 
{


	protected Object node;
	protected boolean showInterior = true;
	protected Set visited = new HashSet();

/**
 * Create an iterator over a node in a composite.
 *
 * @param node the node to iterate over
 * @param visited a set to track visited nodes
 */
public ComponentIterator(Object node, Set visited)
{
	this.node = node;
	this.visited = visited;
}

/**
 * Return the current depth of the iteration
 *
 * @return the current depth of the iteration (that is, for
 *         the current node the number of nodes above it)
 */
public abstract int depth();

/**
 * Return true if there is another node to see
 *
 * @return true if there is another node to see
 */
public abstract boolean hasNext();

/**
 * Return the next node in the iteration
 *
 * @return the next node in the iteration
 */
public abstract Object next();

/**
 * Determine whether interior (non-leaf) nodes should
 * appear in iteration.
 *
 * @param boolean if true, interior nodes can be returned
 *                from next()
 */
public void setShowInterior(boolean showInterior)
{
	this.showInterior = showInterior;
}
}
