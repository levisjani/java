package com.oozinoz.io;

import java.io.*;
import java.util.*;

public class WrapFilter extends OozinozFilter 
{
	protected int lineLength;
	protected StringBuffer lineBuf = new StringBuffer();
	protected StringBuffer wordBuf = new StringBuffer();
	protected boolean center = false;
	protected boolean inWhite = false;
	protected boolean needBlank = false;
/**
 * Construct a filter that will wrap its writes at the
 * specified length.
 *
 * @param out a writer to which to pass down writes
 *
 * @param lineLength the length at which to wrap text
 */
public WrapFilter(BufferedWriter out, int lineLength)
{
	super(out);
	this.lineLength = lineLength;
}
/**
 * Flush and close the stream.
 *
 * @throws IOException if an I/O error occurs
 */
public void close() throws IOException 
{
	flush();
	out.close();
}
/**
 * Write out any characters that were being held, 
 * awaiting a full line.
 *
 * @throws IOException if an I/O error occurs
 */
public void flush() throws IOException 
{
	if (wordBuf.length() > 0)
	{
		postWord();
	}
	if (lineBuf.length() > 0)
	{
		postLine();
	}
	out.flush();
}
/*
 * Write out the characters in the line buffer, 
 * optionally centering this output.
 */
protected void postLine() throws IOException 
{
	if (center)
	{
		char[] skootch =
			new char[(lineLength - lineBuf.length()) / 2];
		Arrays.fill(skootch, ' ');
		out.write(skootch);
	}
	out.write(lineBuf.toString());
}
/*
 * Add the word buffer to the line buffer, unless this
 * would make the line buffer too long. In that case, 
 * post the line buffer and then reset the line buffer 
 * to the word buffer. 
 */
protected void postWord() throws IOException 
{
	if (lineBuf.length() + 1 + wordBuf.length() > lineLength)
	{
		postLine();
		((BufferedWriter) out).newLine();
		lineBuf = wordBuf;
		wordBuf = new StringBuffer();
	}
	else
	{
		if (needBlank)
		{
			lineBuf.append(" ");
		}
		lineBuf.append(wordBuf);
		needBlank = true;
		wordBuf = new StringBuffer();
	}
}
/**
 * Decide whether or not to center the output.
 *
 * @param center If true, output text will 
 *               be centered.
 */
public void setCenter(boolean center)
{
	this.center = center;
}
/**
 * @param c the character to write
 *
 * @throws IOException if an I/O error occurs
 */
public void write(int c) throws IOException 
{
	if (Character.isWhitespace((char) c))
	{
		if (!inWhite)
		{
			postWord();
		}
		inWhite = true;
	}
	else
	{
		wordBuf.append((char) c);
		inWhite = false;
	}
}
}
