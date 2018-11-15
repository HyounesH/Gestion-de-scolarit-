package creation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.Student;

import java.awt.Color;
import javax.swing.ImageIcon;

public class NEtudiant extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numeroField;
	private JTextField prenomField;
	private JTextField nomField;
	private JTextField cneField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField cniField;
	private JTextField resultatField;
	private JTextField imageuserField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NEtudiant frame = new NEtudiant();
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
	public NEtudiant() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 665);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numeroField = new JTextField();
		numeroField.setColumns(10);
		numeroField.setBounds(150, 89, 265, 29);
		contentPane.add(numeroField);
		
		JLabel label = new JLabel("Numero :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(48, 92, 83, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Prenom :");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setBounds(48, 147, 83, 21);
		contentPane.add(label_1);
		
		prenomField = new JTextField();
		prenomField.setColumns(10);
		prenomField.setBounds(150, 140, 265, 29);
		contentPane.add(prenomField);
		
		nomField = new JTextField();
		nomField.setColumns(10);
		nomField.setBounds(150, 193, 265, 29);
		contentPane.add(nomField);
		
		JLabel label_2 = new JLabel("Nom :");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_2.setBounds(48, 200, 83, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("CNE:");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setBounds(48, 250, 83, 21);
		contentPane.add(label_3);
		
		cneField = new JTextField();
		cneField.setColumns(10);
		cneField.setBounds(150, 243, 265, 29);
		contentPane.add(cneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(150, 292, 265, 29);
		contentPane.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(150, 343, 265, 29);
		contentPane.add(phoneField);
		
		JLabel label_4 = new JLabel("Phone:");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setBounds(48, 350, 83, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Email :");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_5.setBounds(48, 299, 83, 21);
		contentPane.add(label_5);
		
		cniField = new JTextField();
		cniField.setColumns(10);
		cniField.setBounds(150, 395, 265, 29);
		contentPane.add(cniField);
		
		JLabel label_6 = new JLabel("CNI:");
		label_6.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_6.setBounds(48, 402, 83, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Resultat:");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_7.setBounds(48, 454, 83, 21);
		contentPane.add(label_7);
		
		resultatField = new JTextField();
		resultatField.setColumns(10);
		resultatField.setBounds(150, 447, 265, 29);
		contentPane.add(resultatField);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setIcon(new ImageIcon("./img/icon/add-icon.png"));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(imageuserField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "s'il vous plait parcourir une image pour l'etudiant");
					imageuserField.setFocusable(true);
					
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
				    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("INSERT INTO etudiant(numero, prenom, nom, cne, email,phone,cni, resultat,image_user)  VALUES (?, ?, ?, ?, ?, ?,?,?,?) ");
					ps.setInt(1, Integer.parseInt(numeroField.getText()));
					ps.setString(2, prenomField.getText());
					ps.setString(3, nomField.getText());
					ps.setInt(4, Integer.parseInt(cneField.getText()));
					ps.setString(5, emailField.getText());
					ps.setInt(6, Integer.parseInt(phoneField.getText()));
					ps.setString(7, cniField.getText());
					ps.setDouble(8, Double.parseDouble(resultatField.getText()));
					ps.setString(9,imageuserField.getText());
					ps.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				numeroField.setText("");
				prenomField.setText("");
				nomField.setText("");
				cneField.setText("");
				emailField.setText("");
				phoneField.setText("");
				cniField.setText("");
				resultatField.setText("");
				imageuserField.setText("");
				int answer=JOptionPane.showConfirmDialog(null, "Enrigestrement est fait ...!","Enrigestrement",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.YES_OPTION){
					setVisible(false);
				   }
				}
			}
		});
		ajouter.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		ajouter.setBounds(150, 554, 134, 34);
		contentPane.add(ajouter);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon("./img/icon/Actions-edit-delete-icon.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer=JOptionPane.showConfirmDialog(null, "voulez-vous vraiment fermer cette fenetre !!?","Ajouter Etudiant",JOptionPane.YES_NO_CANCEL_OPTION);
			if(answer==JOptionPane.YES_OPTION){
				Toolkit toolkit=getToolkit();
				toolkit.beep();
				setVisible(false);
			}
			}
		});
		btnExit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnExit.setBounds(313, 554, 102, 34);
		contentPane.add(btnExit);
		
		imageuserField = new JTextField();
		imageuserField.setColumns(10);
		imageuserField.setBounds(150, 503, 171, 29);
		contentPane.add(imageuserField);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblImage.setBounds(48, 510, 83, 21);
		contentPane.add(lblImage);
		
		JButton btnParcourir = new JButton("Parcourir");
		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser IconChooser=new JFileChooser();
				IconChooser.showOpenDialog(null);
				File file=IconChooser.getSelectedFile();
			    String filePath=file.getAbsolutePath();
			    imageuserField.setText(filePath);			
			    }
		});
		btnParcourir.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnParcourir.setBounds(326, 502, 89, 29);
		contentPane.add(btnParcourir);
		
		JLabel label_8 = new JLabel("Nouveau Etudiant");
		label_8.setForeground(new Color(51, 0, 0));
		label_8.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		label_8.setBounds(119, 25, 248, 42);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("./img/index7.jpg"));
		label_9.setBounds(0, 0, 480, 626);
		contentPane.add(label_9);
	}
}
