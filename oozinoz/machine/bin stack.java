package com.oozinoz.machine;

import java.util.*;

public class BinStack 
{
	public static final int STACK_LIMIT = 3;
	private Stack stack = new Stack();

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
