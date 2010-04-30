/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIGraphine.java
 *
 * Created on Jan 27, 2010, 7:47:24 AM
 */
package nano.envnt3D.tools.swnt;

import nano.envnt3D.tools.swnt.swnt.graphene;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.TransformGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import nano.envnt3D.AppearanceNano;
import nano.envnt3D.Interface3D;
import nano.envnt3D.commonElements.Atom;
import nano.envnt3D.commonElements.Bond;
import nano.envnt3D.commonElements.ColorPanel.paneleListener;
import nano.envnt3D.tools.EnergyBands.GraphenePanel;
import nano.envnt3D.tools.EnergyBands.SwntPanel;
import nano.envnt3D.tools.NanoGUI;
import nano.envnt3D.tools.swnt.swnt.GrapheneLayer;

/**
 *
 * @author mufthas
 */
public class GUIGraphine extends javax.swing.JPanel {

    /** Creates new form GUIGraphine */
    BranchGroup BG;
    private JPanel panelButton = new JPanel();
    double[][] coords_bond;
    double[][] coords_atom;
    private TransformGroup atomsGroup, bondsGroup;
    SimpleUniverse simpleu;
    JPanel panelFunction;
    JTextField textM, textN, textL;
    AppearanceNano appearancenano = new AppearanceNano();
    boolean firstClick = true;
    GraphenePanel swntpanel = new GraphenePanel();

    public GUIGraphine() {
        //simpleu=Interface3D.simpleU;

        //BG=new BranchGroup();
        //BG.setCapability(BranchGroup.ALLOW_DETACH);
        //simpleu.addBranchGraph(BG);
        initComponents();

        colorPanel1.addColorEventListener(new paneleListener() {

            @Override
            public void colorChangePerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                jButton1ActionPerformed(e);
            }

            @Override
            public void radiousChangePerformed(ChangeEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet.");
                jButton1ActionPerformed(null);
            }
        });

        colorPanel2.addColorEventListener(new paneleListener() {

            @Override
            public void colorChangePerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                jButton1ActionPerformed(e);

            }

            @Override
            public void radiousChangePerformed(ChangeEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet.");
                jButton1ActionPerformed(null);
            }
        });

        URL url=this.getClass().getResource("Images/ok.png");
        Icon icon=new ImageIcon(url);
        jButton1.setIcon(icon);

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        colorPanel1 = new nano.envnt3D.commonElements.ColorPanel.ColorPanel();
        jPanel3 = new javax.swing.JPanel();
        colorPanel2 = new nano.envnt3D.commonElements.ColorPanel.ColorPanel();

        setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 16));
        jLabel1.setText(" Graphene");

        jCheckBox1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jCheckBox1.setText("Show Electrical Properties");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Properties"));
        jPanel1.setForeground(new java.awt.Color(230, 239, 240));

        jLabel2.setText("Length");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setText("8");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField1.setText("10");

        jLabel3.setText("Width");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atom"));

        colorPanel1.setBackground(new java.awt.Color(254, 254, 254));
        colorPanel1.setRGBColor(new java.awt.Color(255, 65, 0));
        colorPanel1.setRadius(20.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bond"));

        colorPanel2.setBackground(new java.awt.Color(254, 254, 254));
        colorPanel2.setRGBColor(new java.awt.Color(0, 255, 246));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(colorPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //simpleu.getLocale().removeBranchGraph(BG);

        if (jCheckBox1.isSelected()) {
            jCheckBox1.setSelected(false);
        }
        double x1, x2, y1, y2;
        //x1 = -Double.parseDouble(jTextField1.getText()) / 2;
       try {
            x2 = Double.parseDouble(jTextField1.getText());
            //y1 = -Double.parseDouble(jTextField2.getText()) / 2;
            y2 = Double.parseDouble(jTextField2.getText());

            GrapheneLayer gra = new GrapheneLayer(x2, y2);
            coords_atom = gra.getAtomCoordinates();
            coords_bond = gra.getBondCoordinates();

            Atom atom = new Atom();
            atomsGroup = atom.drawAtoms(coords_atom, appearancenano.setMatColor(colorPanel1.getRGBColor()), colorPanel1.getRadius() / 100);


            Bond bond = new Bond();
            bondsGroup = bond.drawBonds(coords_bond, appearancenano.setMatColor(colorPanel2.getRGBColor()), colorPanel2.getRadius() / 100);




            ///simpleu.addBranchGraph(BG);
            //Interface3D.addBG(BG);
            TransformGroup[] TG = {atomsGroup, bondsGroup};

            if (firstClick) {
                firstClick = false;
            } else {
                Interface3D.removeLastBG();
            }
            Interface3D.createBG(TG);
            Interface3D.displayLastBG();
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Length and width should be numbers");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Errors in inputs");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {

            Interface3D.setSizeofCanvas(0, 0);
            NanoGUI.setJPanelM(swntpanel);
        } else {

            Interface3D.setSizeofCanvas();
            NanoGUI.setJPanelM(Interface3D.getcanvas3D());
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    public JPanel getPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private nano.envnt3D.commonElements.ColorPanel.ColorPanel colorPanel1;
    private nano.envnt3D.commonElements.ColorPanel.ColorPanel colorPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}