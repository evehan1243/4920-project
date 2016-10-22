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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import UnitSummaryUI.magnifyButton;
//import TradeSystemUI.searchAction;

public class UnitSummaryUI1 extends JPanel {
	
    // Variables declaration - do not modify 
	private JPanel pl;
	
	private JPanel contentPane;
    private javax.swing.JLabel Label_Title;
    
    private JButton FirstButton;
    private JButton LastButton;
    private JButton BackButton;
    
    private javax.swing.JLabel Label_Solidier;
    private javax.swing.JTextArea TextArea1_SolidierInformation;
    
    private javax.swing.JLabel Label_Background;
    // End of variables declaration  
    
    public JPanel getTradeSystemUI() {
		return contentPane;
	}

    public UnitSummaryUI1(JPanel p) {
    	pl = p;
    	
        Label_Title = new javax.swing.JLabel();
        
        Label_Solidier = new javax.swing.JLabel();
        TextArea1_SolidierInformation = new javax.swing.JTextArea();
        
        Label_Background = new javax.swing.JLabel();
    	
        setPreferredSize(new java.awt.Dimension(1280, 960));
        setLayout(null);

        Label_Title.setFont(new java.awt.Font("·½Õý³¬´ÖºÚ¼òÌå", 1, 46)); // NOI18N
        Label_Title.setForeground(new java.awt.Color(153, 0, 0));
        Label_Title.setText("UNIT SUMMARY");
        add(Label_Title);
        Label_Title.setBounds(430, 100, 500, 100);
        
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
		add(FirstButton);

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
		add(LastButton);

		LastButton.addActionListener(new NextPageAction());
		LastButton.addMouseListener(new magnifyButton());

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
		add(BackButton);

		BackButton.addActionListener(new TurnBackAction());
		BackButton.addMouseListener(new magnifyButton());

        java.net.URL imgURL4 = getClass().getResource("UnitSImage/soldier_1.png");
        Label_Solidier.setIcon(new javax.swing.ImageIcon(imgURL4));
        add(Label_Solidier);
        Label_Solidier.setBounds(300, 210, 320, 450);

        TextArea1_SolidierInformation.setColumns(20);
        TextArea1_SolidierInformation.setRows(5);
        TextArea1_SolidierInformation.setOpaque(false);

        add(TextArea1_SolidierInformation);
        TextArea1_SolidierInformation.setBounds(530, 280, 220, 250);

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
	
	private class TurnBackAction implements ActionListener{
		public void actionPerformed(ActionEvent a){
			((CardLayout) pl.getLayout()).previous(pl);
			pl.remove(contentPane);
		}
	}
	
	private class NextPageAction implements ActionListener{
		public void actionPerformed(ActionEvent a){
			pl.add(new UnitSummaryUI2(pl));
			((CardLayout) pl.getLayout()).next(pl);
		}
	}
	
}

