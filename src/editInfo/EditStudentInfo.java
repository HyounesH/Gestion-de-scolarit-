package editInfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
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

public class EditStudentInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numeroField;
	private JTextField prenomField;
	private JTextField nomField;
	private JTextField cneField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField cniField;
	private JTextField resultatField;
    private JLabel ImageUser;
    private JTextField rechercheField;
    private JComboBox recherchecomboBox;
    private JTextField filePath=new JTextField();
	/**
	 * Launch the application.
	 */
    /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudentInfo frame = new EditStudentInfo();
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
   
	public EditStudentInfo() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numeroField = new JTextField();
		numeroField.setColumns(10);
		numeroField.setBounds(156, 137, 238, 29);
		contentPane.add(numeroField);
		
		JLabel label = new JLabel("Numero :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(54, 140, 83, 21);
		contentPane.add(label);
		
		prenomField = new JTextField();
		prenomField.setColumns(10);
		prenomField.setBounds(156, 188, 238, 29);
		contentPane.add(prenomField);
		
		JLabel label_1 = new JLabel("Prenom :");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setBounds(54, 195, 83, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nom :");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_2.setBounds(54, 248, 83, 21);
		contentPane.add(label_2);
		
		nomField = new JTextField();
		nomField.setColumns(10);
		nomField.setBounds(156, 241, 238, 29);
		contentPane.add(nomField);
		
		cneField = new JTextField();
		cneField.setColumns(10);
		cneField.setBounds(156, 291, 238, 29);
		contentPane.add(cneField);
		
		JLabel label_3 = new JLabel("CNE:");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setBounds(54, 298, 83, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Email :");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setBounds(54, 347, 83, 21);
		contentPane.add(label_4);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(156, 340, 238, 29);
		contentPane.add(emailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(156, 391, 238, 29);
		contentPane.add(phoneField);
		
		JLabel label_5 = new JLabel("Phone:");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_5.setBounds(54, 398, 83, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("CNI:");
		label_6.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_6.setBounds(54, 450, 83, 21);
		contentPane.add(label_6);
		
		cniField = new JTextField();
		cniField.setColumns(10);
		cniField.setBounds(156, 443, 238, 29);
		contentPane.add(cniField);
		
		resultatField = new JTextField();
		resultatField.setColumns(10);
		resultatField.setBounds(156, 495, 238, 29);
		contentPane.add(resultatField);
		
		JLabel label_7 = new JLabel("Resultat:");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_7.setBounds(54, 502, 83, 21);
		contentPane.add(label_7);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(418, 157, 186, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
	    ImageUser = new JLabel("");
		ImageUser.setBounds(0, 0, 186, 208);
		panel.add(ImageUser);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setIcon(new ImageIcon("./img/icon/Action-ok-icon.png"));
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "the student information updated successfully !!");	
				
				}
		});
		btnValidate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnValidate.setBounds(156, 553, 131, 39);
		contentPane.add(btnValidate);
		
		JButton btnUpgrade = new JButton("Update");
		btnUpgrade.setIcon(new ImageIcon("./img/icon/Apps-system-software-update-icon.png"));
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numeroField.getText().length()==0 || prenomField.getText().length()==0 || nomField.getText().length()==0 || emailField.getText().length()==0 || phoneField.getText().length()==0
						|| cniField.getText().length()==0 || resultatField.getText().length()==0 || filePath.getText().length()==0){
					JOptionPane.showMessageDialog(null, "a Field is empty please checked all student Fieled before you click on Update button ");
				}
			else{
				try{
					Class.forName("org.postgresql.Driver");
				    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					PreparedStatement ps=con.prepareStatement("UPDATE etudiant SET numero=?, prenom=?, nom=?, cne=?, email=?, phone=?, cni=?, resultat=?,image_user=? WHERE cne=?");
					ps.setInt(1, Integer.parseInt(numeroField.getText()));
					ps.setString(2, prenomField.getText());
					ps.setString(3, nomField.getText());
					ps.setInt(4, Integer.parseInt(cneField.getText()));
					ps.setString(5, emailField.getText());
					ps.setInt(6, Integer.parseInt(phoneField.getText()));
					ps.setString(7, cniField.getText());
					ps.setDouble(8, Double.parseDouble(resultatField.getText()));
					ps.setString(9,filePath.getText());
					ps.setInt(10, Integer.parseInt(cneField.getText()));
					ps.executeUpdate();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			  
			}
			}
		});
		btnUpgrade.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnUpgrade.setBounds(297, 553, 117, 39);
		contentPane.add(btnUpgrade);
		
		JButton btnUpload = new JButton("Parcourir");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser IconChooser=new JFileChooser();
				IconChooser.showOpenDialog(null);
				File file=IconChooser.getSelectedFile();
			    filePath.setText(file.getAbsolutePath());
				ImageUser.setIcon(new ImageIcon(filePath.getText()));
			}
		});
		btnUpload.setIcon(new ImageIcon("./img/icon/Folders-Uploads-Folder-icon.png"));
		btnUpload.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnUpload.setBounds(428, 372, 111, 39);
		contentPane.add(btnUpload);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setIcon(new ImageIcon("./img/icon/Zoom-icon.png"));
		btnRecherche.addActionListener(new ActionListener() {
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
					ResultSet rs=st.executeQuery("select * from etudiant where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					numeroField.setText(rs.getString("numero"));
					prenomField.setText(rs.getString("prenom"));
					nomField.setText(rs.getString("nom"));
				    cneField.setText(rs.getString("cne"));
				    emailField.setText(rs.getString("email"));
					phoneField.setText(rs.getString("phone"));
				    cniField.setText(rs.getString("cni"));
                    resultatField.setText(rs.getString("resultat"));
                    filePath.setText(rs.getString("image_user"));
                    ImageUser.setIcon(new ImageIcon(filePath.getText()));
                    
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
				rechercheField.setText("");
			}
		});
		btnRecherche.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnRecherche.setBounds(480, 82, 144, 29);
		contentPane.add(btnRecherche);
		
		rechercheField = new JTextField();
		rechercheField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String SearchTarget=rechercheField.getText();
				String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
				if(SearchTarget.length()==0){
					fieldsEmpty();
				}
				else{
				try{
					Class.forName("org.postgresql.Driver");
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from etudiant where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					numeroField.setText(rs.getString("numero"));
					prenomField.setText(rs.getString("prenom"));
					nomField.setText(rs.getString("nom"));
				    cneField.setText(rs.getString("cne"));
				    emailField.setText(rs.getString("email"));
					phoneField.setText(rs.getString("phone"));
				    cniField.setText(rs.getString("cni"));
                    resultatField.setText(rs.getString("resultat"));
                    filePath.setText(rs.getString("image_user"));
                    ImageUser.setIcon(new ImageIcon(filePath.getText()));
                    
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			}
			}
		
		});
		rechercheField.setBounds(326, 83, 144, 29);
		contentPane.add(rechercheField);
		rechercheField.setColumns(10);
		
		JLabel lblRecherchePar = new JLabel("Recherche Par :");
		lblRecherchePar.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblRecherchePar.setBounds(54, 90, 144, 21);
		contentPane.add(lblRecherchePar);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"EMAIL", "CNI"}));
		recherchecomboBox.setBounds(201, 83, 115, 29);
		contentPane.add(recherchecomboBox);
		cneField.setEnabled(false);
		cniField.setEnabled(false);
		
		JLabel lblEditEtReparer = new JLabel("Edit et Reparer Les Info D'un Etudiant\r\n");
		lblEditEtReparer.setForeground(new Color(51, 0, 0));
		lblEditEtReparer.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblEditEtReparer.setBounds(68, 11, 508, 42);
		contentPane.add(lblEditEtReparer);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("./img/HNCK2685.jpg"));
		label_8.setBounds(0, 0, 644, 629);
		contentPane.add(label_8);
	}
	public void fieldsEmpty(){
		numeroField.setText("");
		prenomField.setText("");
		nomField.setText("");
		cneField.setText("");
		emailField.setText("");
		phoneField.setText("");
		cniField.setText("");
		resultatField.setText("");
		ImageUser.setIcon(new ImageIcon(""));
	}
}
