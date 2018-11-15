package connecteur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.SplashScreen;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args)throws Exception {
		SplashScreen splash=new SplashScreen();
		splash.setVisible(true);
		  Thread t=Thread.currentThread();
	        t.sleep(10000);
	        splash.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogging = new JButton("LOGGING");
		btnLogging.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\login-icon1.png"));
		btnLogging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logging logging=new Logging();
				logging.setVisible(true);
				setVisible(false);
			}
		});
		btnLogging.setBackground(UIManager.getColor("inactiveCaption"));
		btnLogging.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnLogging.setBounds(86, 68, 270, 50);
		contentPane.add(btnLogging);
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\add-icon.png"));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount createAccount=new CreateAccount();
				createAccount.setVisible(true);
				setVisible(false);
			}
		});
		btnCreateAccount.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnCreateAccount.setBackground(SystemColor.inactiveCaption);
		btnCreateAccount.setBounds(86, 157, 270, 50);
		contentPane.add(btnCreateAccount);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\Aider-son-enfant-dans-sa-scolarite_imagePanoramique500_220.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}

}
