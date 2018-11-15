package apropos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class Apropos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apropos frame = new Apropos();
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
	public Apropos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 478);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomComplet = new JLabel("Nom Complet :    Younes Hamdane");
		lblNomComplet.setForeground(Color.BLACK);
		lblNomComplet.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblNomComplet.setBounds(73, 159, 435, 19);
		contentPane.add(lblNomComplet);
		
		JLabel lblDateNaissance = new JLabel("Date Naissance :  31/12/1994");
		lblDateNaissance.setForeground(Color.BLACK);
		lblDateNaissance.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblDateNaissance.setBounds(73, 207, 435, 19);
		contentPane.add(lblDateNaissance);
		
		JLabel lblNationalitMarocain = new JLabel("Nationalit\u00E9 :    Marocain");
		lblNationalitMarocain.setForeground(Color.BLACK);
		lblNationalitMarocain.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblNationalitMarocain.setBounds(73, 255, 435, 19);
		contentPane.add(lblNationalitMarocain);
		
		JLabel lblVille = new JLabel("Ville : Agadir");
		lblVille.setForeground(Color.BLACK);
		lblVille.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblVille.setBounds(73, 305, 435, 19);
		contentPane.add(lblVille);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setIcon(new ImageIcon("C:\\Users\\Hamdane Younes\\Desktop\\14801132_1159396044149212_201435893_n.jpg"));
		label_1.setBounds(0, 0, 594, 616);
		contentPane.add(label_1);
	}
}
