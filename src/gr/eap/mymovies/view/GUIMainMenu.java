/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.eap.mymovies.view;

import gr.eap.mymovies.controller.AppController;
import gr.eap.mymovies.controller.ControllerMovie;
import gr.eap.mymovies.controller.ControllerGenre;
import java.awt.Toolkit;

/**
 *
 * @author akarafotis
 */
public class GUIMainMenu extends javax.swing.JFrame {

    private AppController appController;
    private ControllerMovie controllerMovie;
    private ControllerGenre controllerGenre;

    /**
     * Creates new form GUIMainMenu
     */
    public GUIMainMenu() {
        initComponents();
        // Κεντράρισμα του παραθύρου εφαρμογής στην οθόνη του υπολογιστή
        this.setLocationRelativeTo(null);

        // Init Application Controller
        controllerMovie = new ControllerMovie();
        controllerGenre = new ControllerGenre();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the
     * Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        retrieveAndStoreMovies = new javax.swing.JButton();
        manageFavoriteLists = new javax.swing.JButton();
        searchMovies = new javax.swing.JButton();
        statistics = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myMovies");
        setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMainMenu.class.getResource("movies.png")));
        setPreferredSize(new java.awt.Dimension(1050, 389));
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 99));

        retrieveAndStoreMovies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/restore.png"))); // NOI18N
        retrieveAndStoreMovies.setText("<html><center>Ανάκτηση &<br/>Αποθήκευση<br/>Δεδομένων Ταινιών</center></html>");
        retrieveAndStoreMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveAndStoreMoviesActionPerformed(evt);
            }
        });

        manageFavoriteLists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/manageLists.png"))); // NOI18N
        manageFavoriteLists.setText("<html><center>Διαχείριση Λιστών <br/>Αγαπημένων Ταινιών</center></html>");
        manageFavoriteLists.setToolTipText("");
        manageFavoriteLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageFavoriteListsActionPerformed(evt);
            }
        });

        searchMovies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/searchMovie.png"))); // NOI18N
        searchMovies.setText("<html><center>Αναζήτηση<br/>Ταινιών</center></html>");
        searchMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persistGenres(evt);
            }
        });

        statistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/statMovies.png"))); // NOI18N
        statistics.setText("Στατιστικά");

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gr/eap/mymovies/view/exit.png"))); // NOI18N
        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(retrieveAndStoreMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retrieveAndStoreMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(manageFavoriteLists, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1024, 99);
        jPanel1.getAccessibleContext().setAccessibleName("ButtonPanel");

        jMenu1.setText("Ταινίες");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Ανάκτηση και Αποθήκευση Δεδομένων Ταινιών");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Αναζήτηση Ταινιών");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleDescription("");

        jMenu2.setText("Λίστες Ταινιών");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Διαχείριση Λιστών Αγαπημένων Ταινιών");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Στατιστικά");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Έξοδος");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retrieveAndStoreMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveAndStoreMoviesActionPerformed
        controllerGenre.insertDataFromJson();
        controllerMovie.retrieveAndPersistMovies();
    }//GEN-LAST:event_retrieveAndStoreMoviesActionPerformed

    private void manageFavoriteListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageFavoriteListsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageFavoriteListsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.out.println("exiting myMovies application");
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void persistGenres(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persistGenres
        //controllerGenre.insertDataFromJson();
    }//GEN-LAST:event_persistGenres

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton manageFavoriteLists;
    private javax.swing.JButton retrieveAndStoreMovies;
    private javax.swing.JButton searchMovies;
    private javax.swing.JButton statistics;
    // End of variables declaration//GEN-END:variables
}
