package com.oozinoz.machine;

import java.util.*;
import com.oozinoz.planning.*;

import com.oozinoz.util.*;
import com.oozinoz.chemical.Tub;

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
 * Represent a machine in an Oozinoz factory.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class Machine extends MachineComponent 
{


	protected Queue bins = new Queue();

/**
 * Queue up a bin for processing at this machine.
 *
 * @param Bin the bin to add
 */
public void addBin(Bin b)
{
	bins.enqueue(b);
}
/**
 * Return an object that can plan for the operational
 * behavior of this machine.
 * 
 * @return a planner for this machine
 */
public abstract MachinePlanner createPlanner();
/**
 * Return the number of machines in this machine, namely 1
 *
 * @return one, since there's only one machine here
 */
public int getMachineCount()
{
	return 1;
}





	protected MachinePlanner planner;

/**
 * Create a machine with the given id and with the supplied
 * parent machine.
 *
 * @param id the identity of this machine
 * @param parent the composite this machine belongs to
 */
public Machine(int id, MachineComponent parent)
{
	super(id, parent);
}

/**
 * Return true if there are any bins on this machine
 *
 * @return true if there are any bins on this machine
 */
public boolean hasMaterial()
{
	return !bins.isEmpty();
}

/**
 * Ask this machine to shutdown.
 */
public void shutdown()
{
	System.out.println(toString() + " shutting down");
}

/**
 * Ask this machine to start up.
 */
public void startup()
{
	System.out.println(toString() + " starting up");
}

/**
 * Remove a material bin from this machine.
 *
 * @return the removed bin
 */
public Bin unload()
{
	if (bins.isEmpty())
	{
		System.out.println(toString() + " already empty");
		return null;
	}
	Bin b = (Bin) bins.dequeue();
	System.out.println(toString() + " unloading");
	return b;
}

	protected boolean isUp = true;
	protected Mediator mediator;

/**
 * Create a machine with the given id.
 *
 * @param id the identity of this machine
 */
public Machine(int id)
{
	super(id);
}

/**
 * Create a machine with the given id and with access to the
 * mediator that will control bin/machine relations.
 *
 * @param id the identity of this machine
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 */
protected Machine(int id, Mediator mediator)
{
	this(id, mediator, null);
}

/**
 * Create a machine with the given id, with access to the
 * mediator that will control bin/machine relations, and
 * with the supplied parent machine.
 *
 * @param id the identity of this machine
 * @param Mediator the mediator that controls this machine's
 *                 relation to bins
 * @param parent the composite this machine belongs to
 */
public Machine(
	int id,
	Mediator mediator,
	MachineComponent parent)
{
	super(id, parent);
	this.mediator = mediator;
}

/**
 * This hook lets visitors add behaviors to the machine
 * composite. The point here is to call back the visitor
 * indicating the type of this node, namely Machine.
 *
 * @param visitor a visitor that will add some sort of
 *                behavior
 */
public void accept(MachineVisitor v)
{
	v.visit(this);
}

/**
 * Place a tub of chemicals at this machine.
 *
 * @param Tub the tub to add
 */
public void addTub(Tub t)
{
	mediator.set(t, this);
}

/**
 * Return a planner for this machine.
 *
 * @return a planner for this machine
 */
public MachinePlanner getPlanner()
{
	if (planner == null)
	{
		planner = createPlanner();
	}
	return planner;
}

/**
 * Return the chemical tubs that are at this machine.
 *
 * @return the chemical tubs that are at this machine
 */
public Set getTubs()
{
	return mediator.getTubs(this);
}

/**
 * Return true; individual machines are always "trees."
 *
 * @param visited ignored
 * @return true; individual machines are always "trees"
 * @see MachineComponent#isTree()
 */
protected boolean isTree(Set visited)
{
	visited.add(this);
	return true;
}

/**
 * Return true if this machine is up.
 *
 * @return true if this machine is up
 */
public boolean isUp()
{
	return isUp;
}

/**
 * Return an iterator that will "iterate over" this machine,
 * returning it once.
 *
 * @return an iterator that will "iterate over" this machine,
 *         returning it once.
 */
public ComponentIterator iterator(Set visited)
{
	return new LeafIterator(this, visited);
}

/**
 * Record whether or not this machine is up.
 *
 * @param isUp whether or not this machine is up
 */
public void setIsUp(boolean isUp)
{
	this.isUp = isUp;
}
}
