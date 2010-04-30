/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.envnt3D.tools.customDesigner;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mufthas
 */
public class CustomTableCellAddBackgrounColorRenderer extends DefaultTableCellRenderer {

    Color color = Color.PINK;
    ArrayList<Color> list = new ArrayList<Color>();

    public CustomTableCellAddBackgrounColorRenderer() {
    }

    public CustomTableCellAddBackgrounColorRenderer(Color C) {
        color = C;
        list.add(C);
    }

    public void setRendererColor(Color C) {
        color = C;
        list.add(C);
    }

    public Color getListColor(int i){
        return (list.get(i));
    }

    public void setListColor(int i,Color c){
        list.set(i, c);
    }

    public void removeListColor(int i){
        list.remove(i);
        //System.out.print(i);
    }

    
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        //Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
        //Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, 2);
        //Color c=(Color) table.getModel().getValueAt(row, 2);

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
        color = list.get(row);

        if (obj == null) {

            setBackground(color);

        } else {

            setBackground((Color) obj);

        }




        return this;
    }
}
