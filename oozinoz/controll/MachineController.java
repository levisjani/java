package com.oozinoz.control;

import com.oozinoz.machine.*;

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
 * This class shows a refactoring of its MachineController_
 * predecessor. The abstract operations are now moved out
 * into a interface for drivers.
 *
 * @author Steven J. Metsker
 *
 */
public class MachineController 
{
	protected MachineDriver driver;
/**
 * Return true if there is no more room in the input queue.
 *
 * @return true if there is no more room in the input queue
 */
public boolean inputFull()
{
	return driver.getQueueMax() >= getQueue().size();
}

	protected Queue queue = new Queue();

/**
 * Return the queue of bins waiting for this machine.
 *
 * @return the queue of bins waiting for this machine
 */
public Queue getQueue()
{
	return queue;
}
}
