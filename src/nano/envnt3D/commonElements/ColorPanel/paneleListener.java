/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.commonElements.ColorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.event.ChangeEvent;



/**
 *
 * @author mufthas
 */
public interface paneleListener extends  EventListener {
   public void colorChangePerformed(ActionEvent e);
   public void radiousChangePerformed(ChangeEvent evt);

}
