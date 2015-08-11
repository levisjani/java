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
 * This interface defines the abstract operations that a
 * machine controller needs.
 *
 * @author Steven J. Metsker
 *
 */
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
