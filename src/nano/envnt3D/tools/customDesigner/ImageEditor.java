/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.customDesigner;

import java.awt.Component;
import java.net.URL;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author mufthas
 */
public class ImageEditor extends AbstractCellEditor implements TableCellEditor {
    JLabel label;
    ImageIcon image;
    
    
    public ImageEditor(String url){
        
        label=new JLabel();
        URL url2=this.getClass().getResource(url);
        ImageIcon icon=new ImageIcon(url2);
        label.setIcon(icon);
    }
    @Override
    public Object getCellEditorValue() {
        return image;

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected)
        image = (ImageIcon)value;
        return label;
    }

}
