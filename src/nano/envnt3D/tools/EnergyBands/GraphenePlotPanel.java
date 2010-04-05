package nano.envnt3D.tools.EnergyBands;

import static org.math.array.DoubleArray.increment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

import org.math.plot.Plot3DPanel;

public class GraphenePlotPanel extends Plot3DPanel {

	private static final long serialVersionUID = 1L;
    double[][] zpos,zneg; 
	double[] x,y;
   // Gipanel gipanel;
    GrapheneDispersion graph1; 
	
	public GraphenePlotPanel(){
		
		x= increment(-2.0,0.08,2.0);
	    y= increment(-2.0,0.08,2.0);
		 graph1 = new GrapheneDispersion();
		//graph1.SetCCBondLength(1);
		graph1.CalculateGraph(x, y);
	    zpos= graph1.getAntiBonding();
	    zneg = graph1.getBonding();
		
		
		
		this.setAxisLabel(2, "Energy(eV)");
		this.addGridPlot("Antibonding", x, y, zpos);
		this.addGridPlot("Bonding", x, y, zneg);
		JButton AbondingBut = new JButton();
                URL antiurl = this.getClass().getResource("images/anti.jpeg");
                Icon antiicon = new ImageIcon(antiurl);
                AbondingBut.setIcon(antiicon);
                AbondingBut.setToolTipText("Antibonding");
		this.plotToolBar.add(AbondingBut);
		
		AbondingBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			removeAllPlots();
			addGridPlot("Antibonding", x, y, zpos);
			
			}
		});
		
		JButton bondingBut = new JButton();
                 URL bondingurl = this.getClass().getResource("images/bonding.jpeg");
                Icon bondingicon = new ImageIcon(bondingurl);
                bondingBut.setIcon(bondingicon);
                bondingBut.setToolTipText("Bonding");
		this.plotToolBar.add(bondingBut);
		
		bondingBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			removeAllPlots();
			addGridPlot("Bonding",Color.RED, x, y, zneg);
			
			
			}
		});
		
		JButton bothBut = new JButton();
                 URL bothurl = this.getClass().getResource("images/both.jpeg");
                Icon bothicon = new ImageIcon(bothurl);
                bothBut.setIcon(bothicon);
                bothBut.setToolTipText("Both bands");

		this.plotToolBar.add(bothBut);
		
		bothBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			removeAllPlots();
			addGridPlot("Antibonding", x, y, zpos);
			addGridPlot("Bonding", x, y, zneg);
			
			
			}
		});
//		JLabel sLabel= new JLabel("Parameters s=");
//		this.plotToolBar.add(sLabel);
//		JTextField sValue = new JTextField("s value");
//	    this.plotToolBar.add(sValue);
	    
//		JLabel ccLabel= new JLabel("C-C bond length in A");
//		this.plotToolBar.add(ccLabel);
//		JTextField ccValue = new JTextField("s value");
//	    this.plotToolBar.add(ccValue);
	  //  gipanel = new Gipanel();
	    
	  //  this.add(gipanel,BorderLayout.EAST);
	    this.addLegend(SOUTH);
	   
	   // gipanel.ccText.setText(Double.toString(graph1.acc));
	   // gipanel.epsText.setText(Double.toString(graph1.eps));
	    //gipanel.gammaText.setText(Double.toString(graph1.gamma));
	    //gipanel.sText.setText(Double.toString(graph1.s));
	   // gipanel.plotBut.addActionListener(new ActionListener() {
			
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
		//		removeAllPlots();
		//		plotButAction();
		//		
		//	}
	//	});
	    
	}
		
	/*public void plotButAction(){
		
	//	GrapheneDispersion plot = new GrapheneDispersion();
		graph1.SetBondEnergy(Double.parseDouble(gipanel.gammaText.getText()));
	      graph1.SetCCBondLength(Double.parseDouble(gipanel.ccText.getText()));
	     graph1.SetEpsilon(Double.parseDouble(gipanel.epsText.getText()));
	      graph1.SetS(Double.parseDouble(gipanel.sText.getText()));
	     // removeAllPlots();
	      graph1.CalculateGraph(x, y);
	      zpos= graph1.getAntiBonding();
	      zneg =graph1.getBonding();
	      addGridPlot("Antibonding", x, y, zpos);
		  addGridPlot("Bonding", x, y, zneg);
		//  System.out.println(plot.acc+" ,"+);
		
	}*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          GraphenePlotPanel panel = new GraphenePlotPanel();
          javax.swing.JFrame frame =new javax.swing.JFrame();
          frame.setSize(1400,1000);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
          frame.add(panel);
	}

}
