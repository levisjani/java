//import com.sun.java.swing.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SwingFacade 
{

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

public static JPanel createTitledPanel(
	String title,
	JPanel in)
{
	JPanel out = new JPanel();
	out.add(in);
	out.setBorder(createTitledBorder(title));
	return out;
}

public static Font getStandardFont()
{
	return new Font("Dialog", Font.PLAIN, 18);
}

public static JFrame launch(Component c, String title)
{
	JFrame frame = new JFrame(title);
	frame.getContentPane().add(c);
	listen(frame);
	frame.pack();
	frame.setVisible(true);
	return frame;
}

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
