package creation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.Student;

import java.awt.Color;
import javax.swing.ImageIcon;

public class NActivite extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AdateField;
	private JTextField AtypeField;
	private JTextField AnomField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NActivite frame = new NActivite();
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
	public NActivite() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AdateField = new JTextField("DD-MM-YYYY");
		AdateField.setFont(new Font("Arial Black", Font.ITALIC, 13));
		AdateField.setColumns(10);
		AdateField.setBounds(123, 213, 265, 29);
		contentPane.add(AdateField);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDate.setBounds(21, 220, 83, 21);
		contentPane.add(lblDate);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblType.setBounds(21, 168, 83, 21);
		contentPane.add(lblType);
		
		AtypeField = new JTextField();
		AtypeField.setFont(new Font("Arial Black", Font.ITALIC, 13));
		AtypeField.setColumns(10);
		AtypeField.setBounds(123, 161, 265, 29);
		contentPane.add(AtypeField);
		
		AnomField = new JTextField();
		AnomField.setFont(new Font("Arial Black", Font.ITALIC, 13));
		AnomField.setColumns(10);
		AnomField.setBounds(123, 110, 265, 29);
		contentPane.add(AnomField);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNom.setBounds(21, 117, 83, 21);
		contentPane.add(lblNom);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setIcon(new ImageIcon("./img/icon/add-icon.png"));
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AnomField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "field de Nom d'activité est vide !!");
					AnomField.setFocusable(true);
				}
				else{
					try{
					String url="jdbc:postgresql://localhost:5432/mydatabase";
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection(url,"postgres","y1sasm");
					java.sql.PreparedStatement ps=con.prepareStatement("INSERT INTO activite(nomact, type, temp) VALUES (?, ?, ?)");
					ps.setString(1, AnomField.getText());
					ps.setString(2, AtypeField.getText());
					ps.setString(3, AdateField.getText());
					ps.executeUpdate();
					}catch(Exception ex){
						ex.printStackTrace();
					}
					AnomField.setText("");
					AdateField.setText("");
					AtypeField.setText("");
					if(JOptionPane.showConfirmDialog(null, "L'Energistrement est fait ...","Energistrement d'Activité",JOptionPane.YES_NO_OPTION)
							==JOptionPane.YES_OPTION){
						Toolkit toolkit=getToolkit();
						toolkit.beep();
						setVisible(false);
					}
				}
			}
		});
		btnajouter.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnajouter.setBounds(133, 253, 130, 39);
		contentPane.add(btnajouter);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setIcon(new ImageIcon("./img/icon/Actions-edit-delete-icon.png"));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "voulez-vous vraiment quitter cette fenetre !!?","Energistrement d'activité",JOptionPane.YES_NO_CANCEL_OPTION)
						==JOptionPane.YES_OPTION){
					Toolkit toolkit=getToolkit();
					toolkit.beep();
					setVisible(false);
				}
			}
		});
		btnexit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnexit.setBounds(273, 253, 115, 39);
		contentPane.add(btnexit);
		
		JLabel lblNouveauEtudiant = new JLabel("Nouveau Activit\u00E9");
		lblNouveauEtudiant.setForeground(new Color(51, 0, 0));
		lblNouveauEtudiant.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblNouveauEtudiant.setBounds(98, 35, 248, 42);
		contentPane.add(lblNouveauEtudiant);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./img/HNCK4003.jpg"));
		label.setBounds(0, 0, 434, 336);
		contentPane.add(label);
	}
}
