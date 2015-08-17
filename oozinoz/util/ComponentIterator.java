package com.oozinoz.util;

import java.util.*;

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
