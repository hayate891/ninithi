package nano.envnt3D.tools.swnt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;



import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import nano.envnt3D.commonElements.pluginExtension;

public class LoadModule extends pluginExtension {

    
    @Override
	public JPanel createButtons(){
	JButton b7,b1,b2,b10;
        URL myurl = this.getClass().getResource("Images/ribbon.png");
	Icon icon=new  ImageIcon(myurl);

	b1=new JButton(icon);
        b1.setPreferredSize(new Dimension(50,50));
        b1.setToolTipText("Nano Ribbon");
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        myurl = this.getClass().getResource("Images/gra.png");
        icon=new  ImageIcon(myurl);
	b2=new JButton(icon);
        b2.setToolTipText("Graphine");
        b2.setPreferredSize(new Dimension(50,50));
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);


        myurl = this.getClass().getResource("Images/tube.png");
        icon=new  ImageIcon(myurl);
	b7=new JButton(icon);
        b7.setToolTipText("nano Tube");
        b7.setPreferredSize(new Dimension(50,50));
        b7.setVerticalTextPosition(SwingConstants.BOTTOM);
        b7.setHorizontalTextPosition(SwingConstants.CENTER);

        myurl = this.getClass().getResource("Images/swntgraph.png");
        icon=new  ImageIcon(myurl);
        b10=new JButton(icon);
        b10.setPreferredSize(new Dimension(50,50));
        b10.setToolTipText("Electrical prperties");
        b10.setVerticalTextPosition(SwingConstants.BOTTOM);
        b10.setHorizontalTextPosition(SwingConstants.CENTER);

	
	panelButton.add(b1);
	panelButton.add(b2);
	panelButton.add(b7);
        panelButton.add(b10);
        
	
	
	b10.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		       createEbandGui();
                 
		}

            private void createEbandGui() {
                SwntBandPanel guiE=new SwntBandPanel();
                
                drawPanel(guiE);

                }
	});

        b7.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		       createNanoTubeGui();
                 
		}

            private void createNanoTubeGui() {
                GUINanotube gui2=new GUINanotube();
                
                drawPanel(gui2.getPanel());

                }
	});


	
		b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					createNanoRibbonGui();
				}

                                protected void createNanoRibbonGui() {
                                    GUINanoribbon gui=new GUINanoribbon();

                                    drawPanel(gui.getPanel());

                                }

			});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			GUIGraphine gui=new GUIGraphine();                               
                                    drawPanel(gui.getPanel());
				
				
			}
		});
	
	return panelButton;
	}




	
}
