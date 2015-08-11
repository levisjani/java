package com.oozinoz.control;

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
