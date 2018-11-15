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

public class NCours extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CurlField;
	private JTextField CdomainField;
	private JTextField CtitreField;
	private JTextField CidField;
	private JTextField CimageField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NCours frame = new NCours();
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
	public NCours() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 481);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CurlField = new JTextField();
		CurlField.setColumns(10);
		CurlField.setBounds(140, 253, 171, 29);
		contentPane.add(CurlField);
		
		JLabel lblUrl = new JLabel("URL :");
		lblUrl.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUrl.setBounds(38, 260, 83, 21);
		contentPane.add(lblUrl);
		
		JLabel lblDomain = new JLabel("Domain :");
		lblDomain.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDomain.setBounds(38, 208, 83, 21);
		contentPane.add(lblDomain);
		
		CdomainField = new JTextField();
		CdomainField.setColumns(10);
		CdomainField.setBounds(140, 201, 265, 29);
		contentPane.add(CdomainField);
		
		CtitreField = new JTextField();
		CtitreField.setColumns(10);
		CtitreField.setBounds(140, 149, 265, 29);
		contentPane.add(CtitreField);
		
		JLabel lblD = new JLabel("Titre :");
		lblD.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblD.setBounds(38, 156, 83, 21);
		contentPane.add(lblD);
		
		CidField = new JTextField();
		CidField.setColumns(10);
		CidField.setBounds(140, 98, 265, 29);
		contentPane.add(CidField);
		
		JLabel lblNom = new JLabel("ID :");
		lblNom.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNom.setBounds(38, 105, 83, 21);
		contentPane.add(lblNom);
		
		JButton btnparcourir = new JButton("Parcourir");
		btnparcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.showOpenDialog(null);
				File file=fileChooser.getSelectedFile();
				String path=file.getAbsolutePath();
				CimageField.setText(path);
				
			}
		});
		btnparcourir.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnparcourir.setBounds(316, 308, 89, 29);
		contentPane.add(btnparcourir);
		
		CimageField = new JTextField();
		CimageField.setColumns(10);
		CimageField.setBounds(140, 309, 171, 29);
		contentPane.add(CimageField);
		
		JLabel label_4 = new JLabel("Image :");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setBounds(38, 316, 83, 21);
		contentPane.add(label_4);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setIcon(new ImageIcon("./img/icon/Actions-edit-delete-icon.png"));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer=JOptionPane.showConfirmDialog(null,"voulez-vous vraiment quitter cette fenetre !!?","Enregistrement de Cours",JOptionPane.YES_NO_CANCEL_OPTION);
			    if(answer==JOptionPane.YES_OPTION){
			    	Toolkit toolkit=getToolkit();
			    	toolkit.beep();
			    	setVisible(false);
			    }
			}
		});
		btnexit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnexit.setBounds(293, 361, 102, 36);
		contentPane.add(btnexit);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setIcon(new ImageIcon("./img/icon/add-icon.png"));
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CurlField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "s'il vous plait parcourir une fichier qui vous voudrez lire !!");
					CurlField.setFocusable(true);
					
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
				    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("INSERT INTO cours(id, titre, domain, url,image_livre)  VALUES (?, ?, ?, ?, ?) ");
					ps.setInt(1,Integer.parseInt(CidField.getText()));
					ps.setString(2, CtitreField.getText());
					ps.setString(3, CdomainField.getText());
					ps.setString(4,CurlField.getText());
					ps.setString(5,CimageField.getText());
					ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}
				CidField.setText("");
				CtitreField.setText("");
				CurlField.setText("");
				CdomainField.setText("");
				CimageField.setText("");
				if(JOptionPane.showConfirmDialog(null, "Enregistrement est Fait ...","Enregistrement",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					setVisible(false);
				}
				}
				
			}
		});
		btnajouter.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnajouter.setBounds(140, 361, 129, 36);
		contentPane.add(btnajouter);
		
		JButton btnParcourirUrl = new JButton("Parcourir");
		btnParcourirUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser document=new JFileChooser();
				document.showOpenDialog(null);
				File file=document.getSelectedFile();
				String path=file.getAbsolutePath();
				CurlField.setText(path);
			}
		});
		btnParcourirUrl.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnParcourirUrl.setBounds(316, 253, 89, 29);
		contentPane.add(btnParcourirUrl);
		
		JLabel lblNouveauCours = new JLabel("Nouveau Cours");
		lblNouveauCours.setForeground(new Color(51, 0, 0));
		lblNouveauCours.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblNouveauCours.setBounds(127, 33, 214, 42);
		contentPane.add(lblNouveauCours);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./img/HNCK4067.jpg"));
		label.setBounds(0, 0, 486, 442);
		contentPane.add(label);
	}

}
