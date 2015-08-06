package com.oozinoz.fireworks;

import com.oozinoz.units.*;

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
 * A utility class that returns a list of fireworks we'd
 * really like to unload.
 *
 * @author Steven J. Metsker
 */
public class Promo implements UnitConstants 
{
/**
 * Return a list of fireworks that we are especially
 * interested selling.
 *
 * @return a list of fireworks that we are especially
 * interested selling
 */
public static FireworkList getPromotionalFireworks() {
	FireworkList fl = new FireworkList();
	fl.add(new Sparkler("Brightful", .35));
	fl.add(new Firecracker("Frightful", .19));
	fl.add(
		new Rocket(
			"Heightful",
			33.95,
			(Length) METER.times(300)));
	return fl;
}
}
