package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener {
	
	
	public final static String VIEW = "view graph";
	public final static String CALCULATE = "calculate path";
	public final static String ROUTES = "check routes";

	
	
	private JButton viewBut;
	private JButton calculateBut;
	private JButton checkRutesBut;
	private MainWindow main;

	
	public MainPanel( MainWindow main)
	{
		this.main = main;
		this.setSize(200,200);
		this.setLayout(new GridLayout(3,1));
		viewBut = new JButton("Ver mapa ferroviario");
		viewBut.setActionCommand(VIEW);
		viewBut.addActionListener(this);
		calculateBut = new JButton("Calculate the shortest path from one city to another");
		calculateBut.setActionCommand(CALCULATE);
		calculateBut.addActionListener(this);
		checkRutesBut = new JButton("Take a look of the routes that goes from where you are");
		checkRutesBut.setActionCommand(ROUTES);
		checkRutesBut.addActionListener(this);
		add(viewBut);
		add(calculateBut);
		add(checkRutesBut);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
