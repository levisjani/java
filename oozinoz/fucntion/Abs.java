package com.oozinoz.function;

public class Abs extends Function 
{

/**
 * Construct an absolute value function that decorates the 
 * provided source function.
 *
 * @param Function the source function that this function
 *                 wraps
 */
public Abs(Function f)
{
	super(f);
}
/**
 * Return Math.abs() applied to the source function's value
 * at time t.
 *
 * @param t the time function that goes 0 to 1 and that
 *          other functions use as a parameter
 *
 * @return Math.abs() applied to the source function's value
 *         at time t.
 */
public double f(double t)
{
	return Math.abs(source[0].f(t));
}
}
