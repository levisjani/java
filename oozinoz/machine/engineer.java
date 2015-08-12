package com.oozinoz.machine;

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
