package aide;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 485);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 698, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnCetteApplicationEst = new JTextPane();
		txtpnCetteApplicationEst.setFont(new Font("Arial Black", Font.ITALIC, 12));
		txtpnCetteApplicationEst.setText("  -Cette application est une plate-forme p\u00E9dagogique et administrative destin\u00E9e aux \u00E9tablissements scolaires publique ou priv\u00E9es.\r\n  -Cette plateforme est dot\u00E9e de toutes les fonctionnalit\u00E9s dont vous aurez besoin pour vous faciliter la gestion de vos \u00E9tablissements scolaires.\r\n\r\n-Registration des informations des \u00E9tudiants.\r\n-Inscription de tous les \u00E9tudiants de l'\u00E9tablissement.\r\n-Gestion des classes enseign\u00E9es.\r\n\r\n-Visualisation graphique des statistiques des inscriptions, des registrations annuelles .\r\n  Ce programme est complet, gratuit et open source.\r\n\r\n  -Cette application facilite l'utilisation de l'outil informatique au sein des \u00E9tablissements     scolaires qui vont d'une petite \u00E9cole jusqu'\u00E0 la facult\u00E9. Elle est gratuite et open source.");
		txtpnCetteApplicationEst.setBounds(10, 11, 389, 409);
		panel.add(txtpnCetteApplicationEst);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./img/images11.jpg"));
		label.setBounds(401, 0, 272, 193);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("./img/imagesLogin3.jpg"));
		label_1.setBounds(401, 216, 272, 145);
		panel.add(label_1);
	}
}
