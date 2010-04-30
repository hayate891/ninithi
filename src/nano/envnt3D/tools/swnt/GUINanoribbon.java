/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUINanoribbon.java
 *
 * Created on Jan 26, 2010, 10:51:45 PM
 */

package nano.envnt3D.tools.swnt;

import com.sun.j3d.utils.universe.SimpleUniverse;
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
import nano.envnt3D.Coords;
import nano.envnt3D.Interface3D;
import nano.envnt3D.commonElements.Atom;
import nano.envnt3D.commonElements.Bond;
import nano.envnt3D.commonElements.ColorPanel.paneleListener;
import nano.envnt3D.tools.EnergyBands.SwntPanel;
import nano.envnt3D.tools.NanoGUI;
import nano.envnt3D.tools.swnt.swnt.nanoribbon;

/**
 *
 * @author mufthas
 */
public class GUINanoribbon extends javax.swing.JPanel {

    /** Creates new form GUINanoribbon */


	BranchGroup BG;

	private JPanel panelButton=new JPanel();
	double[][] coords_bond;
	double[][] coords_atom;
	private TransformGroup atomsGroup,bondsGroup;
	SimpleUniverse simpleu;
	JPanel panelFunction;
	JTextField textM,textN,textL;
	AppearanceNano appearancenano=new AppearanceNano();
        boolean firstClick=true;
    public GUINanoribbon() {
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        colorPanel1 = new nano.envnt3D.commonElements.ColorPanel.ColorPanel();
        jPanel3 = new javax.swing.JPanel();
        colorPanel2 = new nano.envnt3D.commonElements.ColorPanel.ColorPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jLabel4.setText("Carbon Nano Ribbon");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Properties"));

        jLabel1.setText("M");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setText("5");

        jTextField1.setText("5");

        jLabel3.setText("Length");

        jLabel2.setText("N");

        jTextField3.setText("5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 220));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atom"));

        colorPanel1.setRGBColor(new java.awt.Color(255, 0, 191));
        colorPanel1.setRadius(20.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(colorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bond"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(colorPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 270, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //simpleu.getLocale().removeBranchGraph(BG);
        

        nanoribbon ribbon = null;

        try {
            ribbon = new nanoribbon(Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()), Double.parseDouble(jTextField3.getText()));

            coords_atom = ribbon.getAtomCoordinates();
            coords_bond = ribbon.getBondCoordinates();
            //Coords coords=new Coords();
            //coords_atom=coords.adjustCoordsToCenter(coords_atom);
            //coords_bond=coords.adjustCoordsToCenter(coords_bond);


            Atom atom = new Atom();
            atomsGroup = atom.drawAtoms(coords_atom, appearancenano.setMatColor(colorPanel1.getRGBColor()), colorPanel1.getRadius() / 100);


            Bond bond = new Bond();
            bondsGroup = bond.drawBonds(coords_bond, appearancenano.setMatColor(colorPanel2.getRGBColor()), colorPanel2.getRadius() / 100);



            //simpleu.addBranchGraph(BG);
            //Interface3D.addBG(BG);
            TransformGroup[] TG = {atomsGroup, bondsGroup};
            if (firstClick) {
                firstClick = false;
            } else {
                Interface3D.removeLastBG();
            }

            Interface3D.createBG(TG);
            Interface3D.displayLastBG();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "M,N should be integers and length should be a number");
        }
}//GEN-LAST:event_jButton1ActionPerformed

public JPanel getPanel(){
    return this;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private nano.envnt3D.commonElements.ColorPanel.ColorPanel colorPanel1;
    private nano.envnt3D.commonElements.ColorPanel.ColorPanel colorPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
