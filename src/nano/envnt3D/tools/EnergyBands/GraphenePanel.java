package nano.envnt3D.tools.EnergyBands;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphenePanel extends JPanel {

	GraphenePlotPanel plotpanel;
	Gipanel inputpanel;
	
	private static final long serialVersionUID = 1L;

	public GraphenePanel() {
		
		this.setLayout(new BorderLayout());
		plotpanel = new GraphenePlotPanel();
		inputpanel = new Gipanel();
		this.add(plotpanel,BorderLayout.CENTER);
		this.add(inputpanel,BorderLayout.EAST);
		
		
		 inputpanel.ccText.setText(Double.toString(plotpanel.graph1.acc));
		    inputpanel.epsText.setText(Double.toString(plotpanel.graph1.eps));
		    inputpanel.gammaText.setText(Double.toString(plotpanel.graph1.gamma));
		    inputpanel.sText.setText(Double.toString(plotpanel.graph1.s));
		    
		    inputpanel.plotBut.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					plotpanel.removeAllPlots();
					plotButAction();
					
				}
			});
	}
	
	public void plotButAction(){
		
		
	try {
                plotpanel.graph1.SetBondEnergy(Double.parseDouble(inputpanel.gammaText.getText()));
                plotpanel.graph1.SetCCBondLength(Double.parseDouble(inputpanel.ccText.getText()));
                plotpanel.graph1.SetEpsilon(Double.parseDouble(inputpanel.epsText.getText()));
                plotpanel.graph1.SetS(Double.parseDouble(inputpanel.sText.getText()));
                plotpanel.graph1.CalculateGraph(plotpanel.x, plotpanel.y);
                plotpanel.zpos = plotpanel.graph1.getAntiBonding();
                plotpanel.zneg = plotpanel.graph1.getBonding();
                plotpanel.addGridPlot("Antibonding", plotpanel.x, plotpanel.y, plotpanel.zpos);
                plotpanel.addGridPlot("Bonding", plotpanel.x, plotpanel.y, plotpanel.zneg);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Inputs should be numbers");
            }
			//  System.out.println(plot.acc+" ,"+);
			
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphenePanel panel = new GraphenePanel();
        javax.swing.JFrame frame =new javax.swing.JFrame();
        frame.setSize(1400,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

	}

}
