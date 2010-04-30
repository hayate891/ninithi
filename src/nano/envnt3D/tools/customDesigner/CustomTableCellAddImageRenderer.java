/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.envnt3D.tools.customDesigner;

import java.awt.Component;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mufthas
 */
public class CustomTableCellAddImageRenderer extends JLabel implements TableCellRenderer {

    String url;
    ArrayList<String> list = new ArrayList<String>();

    public CustomTableCellAddImageRenderer(String url) {
        this.url = url;
        list.add(url);
    }

    public CustomTableCellAddImageRenderer() {
    }

    public String getImageURL(int i) {
        return (list.get(i));
    }

    public void setImage(String string) {
        this.url = string;
        list.add(string);
        
    }
     public void removeImage(int i){
         list.remove(i);
        //System.out.println(i);
    }

    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        //Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

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
        if (column == 1) {
            url = list.get(row);
        }
        URL url2 = this.getClass().getResource(url);
        ImageIcon icon = new ImageIcon(url2);
        setIcon(icon);
        setAlignmentX(CENTER_ALIGNMENT);
        return this;
    }
}
