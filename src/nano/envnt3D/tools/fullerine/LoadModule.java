/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.fullerine;

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

/**
 *
 * @author mufthas
 */
public class LoadModule extends pluginExtension{

    @Override
    public JPanel createButtons() {
        //throw new UnsupportedOperationException("Not supported yet.");
        URL url=this.getClass().getResource("Images/full.png");
        Icon icon=new  ImageIcon(url);
        JButton b1;


        b1=new JButton(icon);
        b1.setPreferredSize(new Dimension(50,50));
        b1.setToolTipText("Fullerene");
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        panelButton.add(b1);



        
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet.");
                FullerineInputPanel panel = new FullerineInputPanel();
                drawPanel(panel);
            }
        });
        return panelButton;
    }


}
