package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainContainer extends JPanel{

	
	private ImagePanel imagePanel;
	private MainPanel mainPanel;
	
	public MainContainer(MainWindow w)
	{
		setVisible(true);
		this.setBackground(Color.WHITE);
		this.setSize(1000,1000);
		mainPanel = new MainPanel(w);
		imagePanel = new ImagePanel();
		this.setLayout(new GridLayout(1,2));
		ImageIcon image = new ImageIcon("Images/image1.jpg");
		add(mainPanel);
		add(imagePanel);
	}

	private void add(ImageIcon image) {
		// TODO Auto-generated method stub
		
	}
}
