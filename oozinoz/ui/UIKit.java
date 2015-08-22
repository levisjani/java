import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

public class UIKit 
{
	protected OzButton button = new OzButton();
	protected OzTextArea textArea = new OzTextArea();

public JButton createButton(String text)
{
	JButton b = new JButton(text);
	b.setFont(button.getFont());
	return b;
}

public OzTextArea createTextArea()
{
	return (OzTextArea) textArea.clone();
}

public static UIKit fullScreen()
{
	Font f = new Font("Dialog", Font.ITALIC, 18);
	UIKit k = new UIKit();
	k.button.setFont(f);
	k.textArea.setFont(f);
	return k;
}

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
