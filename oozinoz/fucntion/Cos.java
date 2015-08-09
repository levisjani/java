package com.oozinoz.function;

public class Cos extends Function 
{

/**
 * @param Function the source function that this function
 *                 wraps
 */
public Cos(Function f)
{
	super(f);
}
/**
 * Return Math.cos() applied to the source function's value
 * at time t.
 * @return Math.cos() applied to the source function's value
 *         at time t.
 */
public double f(double t)
{
	return Math.cos(source[0].f(t));
}
}
