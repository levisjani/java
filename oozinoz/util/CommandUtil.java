package com.oozinoz.util;

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
 * This class provides a utility for timing the execution
 * of a provided command.
 *
 * @author Steven J. Metsker
 *
 */
public class CommandUtil 
{
/**
 * Return the time in milliseconds that it takes to execute
 * the provided command.
 *
 * @param Command the command to execute
 * @return the time in milliseconds that it takes to execute
 *         the provided command
 */
public static long time(Command c)
{
	long t1 = System.currentTimeMillis();
	c.execute();
	long t2 = System.currentTimeMillis();
	return t2 - t1;
}
}
