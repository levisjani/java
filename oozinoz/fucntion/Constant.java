package com.oozinoz.function;

public class Constant extends Function 
{
	private double constant;

public Constant(double constant)
{
	super(new Function[0]);
	this.constant = constant;
}

/**
 * @param t ignored
 *
 * @return this object's constant value
 */
public double f(double t)
{
	return constant;
}

}
