package view;

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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,2000,2000);
		g.setColor(Color.black);
		ImageIcon i1 = new ImageIcon("Images/Eurail_RGB.png");
		g.drawImage(i1.getImage(),200, 200, 300,300,this);
		g.setFont(new Font("Harlow Solid Italic",Font.BOLD, 28));
		g.setColor(Color.WHITE);
		
		ImageIcon i2 = new ImageIcon("Images/EurailMapBasic.jpeg");
		g.drawImage(i2.getImage(),600, 50, 1000,800,this);
		
		

	}
}
