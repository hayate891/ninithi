/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.mwnt;

import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author chanaka
 */
public class TubeTableCellRenderer extends DefaultTableCellRenderer{

	public TubeTableCellRenderer() {
		setHorizontalAlignment(JLabel.CENTER);
             //   setForeground(Color.red);

	}

    @Override
        public Component getTableCellRendererComponent( JTable table,
				Object value, boolean isSelected, boolean hasFocus,int row, int column ){

        URL url=this.getClass().getResource("images/close.png");
        ImageIcon image=new ImageIcon(url);
        setIcon(image);
        return this;

        }

}



