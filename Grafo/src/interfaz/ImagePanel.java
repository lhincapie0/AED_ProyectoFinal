package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	
	private Graphics g;
	
	public ImagePanel( )
	{
		
	
	}
	
	@Override 
	public void paint(Graphics g)
	{
		super.paint(g);
		ImageIcon i1 = new ImageIcon("Images/image1.jpg");
		g.drawImage(i1.getImage(),0, 0, 400,300,this);
		g.setFont(new Font("Harlow Solid Italic",Font.BOLD, 28));
		g.setColor(Color.WHITE);
		g.drawString("Quienes somos??", 30, 30);

	}
}
