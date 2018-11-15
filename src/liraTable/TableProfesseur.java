package liraTable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TableProfesseur extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();

	private JTable table;
	private String columns[]={"ID", "Pr\u00E9nom", "Nom", "Mati\u00E9re", "Email", "CNI", "Phone", "Address"};
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
	private JTextField idField;
	private JTextField cniField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField matiereField;
	private JTextField addressField;
	private JPanel panel;
	private JButton btnEdit;
	private JLabel imagelabel;
	private String filePath;
	private JButton btnSuppr;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableProfesseur frame = new TableProfesseur();
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
	public TableProfesseur() {
		getData();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 662, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(obj);
		table.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		scrollPane.setViewportView(table);
		
		toolPanel = new JPanel();
		toolPanel.setBackground(new Color(176, 196, 222));
		toolPanel.setBounds(0, 157, 662, 40);
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
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from professeurs where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String fname=rs.getString("fname");
					String lname=rs.getString("lname");
					String matiere=rs.getString("school_subject");
					String email=rs.getString("email");
					String cni=rs.getString("cni");
					String phone=rs.getString("phone");
					String address=rs.getString("adress");
					String row[]={id,fname,lname,matiere,email,cni,phone,address};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
			}
		});
		btnRecherche.setBounds(612, 5, 40, 23);
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
					ResultSet rs=st.executeQuery("select * from professeurs where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String fname=rs.getString("fname");
					String lname=rs.getString("lname");
					String matiere=rs.getString("school_subject");
					String email=rs.getString("email");
					String cni=rs.getString("cni");
					String phone=rs.getString("phone");
					String address=rs.getString("adress");
					String row[]={id,fname,lname,matiere,email,cni,phone,address};
					obj.addRow(row);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			}
		});
		rechercheField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		rechercheField.setColumns(10);
		rechercheField.setBounds(446, 5, 156, 23);
		toolPanel.add(rechercheField);
		
		rechercheParBox = new JComboBox();
		rechercheParBox.setModel(new DefaultComboBoxModel(new String[] { "Fname", "Lname", "school_subject", "Email", "CNI", "Phone", "Adress"}));
		rechercheParBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		rechercheParBox.setBackground(new Color(245, 255, 250));
		rechercheParBox.setBounds(330, 6, 106, 22);
		toolPanel.add(rechercheParBox);
		
		label = new JLabel("Recherche Par :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(214, 5, 106, 23);
		toolPanel.add(label);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				idField.setText((String) obj.getValueAt(selectedRow, 0));
				nomcompletField.setText((String)obj.getValueAt(selectedRow, 1)+" "+(String)obj.getValueAt(selectedRow, 2));
				matiereField.setText((String)obj.getValueAt(selectedRow, 3));
				emailField.setText((String)obj.getValueAt(selectedRow, 4));
				cniField.setText((String)obj.getValueAt(selectedRow, 5));
				phoneField.setText((String)obj.getValueAt(selectedRow, 6));
				addressField.setText((String)obj.getValueAt(selectedRow, 7));
				
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
				    java.sql.Statement st=con.createStatement();
				    ResultSet rs=st.executeQuery("select * from professeurs where cni='"+cniField.getText()+"'");
				    while(rs.next()){
				    	filePath=rs.getString("image");
				    }
				   
			}catch(Exception ex){
				ex.printStackTrace();
			}
				 imagelabel.setIcon(new ImageIcon(filePath));
			}
		});
		editInfoPanel = new JPanel();
		btnEdit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnEdit.setBounds(115, 6, 89, 23);
		toolPanel.add(btnEdit);
		
		btnSuppr = new JButton("Suppr");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String target=(String) obj.getValueAt(table.getSelectedRow(), 5);
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("DELETE FROM professeurs WHERE cni=?");
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
		btnSuppr.setBounds(10, 6, 89, 23);
		toolPanel.add(btnSuppr);
		
		editInfoPanel = new JPanel();
		editInfoPanel.setBackground(new Color(211, 211, 211));
		editInfoPanel.setBounds(0, 196, 662, 235);
		contentPane.add(editInfoPanel);
		editInfoPanel.setLayout(null);
		
		lblNomComplet = new JLabel("- Nom Complet :");
		lblNomComplet.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNomComplet.setBounds(33, 23, 124, 24);
		editInfoPanel.add(lblNomComplet);
		
		lblNumero = new JLabel("- ID :");
		lblNumero.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNumero.setBounds(33, 51, 124, 24);
		editInfoPanel.add(lblNumero);
		
		lblNcne = new JLabel("- CNI :");
		lblNcne.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNcne.setBounds(33, 79, 124, 24);
		editInfoPanel.add(lblNcne);
		
		lblEmail = new JLabel("- Email :");
		lblEmail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(33, 107, 124, 24);
		editInfoPanel.add(lblEmail);
		
		lblPhone = new JLabel("- Phone :");
		lblPhone.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblPhone.setBounds(33, 135, 124, 24);
		editInfoPanel.add(lblPhone);
		
		lblCni = new JLabel("- Matiére :");
		lblCni.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblCni.setBounds(33, 163, 124, 24);
		editInfoPanel.add(lblCni);
		
		lblResultat = new JLabel("- Address :");
		lblResultat.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblResultat.setBounds(33, 191, 124, 24);
		editInfoPanel.add(lblResultat);
		
		nomcompletField = new JTextField();
		nomcompletField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		nomcompletField.setEnabled(false);
		nomcompletField.setBounds(170, 26, 246, 21);
		editInfoPanel.add(nomcompletField);
		nomcompletField.setColumns(10);
		
		idField = new JTextField();
		idField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		idField.setEnabled(false);
		idField.setColumns(10);
		idField.setBounds(170, 54, 246, 21);
		editInfoPanel.add(idField);
		
		cniField = new JTextField();
		cniField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		cniField.setEnabled(false);
		cniField.setColumns(10);
		cniField.setBounds(170, 82, 246, 21);
		editInfoPanel.add(cniField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		emailField.setEnabled(false);
		emailField.setColumns(10);
		emailField.setBounds(170, 110, 246, 21);
		editInfoPanel.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		phoneField.setEnabled(false);
		phoneField.setColumns(10);
		phoneField.setBounds(170, 138, 246, 21);
		editInfoPanel.add(phoneField);
		
		matiereField = new JTextField();
		matiereField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		matiereField.setEnabled(false);
		matiereField.setColumns(10);
		matiereField.setBounds(170, 166, 246, 21);
		editInfoPanel.add(matiereField);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		addressField.setEnabled(false);
		addressField.setColumns(10);
		addressField.setBounds(170, 194, 246, 21);
		editInfoPanel.add(addressField);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(446, 11, 182, 204);
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
			java.sql.ResultSet rs=st.executeQuery(" select * from professeurs order by lname");
			while(rs.next()){
				String numero=rs.getString("id");
				String fname=rs.getString("fname");
				String lname=rs.getString("lname");
				String matiere=rs.getString("school_subject");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String cni=rs.getString("cni");
				String address=rs.getString("adress");
				String row[]={numero,fname,lname,matiere,email,cni,phone,address};
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
		idField.setText("");
		nomcompletField.setText("");
		cniField.setText("");
		addressField.setText("");
		emailField.setText("");
		phoneField.setText("");
		matiereField.setText("");
		imagelabel.setIcon(new ImageIcon(""));
	}

}
