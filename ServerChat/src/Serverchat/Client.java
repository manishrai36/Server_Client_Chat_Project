package Serverchat;
import java.io.*;
import java.net.*;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
public class Client extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;
		//private static final long serialVersionUID = 1L;
		JPanel p1;
		JTextField t1;
		JButton b1;
		static JTextArea a1;
		static DataInputStream din;
		static DataOutputStream dout;
		static Socket s;
		 Client() {
			 p1=new JPanel();
			 p1.setLayout(null);
			 p1.setBackground(new Color(7,94,84));
			 p1.setBounds(0, 0, 400, 55);
			 add(p1);
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/3.png"));
			 Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		       ImageIcon i3 = new ImageIcon(i2);
		       JLabel l1 = new JLabel(i3);
		       l1.setBounds(5, 17, 30, 30);
		       p1.add(l1);
		       
		       l1.addMouseListener(new MouseAdapter()
		       {
		    	   public void mouseClicked(MouseEvent ae)
		    	   {
		    		   System.exit(0);
		    	   }
		       });
		       
				ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/2.png"));
				 Image i5 = i4.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
			       ImageIcon i6 = new ImageIcon(i5);
			       JLabel l2 = new JLabel(i6);
			       l2.setBounds(35, 3, 50, 50);
			       p1.add(l2);
			       
					ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/video.png"));
					 Image i8 = i7.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT);
				       ImageIcon i9 = new ImageIcon(i8);
				       JLabel l5 = new JLabel(i9);
				       l5.setBounds(270, 6, 50, 50);
				       p1.add(l5);
				       
						ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/phone.png"));
						 Image i12 = i11.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT);
					       ImageIcon i13 = new ImageIcon(i12);
					       JLabel l6 = new JLabel(i13);
					       l6.setBounds(315, 6, 50, 50);
					       p1.add(l6);
					       
							ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("icon/3icon.png"));
							 Image i15 = i14.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
						       ImageIcon i16 = new ImageIcon(i15);
						       JLabel l7 = new JLabel(i16);
						       l7.setBounds(370, 20, 10, 20);
						       p1.add(l7);
						       
							      
			       
			       JLabel I3=new JLabel("Bunty");
			       I3.setBounds(90, 10, 90, 20);
			       I3.setFont(new Font("arial",Font.BOLD,16));
			       I3.setForeground(Color.WHITE);
			       p1.add(I3);
			       
			       JLabel I4=new JLabel("Active Now");
			       I4.setFont(new Font("arial",Font.PLAIN,12));
			       I4.setForeground(Color.WHITE);
			       I4.setBounds(93, 30, 90, 20);
			       p1.add(I4);
			       
			       
			       a1=new JTextArea();
			       a1.setBounds(2, 58, 395, 450);
			     //  a1.setBackground(Color.pink);
			       a1.setFont(new Font("arial",Font.PLAIN,16));
			       a1.setEditable(false);
			       a1.setLineWrap(true);
			       a1.setWrapStyleWord(true);
			       add(a1);
			       
			      t1=new JTextField();
			      t1.setBounds(2, 510, 295, 37);
			      t1.setFont(new Font("arial",Font.PLAIN,14));
			       add(t1);
			       
			       b1=new JButton("SEND");
			       b1.setBounds(298, 510, 100, 36);
			       b1.setBackground(new Color(7,96,84));
			       b1.setForeground(Color.white);
			       b1.setFont(new Font("arial",Font.PLAIN,16));
			       b1.addActionListener(this);
			       add(b1);
				       
			      getContentPane().setBackground(Color.WHITE);
		       setLayout(null);
			setSize(400,550);
			setLocation(900,100);
			setUndecorated(true);
			setVisible(true);
		}

		 
		 	public void actionPerformed(ActionEvent ae)
		 	{
		 		try {
		 		//String st2="";
		 		String out=t1.getText();
		 		//if(out.equals(st2))
		 		//{
		 		//	b1.setEnabled(false);
		 		//}
		 		//else
		 	//	{	//b1.setEnabled(true);
		 			a1.setText(a1.getText()+"\n\t\t"+out);
			 		dout.writeUTF(out);
		 			t1.setText(null);
		 		//}
		 		}catch(Exception e) {}
		 		
		 		
		 	
		 	}

	


	public static void main(String[] args) {
		
		new Client().setVisible(true);
		try
		{
			String msginput= "";
			s=new Socket("127.0.0.1",7001);
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			while(true)
			{
			msginput=din.readUTF();
			a1.setText(a1.getText()+"\n"+msginput);
			}
		}catch(Exception e) {};
	}

}
