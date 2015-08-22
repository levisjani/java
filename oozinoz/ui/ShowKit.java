package com.oozinoz.ui;

import java.awt.*;

import javax.swing.*;

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
 * Show how a class might construct higher-level components
 * from buttons and text areas in a component kit.
 * 
 * @author Steven J. Metsker
 */
public class ShowKit 
{
/**
 * Return a "cross sales" panel that supports selling
 * Oozinoz customers something other than what they
 * called (or clicked) about.
 *
 * @return a "cross sales" panel that supports selling
 *         Oozinoz customers something other than what they
 *         called (or clicked) about
 */
public static JPanel crossSales(UIKit k)
{
	JPanel p = new JPanel();
	p.setLayout(new BorderLayout());
	p.add(k.createButton("Clear"), "South");
	OzTextArea t = k.createTextArea();
	t.append(" 1) Consult the recommendation list.\n");
	t.append(" 2) Establish customer interest.\n");
	t.append(" 3) Close the sale.\n");
	p.add(t, "Center");
	return p;
}
/**
 * Show how a class might construct higher-level components
 * from buttons and text areas in a component kit.
 */
public static void main(String[] args)
{
	UIKit k = UIKit.handheld();
	JPanel p = ShowKit.crossSales(k);
	SwingFacade.launch(p, " Oozinoz Cross Sales");
}
}
