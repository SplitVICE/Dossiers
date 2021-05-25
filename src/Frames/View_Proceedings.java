package Frames;

import Libs.Memory;
import Libs.Run;
import Models.Model_Proceeding;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import Controllers.Controller_Proceeding;

public class View_Proceedings extends javax.swing.JFrame {

    public View_Proceedings() {
        setIconImage(Memory.getIconImage());
        initComponents();
        this.setTitle(Memory.application_name +" by SPLIT VICE - " + Memory.application_version);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        on_load_settings();
    }

    private void on_load_settings() {
        set_jlist();
        set_categories_jcombobox();
        jTextArea_body.setLineWrap(true);
        jTextArea_body.setEditable(false);
        jTextArea_body.setWrapStyleWord(true);
    }

    private void set_jlist() {
        DefaultListModel<Model_Proceeding> jlist_model = new DefaultListModel<>();
        for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {
            jlist_model.add(i, Memory.list_model_proceeding.get(i));
        }
        jList.setModel(jlist_model);
    }

    private void set_categories_jcombobox() {
        jComboBox_category.removeAllItems();
        jComboBox_category.addItem("");
        LinkedList<String> category_list = new Model_Proceeding().get_categories_not_repeated();
        for (int j = 0; j < category_list.size(); j++) {
            jComboBox_category.addItem(category_list.get(j));
        }
    }

    private void search() {
        jButton_copy_uuid.setText("Copy UUID");
        DefaultListModel<Model_Proceeding> jlist_model = new DefaultListModel<>();

        String name = jTextField_name.getText().toLowerCase();
        String date = jTextField_date.getText();
        String uuid = jTextField_uuid.getText();
        String on_body = jTextField_body.getText();
        String category = jComboBox_category.getSelectedItem().toString();

        if (name.isEmpty() && date.isEmpty() && uuid.isEmpty() && on_body.isEmpty() && category.isEmpty()) {
            set_jlist();
            return;
        }

        for (int i = 0; i < Memory.list_model_proceeding.size(); i++) {

            boolean matches = true;

            if (!name.isEmpty()) {
                if (!Memory.list_model_proceeding.get(i).getName().toLowerCase().contains(name)) {
                    matches = false;
                }
            }

            if (!date.isEmpty()) {
                if (!Memory.list_model_proceeding.get(i).getDate().toLowerCase().contains(date)) {
                    matches = false;
                }
            }

            if (!uuid.isEmpty()) {
                if (!Memory.list_model_proceeding.get(i).getUuid().toLowerCase().contains(uuid)) {
                    matches = false;
                }
            }

            if (!on_body.isEmpty()) {
                if (!Memory.list_model_proceeding.get(i).getBody().toLowerCase().contains(on_body.toLowerCase())) {
                    matches = false;
                }
            }

            if (!category.isEmpty()) {
                if (!Memory.list_model_proceeding.get(i).getCategory().equals(category)) {
                    matches = false;
                }
            }

            if (matches) {
                jlist_model.add(0, Memory.list_model_proceeding.get(i));
            }

        }
        jList.setModel(jlist_model);
    }

    private void reset_frame() {
        View_Proceedings view_Proceedings = new View_Proceedings();
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_body = new javax.swing.JTextArea();
        jButton_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_category = new javax.swing.JComboBox<>();
        jTextField_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_date = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_body = new javax.swing.JTextField();
        jButton_clean_fields = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_uuid = new javax.swing.JTextField();
        jButton_clean_view = new javax.swing.JButton();
        jButton_copy_uuid = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("View dossiers");

        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList);

        jTextArea_body.setColumns(20);
        jTextArea_body.setRows(5);
        jScrollPane1.setViewportView(jTextArea_body);

        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jLabel2.setText("Search");

        jLabel3.setText("Category");

