import java.awt.*;
import javax.swing.*;

public class ShowKit 
{

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

public static void main(String[] args)
{
	UIKit k = UIKit.handheld();
	JPanel p = ShowKit.crossSales(k);
	SwingFacade.launch(p, " Oozinoz Cross Sales");
}
}
