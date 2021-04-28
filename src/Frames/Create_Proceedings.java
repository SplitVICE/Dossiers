package Frames;

import Controllers.Controller_Proceeding;
import Models.Model_Proceeding;
import Libs.Memory;
import Libs.Run;
import java.util.LinkedList;

public class Create_Proceedings extends javax.swing.JFrame {

    private final Controller_Proceeding controller_Proceeding = new Controller_Proceeding(Memory.database_uri);
    private int id = -1;
    private Model_Proceeding editable_model_proceeding = null;

    /**
     * This frame is used to create and edit proceedings.
     *
     * @param id ID of a proceeding. if id < 0, create procceding form will be shown.
     * If id > 0, edit form will be shown and the proceeding that id == id.
     */
    public Create_Proceedings(int id) {
        this.id = id;
        setIconImage(Memory.getIconImage());
        initComponents();
        this.setTitle(Memory.application_name +" by JUST VICE - " + Memory.application_version);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        on_load_settings();
    }

    private void on_load_settings() {
        set_categories_jcombobox();
        set_uuid();
        jTextField_name.requestFocus();
        jTextArea_body.setLineWrap(true);
        jTextArea_body.setCaretPosition(0);
        jTextArea_body.setWrapStyleWord(true);
        edit_proceeding_form_rendering();
    }

    private void set_categories_jcombobox() {
        jComboBox_category.removeAllItems();
        jComboBox_category.addItem("");
        LinkedList<String> category_list = new Model_Proceeding().get_categories_not_repeated();
        for (int j = 0; j < category_list.size(); j++) {
            jComboBox_category.addItem(category_list.get(j));
        }
    }

    private void set_uuid() {
        jLabel_uuid.setText(Run.get_uuid());
    }

    // Modifies the form to the editing 
    private void edit_proceeding_form_rendering() {
        if (this.id > 0) {
            for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {
                if (Memory.list_model_proceeding.get(i).getId() == this.id) {
                    this.editable_model_proceeding = Memory.list_model_proceeding.get(i);
                    break;
                }
            }
            jTextField_name.setText(this.editable_model_proceeding.getName());
            jTextField_category.setText(this.editable_model_proceeding.getCategory());
            jTextArea_body.setText(this.editable_model_proceeding.getBody());
            jLabel_title.setText("Editing dossier");
            jLabel_uuid.setText(this.editable_model_proceeding.getUuid());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_category = new javax.swing.JTextField();
        jComboBox_category = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_body = new javax.swing.JTextArea();
        jButton_cancel = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel_uuid = new javax.swing.JLabel();
        jButton_copy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_title.setText("Create dossier");

        jLabel2.setText("Name");

        jLabel3.setText("Category");

        jComboBox_category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_categoryItemStateChanged(evt);
            }
        });

        jLabel4.setText("Body");

        jTextArea_body.setColumns(20);
        jTextArea_body.setRows(5);
        jScrollPane1.setViewportView(jTextArea_body);

        jButton_cancel.setText("Back");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jButton_save.setText("Save");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("UUID:");

        jLabel_uuid.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_uuid.setText("UUID");

        jButton_copy.setText("Copy");
        jButton_copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_copyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField_category, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_uuid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_copy)
                                .addGap(90, 90, 90)
                                .addComponent(jButton_save)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancel)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_uuid)
                    .addComponent(jButton_copy)
                    .addComponent(jButton_save))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        if (this.id < 0) {
            Home home = new Home();
        } else {
            View_Proceedings view_Proceedings = new View_Proceedings();
        }
        this.dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        String name = jTextField_name.getText().toString();
        String category = jTextField_category.getText().toString();
        String body = jTextArea_body.getText().toString();

        if (name.equals("") || category.equals("") || body.equals("")) {
            Run.joptionPaneMessage("All fields must be filled", "Required fields", "Alert");
            return;
        }

        if (this.id < 0) {
            create_proceeding_method(name, category, body);
        } else {
            update_proceeding_method(name, category, body);
        }
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void create_proceeding_method(String name, String category, String body) {
        Model_Proceeding model_Proceeding = new Model_Proceeding(name, category, body, jLabel_uuid.getText());
        controller_Proceeding.save_proceeding(model_Proceeding);
        controller_Proceeding.load_proceedings_set_on_memory();
        Memory.model_proceeding.save_dossiers_files_on_txt_files();
        Run.joptionPaneMessage("Dossier " + name + " saved", "Dossier saved", "Message");
        clean_fields();
        set_categories_jcombobox();
        set_uuid();
        jButton_copy.setText("Copy");
    }

    private void update_proceeding_method(String name, String category, String body) {
        this.editable_model_proceeding.setName(name);
        this.editable_model_proceeding.setCategory(category);
        this.editable_model_proceeding.setBody(body);
        controller_Proceeding.update_proceeding(this.editable_model_proceeding);
        controller_Proceeding.load_proceedings_set_on_memory();
        Memory.model_proceeding.save_dossiers_files_on_txt_files();
        Run.joptionPaneMessage("Dossier " + name + " updated", "Dossier updated", "Message");
        View_Proceedings view_Proceedings = new View_Proceedings();
        this.dispose();
    }

    private void jComboBox_categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_categoryItemStateChanged
        if (jComboBox_category.getSelectedItem() != null) {
            if (jComboBox_category.getSelectedItem().toString().equals("")) {
                jTextField_category.setEnabled(true);
                jTextField_category.setText("");
            } else {
                jTextField_category.setEnabled(true);
                jTextField_category.setText(jComboBox_category.getSelectedItem().toString());
                jTextField_category.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboBox_categoryItemStateChanged

    private void jButton_copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_copyActionPerformed
        Run.copy_to_clipboard(jLabel_uuid.getText());
        jButton_copy.setText("Copied");
    }//GEN-LAST:event_jButton_copyActionPerformed

    private void clean_fields() {
        jTextField_name.setText("");
        jTextField_category.setText("");
        jTextArea_body.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_copy;
    private javax.swing.JButton jButton_save;
    private javax.swing.JComboBox<String> jComboBox_category;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_uuid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_body;
    private javax.swing.JTextField jTextField_category;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
