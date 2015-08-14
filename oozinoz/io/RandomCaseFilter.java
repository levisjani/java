package com.oozinoz.io;

import java.io.*;

public class RandomCaseFilter extends OozinozFilter 
{
/**
 * Construct a filter that pass randomly-cased characters
 * to the supplied stream.
 *
 * @param out a writer to which to pass down writes 
 */
public RandomCaseFilter(Writer out)
{
	super(out);
}
/**
 * Pass a randomly-cased version of the supplied character
 * to the underlying stream.
 *
 * @param c the character to write
 *
 * @throws IOException if an I/O error occurs
 */
public void write(int c) throws IOException 
{
	out.write(
		Math.random() > .5
			? Character.toLowerCase((char) c)
			: Character.toUpperCase((char) c));
}
}
