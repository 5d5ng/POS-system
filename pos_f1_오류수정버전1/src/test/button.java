package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class button implements ActionListener{

      JButton b1;
      JButton b2;
      JTextField tf;
      JTextField t;
      JPanel jp1;
      JPanel jp2;
      

      button() {
      JFrame f1 = new JFrame("�г� ����");
      tf = new JTextField(15);
      tf.setBounds(50, 200, 100, 30);
      jp1 = new JPanel();                // JPanel ����
      jp1.setBounds(40,80,200,200);
      jp1.setBackground(Color.gray);
      b1 = new JButton("��ư 1");
      b1.setBounds(50,100, 80,30);
      b1.setBackground(Color.yellow);
      b1.addActionListener(this);      // ������ ����, this ���  
      jp1.add(b1); jp1.add(tf);
      f1.add(jp1);
      f1.setSize(400,400);
      f1.setLayout(null);
      f1.setVisible(true);
      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
     
      }
      
      public void button2() {
    	  JFrame f2 = new JFrame("�г� ����2");
          t = new JTextField(15);
          t.setBounds(50, 200, 100, 30);
          jp2= new JPanel();                // JPanel ����
          jp2.setBounds(40,80,200,200);
          jp2.setBackground(Color.gray);
          b2 = new JButton("��ư 2");
          b2.setBounds(100,100,80,30);
          b2.setBackground(Color.green);     // ������ ����, this ���  
          b2.addActionListener(this);
           jp2.add(b2); 
           jp2.add(t);
          f2.add(jp2);
          f2.setSize(400,400);
          f2.setLayout(null);
          f2.setVisible(true);
          f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1) {
    	  button2();
      }
}
        

      public static void main(String args[])
      {
       new button();
      }
}