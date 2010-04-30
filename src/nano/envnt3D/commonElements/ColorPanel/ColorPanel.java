/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * atomPanel.java
 *
 * Created on Feb 8, 2010, 5:18:08 PM
 */

package nano.envnt3D.commonElements.ColorPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;

/**
 *
 * @author mufthas
 */
public class ColorPanel extends javax.swing.JPanel implements Serializable
 {
    private Color RGBColor=new Color(0, 0, 255);
    private String label = "Radious";
    private float Radious =10;
    

    /** Creates new form atomPanel */
    public ColorPanel() {
        initComponents();
        buttonColor.setBackground(RGBColor);
        setRadius(Radious);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jColorChooser1 = new javax.swing.JColorChooser();
        buttonColor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setPreferredSize(new java.awt.Dimension(215, 80));

        buttonColor.setName("buttonColor"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${RGBColor}"), buttonColor, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        buttonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorActionPerformed(evt);
            }
        });

        jLabel2.setText("Radious");
        jLabel2.setName("jLabel2"); // NOI18N

        jSlider1.setPaintLabels(true);
        jSlider1.setDoubleBuffered(true);
        jSlider1.setName("jSlider1"); // NOI18N
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel3.setText("Color");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(buttonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(buttonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorActionPerformed
        // TODO add your handling code here:
      JDialog dialog= jColorChooser1.createDialog(null, "Color Box", true, jColorChooser1, colorChooserOK, colorChooserCancel);
      dialog.setVisible(true);
      
    }//GEN-LAST:event_buttonColorActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        if(!jSlider1.getValueIsAdjusting())
        {
        setRadius(jSlider1.getValue());
        fireRadiosChangeEvent(evt);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    ActionListener colorChooserOK=new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            RGBColor=jColorChooser1.getColor();
            buttonColor.setBackground(RGBColor);
            fireColorChangeEvent(e);

        }
    };


     
    ActionListener colorChooserCancel=new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            buttonColor.setBackground(RGBColor);
        }
    };


    public Color getRGBColor(){        
        return RGBColor;
    }

    public void setRGBColor(Color C){
        RGBColor=C;
        buttonColor.setBackground(C);
    }

    

    /**
     * Get the value of label
     *
     * @return the value of label
     */
    public String getLabel() {
        label=jLabel2.getText();
        return label;
    }

    /**
     * Set the value of label
     *
     * @param label new value of label
     */
    public void setLabel(String label) {
        jLabel2.setText(label);
        this.label = label;
    }



    

    /**
     * Get the value of valueRadious
     *
     * @return the value of valueRadious
     */
    public float getRadius() {
        return Radious;
    }

    /**
     * Set the value of valueRadious
     *
     * @param valueRadious new value of valueRadious
     */
    public void setRadius(float radious) {
        this.Radious = radious;
        jSlider1.setValue((int)radious);
    }

    //-------------------------------------------Event------------
    protected EventListenerList listenerList= new EventListenerList();
    

    public void addColorEventListener(paneleListener listener) {
        listenerList.add(paneleListener.class, listener);
    }

    public void removeColorEventListener(paneleListener listener) {
        listenerList.remove(paneleListener.class, listener);
    }


    void fireColorChangeEvent(ActionEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==paneleListener.class) {
              ((paneleListener)listeners[i+1]).colorChangePerformed(evt);
              //((colorChangeListener)listeners[i+1]).actionPerformed(evt);
            }
        }
    }

    void fireRadiosChangeEvent(ChangeEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==paneleListener.class) {
              ((paneleListener)listeners[i+1]).radiousChangePerformed(evt);
              //((colorChangeListener)listeners[i+1]).actionPerformed(evt);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton buttonColor;
    javax.swing.JColorChooser jColorChooser1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JSlider jSlider1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    

}
