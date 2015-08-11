package com.oozinoz.control;


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
 * This class is a refactoring of ShellController that occurs
 * when you refactor the MachineController_ hierarchy to use
 * a bridge.
 *
 * @author Steven J. Metsker
 *
 */
public class ShellDriver implements MachineDriver 
{

/**
 * Return the maximum size of this machine's input queue.
 *
 * @return the maximum size of this machine's input queue
 */
public int getQueueMax() {
	return 5;
}

/**
 * Start this machine; not actually implemented.
 */
public void start()
{
}

/**
 * Stop this machine; not actually implemented.
 */
public void stop()
{
}
}
