package Frames;

import Libs.Memory;

public class Home extends javax.swing.JFrame {

    public Home() {
        setIconImage(Memory.getIconImage());
        initComponents();
        this.setTitle(Memory.application_version);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_create_proceeding = new javax.swing.JButton();
        jButton_view_proceedings = new javax.swing.JButton();
        jLabel_about = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Dossiers");

        jButton_create_proceeding.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_create_proceeding.setText("Create dossier");
        jButton_create_proceeding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_create_proceedingActionPerformed(evt);
            }
        });

        jButton_view_proceedings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_view_proceedings.setText("View dossiers");
        jButton_view_proceedings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_view_proceedingsActionPerformed(evt);
            }
        });

        jLabel_about.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_about.setText("About");
        jLabel_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_aboutMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("by JUST VICE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel_about)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_view_proceedings, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_create_proceeding))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton_create_proceeding)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_view_proceedings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel_about)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_create_proceedingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_create_proceedingActionPerformed
        Create_Proceedings create_Proceedings = new Create_Proceedings(-1);
        this.dispose();
    }//GEN-LAST:event_jButton_create_proceedingActionPerformed

    private void jButton_view_proceedingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_view_proceedingsActionPerformed
        View_Proceedings view_Proceedings = new View_Proceedings();
        this.dispose();
    }//GEN-LAST:event_jButton_view_proceedingsActionPerformed

    private void jLabel_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_aboutMouseClicked
        About about = new About();
        this.dispose();
    }//GEN-LAST:event_jLabel_aboutMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_create_proceeding;
    private javax.swing.JButton jButton_view_proceedings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_about;
    // End of variables declaration//GEN-END:variables
}
