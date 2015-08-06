package com.oozinoz.fireworks;

import com.oozinoz.units.*;

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
