package com.oozinoz.io;

import java.io.*;

public class LowerCaseFilter extends OozinozFilter 
{
/**
 * Construct a filter that pass lower case characters
 * to the supplied stream.
 *
 * @param out a writer to which to pass down writes 
 */
public LowerCaseFilter(Writer out)
{
	super(out);
}
/**
 * Pass a lower case version of the supplied character
 * to the underlying stream.
 *
 * @param c the character to write
 *
 * @throws IOException if an I/O error occurs
 */
public void write(int c) throws IOException 
{
	out.write(Character.toLowerCase((char) c));
}
}
