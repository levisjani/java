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
 * Objects of this class represent types of fireworks.
 * 
 * @author Steven J. Metsker
 */
public class Firework
implements ClassificationConstants 
{
	protected String name;
	protected Classification classification;


/**
 * Returns this firework's classification.
 *
 * @return this firework's classification
 */
public Classification getClassification()
{
	return classification;
}
/**
 * Set this firework's classification.
 *
 * @param Classification this firework's classification
 */
public void setClassification(Classification classification)
{
	this.classification = classification;
}

	protected double price;

/**
 * Construct a firework with the given name.
 *
 * @param String the name of the firework
 * @param double the price of the firework
 */
public Firework(String name, double price) 
{
	this(name, price, DISPLAY);
}

/**
 * Construct a firework with the given name and classification.
 *
 * @param String the name of the firework
 * @param double the price of the firework
 * @param Classification the classification of the 
 *                       firework
 */
public Firework(
	String name,
	double price,
	Classification classification)
{
	this.name = name;
	this.price = price;
	this.classification = classification;
}

/**
 * This method exists mainly to show what can happen when
 * a subclass shadows a static method. See "Introducing
 * Operations" in "The Design Patterns Java Workbook."
 */
public static boolean flies()
{
	return false;
}

/**
 * Return the name of this firework
 *
 * @return the name of this firework
 */
public String getName()
{
	return name;
}

/**
 * Return the price of this firework
 *
 * @return the price of this firework
 */
public double getPrice()
{
	return price;
}

/**
 * Return a random firework from our shelves.
 *
 * @return a random firework from our shelves; not actually 
 *         implemented
 */
public static Firework getRandom()
{
	return null;
}

/**
 * Return the type of this firework, essentially the
 * class's name.
 *
 * @return the type of this firework, essentially the
 *         class's name
 */
public String getType()
{
	String s = getClass().getName();
	return s.substring(s.lastIndexOf('.') + 1);
}

/**
 * Return a firework of the given name.
 *
 * @param name a name to lookup
 * @return a firework of the given name; not actually 
 *         implemented
 */
public static Firework lookup(String name)
{
	return new Firework("demo", 0);
}
}
