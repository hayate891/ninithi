package nano.envnt3D.tools.swnt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;



import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import nano.envnt3D.Interface3D;


import nano.envnt3D.commonElements.pluginExtension;
import nano.envnt3D.tools.EnergyBands.GraphenePanel;
import nano.envnt3D.tools.NanoGUI;

public class LoadModule extends pluginExtension {

    @Override
    public JPanel createButtons() {
        JButton b7, b1, b2, b3, b4;
        URL myurl = this.getClass().getResource("Images/ribbon.png");
        Icon icon = new ImageIcon(myurl);

        b1 = new JButton(icon);
        b1.setPreferredSize(new Dimension(50, 50));
        b1.setToolTipText("Nano Ribbon");
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);


        myurl = this.getClass().getResource("Images/gra.png");
        icon = new ImageIcon(myurl);
        b2 = new JButton(icon);
        b2.setToolTipText("Graphene");
        b2.setPreferredSize(new Dimension(50, 50));
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);


        myurl = this.getClass().getResource("Images/tube.png");
        icon = new ImageIcon(myurl);
        b7 = new JButton(icon);
        b7.setToolTipText("Carbon Nanotube");
        b7.setPreferredSize(new Dimension(50, 50));
        b7.setVerticalTextPosition(SwingConstants.BOTTOM);
        b7.setHorizontalTextPosition(SwingConstants.CENTER);


        myurl = this.getClass().getResource("Images/tubeE.png");
        icon = new ImageIcon(myurl);
        b3 = new JButton(icon);
        b3.setPreferredSize(new Dimension(50, 50));
        b3.setToolTipText("Electrical properties of Nanotube");
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);

        myurl = this.getClass().getResource("Images/graE.png");
        icon = new ImageIcon(myurl);
        b4 = new JButton(icon);
        b4.setPreferredSize(new Dimension(50, 50));
        b4.setToolTipText("Electrical properties of Graphene");
        b4.setVerticalTextPosition(SwingConstants.BOTTOM);
        b4.setHorizontalTextPosition(SwingConstants.CENTER);

        panelButton.add(b1);
        panelButton.add(b2);
        panelButton.add(b4);
        panelButton.add(b7);
        panelButton.add(b3);

        //---------------------
        JMenuItem item1 = new JMenuItem("Nanotube");
        item1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNanoTubeGui();
            }
        });

        NanoGUI.addMenuItem(item1);


        b7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                createNanoTubeGui();
            }
        });


//---------------------------------------


        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                createNanoRibbonGui();
            }
        });

        JMenuItem item2 = new JMenuItem("Nanoribbon");
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNanoRibbonGui();
            }
        });

        NanoGUI.addMenuItem(item2);

        //-------------------------------------------------

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                createGraphineGui();



            }
        });

        JMenuItem item3 = new JMenuItem("Graphene");
        item3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createGraphineGui();
            }
        });

        NanoGUI.addMenuItem(item3);

        //------------------------------------


        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNanotubePanel();

            }
        });

        JMenuItem item4 = new JMenuItem("Electrical Properties of Nanotube");
        item4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNanotubePanel();
            }
        });

        NanoGUI.addMenuItem(item4);

        //--------------------------------------------

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createGraphineProperties();

            }
        });

        JMenuItem item5 = new JMenuItem("Electrical Properties of Graphene");
        item5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createGraphineProperties();
            }
        });

        NanoGUI.addMenuItem(item5);



        //----------------------------------------------------------

        return panelButton;
    }

    private void createNanoTubeGui() {
        GUINanotube gui2 = new GUINanotube();

        drawPanel(gui2.getPanel());

    }

    protected void createNanoRibbonGui() {
        GUINanoribbon gui = new GUINanoribbon();

        drawPanel(gui.getPanel());

    }

    private void createGraphineGui() {
        GUIGraphine gui = new GUIGraphine();
        drawPanel(gui.getPanel());
    }

    private void createGraphineProperties() {
        drawPanel(new JPanel());
        GraphenePanel gp = new GraphenePanel();
        Interface3D.setSizeofCanvas(0, 0);
        NanoGUI.setJPanelM(gp);
    }

    private void createNanotubePanel() {
        drawPanel(new SwntBandPanel());
    }
}
