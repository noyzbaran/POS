/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.db_methods;
import MODEL.gen_methods;
import MODEL.gen_objects;
import MODEL.login_methods;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
public class Frm_Login_new extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Login
     */
    public Frm_Login_new() {
        initComponents();
        setLocationRelativeTo(null);
//        setBackground(new java.awt.Color(0,0,0,120));

        g_o.storeName = d_m.returnValue("select shopname from tbl_settings", "shopname");
        g_o.contact = "";
        g_o.owner = d_m.returnValue("select owner from tbl_settings", "owner");
        g_o.address = d_m.returnValue("select address from tbl_settings", "address");
        store.setText(g_o.storeName + " POS");
        owner.setText("Owner: " + g_o.owner);
        address.setText("Address: " + g_o.address);
    }
    gen_objects g_o = new gen_objects();
    login_methods l_m = new login_methods();
    gen_methods g_m = new gen_methods();
    db_methods d_m = new db_methods();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        store = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        panel_username = new javax.swing.JPanel();
        txtusername = new javax.swing.JTextField();
        icon_user = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        panel_username1 = new javax.swing.JPanel();
        icon_password = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        label_password = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        owner = new javax.swing.JLabel();
        footer = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                ImageIcon II  =new ImageIcon(getClass().getResource("/images/loginfooter.jpg"));
                Image image = II.getImage();
                g.drawImage(image, 0, 0, getWidth(),getHeight(), this);

            }
        };
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 97, 221), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(97, 97, 221));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close Window_56px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 3, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cash Register_100px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 188, 665, -1));

        store.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        store.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        store.setText(" Sample Name POS Inventory System");
        jPanel1.add(store, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 78, 665, -1));

        address.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        address.setText("Tankulan, Manolo Fortich, Bukinon");
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 122, 665, -1));

        panel_username.setBackground(new java.awt.Color(255, 255, 255));
        panel_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        panel_username.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusername.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(51, 51, 51));
        txtusername.setOpaque(false);
        txtusername.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtusernameCaretUpdate(evt);
            }
        });
        panel_username.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 2, 315, 51));

        icon_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Shield_48px.png"))); // NOI18N
        panel_username.add(icon_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 51));

        label_user.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        label_user.setForeground(new java.awt.Color(87, 87, 87));
        label_user.setText("Username");
        panel_username.add(label_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 320, 50));

        jPanel1.add(panel_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 332, -1, -1));

        panel_username1.setBackground(new java.awt.Color(255, 255, 255));
        panel_username1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        panel_username1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User Credentials_48px.png"))); // NOI18N
        panel_username1.add(icon_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 51));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtpassword.setOpaque(false);
        txtpassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtpasswordCaretUpdate(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });
        panel_username1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 320, 50));

        label_password.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        label_password.setForeground(new java.awt.Color(87, 87, 87));
        label_password.setText("Password");
        panel_username1.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 0, 320, 50));

        jPanel1.add(panel_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 414, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Enter_45px.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 60));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sign-in");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 360, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 501, 371, 58));

        owner.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        owner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        owner.setText("Tankulan, Manolo Fortich, Bukinon");
        jPanel1.add(owner, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 157, 665, -1));

        footer.setBackground(new java.awt.Color(97, 97, 221));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Designed by: Angel Barz");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("All Rights Reserved 2020");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Developed by: Nozoft");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel15))
        );

        jPanel1.add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 625, 685, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 690, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtusernameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtusernameCaretUpdate
        if (txtusername.getText().length() > 0) {
            label_user.setVisible(false);
        } else {
            label_user.setVisible(true);
        }
    }//GEN-LAST:event_txtusernameCaretUpdate

    private void txtpasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtpasswordCaretUpdate
        if (txtpassword.getText().length() > 0) {
            label_password.setVisible(false);
        } else {
            label_password.setVisible(true);
        }
    }//GEN-LAST:event_txtpasswordCaretUpdate

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if (l_m.checkAccount(txtusername.getText(), txtpassword.getText(), this)) {
            g_m.Message("Welcome " + txtusername.getText());
            dispose();
        } else {
            //g_m.Error_Message("Account Error", "Unknown Account!");
        }

    }//GEN-LAST:event_jLabel10MouseClicked

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (l_m.checkAccount(txtusername.getText(), txtpassword.getText(), this)) {
                g_m.Message("Welcome " + txtusername.getText());
                dispose();
            } else {
                //g_m.Error_Message("Account Error", "Unknown Account!");
            }

        }
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        g_m.Message("trouble encountered!");
    }//GEN-LAST:event_formWindowOpened

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Login_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login_new().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel icon_password;
    private javax.swing.JLabel icon_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_user;
    private javax.swing.JLabel owner;
    private javax.swing.JPanel panel_username;
    private javax.swing.JPanel panel_username1;
    private javax.swing.JLabel store;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
