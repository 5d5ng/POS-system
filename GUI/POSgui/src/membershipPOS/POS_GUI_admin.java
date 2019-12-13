package membershipPOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
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

import membershipPOS.POS_GUI.addMemberWindow;

public class POS_GUI_admin extends JFrame{
	private JPanel thePanel = new JPanel();
	
	private JButton recordButton = new JButton(new ImageIcon("images/admin_1.jpg")); //제품구매
	private JButton lookupButton = new JButton(new ImageIcon("images/admin_2.jpg")); //회원추가
	private JButton searchButton = new JButton(new ImageIcon("images/admin_3.jpg")); //관리자모드
	private JButton addlookupButton = new JButton(new ImageIcon("images/admin_4.jpg")); //종료
	private JButton memberLookupButton = new JButton(new ImageIcon("images/admin_5.jpg")); //제품구매
	private JButton memberSearchButton = new JButton(new ImageIcon("images/admin_6.jpg")); //회원추가
	private JButton bookLookupButton = new JButton(new ImageIcon("images/admin_7.jpg")); //관리자모드
	private JButton exitButton = new JButton(new ImageIcon("images/admin_8.jpg")); //종료
	private ImageIcon logo = new ImageIcon("images/logo.jpg");
	private JLabel logoImage = new JLabel(logo);
	
	public POS_GUI_admin() 
	{
		super("MembershipPOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminMain(); //판매자 초기화면
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
	public void AdminMain() 
	{
		setLayout(new BorderLayout());
		thePanel.setBackground(new Color(26,44,91));
		thePanel.setLayout(null);
		
		setImage(recordButton);
		setImage(lookupButton);
		setImage(searchButton);
		setImage(addlookupButton);
		setImage(memberLookupButton);
		setImage(memberSearchButton);
		setImage(bookLookupButton);
		setImage(exitButton);
		
		logoImage.setBounds(20,15, 345, 50);

		recordButton.setBounds(85,150,200,200);
		recordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new recordWindow();	
			}
		});
		lookupButton.setBounds(295,150, 200, 200);

