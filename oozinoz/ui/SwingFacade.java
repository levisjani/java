package com.oozinoz.ui;

//import com.sun.java.swing.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;

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
 * This utility class provides an interface that makes the 
 * Swing subsystem easy to use.
 * 
 * @author Steven J. Metsker
 */
public class SwingFacade 
{
/**
 * Create a titled border with the given title.
 *
 * @param title the words to show in the title border tab
 * @return a (beveled) titled border with the given title
 */
public static TitledBorder createTitledBorder(String title)
{
	TitledBorder tb =
		BorderFactory.createTitledBorder(
			BorderFactory.createBevelBorder(BevelBorder.RAISED),
			title,
			TitledBorder.LEFT,
			TitledBorder.TOP);
	tb.setTitleColor(Color.black);
	tb.setTitleFont(getStandardFont());
	return tb;
}
/**
 * Create a new panel that wraps a titled border around a 
 * given panel.
 *
 * @param title the words to show in the title border tab
 * @param in the panel that the border goes around
 * @return a (beveled) titled border with the given title
 */
public static JPanel createTitledPanel(
	String title,
	JPanel in)
{
	JPanel out = new JPanel();
	out.add(in);
	out.setBorder(createTitledBorder(title));
	return out;
}
/**
 * Create a standard font for GUI use.
 *
 * @return a standard font for GUI use
 */
public static Font getStandardFont()
{
	return new Font("Dialog", Font.PLAIN, 18);
}
/**
 * Display the given component within a frame.
 *
 * @param component the component to display
 * @param title the window title for the frame
 * @return the frame
 */
public static JFrame launch(Component c, String title)
{
	JFrame frame = new JFrame(title);
	frame.getContentPane().add(c);
	listen(frame);
	frame.pack();
	frame.setVisible(true);
	return frame;
}
/**
 * Set up an exit listener for a supplied frame.
 *
 * @param frame the frame whose closing will trigger a
 *              system exit
 */
public static void listen(Frame f) 
{
	f.addWindowListener
		(new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					System.exit(0);
				}
			}
		);
}
}
