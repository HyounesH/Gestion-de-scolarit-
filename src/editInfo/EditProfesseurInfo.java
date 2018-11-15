package editInfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class EditProfesseurInfo extends JFrame {

	private JPanel contentPane;
	private JTextField rechercheField;
	private JTextField idField;
	private JTextField prenomField;
	private JTextField nomField;
	private JTextField matiereField;
	private JTextField emailField;
	private JTextField cniField;
	private JTextField phoneField;
	private JTextField addressField;
	private String filePath;
    private JLabel imageProfesseurLabel;
    private JComboBox recherchecomboBox;
    private JButton btnupdate;
	/**
	 * Launch the application.
	 */
    /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfesseurInfo frame = new EditProfesseurInfo();
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
	public EditProfesseurInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnrecherche = new JButton("Recherche");
		btnrecherche.setIcon(new ImageIcon("./img/icon/Zoom-icon.png"));
		btnrecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(SearchTarget.length()==0){
					JOptionPane.showMessageDialog(null, "la case de recherche est vide !!");
					rechercheField.setFocusable(true);
					fieldsEmpty();
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from professeurs where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					idField.setText(rs.getString("id"));
					prenomField.setText(rs.getString("fname"));
					nomField.setText(rs.getString("lname"));
				    matiereField.setText(rs.getString("school_subject"));
				    emailField.setText(rs.getString("email"));
					phoneField.setText(rs.getString("phone"));
				    cniField.setText(rs.getString("cni"));
                   addressField.setText(rs.getString("adress"));
                    filePath=rs.getString("image");
                    imageProfesseurLabel.setIcon(new ImageIcon(filePath));
                    
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
				rechercheField.setText("");				
			}
		});
		btnrecherche.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnrecherche.setBounds(461, 108, 144, 29);
		contentPane.add(btnrecherche);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(rechercheField.getText().length()==0){
					fieldsEmpty();
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from professeurs where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					idField.setText(rs.getString("id"));
					prenomField.setText(rs.getString("fname"));
					nomField.setText(rs.getString("lname"));
				    matiereField.setText(rs.getString("school_subject"));
				    emailField.setText(rs.getString("email"));
					phoneField.setText(rs.getString("phone"));
				    cniField.setText(rs.getString("cni"));
                   addressField.setText(rs.getString("adress"));
                    filePath=rs.getString("image");
                    imageProfesseurLabel.setIcon(new ImageIcon(filePath));
                    
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
			}
		
		});
		rechercheField.setColumns(10);
		rechercheField.setBounds(307, 109, 144, 29);
		contentPane.add(rechercheField);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Fname", "Lname", "school_subject", "Email", "CNI", "Phone", "Adress"}));
		recherchecomboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		recherchecomboBox.setBounds(182, 109, 115, 29);
		contentPane.add(recherchecomboBox);
		
		JLabel label = new JLabel("Recherche Par :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(35, 116, 144, 21);
		contentPane.add(label);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblId.setBounds(35, 166, 83, 21);
		contentPane.add(lblId);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(137, 163, 238, 29);
		contentPane.add(idField);
		
		prenomField = new JTextField();
		prenomField.setColumns(10);
		prenomField.setBounds(137, 214, 238, 29);
		contentPane.add(prenomField);
		
		JLabel label_2 = new JLabel("Prenom :");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_2.setBounds(35, 221, 83, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Nom :");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setBounds(35, 274, 83, 21);
		contentPane.add(label_3);
		
		nomField = new JTextField();
		nomField.setColumns(10);
		nomField.setBounds(137, 267, 238, 29);
		contentPane.add(nomField);
		
		matiereField = new JTextField();
		matiereField.setColumns(10);
		matiereField.setBounds(137, 317, 238, 29);
		contentPane.add(matiereField);
		
		JLabel lblMatire = new JLabel("Mati\u00E9re:");
		lblMatire.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMatire.setBounds(35, 324, 83, 21);
		contentPane.add(lblMatire);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(137, 366, 238, 29);
		contentPane.add(emailField);
		
		JLabel label_5 = new JLabel("Email :");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_5.setBounds(35, 373, 83, 21);
		contentPane.add(label_5);
		
		cniField = new JTextField();
		cniField.setEnabled(false);
		cniField.setColumns(10);
		cniField.setBounds(137, 417, 238, 29);
		contentPane.add(cniField);
		
		JLabel lblCni = new JLabel("CNI:");
		lblCni.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCni.setBounds(35, 424, 83, 21);
		contentPane.add(lblCni);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(137, 469, 238, 29);
		contentPane.add(phoneField);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPhone.setBounds(35, 476, 83, 21);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblAddress.setBounds(35, 528, 83, 21);
		contentPane.add(lblAddress);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(137, 521, 238, 29);
		contentPane.add(addressField);
		
		btnupdate = new JButton("Reparer");
		btnupdate.setIcon(new ImageIcon("./img/icon/Apps-system-software-update-icon.png"));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idField.getText().length()==0 || prenomField.getText().length()==0 || nomField.getText().length()==0 || matiereField.getText().length()==0 
						|| emailField.getText().length()==0 || phoneField.getText().length()==0 || addressField.getText().length()==0 ||cniField.getText().length()==0 || filePath.length()==0){
				        JOptionPane.showMessageDialog(null, "une Case est vide s'il vous plait vérifier les cases !!!");
				}
			else{
				try{
					Class.forName("org.postgresql.Driver");
				    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("UPDATE professeurs SET id=?, fname=?, lname=?, school_subject=?, email=?, cni=?, phone=?, adress=?,image=? WHERE cni=?");
					ps.setString(1, idField.getText());
					ps.setString(2, prenomField.getText());
					ps.setString(3, nomField.getText());
					ps.setString(4, matiereField.getText());
					ps.setString(5, emailField.getText());
					ps.setString(6, cniField.getText());
					ps.setString(7, phoneField.getText());
					ps.setString(8, addressField.getText());
					ps.setString(9,filePath);
					ps.setString(10,cniField.getText());
					ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
			}
		});
		btnupdate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnupdate.setBounds(278, 579, 128, 39);
		contentPane.add(btnupdate);
		
		JButton btnvalidate = new JButton("Validate");
		btnvalidate.setIcon(new ImageIcon("./img/icon/Action-ok-icon.png"));
		btnvalidate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(null, "les informations de professeur qu'a comme CNI :"+cniField.getText()+"sont reparé !!","Reparer les infos des professeurs  ",JOptionPane.YES_NO_OPTION)
					==JOptionPane.YES_OPTION){
				Toolkit toolkit=getToolkit();
				toolkit.beep();
				setVisible(false);
			}
				
			}
		});
		btnvalidate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnvalidate.setBounds(137, 579, 131, 39);
		contentPane.add(btnvalidate);
		
		JButton btnupload = new JButton("Parcourir");
		btnupload.setIcon(new ImageIcon("./img/icon/Folders-Uploads-Folder-icon.png"));
		btnupload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file=fileChooser.getSelectedFile();
            filePath=file.getAbsolutePath();
            imageProfesseurLabel.setIcon(new ImageIcon(filePath));
			}
		});
		btnupload.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnupload.setBounds(385, 411, 128, 39);
		contentPane.add(btnupload);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(385, 166, 173, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		imageProfesseurLabel = new JLabel("");
		imageProfesseurLabel.setBounds(0, 0, 173, 224);
		panel.add(imageProfesseurLabel);
		
		JLabel lblEditEtReparer = new JLabel("Edit et Reparer Les Info D'un Prof\r\n");
		lblEditEtReparer.setForeground(new Color(51, 0, 0));
		lblEditEtReparer.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblEditEtReparer.setBounds(81, 34, 508, 42);
		contentPane.add(lblEditEtReparer);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("./img/index0.jpg"));
		label_1.setBounds(0, 0, 644, 629);
		contentPane.add(label_1);
	}
	public void  fieldsEmpty(){
		idField.setText("");
		prenomField.setText("");
		nomField.setText("");
		cniField.setText("");
		emailField.setText("");
		phoneField.setText("");
		matiereField.setText("");
		addressField.setText("");
		imageProfesseurLabel.setIcon(new ImageIcon(""));
	}

}
