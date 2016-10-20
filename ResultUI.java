import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.event.*;

public class ResultUI extends JPanel {
	
    // Variables declaration - do not modify 
	private JPanel pl;
	
    private javax.swing.JLabel Label_Title;
    private javax.swing.JLabel Label_DefenceArmy1;
    private javax.swing.JLabel Label_OffenceArmy;
    
    private javax.swing.JButton Button_Leave;
    private javax.swing.JButton Button_Rematch;
    
    private javax.swing.JButton Button_du1;
    private javax.swing.JButton Button_du2;
    private javax.swing.JButton Button_du3;
    private javax.swing.JButton Button_du4;
    private javax.swing.JButton Button_du5;
    private javax.swing.JButton Button_ou6;
    private javax.swing.JButton Button_ou7;
    private javax.swing.JButton Button_ou8;
    private javax.swing.JButton Button_ou9;
    private javax.swing.JButton Button_ou10;   
    
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    
    private javax.swing.JLabel Label_Background;
    // End of variables declaration  

    public ResultUI(JPanel p) {
    	pl = p;
    	
        Label_Title = new javax.swing.JLabel();
        Label_OffenceArmy = new javax.swing.JLabel();
        Label_DefenceArmy1 = new javax.swing.JLabel();
        
        Button_du1 = new javax.swing.JButton();
        Button_du2 = new javax.swing.JButton();
        Button_du3 = new javax.swing.JButton();
        Button_du4 = new javax.swing.JButton();
        Button_du5 = new javax.swing.JButton();
        Button_ou6 = new javax.swing.JButton();
        Button_ou7 = new javax.swing.JButton();
        Button_ou8 = new javax.swing.JButton();
        Button_ou9 = new javax.swing.JButton();
        Button_ou10 = new javax.swing.JButton();

        Button_Rematch = new javax.swing.JButton();
        Button_Leave = new javax.swing.JButton();
        
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        
        Label_Background = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 960));
        setLayout(null);

        Label_Title.setFont(new java.awt.Font("·½Õý³¬´ÖºÚ¼òÌå", 1, 48)); // NOI18N
        Label_Title.setForeground(new java.awt.Color(0, 102, 102));
        Label_Title.setText("GAME RESULT");
        add(Label_Title);
        Label_Title.setBounds(400, 50, 560, 50);

        Label_OffenceArmy.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        Label_OffenceArmy.setForeground(new java.awt.Color(102, 0, 102));
        Label_OffenceArmy.setText("offence ARMY");
        add(Label_OffenceArmy);
        Label_OffenceArmy.setBounds(690, 170, 180, 40);

        Label_DefenceArmy1.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        Label_DefenceArmy1.setForeground(new java.awt.Color(0, 0, 102));
        Label_DefenceArmy1.setText("DEFENCE ARMY");
        add(Label_DefenceArmy1);
        Label_DefenceArmy1.setBounds(110, 170, 180, 40);


        Button_du1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_du1.setForeground(new java.awt.Color(0, 0, 102));
        Button_du1.setText("unit1");
        Button_du1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_du10ActionPerformed(evt);
            }
        });
        add(Button_du1);
        Button_du1.setBounds(110, 230, 80, 30);

        Button_du2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_du2.setForeground(new java.awt.Color(0, 0, 102));
        Button_du2.setText("unit2");
        Button_du2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_du2ActionPerformed(evt);
            }
        });
        add(Button_du2);
        Button_du2.setBounds(210, 230, 80, 30);

        Button_du3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_du3.setForeground(new java.awt.Color(0, 0, 102));
        Button_du3.setText("unit3");
        Button_du3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_du3ActionPerformed(evt);
            }
        });
        add(Button_du3);
        Button_du3.setBounds(310, 230, 80, 30);

        Button_du4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_du4.setForeground(new java.awt.Color(0, 0, 102));
        Button_du4.setText("unit4");
        Button_du4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_du4ActionPerformed(evt);
            }
        });
        add(Button_du4);
        Button_du4.setBounds(410, 230, 80, 30);

        Button_du5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_du5.setForeground(new java.awt.Color(0, 0, 102));
        Button_du5.setText("unit5");
        Button_du5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_du5ActionPerformed(evt);
            }
        });
        add(Button_du5);
        Button_du5.setBounds(510, 230, 80, 30);
        
        Button_ou6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_ou6.setForeground(new java.awt.Color(0, 0, 102));
        Button_ou6.setText("unit6");
        Button_ou6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ou1ActionPerformed(evt);
            }
        });
        add(Button_ou6);
        Button_ou6.setBounds(690, 230, 80, 30);

        Button_ou7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_ou7.setForeground(new java.awt.Color(0, 0, 102));
        Button_ou7.setText("unit7");
        Button_ou7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ou6ActionPerformed(evt);
            }
        });
        add(Button_ou7);
        Button_ou7.setBounds(790, 230, 80, 30);

        Button_ou8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_ou8.setForeground(new java.awt.Color(0, 0, 102));
        Button_ou8.setText("unit8");
        Button_ou8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ou7ActionPerformed(evt);
            }
        });
        add(Button_ou8);
        Button_ou8.setBounds(890, 230, 80, 30);
        

        Button_ou9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_ou9.setForeground(new java.awt.Color(0, 0, 102));
        Button_ou9.setText("unit9");
        Button_ou9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ou9ActionPerformed(evt);
            }
        });
        add(Button_ou9);
        Button_ou9.setBounds(990, 230, 80, 30);

        Button_ou10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Button_ou10.setForeground(new java.awt.Color(0, 0, 102));
        Button_ou10.setText("unit10");
        Button_ou10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ou8ActionPerformed(evt);
            }
        });
        add(Button_ou10);
        Button_ou10.setBounds(1090, 230, 80, 30);
        

        Button_Rematch.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        Button_Rematch.setText("REMATCH");
        add(Button_Rematch);
        Button_Rematch.setBounds(790, 700, 140, 50);

        Button_Leave.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        Button_Leave.setText("LEAVE");
        Button_Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LeaveActionPerformed(evt);
            }
        });
        add(Button_Leave);
        Button_Leave.setBounds(1040, 700, 130, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("               Defence Army Status \n   Army Name:\n   level:\n   Max_HP:\n   HP:\n   Exp:\n   Defence:\n   Attack:\n   item1:\n   item2:\n   item3:");
        jScrollPane3.setViewportView(jTextArea1);

        add(jScrollPane3);
        jScrollPane3.setBounds(690, 310, 480, 360);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Mangal", 1, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("               Defence Army Status\n   Army Name:\n   level:\n   Max_HP:\n   HP:\n   Exp:\n   Defence:\n   Attack:\n   item1:\n   item2:\n   item3:");
        jScrollPane4.setViewportView(jTextArea2);

        add(jScrollPane4);
        jScrollPane4.setBounds(110, 310, 480, 360);

        java.net.URL imgURL = getClass().getResource("ResultImage.jpg");
        Label_Background.setIcon(new javax.swing.ImageIcon(imgURL));
        Label_Background.setPreferredSize(new java.awt.Dimension(1280, 960));
        add(Label_Background);
        Label_Background.setBounds(0, 0, 1280, 960);
    }// </editor-fold>                        

    private void Button_LeaveActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void Button_du2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_du3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_du4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_du5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_ou1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_ou6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_ou7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_ou8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_ou9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void Button_du10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


                 
}

