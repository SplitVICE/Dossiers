package Frames;

import Libs.Memory;
import Libs.Run;

public class About extends javax.swing.JFrame {
    
    private int inki = 0;

    public About() {
        setIconImage(Memory.getIconImage());
        initComponents();
        this.setTitle(Memory.application_name +" by JUST VICE - " + Memory.application_version);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        jLabel_copyright_vice_version.setText("© MIT - JUST VICE 2021 - " + Memory.application_version);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_dossiers_website = new javax.swing.JLabel();
        jLabel_twitter = new javax.swing.JLabel();
        jLabel_github_repository = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();
        jLabel_copyright_vice_version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        jLabel_dossiers_website.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_dossiers_website.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_dossiers_website.setText("Dossiers website");
        jLabel_dossiers_website.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_dossiers_websiteMouseClicked(evt);
            }
        });

        jLabel_twitter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_twitter.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_twitter.setText("VICE's Twitter");
        jLabel_twitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_twitterMouseClicked(evt);
            }
        });

        jLabel_github_repository.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_github_repository.setForeground(new java.awt.Color(51, 51, 255));
        jLabel_github_repository.setText("Github repository");
        jLabel_github_repository.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_github_repositoryMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Dossiers");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/justvice.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        jLabel_copyright_vice_version.setText("© MIT - JUST VICE 2021 - 0.0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel_github_repository)
                                    .addComponent(jLabel_dossiers_website)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel_twitter)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_back)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel_copyright_vice_version)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_twitter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_dossiers_website)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_github_repository)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_back)
                    .addComponent(jLabel_copyright_vice_version))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        Home home = new Home();
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jLabel_github_repositoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_github_repositoryMouseClicked
        Run.openLink("https://github.com/JUSTVICE/Dossiers");
    }//GEN-LAST:event_jLabel_github_repositoryMouseClicked

    private void jLabel_dossiers_websiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_dossiers_websiteMouseClicked
        Run.openLink("http://just-vice.com/technology/java/dossiers/");
    }//GEN-LAST:event_jLabel_dossiers_websiteMouseClicked

    private void jLabel_twitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_twitterMouseClicked
        Run.openLink("http://just-vice.com/s/twitter");
    }//GEN-LAST:event_jLabel_twitterMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.inki++;
        if(this.inki == 10){
            Inki inki1 = new Inki();
        }
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_copyright_vice_version;
    private javax.swing.JLabel jLabel_dossiers_website;
    private javax.swing.JLabel jLabel_github_repository;
    private javax.swing.JLabel jLabel_twitter;
    // End of variables declaration//GEN-END:variables
}
