package membershipPOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class POS_GUI extends JFrame{
	private JPanel thePanel = new JPanel();
	private JButton sellButton = new JButton(new ImageIcon("images/sell.jpg")); //제품구매
	private JButton memberButton = new JButton(new ImageIcon("images/member.jpg")); //회원추가
	private JButton adminButton = new JButton(new ImageIcon("images/admin.jpg")); //관리자모드
	private JButton exitButton = new JButton(new ImageIcon("images/exit.jpg")); //종료
	private ImageIcon logo = new ImageIcon("images/logo.jpg");
	private JLabel logoImage = new JLabel(logo);
	
	public POS_GUI() 
	{
		super("MembershipPOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main(); //판매자 초기화면
		setPreferredSize(new Dimension(1000,750));
		pack();
		setVisible(true);
	}
	private void setImage(JButton bt) {
		bt.setBackground(Color.red);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setContentAreaFilled(false);
	}
	public void Main() 
	{
		setLayout(new BorderLayout());
		thePanel.setBackground(new Color(26,44,91));
		thePanel.setLayout(null);
		setImage(sellButton);
		setImage(memberButton);
		setImage(adminButton);
		setImage(exitButton);
		
		logoImage.setBounds(20,15, 345, 50);
		
		sellButton.setBounds(250,150, 200, 200);
		sellButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addSellWindow();
			}
		});
		
		memberButton.setBounds(500,150, 200, 200);
		memberButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addMemberWindow();	
			}
		});
		
		adminButton.setBounds(250,400, 200, 200);
		adminButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new adminWindow();	
			}
		});
		
		exitButton.setBounds(500,400, 200, 200);
		thePanel.add(logoImage);
		thePanel.add(sellButton);
		thePanel.add(memberButton);
		thePanel.add(adminButton);
		thePanel.add(exitButton);
		getContentPane().add(thePanel);
	}
	
	//회원추가창
	class addMemberWindow extends JFrame { 
		
		
		// 텍스트필드 선설정 배경 글꼴 함수
        public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("Arial",Font.PLAIN,25));
        }
        
		addMemberWindow() {
	        setTitle("회원추가");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);
	        
	    	ImageIcon name = new ImageIcon("images/name.jpg");
	    	JLabel nameImage = new JLabel(name);
	    	ImageIcon age = new ImageIcon("images/age.jpg");
	    	JLabel ageImage = new JLabel(age);	        
	    	ImageIcon PhoneNumber = new ImageIcon("images/PhoneNumber.jpg");
	    	JLabel PhoneNumberImage = new JLabel(PhoneNumber);
	    	
	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	
	    	
	        JTextField nameField = new JTextField(); 
	        setTextField(nameField);     
	        JTextField phoneNumberField = new JTextField();
	        setTextField(phoneNumberField);     
	        JTextField ageField = new JTextField();
	        setTextField(ageField);     


	        NewWindowMember.add(nameImage);
	        NewWindowMember.add(ageImage);
	        NewWindowMember.add(PhoneNumberImage);
	        NewWindowMember.add(nameField);
	        NewWindowMember.add(phoneNumberField);
	        NewWindowMember.add(ageField);
	        NewWindowMember.add(okayButton);

	    	nameImage.setBounds(55,72,85,46);
	    	ageImage.setBounds(55,160,81,47);
	    	PhoneNumberImage.setBounds(13,255,175,44);

	        nameField.setBounds(205,70,250,50);
	        phoneNumberField.setBounds(205,160,250,50);
	        ageField.setBounds(205,250,250,50);
	        okayButton.setBounds(170,360,138,51);


	        setSize(500,500);
	        setResizable(true);
	        setVisible(true);
	    }
	}
	//관리자 창 
	class adminWindow extends JFrame { 
        adminWindow() {
        	POS_GUI_admin frame = new POS_GUI_admin();
	    }
	}
	
	class addSellWindow extends JFrame {
		addSellWindow(){
			POS_GUI_Sell frame = new POS_GUI_Sell();
		}
	}
}