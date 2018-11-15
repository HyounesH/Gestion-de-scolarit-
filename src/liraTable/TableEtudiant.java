package liraTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TableEtudiant extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String columns[]={"Numero", "Prenom", "Nom", "CNE", "Email", "Phone", "CNI", "Resultat"};
	private Object rows[][]={};
	private DefaultTableModel obj=new DefaultTableModel(rows,columns);
	private JPanel toolPanel;
	private JButton btnRecherche;
	private JTextField rechercheField;
	private JComboBox rechercheParBox;
	private JLabel label;
	private JPanel editInfoPanel;
	private JLabel lblNomComplet;
	private JLabel lblNumero;
	private JLabel lblNcne;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblCni;
	private JLabel lblResultat;
	private JTextField nomcompletField;
	private JTextField numeroField;
	private JTextField cneField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField cniField;
	private JTextField resultatField;
	private JPanel panel;
	private JButton btnEdit;
	private JLabel imagelabel;
	private String filePath;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableEtudiant frame = new TableEtudiant();
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
	public TableEtudiant() {
		getData();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 675, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(obj);
		table.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		scrollPane.setViewportView(table);
		
		toolPanel = new JPanel();
		toolPanel.setBackground(new Color(176, 196, 222));
		toolPanel.setBounds(0, 157, 675, 40);
		contentPane.add(toolPanel);
		toolPanel.setLayout(null);
		
		btnRecherche = new JButton("");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=rechercheParBox.getSelectedItem().toString().toLowerCase();
				if(SearchTarget.length()==0){
					JOptionPane.showMessageDialog(null, "la case de recherche est vide !!");
					rechercheField.setFocusable(true);
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from etudiant where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String numero=rs.getString("numero");
					String fname=rs.getString("prenom");
					String lname=rs.getString("nom");
					String cne=rs.getString("cne");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					String cni=rs.getString("cni");
					String resultat=rs.getString("resultat");
					String row[]={numero,fname,lname,cne,email,phone,cni,resultat};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
			}
		});
		btnRecherche.setBounds(606, 11, 40, 23);
		toolPanel.add(btnRecherche);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				deleteAllTableRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=rechercheParBox.getSelectedItem().toString().toLowerCase();
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from etudiant where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String numero=rs.getString("numero");
					String fname=rs.getString("prenom");
					String lname=rs.getString("nom");
					String cne=rs.getString("cne");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					String cni=rs.getString("cni");
					String resultat=rs.getString("resultat");
					String row[]={numero,fname,lname,cne,email,phone,cni,resultat};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			}
		});
		rechercheField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		rechercheField.setColumns(10);
		rechercheField.setBounds(440, 11, 156, 23);
		toolPanel.add(rechercheField);
		
		rechercheParBox = new JComboBox();
		rechercheParBox.setModel(new DefaultComboBoxModel(new String[] {"Prenom", "Nom", "CNE", "Email", "Phone", "CNE", "Resultat"}));
		rechercheParBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		rechercheParBox.setBackground(new Color(245, 255, 250));
		rechercheParBox.setBounds(324, 11, 106, 22);
		toolPanel.add(rechercheParBox);
		
		label = new JLabel("Recherche Par :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(208, 11, 106, 23);
		toolPanel.add(label);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				numeroField.setText((String) obj.getValueAt(selectedRow, 0));
				nomcompletField.setText((String)obj.getValueAt(selectedRow, 1)+" "+(String)obj.getValueAt(selectedRow, 2));
				cneField.setText((String)obj.getValueAt(selectedRow, 3));
				emailField.setText((String)obj.getValueAt(selectedRow, 4));
				phoneField.setText((String)obj.getValueAt(selectedRow, 5));
				cniField.setText((String)obj.getValueAt(selectedRow, 6));
				resultatField.setText((String)obj.getValueAt(selectedRow, 7));
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
				    java.sql.Statement st=con.createStatement();
				    ResultSet rs=st.executeQuery("select * from etudiant where cne='"+cneField.getText()+"'");
				    while(rs.next()){
				    	filePath=rs.getString("image_user");
				    }
				   
			}catch(Exception ex){
				ex.printStackTrace();
			}
				 imagelabel.setIcon(new ImageIcon(filePath));
			}
		});
		editInfoPanel = new JPanel();
		btnEdit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnEdit.setBounds(109, 11, 89, 23);
		toolPanel.add(btnEdit);
		
		JButton btnSuppr = new JButton("Suppr");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String target=(String) obj.getValueAt(table.getSelectedRow(), 6);
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("DELETE FROM etudiant WHERE cni=?");
					ps.setString(1,target);
					ps.executeUpdate();
					}catch(Exception ex){
						ex.printStackTrace();
					}
			 deleteAllTableRows();
			 getData();
			 emptyFields();
			 try{
				 Thread.sleep(50);
				 setVisible(false);
				Thread.sleep(50);
				setVisible(true);
			 }catch(Exception ex){
				 ex.printStackTrace();
			 }
			}
		});
		btnSuppr.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnSuppr.setBounds(10, 11, 89, 23);
		toolPanel.add(btnSuppr);
		
		editInfoPanel = new JPanel();
		editInfoPanel.setBackground(new Color(211, 211, 211));
		editInfoPanel.setBounds(0, 196, 675, 235);
		contentPane.add(editInfoPanel);
		editInfoPanel.setLayout(null);
		
		lblNomComplet = new JLabel("- Nom Complet :");
		lblNomComplet.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNomComplet.setBounds(40, 23, 124, 24);
		editInfoPanel.add(lblNomComplet);
		
		lblNumero = new JLabel("- Numero :");
		lblNumero.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNumero.setBounds(40, 51, 124, 24);
		editInfoPanel.add(lblNumero);
		
		lblNcne = new JLabel("- CNE :");
		lblNcne.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNcne.setBounds(40, 79, 124, 24);
		editInfoPanel.add(lblNcne);
		
		lblEmail = new JLabel("- Email :");
		lblEmail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(40, 107, 124, 24);
		editInfoPanel.add(lblEmail);
		
		lblPhone = new JLabel("- Phone :");
		lblPhone.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblPhone.setBounds(40, 135, 124, 24);
		editInfoPanel.add(lblPhone);
		
		lblCni = new JLabel("- CNI :");
		lblCni.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblCni.setBounds(40, 163, 124, 24);
		editInfoPanel.add(lblCni);
		
		lblResultat = new JLabel("- Resultat :");
		lblResultat.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblResultat.setBounds(40, 191, 124, 24);
		editInfoPanel.add(lblResultat);
		
		nomcompletField = new JTextField();
		nomcompletField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		nomcompletField.setEnabled(false);
		nomcompletField.setBounds(177, 26, 246, 21);
		editInfoPanel.add(nomcompletField);
		nomcompletField.setColumns(10);
		
		numeroField = new JTextField();
		numeroField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		numeroField.setEnabled(false);
		numeroField.setColumns(10);
		numeroField.setBounds(177, 54, 246, 21);
		editInfoPanel.add(numeroField);
		
		cneField = new JTextField();
		cneField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		cneField.setEnabled(false);
		cneField.setColumns(10);
		cneField.setBounds(177, 82, 246, 21);
		editInfoPanel.add(cneField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		emailField.setEnabled(false);
		emailField.setColumns(10);
		emailField.setBounds(177, 110, 246, 21);
		editInfoPanel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		phoneField.setEnabled(false);
		phoneField.setColumns(10);
		phoneField.setBounds(177, 138, 246, 21);
		editInfoPanel.add(phoneField);
		
		cniField = new JTextField();
		cniField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		cniField.setEnabled(false);
		cniField.setColumns(10);
		cniField.setBounds(177, 166, 246, 21);
		editInfoPanel.add(cniField);
		
		resultatField = new JTextField();
		resultatField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		resultatField.setEnabled(false);
		resultatField.setColumns(10);
		resultatField.setBounds(177, 194, 246, 21);
		editInfoPanel.add(resultatField);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(462, 11, 182, 204);
		editInfoPanel.add(panel);
		panel.setLayout(null);
		
		imagelabel = new JLabel("");
		imagelabel.setBounds(0, 0, 182, 204);
		panel.add(imagelabel);
	}
	public void getData(){
		try{
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
			java.sql.Statement st=con.createStatement();
			java.sql.ResultSet rs=st.executeQuery(" select * from etudiant order by numero");
			while(rs.next()){
				String numero=rs.getString("numero");
				String fname=rs.getString("prenom");
				String lname=rs.getString("nom");
				String cne=rs.getString("cne");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String cni=rs.getString("cni");
				String resultat=rs.getString("resultat");
				String row[]={numero,fname,lname,cne,email,phone,cni,resultat};
				obj.addRow(row);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void deleteAllTableRows(){
		for(int i=0;i<table.getRowCount();i++){
			obj.removeRow(i);
		}
	}
	public void emptyFields(){
		numeroField.setText("");
		nomcompletField.setText("");
		cneField.setText("");
		emailField.setText("");
		phoneField.setText("");
		cniField.setText("");
		resultatField.setText("");
		imagelabel.setIcon(new ImageIcon(""));
	}
}
