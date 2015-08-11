package com.oozinoz.control;

import com.oozinoz.machine.*;

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
