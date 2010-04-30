/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.envnt3D.tools.mwnt;

import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mufthas
 */
public class CustomTableCellAddImageRenderer extends DefaultTableCellRenderer {

    String url;
    public CustomTableCellAddImageRenderer(String url){
       this.url=url;
    }
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

/*
        // String s =  table.getModel().getValueAt(row, 8).toString();
        String s = table.getValueAt(row, 3).toString();



        if (s.equalsIgnoreCase("true")) {
            cell.setBackground(Color.BLUE);
            cell.setForeground(Color.WHITE);
        } else {
            cell.setForeground(Color.BLUE);
            if (row % 2 == 0) {
                cell.setBackground(Color.WHITE);
            } else {
                cell.setBackground(new Color(255, 255, 224));
            }
        }
 * *
 */

        URL url2=this.getClass().getResource(url);
        ImageIcon icon=new ImageIcon(url2);
        setIcon(icon);
        return this;
    }
}
