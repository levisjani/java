package com.oozinoz.function;

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
 * Provide a "function" that ignores the time t parameter
 * and always returns a constant value.
 * 
 * @author Steven J. Metsker
 */
public class Constant extends Function 
{
	private double constant;
/**
 * Construct a "function" that ignores the time t parameter
 * and always returns a constant value.
 */
public Constant(double constant)
{
	super(new Function[0]);
	this.constant = constant;
}

/**
 * Return this object's constant value.
 *
 * @param t ignored
 *
 * @return this object's constant value
 */
public double f(double t)
{
	return constant;
}

}
