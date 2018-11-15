package tables;

import java.awt.EventQueue;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EtudiantT extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String columns[]={"Numero", "Prenom", "Nom", "CNE", "Email", "Phone", "CNI", "Resultat"};
	private Object rows[][]={};
	private DefaultTableModel obj=new DefaultTableModel(rows,columns);
	private JLabel image0label;
	private JLabel image1label;
	private JLabel image2label;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantT frame = new EtudiantT();
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
	public EtudiantT() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getData();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 705, 156);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(obj);
		scrollPane.setViewportView(table);
		
		image0label = new JLabel("");
		image0label.setIcon(new ImageIcon("./img/images.jpg"));
		image0label.setBounds(0, 155, 240, 106);
		contentPane.add(image0label);
		
		image1label = new JLabel("");
		image1label.setIcon(new ImageIcon("./img/images0.jpg"));
		image1label.setBounds(240, 155, 240, 106);
		contentPane.add(image1label);
		
		image2label = new JLabel("");
		image2label.setIcon(new ImageIcon("./img/images9.jpg"));
		image2label.setBounds(480, 155, 240, 106);
		contentPane.add(image2label);
		
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
	public void slideshow(){
		Thread t=new Thread(){
            int count;
			@Override
			public void run() {
				while(true){
					switch(count){
					case 0:
					}
				}
			}
			
		};
		t.start();
	}
}
