/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.fields;

import components.IGetValue;
import domain.Gender;
import domain.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.FrmPerson;

/**
 *
 * @author student1
 */
public class PanelInputPersonv2 extends javax.swing.JPanel implements IGetValue {

    /**
     * Creates new form PanelInputPersonv2
     */
    public PanelInputPersonv2() {
        initComponents();
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputFirstName = new components.fields.PanelInputTextField();
        inputLastName = new components.fields.PanelInputTextField();
        inputDate = new components.fields.PanelInputDate();
        inputGender = new components.fields.PanelInputComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(inputDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   private void prepareView() {
        inputFirstName.getLblFieldText().setText("First name:");
        inputFirstName.getLblError().setText("");
        inputFirstName.initialize("");
        inputLastName.getLblFieldText().setText("Last name:");
        inputLastName.getLblError().setText("");
        inputLastName.initialize("");
        inputDate.getLblFieldText().setText("Date:");
        inputDate.getLblError().setText("");
        inputDate.initialize("2000");
        inputGender.getLblFieldText().setText("Gender:");
        inputGender.getLblError().setText("");
        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.MALE);
        genders.add(Gender.FEMALE);
        inputGender.initialize(genders);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.fields.PanelInputDate inputDate;
    private components.fields.PanelInputTextField inputFirstName;
    private components.fields.PanelInputComboBox inputGender;
    private components.fields.PanelInputTextField inputLastName;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getValue() {
          Person person = new Person();
        person.setFirstName((String) inputFirstName.getValue());
        person.setLastName((String) inputLastName.getValue());
        try {
            person.setDate((Date) inputDate.getValue());
        } catch (Exception ex) {
            Logger.getLogger(FrmPerson.class.getName()).log(Level.SEVERE, null, ex);
            inputDate.getLblError().setText(ex.getMessage());
            return null;
        }
        try {
            person.setGender((Gender) inputGender.getValue());
        } catch (Exception e) {
            inputGender.getLblError().setText(e.getMessage());
        }
        return person;
    }

    @Override
    public void initialize(Object initValue) {
        // TODO:
    }
}
