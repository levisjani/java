package com.oozinoz.machine;

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
 * This is a minimal model of a "bin," a large plastic
 * rectangular basket that holds fireworks materials as
 * they go through the factory.
 *
 * @author Steven J. Metsker
 *
 */
public class Bin 
{
	protected String id;


/**
 * Return the machine that this bin is at or on.
 *
 * @return the machine that this bin is at or on
 */
public Machine getMachine()
{
	return machine;
}
/**
 * Set the machine that this bin is at or on.
 *
 * @param machine the machine that this bin is at or on
 */
public void setMachine(Machine machine)
{
	this.machine = machine;
}
/**
 * Return a textual representation of this bin.
 *
 * @return a textual representation of this bin
 */
public String toString()
{
	return id;
}

	protected Machine machine;

/**
 * Create a bin with the given id.
 *
 * @param id the identity of this bin
 */
public Bin(String id)
{
	this.id = id;
}
}
