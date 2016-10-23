import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


//import UnitSummaryUI.magnifyButton;
//import TradeSystemUI.searchAction;

public class UnitSummaryUI1 extends JPanel {
	Player p = new Player();
	Unit u1 = new Unit(0,5,10,5);
	Unit u2 = new Unit(3,6,9,6);
	Unit u3 = new Unit(2,5,5,5);
	Unit u4 = new Unit(1,7,8,5);
	ArrayList<Unit> Army;
	
	//String text = Army.get(0).getUnitName();

    // Variables declaration - do not modify 
	private JPanel pl;
	
	private JPanel contentPanel;
	private JPanel In_interface;
	
    private javax.swing.JLabel Label_Title;
    
    private JButton FirstButton;
    private JButton LastButton;
    private JButton BackButton;
    
    private javax.swing.JLabel Label_Solidier;
    private javax.swing.JLabel Label_Solidier2;
    
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea4;
    
    private javax.swing.JLabel Label_Background;
    private static String page = "page1";
    
    private final static String newline = "\n";
    
    private InGameHandle gHandle;
    // End of variables declaration  
    
    public JPanel getUnitSummaryUI1() {
		return contentPanel;
	}

    public UnitSummaryUI1(JPanel p) {
    	pl = p;
    	
		contentPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				 java.net.URL imgURL = getClass().getResource("UnitSImage/background.png");
				 ImageIcon icon = new ImageIcon(imgURL);
				 Image img = icon.getImage();  
	             g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());   
			}
		};
		contentPanel.setOpaque(false);
		contentPanel.setBorder(null);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		((CardLayout) contentPanel.getLayout()).show(contentPanel, "first");

		In_interface = new JPanel();
		contentPanel.add(In_interface, "first");
		In_interface.setLayout(new GridLayout(0, 1, 0, 0));
		In_interface.setOpaque(false);

		JPanel top = new JPanel();
		In_interface.add(top);
		top.setBackground(null);
		top.setOpaque(false);
		top.setLayout(null);
    	
        Label_Title = new javax.swing.JLabel();
        
        Label_Solidier = new javax.swing.JLabel();
        
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        
        jTextArea4.setColumns(5);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        top.add(jScrollPane4);
        jScrollPane4.setBounds(700, 300, 170, 200);
    	
        String type = u1.getTypeName();
        int max_HP = u1.getMaxHP();
        int attack = u1.getAttack();
        int defense = u1.getDefence();
        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
        		          "     MAX_HP:    "+max_HP+ newline+newline+
        		          "     ATTACK:    "+attack+ newline+newline+
        		          "     DEFENCE:    "+defense+ newline);
        
        Label_Background = new javax.swing.JLabel();
    	
        setPreferredSize(new java.awt.Dimension(1280, 960));
        setLayout(null);

        Label_Title.setFont(new java.awt.Font("·½Õý³¬´ÖºÚ¼òÌå", 1, 46)); // NOI18N
        Label_Title.setForeground(new java.awt.Color(153, 0, 0));
        Label_Title.setText("UNIT SUMMARY");
        top.add(Label_Title);
        Label_Title.setBounds(430, 150, 500, 100);
        
        
        FirstButton = new JButton() {
			protected void paintComponent(Graphics g) {
				int x = 0, y = 0;
				g.drawImage(new ImageIcon(getClass().getResource("UnitSImage/button_first.png")).getImage(), x, y, getSize().width,
						getSize().height, this);
			}
		};

		FirstButton.setBounds(150, 350, 128, 128);
		FirstButton.setBorder(null);
		FirstButton.setContentAreaFilled(false);
		top.add(FirstButton);
		FirstButton.addActionListener(new LastPageAction());
		FirstButton.addMouseListener(new magnifyButton());

		LastButton = new JButton() {
			protected void paintComponent(Graphics g) {
				int x = 0, y = 0;
				g.drawImage(new ImageIcon(getClass().getResource("UnitSImage/button_last.png")).getImage(), x, y, getSize().width,
						getSize().height, this);
			}
		};

		LastButton.setBounds(1000, 350, 128, 128);
		LastButton.setBorder(null);
		LastButton.setContentAreaFilled(false);
		top.add(LastButton);

		LastButton.addActionListener(new NextPageAction());
		LastButton.addMouseListener(new magnifyButton());
		
		if(page.equals("page1")){
	        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_1.png");
	        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		}
		
        top.add(Label_Solidier);
        Label_Solidier.setBounds(300, 210, 320, 450);
        

		BackButton = new JButton() {
			protected void paintComponent(Graphics g) {
				int x = 0, y = 0;
				g.drawImage(new ImageIcon(getClass().getResource("UnitSImage/BackButton.png")).getImage(), x, y, getSize().width,
						getSize().height, this);
			}
		};

		BackButton.setBounds(950, 650, 200, 57);
		BackButton.setBorder(null);
		BackButton.setContentAreaFilled(false);
		top.add(BackButton);

		BackButton.addActionListener(new TurnBackAction());
		BackButton.addMouseListener(new magnifyButton());

        java.net.URL imgURL = getClass().getResource("UnitSImage/background.png");
        Label_Background.setIcon(new javax.swing.ImageIcon(imgURL));
        add(Label_Background);
        Label_Background.setBounds(0, -110, 1280, 960);
        
    }    
    
	private class magnifyButton implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			JButton btn = (JButton) e.getComponent();
			btn.setBounds(btn.getX() - 10, btn.getY() - 10, btn.getWidth() + 20, btn.getHeight() + 20);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			JButton btn = (JButton) e.getComponent();
			btn.setBounds(btn.getX() + 10, btn.getY() + 10, btn.getWidth() - 20, btn.getHeight() - 20);
		}

	}
	
	private class NextPageAction implements ActionListener{
		public void actionPerformed(ActionEvent a){
			if(page.equals("page1")){
				page = "page2";
		        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_2.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u2.getTypeName();
		        int max_HP = u2.getMaxHP();
		        int attack = u2.getAttack();
		        int defense = u2.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}else if(page.equals("page2")){
				page = "page3";
		        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_3.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u3.getTypeName();
		        int max_HP = u3.getMaxHP();
		        int attack = u3.getAttack();
		        int defense = u3.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}else if(page.equals("page3")){
				page = "page4";
		        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_4.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u4.getTypeName();
		        int max_HP = u4.getMaxHP();
		        int attack = u4.getAttack();
		        int defense = u4.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}
		}
	}
	
	public static void reSetPanel(JPanel contentPanel,javax.swing.JLabel Label_Solidier){

		contentPanel.add(Label_Solidier);
	}
	
	private class LastPageAction implements ActionListener{
		public void actionPerformed(ActionEvent a){
			if(page.equals("page4")){
				page = "page3";
		        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_3.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u3.getTypeName();
		        int max_HP = u3.getMaxHP();
		        int attack = u3.getAttack();
		        int defense = u3.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}else if(page.equals("page3")){
				page = "page2";
				java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_2.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u2.getTypeName();
		        int max_HP = u2.getMaxHP();
		        int attack = u2.getAttack();
		        int defense = u2.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}else if(page.equals("page2")){
				page = "page1";
				java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_1.png");
		        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
		        String type = u1.getTypeName();
		        int max_HP = u1.getMaxHP();
		        int attack = u1.getAttack();
		        int defense = u1.getDefence();
		        jTextArea4.setText(null);
		        jTextArea4.append(newline+newline+"     TYPE:    "+type+ newline +newline+
		        		          "     MAX_HP:    "+max_HP+ newline+newline+
		        		          "     ATTACK:    "+attack+ newline+newline+
		        		          "     DEFENCE:    "+defense+ newline);
		        contentPanel.revalidate();
			}
		}
	}
	
	private class TurnBackAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			page = "page1";
				((CardLayout) pl.getLayout()).previous(pl);
				pl.remove(contentPanel);
		}
	}
	
}

