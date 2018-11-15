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

import project.Student;

import java.awt.Color;

public class EditCoursInfo extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField titreField;
	private JTextField domainField;
	private JTextField urlField;
	private JTextField rechercheField;
	private String filePath;
    private JLabel imagelivrelabel;
    private JComboBox recherchecomboBox;
	/**
	 * Launch the application.
	 */
    /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCoursInfo frame = new EditCoursInfo();
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
	public EditCoursInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(123, 151, 265, 29);
		contentPane.add(idField);
		
		JLabel label = new JLabel("ID :");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setBounds(21, 158, 83, 21);
		contentPane.add(label);
		
		titreField = new JTextField();
		titreField.setEnabled(false);
		titreField.setColumns(10);
		titreField.setBounds(123, 202, 265, 29);
		contentPane.add(titreField);
		
		JLabel label_1 = new JLabel("Titre :");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setBounds(21, 209, 83, 21);
		contentPane.add(label_1);
		
		domainField = new JTextField();
		domainField.setColumns(10);
		domainField.setBounds(123, 254, 265, 29);
		contentPane.add(domainField);
		
		JLabel label_2 = new JLabel("Domain :");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_2.setBounds(21, 261, 83, 21);
		contentPane.add(label_2);
		
		JButton btnParcourirurl = new JButton("Parcourir");
		btnParcourirurl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
             JFileChooser fileChooser=new JFileChooser();
             fileChooser.showOpenDialog(null);
             File file=fileChooser.getSelectedFile();
             urlField.setText(file.getAbsolutePath());
			}
		});
		btnParcourirurl.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnParcourirurl.setBounds(299, 306, 89, 29);
		contentPane.add(btnParcourirurl);
		
		urlField = new JTextField();
		urlField.setColumns(10);
		urlField.setBounds(123, 306, 171, 29);
		contentPane.add(urlField);
		
		JLabel label_3 = new JLabel("URL :");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setBounds(21, 313, 83, 21);
		contentPane.add(label_3);
		
		recherchecomboBox = new JComboBox();
		recherchecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Titre", "Domain"}));
		recherchecomboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		recherchecomboBox.setBounds(157, 90, 115, 29);
		contentPane.add(recherchecomboBox);
		
		JLabel label_4 = new JLabel("Recherche Par :");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setBounds(10, 97, 144, 21);
		contentPane.add(label_4);
		
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
					ResultSet rs=st.executeQuery("select * from cours where "+SearchType+" like '%"+SearchTarget+"%'");
				
				while(rs.next()){
					idField.setText(rs.getString("id"));
					titreField.setText(rs.getString("titre"));
					domainField.setText(rs.getString("domain"));
					urlField.setText(rs.getString("url"));
					filePath=rs.getString("image_livre");
					imagelivrelabel.setIcon(new ImageIcon(filePath));
				}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			}
		});
		rechercheField.setColumns(10);
		rechercheField.setBounds(282, 90, 144, 29);
		contentPane.add(rechercheField);
		
		JButton btnrecherche = new JButton("Recherche");
		btnrecherche.setIcon(new ImageIcon("./img/icon/Zoom-icon.png"));
		btnrecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rechercheField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "La case de recherche est vide !!");
					rechercheField.setFocusable(true);
					fieldsEmpty();
				}
				else{
					String SearchTarget=rechercheField.getText();
					String SearchType=recherchecomboBox.getSelectedItem().toString().toLowerCase();
					try{
						Class.forName("org.postgresql.Driver");
						Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
						java.sql.Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from cours where "+SearchType+" like '%"+SearchTarget+"%'");
					
					while(rs.next()){
						idField.setText(rs.getString("id"));
						titreField.setText(rs.getString("titre"));
						domainField.setText(rs.getString("domain"));
						urlField.setText(rs.getString("url"));
						filePath=rs.getString("image_livre");
						imagelivrelabel.setIcon(new ImageIcon(filePath));
					}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				rechercheField.setText("");
			}
		});
		btnrecherche.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnrecherche.setBounds(436, 89, 144, 29);
		contentPane.add(btnrecherche);
		
		JButton btnupdate = new JButton("R\u00E9parer");
		btnupdate.setIcon(new ImageIcon("./img/icon/Apps-system-software-update-icon.png"));
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idField.getText().length()==0 || titreField.getText().length()==0 || domainField.getText().length()==0 || urlField.getText().length()==0 || filePath.length()==0){
					JOptionPane.showMessageDialog(null, "une ou beucoup des cases sont vide please Verifier tout les cases !!!");
				}
				else{
					try{
						Class.forName("org.postgresql.Driver");
					    java.sql.Connection	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase","postgres","y1sasm");
						PreparedStatement ps=con.prepareStatement("UPDATE cours SET id=?, titre=?, domain=?, url=?, image_livre=? WHERE titre=?");
						ps.setInt(1, Integer.parseInt(idField.getText()));
						ps.setString(2, titreField.getText());
						ps.setString(3, domainField.getText());
						ps.setString(4, urlField.getText());
						ps.setString(5, filePath);
						ps.setString(6,titreField.getText());
						ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}
				}
			}
		});
		btnupdate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnupdate.setBounds(264, 380, 124, 39);
		contentPane.add(btnupdate);
		
		JButton btnvalidate = new JButton("Validate");
		btnvalidate.setIcon(new ImageIcon("./img/icon/Action-ok-icon.png"));
		btnvalidate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(null, "les infos de livre "+titreField.getText() +" sont reparé !!! ","Livre Information",JOptionPane.YES_NO_OPTION)==
            		JOptionPane.YES_OPTION)	{
            	Toolkit toolkit=getToolkit();
            	toolkit.beep();
            	setVisible(false);
            }
			}
		});
		btnvalidate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnvalidate.setBounds(123, 380, 131, 39);
		contentPane.add(btnvalidate);
		
		JButton btnParcourirImage = new JButton("Parcourir");
		btnParcourirImage.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\Formation\\Folders-Uploads-Folder-icon.png"));
		btnParcourirImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.showOpenDialog(null);
				File file=fileChooser.getSelectedFile();
				filePath=file.getAbsolutePath();
				imagelivrelabel.setIcon(new ImageIcon(filePath));				
			}
		});
		btnParcourirImage.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnParcourirImage.setBounds(416, 310, 131, 39);
		contentPane.add(btnParcourirImage);
		
		JPanel imagepanel = new JPanel();
		imagepanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		imagepanel.setBounds(416, 142, 151, 157);
		contentPane.add(imagepanel);
		imagepanel.setLayout(null);
		
		imagelivrelabel = new JLabel("");
		imagelivrelabel.setBounds(0, 0, 151, 157);
		imagepanel.add(imagelivrelabel);
		
		JLabel lblEditEtReparer = new JLabel("Edit et Reparer un Cours\n");
		lblEditEtReparer.setForeground(new Color(51, 0, 0));
		lblEditEtReparer.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 23));
		lblEditEtReparer.setBounds(153, 23, 342, 42);
		contentPane.add(lblEditEtReparer);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("./img/HNCK4880.jpg"));
		label_5.setBounds(0, 0, 644, 461);
		contentPane.add(label_5);
	}
public void fieldsEmpty(){
	idField.setText("");
	titreField.setText("");
	domainField.setText("");
	urlField.setText("");
	imagelivrelabel.setIcon(new ImageIcon());
}
}
