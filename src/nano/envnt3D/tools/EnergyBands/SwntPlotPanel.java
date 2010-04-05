/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.EnergyBands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author chanaka
 */
public class SwntPlotPanel extends Plot2DPanel {

    public SwntEBands bandPlot;
    double[] x,y;
    int m,n;

    public SwntPlotPanel(){
        JButton AbondingBut = new JButton();
        URL antiurl = this.getClass().getResource("images/anti.jpeg");
        Icon antiicon = new ImageIcon(antiurl);
        AbondingBut.setIcon(antiicon);
        AbondingBut.setToolTipText("Conduction bands");
		this.plotToolBar.add(AbondingBut);

		AbondingBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			removeAllPlots();
			for(int i=0;i<bandPlot.Nc;i++){
                            addLinePlot("Antibonding N="+i,bandPlot.k, bandPlot.antiBondingBands[i]);

		        }

			}
		});

		JButton bondingBut = new JButton();
                URL bondingurl = this.getClass().getResource("images/bonding.jpeg");
                Icon bondingicon = new ImageIcon(bondingurl);
                bondingBut.setIcon(bondingicon);
                bondingBut.setToolTipText("Valance bands");

		this.plotToolBar.add(bondingBut);

		bondingBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			removeAllPlots();
			for(int i=0;i<bandPlot.Nc;i++){
                            addLinePlot("bonding N="+i, bandPlot.k, bandPlot.BondingBands[i]);
		        }


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
			for(int i=0;i<bandPlot.Nc;i++){
			//band = cnt1.antiBondingBands[i];
			//color = new Color(255/cnt1.Nc*i ,255-255/cnt1.Nc*i, 255/cnt1.Nc*i);
                        int j=i+1;
			addLinePlot("Antibonding N="+i,bandPlot.k, bandPlot.antiBondingBands[i]);
			addLinePlot("bonding N="+i, bandPlot.k, bandPlot.BondingBands[i]);
		        }

			}
		});

    }

    public void SetMN(int M,int N){
        m=M;
        n=N;
        removeLegend();
        bandPlot= new SwntEBands(m,n);
        bandPlot.CreateGraphPlots();
        for(int i=0;i<bandPlot.Nc;i++){
			//band = cnt1.antiBondingBands[i];
			//color = new Color(255/cnt1.Nc*i ,255-255/cnt1.Nc*i, 255/cnt1.Nc*i);
			this.addLinePlot("Antibonding N="+i,bandPlot.k, bandPlot.antiBondingBands[i]);
			this.addLinePlot("bonding N="+i, bandPlot.k, bandPlot.BondingBands[i]);
		}
        setAxisLabel(1, "Energy(eV)");
        setAxisLabel(0, "k");
        if(bandPlot.Nc<21){
                 addLegend(SOUTH);
                }       
    }

}

