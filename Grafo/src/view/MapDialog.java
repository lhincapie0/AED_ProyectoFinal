package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.sun.javafx.geom.Line2D;
import com.sun.prism.BasicStroke;

public class MapDialog extends JDialog implements MouseListener {
	
	private MainWindow mainWindow;
	
	public MapDialog(MainWindow mainWindow) 
	{
		
		this.mainWindow = mainWindow;
		this.setSize(1200,900);
		addMouseListener(this);
	}

	
	@Override
	public void paint (Graphics g)
	{
		super.paint(g);
		ImageIcon i1 = new ImageIcon("Images/EurailMapBasic.jpeg");
		g.drawImage(i1.getImage(),0, 0, this.getWidth(),this.getHeight(),this);
	
		g.setColor(Color.BLUE);
		g.fillOval(160, 680,15,15);
		
		g.fillOval(176, 736,15,15);
		g.drawLine(158, 680, 174, 736);
		g.drawLine(159, 680, 175, 736);
		g.drawLine(160, 680, 176, 736);g.drawLine(161, 681, 177, 737);
		g.drawLine(162, 680, 178, 736);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent h) {
		
		MouseEvent e = h;
		System.out.println(e.getX()+","+e.getY());

		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}