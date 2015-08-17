package com.oozinoz.util;

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
