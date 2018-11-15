package editInfo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.Student;

import java.awt.Color;
import javax.swing.ImageIcon;

public class EditActivite extends JFrame {

	private JPanel contentPane;
	private JTextField rechercheField;
	private JTextField nomField;
	private JTextField typeField;
	private JTextField dateField;
	private JComboBox recherchecomboBox;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditActivite frame = new EditActivite();
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
	public EditActivite() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 465);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"NomAct", "Type", "Temp"}));
		recherchecomboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		recherchecomboBox.setBounds(154, 141, 115, 29);
		contentPane.add(recherchecomboBox);
		
		JLabel label = new JLabel("Recherche Par :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(28, 149, 144, 21);
		contentPane.add(label);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(rechercheField.getText().length()==0){
					nomField.setText("");
					typeField.setText("");
					dateField.setText("");
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from activite where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					nomField.setText(rs.getString("nomact"));
					typeField.setText(rs.getString("type"));
					dateField.setText(rs.getString("temp"));
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			}
		});
		rechercheField.setColumns(10);
		rechercheField.setBounds(279, 141, 144, 29);
		contentPane.add(rechercheField);
		
		JButton btnrecherche = new JButton("Recherche");
		btnrecherche.setIcon(new ImageIcon("./img/icon/Zoom-icon.png"));
		btnrecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(rechercheField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "La Case de recherche est vide !!");
					rechercheField.setFocusable(true);
					nomField.setText("");
					typeField.setText("");
					dateField.setText("");
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from activite where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					nomField.setText(rs.getString("nomact"));
					typeField.setText(rs.getString("type"));
					dateField.setText(rs.getString("temp"));
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}
				rechercheField.setText("");
			}
			}
		});
		btnrecherche.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnrecherche.setBounds(433, 141, 155, 29);
		contentPane.add(btnrecherche);
		
		nomField = new JTextField();
		nomField.setEnabled(false);
		nomField.setColumns(10);
		nomField.setBounds(141, 203, 265, 29);
		contentPane.add(nomField);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNom.setBounds(39, 210, 83, 21);
		contentPane.add(lblNom);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblType.setBounds(39, 261, 83, 21);
		contentPane.add(lblType);
		
		typeField = new JTextField();
		typeField.setColumns(10);
		typeField.setBounds(141, 254, 265, 29);
		contentPane.add(typeField);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(141, 306, 265, 29);
		contentPane.add(dateField);
		
		JLabel lblDa = new JLabel("Date:");
		lblDa.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDa.setBounds(39, 313, 83, 21);
		contentPane.add(lblDa);
		
		JButton btnreparer = new JButton("Reparer");
		btnreparer.setIcon(new ImageIcon("./img/icon/Apps-system-software-update-icon.png"));
		btnreparer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nomField.getText().length()==0 || typeField.getText().length()==0 || dateField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "une ou plusiers sont vide s'il vous plait verifier tous les cases !!");
				}
				else{
					try{
						Class.forName("org.postgresql.Driver");
					    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
						PreparedStatement ps=con.prepareStatement("UPDATE activite SET nomact=?, type=?, temp=? WHERE nomact=?");
						ps.setString(1,nomField.getText());
						ps.setString(2, typeField.getText());
						ps.setString(3, dateField.getText());
						ps.setString(4,nomField.getText());
					
						ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}
				}
			}
		});
		btnreparer.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnreparer.setBounds(282, 365, 124, 39);
		contentPane.add(btnreparer);
		
		JButton btnvalidate = new JButton("Validate");
		btnvalidate.setIcon(new ImageIcon("./img/icon/Action-ok-icon.png"));
		btnvalidate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "les infos d'activite "+nomField.getText() +" sont reparé !!! ","Activité Information",JOptionPane.YES_NO_OPTION)==
	            		JOptionPane.YES_OPTION){
					Toolkit toolkit=getToolkit();
					toolkit.beep();
					setVisible(false);
					
				}
			}
		});
		btnvalidate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnvalidate.setBounds(141, 365, 131, 39);
		contentPane.add(btnvalidate);
		
		JLabel lblEditEtReparer = new JLabel("Edit et Reparer une Activit\u00E9");
		lblEditEtReparer.setForeground(new Color(51, 0, 0));
		lblEditEtReparer.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblEditEtReparer.setBounds(90, 50, 393, 42);
		contentPane.add(lblEditEtReparer);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("./img/HNCK0906.jpg"));
		label_1.setBounds(0, 0, 598, 426);
		contentPane.add(label_1);
	}

}
