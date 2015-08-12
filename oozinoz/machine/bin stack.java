package com.oozinoz.machine;

import java.util.*;

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
 * 
 * Represent a stack of bins, limited in height by the reach
 * of a track robot.
 * <p>
 * The "Introducing Extensions" chapter of "The Design Patterns 
 * Java Workbook" uses this class.
 * 
 * @author Steven J. Metsker
 */
public class BinStack 
{
	public static final int STACK_LIMIT = 3;
	private Stack stack = new Stack();
/**
 * Remove and return the top of the stack. This method
 * will wait if the stack is empty.
 *
 * @return top of the stack
 */
synchronized public Bin pop()
{
	while (stack.size() == 0)
	{
		try
		{
			wait();
			// don't snatch away a bin before the user sees it
			Thread.sleep(500);
		}
		catch (InterruptedException ignore)
		{
		}
	}
	if (stack.size() == STACK_LIMIT)
	{
		notify();
	}
	return (Bin) stack.pop();
}
/**
 * Add the provided bin to the top of the stack. This method
 * will wait if the stack is full.
 *
 * @param Bin the bin to stack
 */
synchronized public void push(Bin b)
{
	while (stack.size() == STACK_LIMIT)
	{
		try
		{
			wait();
			// don't snatch replace a bin before the user sees
			// a space for it
			Thread.sleep(500);
		}
		catch (InterruptedException ignore)
		{
		}
	}
	if (stack.size() == 0)
	{
		notify();
	}
	stack.push(b);
}
/**
 * Return the size of the stack.
 *
 * @return the size of the stack
 */
public int size()
{
	return stack.size();
}
}
