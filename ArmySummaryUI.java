/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Administrator
 */
public class ArmySummaryUI extends javax.swing.JPanel {

    /**
     * Creates new form ArmySummaryUI
     */
    public ArmySummaryUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("閺傝顒滅搾鍛煐姒涙垹鐣濇担锟�", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("PROFILE");
        add(jLabel1);
        jLabel1.setBounds(240, 20, 385, 50);

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("閺傝顒滅划妤�娓剧粻锟芥担锟�", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME");
        add(jLabel2);
        jLabel2.setBounds(480, 20, 110, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 0));
        jLabel3.setFont(new java.awt.Font("閺傝顒滅划妤�娓剧粻锟芥担锟�", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LEVEL");
        add(jLabel3);
        jLabel3.setBounds(480, 60, 110, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 0));
        jLabel4.setFont(new java.awt.Font("閺傝顒滅划妤�娓剧粻锟芥担锟�", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GOLD");
        add(jLabel4);
        jLabel4.setBounds(480, 100, 110, 30);

        jLabel5.setFont(new java.awt.Font("閺傝顒滅搾鍛煐姒涙垹鐣濇担锟�", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("ARMY SUMMARY");
        add(jLabel5);
        jLabel5.setBounds(110, 140, 190, 30);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(540, 20, 100, 30);

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7);
        jTextField7.setBounds(540, 60, 100, 30);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        add(jTextField8);
        jTextField8.setBounds(540, 100, 100, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ARMY NAME", "LEVEL", "EXP", "HP", "ATTACK", "DEFENCE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 170, 460, 150);

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(433, 346, 69, 23);

        jButton2.setText("BACK");
        add(jButton2);
        jButton2.setBounds(541, 346, 75, 23);

        java.net.URL imgURL = getClass().getResource("ArmySImage.jpg");
        
        jLabel6.setIcon(new javax.swing.ImageIcon(imgURL)); // NOI18N
       
        jLabel6.setText("jLabel6");
        add(jLabel6);
        jLabel6.setBounds(0, 0, 660, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
