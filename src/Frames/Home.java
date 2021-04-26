package Frames;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_create_proceeding = new javax.swing.JButton();
        jButton_view_proceedings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Proceedings");

        jButton_create_proceeding.setText("Create proceeding");
        jButton_create_proceeding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_create_proceedingActionPerformed(evt);
            }
        });

        jButton_view_proceedings.setText("View proceedings");
        jButton_view_proceedings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_view_proceedingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton_create_proceeding)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_view_proceedings)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_create_proceeding)
                    .addComponent(jButton_view_proceedings))
                .addContainerGap(21, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_create_proceeding;
    private javax.swing.JButton jButton_view_proceedings;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
