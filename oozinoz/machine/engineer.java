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
 * This isn't much of a model, but it provides a data type
 * that represents the role of a person that can be
 * responsible for a machine.
 *
 * @author Steven J. Metsker
 *
 */
public class Engineer 
{
	protected int employeeId;
/**
 * Model an engineer with the given employee id.
 *
 * @param id the employee id for the engineer
 */
public Engineer(int employeeId)
{
	this.employeeId = employeeId;
}
/**
 * Return this engineer's employee id
 *
 * @return this engineer's employee id
 */
public int getEmployeeId()
{
	return employeeId;
}
}
