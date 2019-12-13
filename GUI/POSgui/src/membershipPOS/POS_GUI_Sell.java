package membershipPOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.Border;

import membershipPOS.POS_GUI.addMemberWindow;

public class POS_GUI_Sell extends JFrame {
	private JPanel thePanel = new JPanel();
	private JButton buyButton = new JButton(new ImageIcon("images/buy.jpg"));
	private JButton cancelButton = new JButton(new ImageIcon("images/cancel.jpg"));
	private JButton cashButton = new JButton(new ImageIcon("images/cash.jpg"));
	private JButton cardButton = new JButton(new ImageIcon("images/card.jpg"));
	private JButton baaddButton = new JButton(new ImageIcon("images/baadd.jpg"));
	private JButton bafinButton = new JButton(new ImageIcon("images/bafin.jpg"));
	private ImageIcon logo = new ImageIcon("images/logo.jpg");
	private JLabel logoImage = new JLabel(logo);
	private ImageIcon order = new ImageIcon("images/order.jpg");
	private JLabel orderImage = new JLabel(order);
	//private ImageIcon baco = new ImageIcon("images/baco.jpg");
	//private JLabel bacoImage = new JLabel(baco);
	private ImageIcon barcode = new ImageIcon("images/barcode.jpg");
	private JLabel barcodeImage = new JLabel(barcode);
	private ImageIcon num = new ImageIcon("images/amount.jpg");
	private JLabel numImage = new JLabel(num);
	private JButton exitButton = new JButton(new ImageIcon("images/sellexit.jpg"));
	
	public POS_GUI_Sell() 
	{
		super("MembershipPOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SellMain(); //판매자 초기화면
		setPreferredSize(new Dimension(1000,750));
		pack();
		setVisible(true);
	}
	public void setTextField(JTextField L){
        Border lineBorder = BorderFactory.createLineBorder(Color.white, 3);
        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
        L.setBackground(new Color(26,44,91));
        L.setForeground(Color.white);
        L.setFont(new Font("Arial",Font.PLAIN,25));
    }
	
	private void setImage(JButton bt) {
		bt.setBackground(Color.red);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setContentAreaFilled(false);
	}
	private void SellMain() {
		setLayout(new BorderLayout());
		thePanel.setBackground(new Color(26,44,91));
		thePanel.setLayout(null);
		
		setImage(buyButton);
		setImage(cancelButton);
		setImage(cashButton);
		setImage(cardButton);
		setImage(baaddButton);
		setImage(bafinButton);
		setImage(exitButton);
		
		logoImage.setBounds(20,15, 345, 50);
		orderImage.setBounds(50, 125, 501, 500);
		//bacoImage.setBounds(600, 125, 315, 207);
		
		JTextField bacoField = new JTextField(); //바코드 입력하는 곳
        setTextField(bacoField);
        JTextField numField = new JTextField();  //수량 입력하는 곳
        setTextField(numField);
        
        barcodeImage.setBounds(615, 125, 118, 46);
        numImage.setBounds(615, 180, 80, 46);
        bacoField.setBounds(772, 125, 125, 50);
        numField.setBounds(772, 180, 125, 50);
        
        
		baaddButton.setBounds(615, 250, 130, 60);
		bafinButton.setBounds(770, 250, 130, 60);
		buyButton.setBounds(620, 350, 126, 126);
		buyButton.addActionListener(new ActionListener() { //회원구매버튼 눌렀을 경우
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addBuyWindow();	
			}
		});
		cancelButton.setBounds(770, 350, 126, 126); //취소
		cashButton.setBounds(620, 500, 126, 126);  //현금
		cardButton.setBounds(770, 500, 126, 126); //카드
		exitButton.setBounds(885,10, 88, 86); //종료
		
		thePanel.add(logoImage);
		thePanel.add(orderImage);
		thePanel.add(barcodeImage);
		thePanel.add(numImage);
		thePanel.add(bacoField);
		thePanel.add(numField);
		thePanel.add(baaddButton);
		thePanel.add(bafinButton);
		thePanel.add(buyButton);
		thePanel.add(cancelButton);
		thePanel.add(cashButton);
		thePanel.add(cardButton);
		thePanel.add(exitButton);
		getContentPane().add(thePanel);
	}
	
	// 회원구매창
	class addBuyWindow extends JFrame { //회원구매 버튼 눌렀을때 활성화
		public void setTextField(JTextField L){
	        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
	        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	        L.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
	        L.setBackground(new Color(26,44,91));
	        L.setForeground(Color.white);
	        L.setFont(new Font("Arial",Font.PLAIN,25));
        }	
		addBuyWindow() {
	        setTitle("회원구매");
	        JPanel NewWindowMember = new JPanel();
			setLayout(new BorderLayout());
			NewWindowMember.setLayout(null);
			NewWindowMember.setBackground(new Color(26,44,91));
	        setContentPane(NewWindowMember);
	        
	        ImageIcon PhoneNumber = new ImageIcon("images/PhoneNumber.jpg"); 
	    	JLabel PhoneNumberImage = new JLabel(PhoneNumber);
	    	
	    	JButton okayButton = new JButton(new ImageIcon("images/okay.jpg")); //종료
	    	setImage(okayButton);
	    	
	    	JTextField phoneNumberField = new JTextField(); //전화번호입력받는 곳
	        setTextField(phoneNumberField);
	        
	        NewWindowMember.add(PhoneNumberImage);
	        NewWindowMember.add(phoneNumberField);
	        NewWindowMember.add(okayButton);
	        
	        PhoneNumberImage.setBounds(20,50,175,44);
	        phoneNumberField.setBounds(215,50,250,50);
	        
	        okayButton.setBounds(180,125,138,51);
	        setSize(500,250);
	        setResizable(true);
	        setVisible(true);
		}
	}
	
}
