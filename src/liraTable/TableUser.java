package liraTable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TableUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String column[]={"ID", "Prenom", "Nom", "Username", "Password", "Email", "Phone"};
	private Object rows[][]={};
	private DefaultTableModel obj=new DefaultTableModel(rows,column);
	private JTextField rechercheField;
	private JTextField idField;
	private JTextField nomCompletField;
	private JTextField usernameField;
	private JTextField userpassField;
	private JTextField emailField;
	private JTextField phoneField;
	private JComboBox recherchecomboBox;
	private JLabel userimageLabel;
	private String filePath;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableUser frame = new TableUser();
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
	public TableUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 429);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getData();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 723, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		table.setModel(obj);
		scrollPane.setViewportView(table);
		
		JPanel toolPanel = new JPanel();
		toolPanel.setBackground(new Color(95, 158, 160));
		toolPanel.setBounds(0, 132, 767, 50);
		contentPane.add(toolPanel);
		toolPanel.setLayout(null);
		
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				idField.setText((String) obj.getValueAt(selectedRow, 0));
				nomCompletField.setText((String)obj.getValueAt(selectedRow, 1)+" "+(String)obj.getValueAt(selectedRow, 2));
				usernameField.setText((String)obj.getValueAt(selectedRow, 3));
				userpassField.setText((String)obj.getValueAt(selectedRow, 4));
				emailField.setText((String)obj.getValueAt(selectedRow, 5));
				phoneField.setText((String)obj.getValueAt(selectedRow, 6));
				
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
				    java.sql.Statement st=con.createStatement();
				    ResultSet rs=st.executeQuery("select * from utilisateur where email='"+emailField.getText()+"'");
				    while(rs.next()){
				    	filePath=rs.getString("image");
				    }
				   
			}catch(Exception ex){
				ex.printStackTrace();
			}
				userimageLabel.setIcon(new ImageIcon(filePath));
				
			}
		});
		btnedit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnedit.setBounds(145, 11, 89, 23);
		toolPanel.add(btnedit);
		
		JLabel label = new JLabel("Recherche Par :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(257, 11, 106, 23);
		toolPanel.add(label);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Prenom", "Nom", "Username", "Email", "Phone"}));
		recherchecomboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		recherchecomboBox.setBackground(new Color(245, 255, 250));
		recherchecomboBox.setBounds(373, 11, 106, 22);
		toolPanel.add(recherchecomboBox);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				deleteALLRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from utilisateur where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String fname=rs.getString("prenom");
					String lname=rs.getString("nom");
					String username=rs.getString("username");
					String password=rs.getString("userpass");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					String row[]={id,fname,lname,username,password,email,phone};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
				
			}
			
			
		});
		rechercheField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		rechercheField.setColumns(10);
		rechercheField.setBounds(487, 11, 156, 23);
		toolPanel.add(rechercheField);
		
		JButton btnrecherche = new JButton("");
		btnrecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteALLRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(SearchTarget.length()==0){
					JOptionPane.showMessageDialog(null, "la case de recherche est vide !!");
					rechercheField.setFocusable(true);
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from utilisateur where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String fname=rs.getString("prenom");
					String lname=rs.getString("nom");
					String username=rs.getString("username");
					String password=rs.getString("userpass");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					String row[]={id,fname,lname,username,password,email,phone};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
				
			}
		});
		btnrecherche.setBounds(674, 11, 40, 23);
		toolPanel.add(btnrecherche);
		
		JButton btndelete = new JButton("Supprimer");
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String target=(String) obj.getValueAt(table.getSelectedRow(), 3);
			try{
				Class.forName("org.postgresql.Driver");
				java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
				PreparedStatement ps=con.prepareStatement("DELETE FROM utilisateur WHERE username=?");
				ps.setString(1,target);
				ps.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
		 deleteALLRows();
		 getData();
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
		btndelete.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btndelete.setBounds(10, 11, 110, 23);
		toolPanel.add(btndelete);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 182, 767, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("ID :");
		label_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(30, 11, 158, 21);
		panel.add(label_1);
		
		JLabel lblCompletName = new JLabel("Complet Name :");
		lblCompletName.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblCompletName.setBounds(30, 43, 158, 21);
		panel.add(lblCompletName);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblUsername.setBounds(30, 75, 158, 21);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(30, 107, 158, 21);
		panel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(30, 139, 158, 21);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblPhone.setBounds(30, 171, 158, 21);
		panel.add(lblPhone);
		
		idField = new JTextField();
		idField.setEnabled(false);
		idField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		idField.setBounds(198, 12, 241, 23);
		panel.add(idField);
		idField.setColumns(10);
		
		nomCompletField = new JTextField();
		nomCompletField.setEnabled(false);
		nomCompletField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		nomCompletField.setColumns(10);
		nomCompletField.setBounds(198, 44, 241, 23);
		panel.add(nomCompletField);
		
		usernameField = new JTextField();
		usernameField.setEnabled(false);
		usernameField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(198, 76, 241, 23);
		panel.add(usernameField);
		
		userpassField = new JTextField();
		userpassField.setEnabled(false);
		userpassField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		userpassField.setColumns(10);
		userpassField.setBounds(198, 108, 241, 23);
		panel.add(userpassField);
		
		emailField = new JTextField();
		emailField.setEnabled(false);
		emailField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		emailField.setColumns(10);
		emailField.setBounds(198, 141, 241, 23);
		panel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setEnabled(false);
		phoneField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(198, 173, 241, 23);
		panel.add(phoneField);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		imagePanel.setBounds(514, 11, 179, 181);
		panel.add(imagePanel);
		imagePanel.setLayout(null);
		
		userimageLabel = new JLabel("");
		userimageLabel.setBounds(0, 0, 179, 181);
		imagePanel.add(userimageLabel);
		
	}
	public void getData(){
		try{
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
			java.sql.Statement st=con.createStatement();
			java.sql.ResultSet rs=st.executeQuery("select * from utilisateur");
			while(rs.next()){
				String row[]={rs.getString("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("username"),rs.getString("userpass"),rs.getString("email"),rs.getString("phone")};
			    obj.addRow(row);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void deleteALLRows(){
		for(int i=0;i<table.getRowCount();i++){
			obj.removeRow(i);
		}
	}
	
}
