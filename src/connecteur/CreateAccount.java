package connecteur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField userID;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField usernameField;
	private JPasswordField userpassField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField urlimageField;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 592);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBackground(Color.WHITE);
		panel.setBounds(55, 11, 460, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblId.setBounds(43, 62, 33, 25);
		panel.add(lblId);
		
		userID = new JTextField();
		userID.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		userID.setBounds(133, 62, 260, 25);
		panel.add(userID);
		userID.setColumns(10);
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		fnameField.setColumns(10);
		fnameField.setBounds(133, 108, 260, 25);
		panel.add(fnameField);
		
		lnameField = new JTextField();
		lnameField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lnameField.setColumns(10);
		lnameField.setBounds(133, 153, 260, 25);
		panel.add(lnameField);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		usernameField.setColumns(10);
		usernameField.setBounds(133, 199, 260, 25);
		panel.add(usernameField);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblFirstName.setBounds(43, 108, 80, 25);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblLastName.setBounds(43, 153, 80, 25);
		panel.add(lblLastName);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblUsername.setBounds(43, 199, 80, 25);
		panel.add(lblUsername);
		
		userpassField = new JPasswordField();
		userpassField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		userpassField.setBounds(133, 250, 260, 25);
		panel.add(userpassField);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPassword.setBounds(43, 249, 80, 25);
		panel.add(lblPassword);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		emailField.setColumns(10);
		emailField.setBounds(133, 299, 260, 25);
		panel.add(emailField);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblEmail.setBounds(43, 299, 80, 25);
		panel.add(lblEmail);
		
		JLabel lblCreateAccount = new JLabel("         Create Account");
		lblCreateAccount.setBackground(new Color(0, 128, 128));
		lblCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblCreateAccount.setBounds(43, 11, 218, 25);
		panel.add(lblCreateAccount);
		Toolkit toolkit=getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
		JButton cancel = new JButton("Cancel");
		cancel.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\delete-icon.png"));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer=JOptionPane.showConfirmDialog(null, "do you really want to exit this window ?","Create Account",JOptionPane.YES_NO_CANCEL_OPTION);
				if(answer==JOptionPane.YES_OPTION){
					setVisible(false);	
					Home home=new Home();
					home.setVisible(true);
					}
			}
		});
		cancel.setBackground(UIManager.getColor("activeCaption"));
		cancel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		cancel.setBounds(268, 462, 111, 33);
		panel.add(cancel);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\client-account-template-icon.png"));
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(userID.getText().length()==0 || fnameField.getText().length()==0 || lnameField.getText().length()==0 || usernameField.getText().length()==0 || userpassField.getText().toString().length()==0
					|| emailField.getText().toString().length()==0 || phoneField.getText().toString().length()==0 ||  urlimageField.getText().toString().length()==0){
				JOptionPane.showMessageDialog(null, "une case ou plusiers cases sont vide s'il vous plait remplir  tous les cases !!","ERROR",JOptionPane.ERROR_MESSAGE);
				toolkit.beep();
			}
			else{
				try {
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("INSERT INTO utilisateur(id, prenom, nom, username, userpass, email,phone,image)  VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
					ps.setInt(1,Integer.parseInt(userID.getText()));
					ps.setString(2, fnameField.getText());
					ps.setString(3, lnameField.getText());
					ps.setString(4, usernameField.getText());
					ps.setString(5, userpassField.getText().toString());
					ps.setString(6, emailField.getText());
					ps.setString(7, phoneField.getText());
					ps.setString(8, urlimageField.getText());
					int rs=ps.executeUpdate();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "account created successfully ..");
			    setVisible(false);
			    Home home=new Home();
				home.setVisible(true);
			}
			}
		});
		createAccount.setBackground(UIManager.getColor("inactiveCaption"));
		createAccount.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		createAccount.setBounds(83, 462, 175, 33);
		panel.add(createAccount);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		phoneField.setColumns(10);
		phoneField.setBounds(133, 351, 260, 25);
		panel.add(phoneField);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblPhone.setBounds(43, 351, 80, 25);
		panel.add(lblPhone);
		
		urlimageField = new JTextField();
		urlimageField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		urlimageField.setColumns(10);
		urlimageField.setBounds(133, 404, 175, 25);
		panel.add(urlimageField);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblImage.setBounds(43, 404, 80, 25);
		panel.add(lblImage);
		
		JButton btnParcourir = new JButton("parcourir");
		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.showOpenDialog(null);
				File file=fileChooser.getSelectedFile();
				urlimageField.setText(file.getAbsolutePath());
			}
		});
		btnParcourir.setBounds(318, 405, 90, 25);
		panel.add(btnParcourir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\photo_3D\\btn_previous_next.jpg"));
		label.setBounds(0, 0, 575, 553);
		contentPane.add(label);
	}
}
