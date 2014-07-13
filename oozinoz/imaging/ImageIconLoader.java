package com.oozinoz.imaging;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageIconLoader
	extends ImageIcon
	implements Runnable {
	static final ImageIcon ABSENT =
		new ImageIcon(
			ClassLoader.getSystemResource("absent.jpg"));
	static final ImageIcon LOADING =
		new ImageIcon(
			ClassLoader.getSystemResource("loading.jpg"));
	protected String filename;
	protected JFrame callbackFrame;
	
	public ImageIconLoader(String filename)
{
	super(ABSENT.getImage());
	this.filename = filename;
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
	setImage(LOADING.getImage());
	callbackFrame.repaint();
	new Thread(this).start();
}
/**
 * Load the desired image (presumably in a separate thread). 
 */
public void run()
{
	setImage(
		new ImageIcon(
			ClassLoader.getSystemResource(filename))
			.getImage());
	callbackFrame.pack();
}
}
