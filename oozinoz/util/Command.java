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
 * This interface supports the Command pattern by establishing
 * a standard method, namely <code>execute()</code>. This
 * lets a service provider create a context in which a
 * command should execute, and lets a client of the service
 * create commands to plug into the service.
 * 
 * @author Steven J. Metsker
 */
public interface Command {
/**
 * This generic operation lets a service provider create
 * a context in which the implementer executes.
 */
void execute();
}
