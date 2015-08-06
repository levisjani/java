package com.oozinoz.fireworks;

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
 * A firework that just explodes, a behavior that many
 * people find quite entertaining in itself.
 * 
 * @author Steven J. Metsker
 *
 * @version 1.0
 */
public class Firecracker extends Firework 
{
/**
 * Make a firecracker. The English call these "bangers," which
 * seems a bit more straightforward.
 *
 * @param String the firecracker's name
 * @param double the price
 */
public Firecracker(String name, double price)
{
	super(name, price);
}
}
