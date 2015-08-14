package com.oozinoz.io;

import java.io.*;

public abstract class OozinozFilter extends FilterWriter 
{
protected OozinozFilter(Writer out)
{
	super(out);
}
/**
 * Write a portion of an array of characters.
 *
 * @param cbuf Buffer of characters to be written
 * @param  off Offset from which to start reading characters
 * @param  len Number of characters to be written
 *
 * @throws IOException if an I/O error occurs
 */
public void write(char cbuf[], int off, int len)
	throws IOException {
	for (int i = 0; i < len; i++)
	{
		write(cbuf[off + i]);
	}
}
/**
 * Write a single character.
 *
 * @throws IOException if an I/O error occurs
 */
public abstract void write(int c) throws IOException;

public void write(String s, int off, int len)
throws IOException 
{
	write(s.toCharArray(), off, len);
}
}
