/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.EnergyBands;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chanaka
 */
public class SwntPanel extends JPanel {

    SwntPlotPanel plotpanel= new SwntPlotPanel();
    SwntiPanel inputpanel=new SwntiPanel();

    public JPanel setMN(int m, int n){
        this.setLayout(new BorderLayout());

                plotpanel.removeAllPlots();
                plotpanel.SetMN(m,n);
		//inputpanel = new SwntiPanel();
		this.add(plotpanel,BorderLayout.CENTER);
		this.add(inputpanel,BorderLayout.EAST);
                this.updateUI();

                String mval = Integer.toString(m);
                String nval = Integer.toString(n);
                inputpanel.mLabel.setText(mval);
                inputpanel.nLable.setText(nval);


		    inputpanel.ccText.setText(Double.toString(plotpanel.bandPlot.acc));
		    inputpanel.epsText.setText(Double.toString(plotpanel.bandPlot.eps));
		    inputpanel.gammaText.setText(Double.toString(plotpanel.bandPlot.gamma));
		    inputpanel.sText.setText(Double.toString(plotpanel.bandPlot.s));


		    inputpanel.plotBut.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					plotpanel.removeAllPlots();
					plotButAction();

				}
			});
                        return this;
    }

    public void plotButAction(){


		      try {
            plotpanel.bandPlot.SetBondEnergy(Double.parseDouble(inputpanel.gammaText.getText()));
            plotpanel.bandPlot.SetCCBondLength(Double.parseDouble(inputpanel.ccText.getText()));
            plotpanel.bandPlot.SetEpsilon(Double.parseDouble(inputpanel.epsText.getText()));
            plotpanel.bandPlot.SetS(Double.parseDouble(inputpanel.sText.getText()));
            plotpanel.bandPlot.CreateGraphPlots();

            for (int i = 0; i < plotpanel.bandPlot.Nc; i++) {
                //band = cnt1.antiBondingBands[i];
                //color = new Color(255/cnt1.Nc*i ,255-255/cnt1.Nc*i, 255/cnt1.Nc*i);
                plotpanel.addLinePlot("Antibonding N=" + i, plotpanel.bandPlot.k, plotpanel.bandPlot.antiBondingBands[i]);
                plotpanel.addLinePlot("bonding N=" + i, plotpanel.bandPlot.k, plotpanel.bandPlot.BondingBands[i]);
            }
        } catch (NumberFormatException numberFormatException) {

            JOptionPane.showMessageDialog(this, "Inputs must be in numbers" );
        }
			

    }



	
}
