package com.oozinoz.imaging;

import java.awt.*;
import javax.swing.*;

public class ImageIconProxy
	extends ImageIcon
	implements Runnable {
	static final ImageIcon ABSENT =
		new ImageIcon(
			ClassLoader.getSystemResource("absent.jpg"));
	static final ImageIcon LOADING =
		new ImageIcon(
			ClassLoader.getSystemResource("loading.jpg"));
	ImageIcon current = ABSENT;
	protected String filename;
	protected JFrame callbackFrame;
/**
 * Construct an ImageIconProxy that will (on demand) 
 * load the image in the provided file.
 *
 * @param filename the name of a file to load
 */
public ImageIconProxy(String filename)
{
	super(ABSENT.getImage());
	this.filename = filename;
}
/**
 * Get the height of the Icon
 */
public int getIconHeight()
{
	return current.getIconHeight();
}
/**
 * Get the width of the Icon
 */
public int getIconWidth()
{
	return current.getIconWidth();
}
/**
 * Load the desired image and call back the provided frame
 * when done.
 *
 * @param JFrame the frame to repaint when the image is loaded
 */
public void load(JFrame callbackFrame)
{
	this.callbackFrame = callbackFrame;
	current = LOADING;
	callbackFrame.repaint();
	new Thread(this).start();
}
/**
 * Paint the Icon
 */
public synchronized void paintIcon(
	Component c,
	Graphics g,
	int x,
	int y)
{
	current.paintIcon(c, g, x, y);
}
/**
 * Load the desired image (presumably in a separate thread). 
 */
public void run()
{
	current =
		new ImageIcon(
			ClassLoader.getSystemResource(filename));
	callbackFrame.pack();
}
}
