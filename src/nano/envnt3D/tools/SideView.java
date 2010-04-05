package nano.envnt3D.tools;

import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;



import nano.envnt3D.ConfigNano;
import nano.envnt3D.Interface3D;

public class SideView {

    JPanel panelButton;
    double[] center;
    TransformGroup tg;
    SimpleUniverse simpleU;
    double[] points;
    ConfigNano confignano;

    public SideView(double[] center, double[] points, ConfigNano confignano) {

        this.center = center;
        this.points = points;
        this.confignano = confignano;



        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
    }

    public SideView() {
        // TODO Auto-generated constructor stub
        //confignano= Interface3D.getConfigNano();
        simpleU = Interface3D.getSimpleUniverse();
        confignano = new ConfigNano();
        panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
    }

    public JPanel createButtons() {

        JButton b1, b2, b3, b4, b5, b6;


        URL myurl = this.getClass().getResource("Images/view-front.png");
        Icon icon = new ImageIcon(myurl);
        b1 = new JButton(icon);
        b1.setPreferredSize(new Dimension(50, 50));


        myurl = this.getClass().getResource("Images/view-left.png");
        icon = new ImageIcon(myurl);
        b2 = new JButton(icon);
        b2.setPreferredSize(new Dimension(50, 50));


        myurl = this.getClass().getResource("Images/view-top.png");
        icon = new ImageIcon(myurl);
        b3 = new JButton(icon);
        b3.setPreferredSize(new Dimension(50, 50));

        myurl = this.getClass().getResource("Images/view-bottom.png");
        icon = new ImageIcon(myurl);
        b4 = new JButton(icon);
        b4.setPreferredSize(new Dimension(50, 50));


        myurl = this.getClass().getResource("Images/view-right.png");
        icon = new ImageIcon(myurl);
        b5 = new JButton(icon);
        b5.setPreferredSize(new Dimension(50, 50));

        myurl = this.getClass().getResource("Images/view-rear.png");
        icon = new ImageIcon(myurl);
        b6 = new JButton(icon);
        b6.setPreferredSize(new Dimension(50, 50));


        panelButton.add(b1);
        panelButton.add(b2);
        panelButton.add(b3);
        panelButton.add(b4);
        panelButton.add(b5);
        panelButton.add(b6);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // Front (Z) direction
                //confignano.setView(new Point3d(center[0], center[1], (center[0]-points[1])/Math.tan(Math.toRadians(30))),new Point3d(center[0], center[1], points[4]),new Vector3d(0, 1, 0));
                confignano.setView(new Point3d(0, 0, 10), new Point3d(0, 0, 0), new Vector3d(0, 1, 0));
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // Left (-X) direction
                confignano.setView(new Point3d(-10, 0, 0), new Point3d(0, 0, 0), new Vector3d(0, 1, 0));
                //confignano.setView(new Point3d((center[1]-points[4])/Math.tan(Math.toRadians(30)), center[1], center[2]),new Point3d(points[0], center[1], center[2]),new Vector3d(0,1, 0));
            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //Top(Y) direction
                confignano.setView(new Point3d(0, 10, 0), new Point3d(0, 0, 0), new Vector3d(0, 0, -1));
                //confignano.setView(new Point3d(center[0],(center[0]-points[1])/Math.tan(Math.toRadians(30)), center[2]),new Point3d(center[0], center[1],center[2]),new Vector3d(0, 0, 1));

            }
        });

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //Bottom (-Y)
                //confignano.setView(new Point3d(center[0], center[1], -(center[0]-points[1])/Math.tan(Math.toRadians(30))),new Point3d(center[0], center[1], center[2]),new Vector3d(0, 1, 0));
                confignano.setView(new Point3d(0, -10, 0), new Point3d(0, 0, 0), new Vector3d(0, 0, 1));
            }
        });

        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //Right (+X)
                confignano.setView(new Point3d(10, 0, 0), new Point3d(0, 0, 0), new Vector3d(0, 1, 0));
                //confignano.setView(new Point3d(-(center[1]-points[3])/Math.tan(Math.toRadians(30)), center[1], center[2]),new Point3d(center[0], center[1], center[2]),new Vector3d(0,-1, 0));
            }
        });

        b6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //Back (-Z)
                confignano.setView(new Point3d(0, 0, -10), new Point3d(0, 0, 0), new Vector3d(0, 1, 0));
                //confignano.setView(new Point3d(center[0],-(center[0]-points[1])/Math.tan(Math.toRadians(30)), center[2]),new Point3d(center[0], center[1],center[2]),new Vector3d(0, 0, -1));

            }
        });



        return panelButton;
    }
}
