package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.sun.javafx.geom.Line2D;
import com.sun.prism.BasicStroke;

import structure.Node;

public class MapDialog extends JDialog implements MouseListener {
	
	private MainWindow mainWindow;
	private ArrayList<Node<String>> nodes;
	private ArrayList<EdgeView> edges ;
	
	public MapDialog(MainWindow mainWindow) 
	{
		
		this.mainWindow = mainWindow;
		this.setSize(1200,900);
		addMouseListener(this);
		nodes = mainWindow.getNodesData();
		edges = mainWindow.getEdgesData();
	}

	
	@Override
	public void paint (Graphics g)
	{
		super.paint(g);
		ImageIcon i1 = new ImageIcon("Images/EurailMapBasic.jpeg");
		g.drawImage(i1.getImage(),0, 0, this.getWidth(),this.getHeight(),this);
	
		g.setColor(Color.BLUE);
		
		for(int i = 0; i<nodes.size();i++)
		{
			int x = nodes.get(i).getX();
			int y = nodes.get(i).getY();
			g.fillOval(x, y,15,15);

		}
		
			g.setColor(Color.orange);
		for(int i = 0; i<edges.size();i++)
		{
		
			int x1 = edges.get(i).getX1();
			int x2 = edges.get(i).getX2();
			int y1 = edges.get(i).getY1();
			int y2 = edges.get(i).getY2();
		
			g.drawLine(x1,y1,x2,y2);
			g.drawLine(x1-1,y1-1,x2-1,y2-1);
			g.drawLine(x1+2,y1+2,x2+2,y2+2);

			g.drawLine(x1+1,y1+1,x2+1,y2+1);

		}
		
	
	
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