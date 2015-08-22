package com.oozinoz.ui;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

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
 * This class shows the idea of establishing user
 * interface kits with prototypical components.
 * 
 * @author Steven J. Metsker
 */
public class UIKit 
{
	protected OzButton button = new OzButton();
	protected OzTextArea textArea = new OzTextArea();
/**
 * Return a (copy of a prototypical) button.
 *
 * @return a (copy of a prototypical) button
 */
public JButton createButton(String text)
{
	JButton b = new JButton(text);
	b.setFont(button.getFont());
	return b;
}
/**
 * Return a (copy of a prototypical) text area.
 *
 * @return a (copy of a prototypical) text area
 */
public OzTextArea createTextArea()
{
	return (OzTextArea) textArea.clone();
}
/**
 * Return a kit for full-screen user interfaces.
 *
 * @return a kit for full-screen user interfaces
 */
public static UIKit fullScreen()
{
	Font f = new Font("Dialog", Font.ITALIC, 18);
	UIKit k = new UIKit();
	k.button.setFont(f);
	k.textArea.setFont(f);
	return k;
}
/**
 * Return a kit for handheld device user interfaces.
 *
 * @return a kit for handheld device user interfaces
 */
public static UIKit handheld()
{
	UIKit k = new UIKit();
	Font f = new Font("Dialog", Font.PLAIN, 8);
	k.button.setFont(f);
	k.textArea = new OzTextArea();
	k.textArea.setFont(f);
	Cursor c = new Cursor(Cursor.HAND_CURSOR);
	k.textArea.setCursor(c);
	return k;
}
}
