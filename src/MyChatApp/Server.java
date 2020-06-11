package MyChatApp;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.io.*;
public class Server extends JFrame implements ActionListener {
  JPanel p1;
  JTextField t1;
  JButton b1;
 static JTextArea a1;
 static ServerSocket skt;
 static  Socket s;
 static DataInputStream din;
 static DataOutputStream dout;
	Server(){
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,400,60);
		add(p1);
		ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("MyChatApp/Icons/arrow.png"));
		Image I2=I1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
	    ImageIcon I3=new ImageIcon(I2);
		JLabel l1=new JLabel(I3);
		
		l1.setBounds(5, 15, 30, 30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon I4=new ImageIcon(ClassLoader.getSystemResource("MyChatApp/Icons/kruti.jpg"));
		Image I5=I4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
	    ImageIcon I6=new ImageIcon(I5);
		JLabel l2=new JLabel(I6);
		l2.setBounds(40,5,50,50);
		p1.add(l2);
		
		JLabel l3=new JLabel("Kruti");
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		l3.setForeground(Color.WHITE);
		l3.setBounds(100, 10, 100, 20);
		p1.add(l3);
		JLabel l4=new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
		l4.setForeground(Color.WHITE);
		l4.setBounds(100, 25, 100, 20);
		p1.add(l4);
		
		ImageIcon I7=new ImageIcon(ClassLoader.getSystemResource("MyChatApp/Icons/video.png"));
		Image I8=I7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
	    ImageIcon I9=new ImageIcon(I8);
		JLabel l5=new JLabel(I9);
		l5.setBounds(230,5 , 40, 40);
		p1.add(l5);

		
		ImageIcon I10=new ImageIcon(ClassLoader.getSystemResource("MyChatApp/Icons/Voice.png"));
		Image I11=I10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
	    ImageIcon I12=new ImageIcon(I11);
		JLabel l6=new JLabel(I12);
		l6.setBounds(300, 10, 30, 30);
		p1.add(l6);
		
		
		ImageIcon I13=new ImageIcon(ClassLoader.getSystemResource("MyChatApp/Icons/more.png"));
		Image I14=I13.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
	    ImageIcon I15=new ImageIcon(I14);
		JLabel l7=new JLabel(I15);
		l7.setBounds(350, 10, 30, 30);
    	p1.add(l7);
	
		t1=new JTextField();
		t1.setBounds(5, 470, 300, 30);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(t1);
		
		b1=new JButton("Send");
		b1.setBounds(310, 470, 85, 30);
		
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		b1.addActionListener(this);
		add(b1);
		
		a1=new JTextArea();
		a1.setBounds(5, 65, 390,400);
    	a1.setBackground(Color.white);
    	a1.setForeground(Color.cyan);
    	
    	a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
    	a1.setEditable(false);
    	a1.setLineWrap(true);
    	a1.setWrapStyleWord(true);
		add(a1);
		
		
		
		setLayout(null);
		setSize(400,500);
		setLocation(400,100);
		setUndecorated(true);
		setVisible(true);
	
		
	}
	public void actionPerformed(ActionEvent ae) {
	try {	String out=t1.getText();
	//	a1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		a1.setText(a1.getText()+"\n\n" +" YOU "+"\n"+out);
		dout.writeUTF(out);
		t1.setText("");}
	catch (Exception e) {}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server().setVisible(true);
		String msgInput="";
		try {
			skt=new ServerSocket(6001);
			while(true) {
			s=skt.accept();
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
		while(true) {	
			msgInput= din.readUTF();
			a1.setText(a1.getText()+ "\n\n" + "KRUTI" +"\n" +msgInput);}
			//skt.close();
			//s.close();
		}
		}	
		catch(Exception e)
		{
			
		}
	}

}





























