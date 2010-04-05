/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Designer.java
 *
 * Created on Mar 10, 2010, 4:36:03 PM
 */
package nano.envnt3D.tools.customDesigner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import nano.envnt3D.Interface3D;
import nano.envnt3D.commonElements.ColorPanel.paneleListener;

/**
 *
 * @author mufthas
 */
public class Designer extends javax.swing.JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();
    ColorEditor colorEditor=new ColorEditor();
    URL url;
    ImageIcon icon;
    Integer no = 0;
    Color color=Color.RED;
    double[][] coords = {{0, 0, 0}};
    CustomTableCellAddBackgrounColorRenderer BGrenderer=new CustomTableCellAddBackgrounColorRenderer();
    CustomTableCellAddImageRenderer imageRenderer=new CustomTableCellAddImageRenderer();

    /** Creates new form Designer */
    public Designer() {
        initComponents();
        addComponentsToToolbar();
        additionalInit();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        colorPanel1 = new nano.envnt3D.commonElements.ColorPanel.ColorPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNo = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jTextFieldCood = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(300, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setRollover(true);
        jToolBar1.setToolTipText("");
        jToolBar1.setName("jToolBar1"); // NOI18N

        jButton1.setToolTipText("Add an atom...");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtomActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jButton1.getAccessibleContext().setAccessibleParent(this);

        jButton2.setToolTipText("Add a bond..");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBondActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 300, -1));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(tableModel);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 270, 251));

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText("No");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Type");
        jLabel2.setName("jLabel2"); // NOI18N

        colorPanel1.setLabel("Radius");
        colorPanel1.setName("colorPanel1"); // NOI18N

        jLabel3.setText("Coordinates");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabelNo.setName("jLabelNo"); // NOI18N

        jLabelType.setName("jLabelType"); // NOI18N

        jTextFieldCood.setName("jTextFieldCoord"); // NOI18N
        jTextFieldCood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCoodMouseClicked(evt);
            }
        });
        jTextFieldCood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCoodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(90, 90, 90)
                                .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCood, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTextFieldCood.getAccessibleContext().setAccessibleParent(jPanel1);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        jButton4.setText("Draw");
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 648, 69, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Interface3D.setSizeofCanvas(0, 0);
        CustomDialog dialog = new CustomDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        coords = dialog.getCoords();



        //NanoGUI.setJPanelM(new AtomDesignerPanel());


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonAtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtomActionPerformed
        // TODO add your handling code here:
        double[][] value={{0,0,0}};
        imageRenderer.setImage("Images/atom2.png");
        jTable1.getColumnModel().getColumn(1).setCellRenderer(imageRenderer);
        //jTable1.getColumnModel().getColumn(1).setCellEditor(new ImageEditor("Images/atom2.png"));
        
        float radius = colorPanel1.getRadius();
        BGrenderer.setRendererColor(Color.BLUE);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(BGrenderer);
        
        no = tableModel.getRowCount() + 1;
        coords=value;
        tableModel.addRow(new String[]{no.toString()});
        tableModel.setValueAt(radius, tableModel.getRowCount() - 1, 3);
        tableModel.setValueAt(adjustCoords(), tableModel.getRowCount() - 1, 4);

    }//GEN-LAST:event_jButtonAtomActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() >= 1) {
            jPanel1.setVisible(true);
            JTable tmpTab = (JTable) evt.getSource();
            int r=tmpTab.getSelectedRow();
            jLabelNo.setText((String)tmpTab.getValueAt(r, 0));

            url = this.getClass().getResource(imageRenderer.getImageURL(r));
            icon = new ImageIcon(url);
            jLabelType.setIcon(icon);
            
            colorPanel1.setRGBColor(BGrenderer.getListColor(r));
            colorPanel1.setRadius((Float)tmpTab.getValueAt(r,3));

            jTextFieldCood.setText((String)jTable1.getValueAt(r, 4));
            
        }
         
         
    }//GEN-LAST:event_jTable1MouseClicked

    @SuppressWarnings("empty-statement")
    private void jButtonBondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBondActionPerformed
        // TODO add your handling code here:
        //jTable1.getColumnModel().getColumn(1).setCellEditor(new ImageEditor("Images/bond2.png"));
        double[][] value={{0,0,0,0,0,0}};
        coords=value;
        imageRenderer.setImage("Images/bond2.png");
        jTable1.getColumnModel().getColumn(1).setCellRenderer(imageRenderer);
        //jTable1.getColumnModel().getColumn(1).setCellEditor(new ImageEditor("Images/bond2.png"));
        float radius = colorPanel1.getRadius();

        BGrenderer.setRendererColor(Color.PINK);
        jTable1.getColumnModel().getColumn(2).setCellRenderer( BGrenderer);
        
        no = tableModel.getRowCount() + 1;
        tableModel.addRow(new String[]{no.toString()});
        tableModel.setValueAt(radius, tableModel.getRowCount() - 1, 3);        
        tableModel.setValueAt(adjustCoords(), tableModel.getRowCount() - 1, 4);
    }//GEN-LAST:event_jButtonBondActionPerformed

    private void jTextFieldCoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCoodActionPerformed
        // TODO add your handling code here:
      
}//GEN-LAST:event_jTextFieldCoodActionPerformed

    private void jTextFieldCoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCoodMouseClicked
        // TODO add your handling code here:
        Interface3D.setSizeofCanvas(0, 0);
        CustomDialog dialog = new CustomDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        coords = dialog.getCoords();
    }//GEN-LAST:event_jTextFieldCoodMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private nano.envnt3D.commonElements.ColorPanel.ColorPanel colorPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNo;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCood;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private void addComponentsToToolbar() {
        url = this.getClass().getResource("Images/atom.png");
        icon = new ImageIcon(url);
        jButton1.setIcon(icon);

        url = this.getClass().getResource("Images/bond.png");
        icon = new ImageIcon(url);
        jButton2.setIcon(icon);
    }

    public JPanel getPanel() {
        return this;
    }

    private void additionalInit() {
        jPanel1.setVisible(false);
        String[] header = {"No", "Type", "Color", "Radius", "Coordinates", "Delete"};
        for (int col = 0; col < header.length; col++) {
            tableModel.addColumn(header[col]);
        }
               
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new CustomTableCellAddImageRenderer("Images/delete3.png"));
              
        colorPanel1.addColorEventListener(new paneleListener() {

            @Override
            public void colorChangePerformed(ActionEvent e) {
                BGrenderer.setListColor(jTable1.getSelectedRow(),colorPanel1.getRGBColor());                               
                jTable1.repaint();                
            }

            @Override
            public void radiousChangePerformed(ChangeEvent evt) {                
               tableModel.setValueAt(colorPanel1.getRadius(), jTable1.getSelectedRow(), 3);
            }
        });
    }

    public String adjustCoords() {
        String s;
        
        if (coords[0].length ==6) {
            s = "(" + coords[0][0] + "," + coords[0][1] + "," + coords[0][2] + ")" + ","
                    + "(" + coords[0][0] + "," + coords[0][1] + "," + coords[0][2] + ")";
        } else {
            s = "(" + coords[0][0] + "," + coords[0][1] + "," + coords[0][2] + ")";
        }
        return s;
    }


}
