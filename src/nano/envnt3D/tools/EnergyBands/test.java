package nano.envnt3D.tools.EnergyBands;

import static org.math.array.DoubleArray.increment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.math.plot.Plot3DPanel;
import org.math.plot.Plot2DPanel;
import org.math.plot.plots.LinePlot;
//import static org.math.array.DoubleArray.*;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}
	
	public static int gcd(int a, int b) {
		 
		   if (b==0) 
		     return a;
		   else
		     return gcd(b, a % b);
		 } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] x= increment(-3.0,0.1,3.0);
		double[] y= increment(-3.0,0.1,3.0);
		Color color;
		
		SwntEBands cnt1 = new SwntEBands(8,8);
		cnt1.CreateGraphPlots();
		double[][] an = cnt1.antiBondingBands;
		//double[] z = cnt1.k;
		Plot2DPanel panel2 = new Plot2DPanel();
		JPanel panel3 =new JPanel();
		panel3.setLayout(new GridLayout(6,1));
		Component[] buttons = panel2.plotToolBar.getComponents();
		for(int i=0;i<buttons.length;i++){
			panel3.add(buttons[i]);
		}
		//double[] band= new double[cnt1.antiBondingBands[0].length] ;
		for(int i=0;i<cnt1.Nc;i++){
			//band = cnt1.antiBondingBands[i];
			//color = new Color(255/cnt1.Nc*i ,255-255/cnt1.Nc*i, 255/cnt1.Nc*i);
			panel2.addLinePlot("Antibonding N="+i,cnt1.k, cnt1.antiBondingBands[i]);			
			panel2.addLinePlot("bonding N="+i, cnt1.k, cnt1.BondingBands[i]);
		}
		
		GrapheneDispersion graph1 = new GrapheneDispersion();
		graph1.SetCCBondLength(1);
		graph1.CalculateGraph(x, y);
		double[][] zpos= graph1.getAntiBonding();
		double[][] zneg = graph1.getBonding();
		
		Plot3DPanel panel1 = new Plot3DPanel();
		panel1.addGridPlot("Antibonding", x, y, zpos);
		panel1.addGridPlot("Bonding", x, y, zneg);
	    // panel2.addLinePlot("f", z, z);
		SwntPlotPanel swntpanel = new SwntPlotPanel();

		JFrame frame = new JFrame("a plot panel");
		frame.setSize(600, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.setContentPane(panel2);
	//	frame.add(panel3,BorderLayout.WEST);
	//	frame.add(panel1);
                frame.add(swntpanel);
		frame.setVisible(true);
		System.out.println(cnt1.BondingBands[0][0]);
		//

	}

}
