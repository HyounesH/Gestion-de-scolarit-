package liraTable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TableActivite extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField rechercheField;
	private JTextField dateField;
	private JTextField typeField;
	private JTextField nomField;
    private JComboBox recherchecomboBox;
    private String column[]={"Nom ", "Type", "Date"};
    private Object rows[][]={};
    private DefaultTableModel obj=new DefaultTableModel(rows,column);
	/**
	 * Launch the application.
	 */
    /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableActivite frame = new TableActivite();
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
	public TableActivite() {
		getData();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 310);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 646, 108);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(obj);
		scrollPane.setViewportView(table);
		
		JPanel toolPanel = new JPanel();
		toolPanel.setBackground(new Color(230, 230, 250));
		toolPanel.setBounds(0, 108, 646, 45);
		contentPane.add(toolPanel);
		toolPanel.setLayout(null);
		
		JButton btnRecherche = new JButton("");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows();
				String fieldSearchText=rechercheField.getText();
				String columnTarget=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(fieldSearchText.length()==0){
					JOptionPane.showMessageDialog(null, "La case de recherche est Vide !!!");
					rechercheField.setFocusable(true);
				}
				else
				{
					try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					java.sql.ResultSet rs=st.executeQuery("select * from activite where "+columnTarget+" like '%"+fieldSearchText+"%'");
					while(rs.next()){
					String nomAct=rs.getString("nomact");
					String type=rs.getString("type");
					String date=rs.getString("temp");
					Object row[]={nomAct,type,date};
					obj.addRow(row);
					}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				rechercheField.setText("");
			}
		});
		btnRecherche.setBounds(596, 11, 40, 23);
		toolPanel.add(btnRecherche);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				deleteAllTableRows();
				String fieldSearchText=rechercheField.getText();
				String columnTarget=recherchecomboBox.getSelectedItem().toString().toLowerCase();
			
					try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					java.sql.ResultSet rs=st.executeQuery("select * from activite where "+columnTarget+" like '%"+fieldSearchText+"%'");
					while(rs.next()){
					String nomAct=rs.getString("nomact");
					String type=rs.getString("type");
					String date=rs.getString("temp");
					Object row[]={nomAct,type,date};
					obj.addRow(row);
					}
					}catch(Exception ex){
						ex.printStackTrace();
					}
			}
		});
		rechercheField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		rechercheField.setColumns(10);
		rechercheField.setBounds(430, 11, 156, 23);
		toolPanel.add(rechercheField);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"NomAct", "Type"}));
		recherchecomboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		recherchecomboBox.setBackground(new Color(245, 255, 250));
		recherchecomboBox.setBounds(314, 11, 106, 22);
		toolPanel.add(recherchecomboBox);
		
		JLabel label = new JLabel("Recherche Par :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(198, 11, 106, 23);
		toolPanel.add(label);
		
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				nomField.setText((String)obj.getValueAt(selectedRow, 0));
				typeField.setText((String)obj.getValueAt(selectedRow, 1));
				dateField.setText((String)obj.getValueAt(selectedRow, 2));
				
			}
		});
		btnedit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnedit.setBounds(99, 11, 89, 23);
		toolPanel.add(btnedit);
		
		JButton btnSuppr = new JButton("Suppr");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String target=(String) obj.getValueAt(table.getSelectedRow(),0);
				try{
					Class.forName("org.postgresql.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("DELETE FROM activite WHERE nomact=?");
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
		btnSuppr.setBounds(12, 11, 77, 23);
		toolPanel.add(btnSuppr);
		
		JPanel affichagePanel = new JPanel();
		affichagePanel.setBackground(new Color(169, 169, 169));
		affichagePanel.setBounds(0, 152, 646, 119);
		contentPane.add(affichagePanel);
		affichagePanel.setLayout(null);
		
		dateField = new JTextField();
		dateField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		dateField.setEnabled(false);
		dateField.setColumns(10);
		dateField.setBounds(236, 70, 299, 21);
		affichagePanel.add(dateField);
		
		JLabel lblType_1 = new JLabel("- Date  :");
		lblType_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblType_1.setBounds(99, 67, 124, 24);
		affichagePanel.add(lblType_1);
		
		JLabel lblType = new JLabel("- Type :");
		lblType.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblType.setBounds(99, 39, 124, 24);
		affichagePanel.add(lblType);
		
		typeField = new JTextField();
		typeField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		typeField.setEnabled(false);
		typeField.setColumns(10);
		typeField.setBounds(236, 42, 299, 21);
		affichagePanel.add(typeField);
		
		nomField = new JTextField();
		nomField.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		nomField.setEnabled(false);
		nomField.setColumns(10);
		nomField.setBounds(236, 14, 299, 21);
		affichagePanel.add(nomField);
		
		JLabel lblNom = new JLabel("- Nom:");
		lblNom.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblNom.setBounds(99, 11, 124, 24);
		affichagePanel.add(lblNom);
	}
	public void getData(){
		try{
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
			java.sql.Statement st=con.createStatement();
			java.sql.ResultSet rs=st.executeQuery("select * from activite order by nomAct");
			while(rs.next()){
				String row[]={rs.getString("nomact"),rs.getString("type"),rs.getString("temp")};
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
	nomField.setText("");
	typeField.setText("");
	dateField.setText("");
}
}