		searchButton.setBounds(495,150, 200, 200);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new searchWindow();	
			}
		});
		addlookupButton.setBounds(695,150,200,200);
		addlookupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addlookupWindow();	
			}
		});
		memberLookupButton.setBounds(85,350,200,200);
		memberSearchButton.setBounds(295,350,200,200);
		memberSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new memberSearchWindow();	
			}
		});
		bookLookupButton.setBounds(495,350,200,200);
		exitButton.setBounds(695,350, 200, 200);
		thePanel.add(logoImage);
		thePanel.add(recordButton);
		thePanel.add(lookupButton);
		thePanel.add(searchButton);
		thePanel.add(addlookupButton);
		thePanel.add(memberLookupButton);
		thePanel.add(memberSearchButton);
		thePanel.add(bookLookupButton);
		thePanel.add(exitButton);
		getContentPane().add(thePanel);
	}
	class recordWindow extends JFrame { 
		
		
		// 텍스트필드 선설정 배경 글꼴 함수
        public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("굴림",Font.PLAIN,25));
        }
        
        recordWindow() {
	        setTitle("상품등록");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);
	        
	    	ImageIcon barcode = new ImageIcon("images/barcode.jpg");
	    	JLabel barcodeImage = new JLabel(barcode);
	    	ImageIcon pname = new ImageIcon("images/pname.jpg");
	    	JLabel pnameImage = new JLabel(pname);	        
	    	ImageIcon ptype = new ImageIcon("images/ptype.jpg");
	    	JLabel ptypeImage = new JLabel(ptype);
	    	ImageIcon amount = new ImageIcon("images/amount.jpg");
	    	JLabel amountImage = new JLabel(amount);
	    	ImageIcon expiration = new ImageIcon("images/expiration.jpg");
	    	JLabel expirationImage = new JLabel(expiration);	        
	    	ImageIcon price = new ImageIcon("images/price.jpg");
	    	JLabel priceImage = new JLabel(price);
	    	
	    	
	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	
	    	
	        JTextField barcodeField = new JTextField(); 
	        setTextField(barcodeField);     
	        JTextField pnameField = new JTextField();
	        setTextField(pnameField);     
	        JTextField ptypeField = new JTextField();
	        setTextField(ptypeField);     
	        
	        JTextField amountField = new JTextField(); 
	        setTextField(amountField);     
	        JTextField expirationField = new JTextField();
	        setTextField(expirationField);     
	        JTextField priceField = new JTextField();
	        setTextField(priceField);    

	        NewWindowMember.add(barcodeImage);
	        NewWindowMember.add(pnameImage);
	        NewWindowMember.add(ptypeImage);
	        NewWindowMember.add(amountImage);
	        NewWindowMember.add(expirationImage);
	        NewWindowMember.add(priceImage);
	        
	        NewWindowMember.add(barcodeField);
	        NewWindowMember.add(pnameField);
	        NewWindowMember.add(ptypeField);
	        NewWindowMember.add(amountField);
	        NewWindowMember.add(expirationField);
	        NewWindowMember.add(priceField);
	        
	        NewWindowMember.add(okayButton);

	        barcodeImage.setBounds(55,72,118,46);
	        pnameImage.setBounds(38,160,155,47);
	        ptypeImage.setBounds(38,245,156,46);
	        amountImage.setBounds(70,335,80,46);
	        expirationImage.setBounds(38,425,155,47);
	        priceImage.setBounds(70,515,77,42);

	        barcodeField.setBounds(205,70,250,50);
	        pnameField.setBounds(205,160,250,50);
	        ptypeField.setBounds(205,250,250,50);
	        
	        amountField.setBounds(205,340,250,50);
	        expirationField.setBounds(205,430,250,50);
	        priceField.setBounds(205,520,250,50);
	        
	        okayButton.setBounds(180,620,138,51);

	        setSize(500,750);
	        setResizable(true);
	        setVisible(true);
	    }
	}
	class searchWindow extends JFrame { 
		
		// 텍스트필드 선설정 배경 글꼴 함수
        public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("굴림",Font.PLAIN,25));
        }
        
        searchWindow() {
	        setTitle("상품검색");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);
	        
	    	ImageIcon barcode = new ImageIcon("images/barcode.jpg");
	    	JLabel barcodeImage = new JLabel(barcode);

	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	
	        JTextField barcodeField = new JTextField(); 
	        setTextField(barcodeField);      

	        NewWindowMember.add(barcodeImage);
	        NewWindowMember.add(barcodeField);
	        
	        NewWindowMember.add(okayButton);

	        barcodeImage.setBounds(55,72,118,46);
	        barcodeField.setBounds(205,72,250,50);
	        
	        okayButton.setBounds(180,170,138,51);

	        setSize(500,300);
	        setResizable(true);
	        setVisible(true);
	    }
	}
	class addlookupWindow extends JFrame { 
		
		// 텍스트필드 선설정 배경 글꼴 함수
        public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("굴림",Font.PLAIN,25));
        }
        
        addlookupWindow() {
	        setTitle("재고추가");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);
	        
	    	ImageIcon barcode = new ImageIcon("images/barcode.jpg");
	    	JLabel barcodeImage = new JLabel(barcode);

	    	ImageIcon amount = new ImageIcon("images/amount.jpg");
	    	JLabel amountImage = new JLabel(amount);
	    	
	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	
	    	
	        JTextField barcodeField = new JTextField(); 
	        setTextField(barcodeField);    
	        JTextField amountField = new JTextField(); 
	        setTextField(amountField);     

	        NewWindowMember.add(barcodeImage);
	        NewWindowMember.add(amountImage);
	        
	        NewWindowMember.add(barcodeField);
	        NewWindowMember.add(amountField);
	        
	        NewWindowMember.add(okayButton);

	        barcodeImage.setBounds(55,72,118,46);
	        amountImage.setBounds(70,162,80,46);

	        barcodeField.setBounds(205,72,250,50);
	        amountField.setBounds(205,162,250,50);
	        
	        okayButton.setBounds(180,280,138,51);

	        setSize(500,400);
	        setResizable(true);
	        setVisible(true);
	    }
	}
	class memberSearchWindow extends JFrame { 
		
		// 텍스트필드 선설정 배경 글꼴 함수
        public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("굴림",Font.PLAIN,25));
        }
        
        memberSearchWindow() {
	        setTitle("고객검색");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);	        
	    	
	        ImageIcon name = new ImageIcon("images/name.jpg");
	    	JLabel nameImage = new JLabel(name);

	    	
	    	ImageIcon age = new ImageIcon("images/age.jpg");
	    	JLabel ageImage = new JLabel(age);
	    	
	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	  	
	        JTextField nameField = new JTextField(); 
	        setTextField(nameField);    
	        JTextField ageField = new JTextField(); 
	        setTextField(ageField);     

	        NewWindowMember.add(nameImage);
	        NewWindowMember.add(ageImage);	        
	        NewWindowMember.add(nameField);
	        NewWindowMember.add(ageField);	      
	        NewWindowMember.add(okayButton);

	        nameImage.setBounds(55,72,118,46);
	        ageImage.setBounds(70,162,80,46);
	        
	        nameField.setBounds(205,72,250,50);
	        ageField.setBounds(205,162,250,50);
	        
	        okayButton.setBounds(180,280,138,51);

	        setSize(500,400);
	        setResizable(true);
	        setVisible(true);
	    }
	}
}
