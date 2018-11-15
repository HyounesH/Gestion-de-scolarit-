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

public class TableCours extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField rechercheField;
	private JTextField titreField;
	private JTextField idField;
	private JTextField domainField;
	private JTextField urlField;
	private String columns[]={"ID", "Titre", "Domain", "URL"};
	private Object rows[][]={};
	private DefaultTableModel obj=new DefaultTableModel(rows,columns);
	private JComboBox recherchecomboBox;
	private String filePath;
	private JLabel imageLivrelabel;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableCours frame = new TableCours();
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
	public TableCours() {
		getData();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 360);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 644, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(obj);
		scrollPane.setViewportView(table);
		
		JPanel toolPanel = new JPanel();
		toolPanel.setBackground(new Color(95, 158, 160));
		toolPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		toolPanel.setBounds(0, 141, 644, 45);
		contentPane.add(toolPanel);
		toolPanel.setLayout(null);
		
		JButton btnrecherche = new JButton("");
		btnrecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(SearchTarget.length()==0){
					JOptionPane.showMessageDialog(null, "la case de recherche est vide !!");
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from cours where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String titre=rs.getString("titre");
					String domain=rs.getString("domain");
					String url=rs.getString("url");
					String row[]={id,titre,domain,url};
					obj.addRow(row);
			}
				}catch(Exception ex){
					ex.printStackTrace();
				}
				}
			}
		});
		btnrecherche.setBounds(599, 11, 40, 23);
		toolPanel.add(btnrecherche);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				deleteAllTableRows();
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from cours where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					String id=rs.getString("id");
					String titre=rs.getString("titre");
					String domain=rs.getString("domain");
					String url=rs.getString("url");
					String row[]={id,titre,domain,url};
					obj.addRow(row);
			}
				}catch(Exception ex){
					ex.printStackTrace();
				
				}
			}
		});
		rechercheField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		rechercheField.setColumns(10);
		rechercheField.setBounds(433, 11, 156, 23);
		toolPanel.add(rechercheField);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Titre", "Domain", "URL"}));
		recherchecomboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		recherchecomboBox.setBackground(new Color(245, 255, 250));
		recherchecomboBox.setBounds(317, 11, 106, 22);
		toolPanel.add(recherchecomboBox);
		
		JLabel label = new JLabel("Recherche Par :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(201, 11, 106, 23);
		toolPanel.add(label);
		
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				idField.setText((String) obj.getValueAt(selectedRow, 0));
				titreField.setText((String)obj.getValueAt(selectedRow, 1));
				domainField.setText((String)obj.getValueAt(selectedRow, 2));
				urlField.setText((String)obj.getValueAt(selectedRow, 3));
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
				    java.sql.Statement st=con.createStatement();
				    ResultSet rs=st.executeQuery("select * from cours where titre = '"+titreField.getText()+"'");
				    while(rs.next()){
				    filePath=rs.getString("image_livre");
				    }
				   
			}catch(Exception ex){
				ex.printStackTrace();
			}
			imageLivrelabel.setIcon(new ImageIcon(filePath));
			}
		});
		btnedit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnedit.setBounds(102, 11, 89, 23);
		toolPanel.add(btnedit);
		
		JButton btnSuppr = new JButton("Suppr");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String target=(String) obj.getValueAt(table.getSelectedRow(), 1);
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("DELETE FROM cours WHERE titre=?");
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
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(169, 169, 169));
		infoPanel.setBounds(0, 183, 644, 138);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		titreField = new JTextField();
		titreField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		titreField.setEnabled(false);
		titreField.setColumns(10);
		titreField.setBounds(147, 14, 246, 21);
		infoPanel.add(titreField);
		
		idField = new JTextField();
		idField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		idField.setEnabled(false);
		idField.setColumns(10);
		idField.setBounds(147, 42, 246, 21);
		infoPanel.add(idField);
		
		JLabel lblTitre = new JLabel("- Titre :");
		lblTitre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblTitre.setBounds(10, 11, 124, 24);
		infoPanel.add(lblTitre);
		
		JLabel label_2 = new JLabel("- ID :");
		label_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 39, 124, 24);
		infoPanel.add(label_2);
		
		domainField = new JTextField();
		domainField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		domainField.setEnabled(false);
		domainField.setColumns(10);
		domainField.setBounds(147, 70, 246, 21);
		infoPanel.add(domainField);
		
		JLabel lblDomain = new JLabel("- Domain :");
		lblDomain.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblDomain.setBounds(10, 67, 124, 24);
		infoPanel.add(lblDomain);
		
		urlField = new JTextField();
		urlField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		urlField.setEnabled(false);
		urlField.setColumns(10);
		urlField.setBounds(147, 98, 246, 21);
		infoPanel.add(urlField);
		
		JLabel lblUrl = new JLabel("- URL :");
		lblUrl.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblUrl.setBounds(10, 95, 124, 24);
		infoPanel.add(lblUrl);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(453, 11, 149, 116);
		infoPanel.add(panel);
		panel.setLayout(null);
		
        imageLivrelabel = new JLabel("");
		imageLivrelabel.setBounds(0, 0, 149, 116);
		panel.add(imageLivrelabel);
	}
	public void getData(){
		try{
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
			java.sql.Statement st=con.createStatement();
			java.sql.ResultSet rs=st.executeQuery(" select * from cours order by titre");
			while(rs.next()){
				String id=rs.getString("id");
				String titre=rs.getString("titre");
				String domain=rs.getString("domain");
				String url=rs.getString("url");
				String row[]={id,titre,domain,url};
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
		titreField.setText("");
		domainField.setText("");
		urlField.setText("");
		imageLivrelabel.setIcon(new ImageIcon(""));
	}
}
