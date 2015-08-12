package com.oozinoz.machine;

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
