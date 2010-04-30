/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.commonElements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import nano.envnt3D.Interface3D;
import nano.envnt3D.tools.NanoGUI;

/**
 *
 * @author mufthas
 */
public abstract class pluginExtension {
    public JPanel panelFunction;
    public JPanel panelButton;

    public pluginExtension(){
        panelFunction=NanoGUI.getJPanelL();
        panelButton=new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));

    }

    public abstract  JPanel createButtons();

    public void drawPanel(JPanel panel){
        Interface3D.setSizeofCanvas();
        panelFunction.removeAll();
        panelFunction.validate();
        panelFunction.add(panel);
        panelFunction.validate();
    }

    
}
