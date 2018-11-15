package connecteur;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import project.Student;

import javax.swing.ImageIcon;

public class Logging extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField userpassField;
    private Toolkit toolkit=getToolkit();
	/**
	 * Launch the application.
	 */
    /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logging frame = new Logging();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public Logging() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 333);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(396, 74, 178, 31);
		contentPane.add(usernameField);
		
		JLabel label = new JLabel("  UserName:");
		label.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(278, 69, 116, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("   Password :");
		label_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(270, 148, 116, 31);
		contentPane.add(label_1);
		
		userpassField = new JPasswordField();
		userpassField.setEchoChar('*');
		userpassField.setBounds(396, 149, 178, 31);
		contentPane.add(userpassField);
		
		JButton btnLogging = new JButton("Logging");
		btnLogging.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnLogging.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\App-login-manager-icon.png"));
		btnLogging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(usernameField.getText().length()==0){
					JOptionPane.showMessageDialog(null,"user name field is empty","Login",JOptionPane.INFORMATION_MESSAGE);
				}
				if(userpassField.getPassword().toString().length()==0){
					JOptionPane.showMessageDialog(null, "user field pass is empty","login",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String name=usernameField.getText();
					String pass=userpassField.getText();
					if(validationLoggin(name, pass)){
						JOptionPane.showMessageDialog(null, "access valid !");
						try{
						Thread.sleep(150);
						Student student=new Student();
						student.setVisible(true);
						setVisible(false);
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "access not valid !(user name or password not vaid");
					}
				}
			usernameField.setText(" ");
			userpassField.setText(" ");
				
			}
			private boolean validationLoggin(String user,String pass){
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("select * from utilisateur where username=? and userpass=?");
					ps.setString(1, user);
					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						return true;
					}
					else {
						return false;
					}
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
			}
		});
		btnLogging.setBounds(328, 203, 116, 36);
		contentPane.add(btnLogging);
		
		JButton bntCancel = new JButton("Cancel");
		bntCancel.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\delete-icon.png"));
		bntCancel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		bntCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer=JOptionPane.showConfirmDialog(null, "do you want really to exit this Window ?!!","Logging Window",JOptionPane.YES_NO_CANCEL_OPTION);
				if(answer==JOptionPane.YES_OPTION){
					toolkit.beep();
					setVisible(false);
					Home home=new Home();
					home.setVisible(true);
				}
			}
		});
		bntCancel.setBounds(454, 203, 120, 36);
		contentPane.add(bntCancel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\imagesLogin1.jpg"));
		label_2.setBounds(8, 50, 260, 198);
		contentPane.add(label_2);
		Toolkit toolkit=getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
	}
}
