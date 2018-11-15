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

public class NProfesseur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PprenomField;
	private JTextField PnomField;
	private JTextField PmatiereField;
	private JTextField PemailField;
	private JTextField PphoneField;
	private JTextField PcniField;
	private JTextField PadressField;
	private JTextField PimageField;
	private JTextField PidField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NProfesseur frame = new NProfesseur();
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
	public NProfesseur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 666);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PprenomField = new JTextField();
		PprenomField.setColumns(10);
		PprenomField.setBounds(146, 151, 265, 29);
		contentPane.add(PprenomField);
		
		JLabel label = new JLabel("Prenom :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(44, 158, 83, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nom :");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setBounds(44, 212, 83, 21);
		contentPane.add(label_1);
		
		PnomField = new JTextField();
		PnomField.setColumns(10);
		PnomField.setBounds(146, 204, 265, 29);
		contentPane.add(PnomField);
		
		PmatiereField = new JTextField();
		PmatiereField.setColumns(10);
		PmatiereField.setBounds(146, 255, 265, 29);
		contentPane.add(PmatiereField);
		
		JLabel lblMatiere = new JLabel("Matiere:");
		lblMatiere.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMatiere.setBounds(44, 262, 83, 21);
		contentPane.add(lblMatiere);
		
		JLabel label_3 = new JLabel("Email :");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setBounds(44, 311, 83, 21);
		contentPane.add(label_3);
		
		PemailField = new JTextField();
		PemailField.setColumns(10);
		PemailField.setBounds(146, 304, 265, 29);
		contentPane.add(PemailField);
		
		PphoneField = new JTextField();
		PphoneField.setColumns(10);
		PphoneField.setBounds(146, 355, 265, 29);
		contentPane.add(PphoneField);
		
		JLabel label_4 = new JLabel("Phone:");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setBounds(44, 362, 83, 21);
		contentPane.add(label_4);
		
		PcniField = new JTextField();
		PcniField.setColumns(10);
		PcniField.setBounds(146, 407, 265, 29);
		contentPane.add(PcniField);
		
		JLabel label_5 = new JLabel("CNI:");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_5.setBounds(44, 414, 83, 21);
		contentPane.add(label_5);
		
		PadressField = new JTextField();
		PadressField.setColumns(10);
		PadressField.setBounds(146, 459, 265, 29);
		contentPane.add(PadressField);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblAdress.setBounds(44, 466, 83, 21);
		contentPane.add(lblAdress);
		
		PimageField = new JTextField();
		PimageField.setColumns(10);
		PimageField.setBounds(146, 515, 171, 29);
		contentPane.add(PimageField);
		
		JLabel label_7 = new JLabel("Image :");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_7.setBounds(44, 522, 83, 21);
		contentPane.add(label_7);
		
		JButton btnparcourir = new JButton("Parcourir");
		btnparcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser IconChooser=new JFileChooser();
				IconChooser.showOpenDialog(null);
				File file=IconChooser.getSelectedFile();
			    String filePath=file.getAbsolutePath();
			    PimageField.setText(filePath);	
			}
		});
		btnparcourir.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnparcourir.setBounds(322, 514, 89, 29);
		contentPane.add(btnparcourir);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setIcon(new ImageIcon("./img/icon/Actions-edit-delete-icon.png"));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    int answer=JOptionPane.showConfirmDialog(null, "voulez-vous vraimet quitter cette fenetre !!? ","Ajouter un Professeur",JOptionPane.YES_NO_CANCEL_OPTION);
			if(answer==JOptionPane.YES_OPTION){
				Toolkit toolkit=getToolkit();
				toolkit.beep();
				setVisible(false);
			}
			}
		});
		btnexit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnexit.setBounds(289, 566, 102, 36);
		contentPane.add(btnexit);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setIcon(new ImageIcon("./img/icon/add-icon.png"));
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PimageField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "s'il vous plait parcourir une image pour l'etudiant");
					PimageField.setFocusable(true);
					
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
				    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("INSERT INTO professeurs(id, fname, lname, school_subject, email,cni,phone, adress,image)  VALUES (?, ?, ?, ?, ?, ?,?,?,?) ");
					ps.setInt(1, Integer.parseInt(PidField.getText()));
					ps.setString(2, PprenomField.getText());
					ps.setString(3, PnomField.getText());
					ps.setString(4, PmatiereField.getText());
					ps.setString(5, PemailField.getText());
					ps.setString(6, PcniField.getText());
					ps.setString(7, PphoneField.getText());
					ps.setString(8, PadressField.getText());
					ps.setString(9,PimageField.getText());
					ps.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				PidField.setText("");
				PprenomField.setText("");
				PnomField.setText("");
				PmatiereField.setText("");
				PemailField.setText("");
				PcniField.setText("");
				PphoneField.setText("");
				PadressField.setText("");
				PimageField.setText("");
				int answer=JOptionPane.showConfirmDialog(null, "Enrigestrement est fait ...!","Enrigestrement",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.YES_OPTION){
					setVisible(false);
				   }
				}
			}
		});
		btnajouter.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnajouter.setBounds(146, 566, 133, 36);
		contentPane.add(btnajouter);
		
		PidField = new JTextField();
		PidField.setColumns(10);
		PidField.setBounds(146, 102, 265, 29);
		contentPane.add(PidField);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblId.setBounds(44, 105, 83, 21);
		contentPane.add(lblId);
		
		JLabel lblNouveauProfesseur = new JLabel("Nouveau Professeur");
		lblNouveauProfesseur.setForeground(new Color(51, 0, 0));
		lblNouveauProfesseur.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblNouveauProfesseur.setBounds(96, 30, 280, 42);
		contentPane.add(lblNouveauProfesseur);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("./img/IMG_6031.jpg"));
		label_2.setBounds(0, 0, 468, 627);
		contentPane.add(label_2);
	}

}
