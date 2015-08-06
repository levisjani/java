package com.oozinoz.fireworks;

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

public static Firework lookup(String name)
{
	return new Firework("demo", 0);
}
}
