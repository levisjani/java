package com.oozinoz.control;

public interface MachineDriver {

/**
 * Return the maximum size of this machine's input queue.
 *
 * @return the maximum size of this machine's input queue
 */
int getQueueMax();

/**
 * Start this machine.
 */
public abstract void start();

/**
 * Stop this machine.
 */
public abstract void stop();
}