        jComboBox_category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_categoryItemStateChanged(evt);
            }
        });

        jTextField_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_nameKeyReleased(evt);
            }
        });

        jLabel4.setText("Name");

        jLabel5.setText("Date");

        jTextField_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_dateKeyReleased(evt);
            }
        });

        jLabel6.setText("On body");

        jTextField_body.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_bodyKeyReleased(evt);
            }
        });

        jButton_clean_fields.setText("Clean fields");
        jButton_clean_fields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clean_fieldsActionPerformed(evt);
            }
        });

        jButton_edit.setText("Edit");
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel7.setText("UUID");

        jTextField_uuid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_uuidKeyReleased(evt);
            }
        });

        jButton_clean_view.setText("Clean view");
        jButton_clean_view.setToolTipText("");
        jButton_clean_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clean_viewActionPerformed(evt);
            }
        });

        jButton_copy_uuid.setText("Copy UUID");
        jButton_copy_uuid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_copy_uuidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_back)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(42, 42, 42)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_name)
                                            .addComponent(jComboBox_category, 0, 244, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_date)
                                            .addComponent(jTextField_uuid)))
                                    .addComponent(jButton_clean_fields)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(34, 34, 34)
                                        .addComponent(jTextField_body, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_clean_view)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_copy_uuid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_delete)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton_clean_fields))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_uuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_back)
                    .addComponent(jButton_edit)
                    .addComponent(jButton_delete)
                    .addComponent(jButton_clean_view)
                    .addComponent(jButton_copy_uuid))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        Home home = new Home();
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMouseClicked
        Model_Proceeding model_Proceeding = jList.getSelectedValue();
        if (model_Proceeding != null) {
            jTextArea_body.setText(model_Proceeding.get_proceeding_view());
            jTextArea_body.setCaretPosition(0);
        }
    }//GEN-LAST:event_jListMouseClicked

    private void jTextField_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nameKeyReleased
        search();
    }//GEN-LAST:event_jTextField_nameKeyReleased

    private void jTextField_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_dateKeyReleased
        search();
    }//GEN-LAST:event_jTextField_dateKeyReleased

    private void jComboBox_categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_categoryItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox_categoryItemStateChanged

    private void jTextField_uuidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_uuidKeyReleased
        search();
    }//GEN-LAST:event_jTextField_uuidKeyReleased

    private void jTextField_bodyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_bodyKeyReleased
        search();
    }//GEN-LAST:event_jTextField_bodyKeyReleased

    private void jButton_clean_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clean_viewActionPerformed
        jTextArea_body.setText("");
        jButton_copy_uuid.setText("Copy UUID");
    }//GEN-LAST:event_jButton_clean_viewActionPerformed

    private void jButton_clean_fieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clean_fieldsActionPerformed
        jTextField_body.setText("");
        jTextField_date.setText("");
        jTextField_name.setText("");
        jTextField_uuid.setText("");
        jButton_copy_uuid.setText("Copy UUID");
        jComboBox_category.setSelectedIndex(0);
        set_jlist();
    }//GEN-LAST:event_jButton_clean_fieldsActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        Model_Proceeding model_Proceeding = jList.getSelectedValue();
        if (model_Proceeding != null) {
            int option = Run.joptionPaneAsk("Are you sure you want to delete this record? This action cannot be undone.", "Delete record", 0, "QuestionMark");
            if (option == 0) {
                Controller_Proceeding controller_Proceedings = new Controller_Proceeding(Memory.database_uri);
                controller_Proceedings.delete_proceeding(model_Proceeding.getId());
                controller_Proceedings.load_proceedings_set_on_memory();
                Memory.model_proceeding.save_dossiers_files_on_txt_files();
                reset_frame();
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        Model_Proceeding model_Proceeding = jList.getSelectedValue();
        if (model_Proceeding != null) {
            Create_Proceedings create_Proceeding = new Create_Proceedings(model_Proceeding.getId());
            this.dispose();
        }
    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton_copy_uuidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_copy_uuidActionPerformed
        Model_Proceeding model_Proceeding = jList.getSelectedValue();
        if (model_Proceeding != null) {
            Run.copy_to_clipboard(model_Proceeding.getUuid());
            jButton_copy_uuid.setText("Copied");
        }
    }//GEN-LAST:event_jButton_copy_uuidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_clean_fields;
    private javax.swing.JButton jButton_clean_view;
    private javax.swing.JButton jButton_copy_uuid;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JComboBox<String> jComboBox_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<Model_Proceeding> jList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_body;
    private javax.swing.JTextField jTextField_body;
    private javax.swing.JTextField jTextField_date;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_uuid;
    // End of variables declaration//GEN-END:variables
}
