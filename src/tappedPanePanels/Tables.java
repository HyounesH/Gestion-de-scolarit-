package tappedPanePanels;

import javax.swing.JPanel;

import tables.ActiviteT;
import tables.CoursT;
import tables.EtudiantT;
import tables.ProfesseurT;
import tables.UsersTable;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tables extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tables() {
		setLayout(null);
		
		JButton btnListDesEtudiants = new JButton("List des Etudiants");
		btnListDesEtudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EtudiantT etudiantT=new EtudiantT();
							etudiantT.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesEtudiants.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		btnListDesEtudiants.setBackground(new Color(210, 180, 140));
		btnListDesEtudiants.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesEtudiants.setBounds(42, 48, 235, 33);
		add(btnListDesEtudiants);
		
		JButton btnListDesProfesseurs = new JButton("List des Professeurs");
		btnListDesProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ProfesseurT professeurT=new ProfesseurT();
							professeurT.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesProfesseurs.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		btnListDesProfesseurs.setBackground(new Color(210, 180, 140));
		btnListDesProfesseurs.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesProfesseurs.setBounds(42, 122, 235, 33);
		add(btnListDesProfesseurs);
		
		JButton btnListDesCours = new JButton("List des Cours");
		btnListDesCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CoursT coursT=new CoursT();
							coursT.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesCours.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		btnListDesCours.setBackground(new Color(210, 180, 140));
		btnListDesCours.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesCours.setBounds(42, 194, 235, 33);
		add(btnListDesCours);
		
		JButton btnListDesActivites = new JButton("List des Activites");
		btnListDesActivites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ActiviteT activiteT=new ActiviteT();
							activiteT.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesActivites.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		btnListDesActivites.setBackground(new Color(210, 180, 140));
		btnListDesActivites.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesActivites.setBounds(42, 268, 235, 33);
		add(btnListDesActivites);
		
		JButton button = new JButton("List des Utilisateurs");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UsersTable userT=new UsersTable();
							userT.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		button.setBackground(new Color(210, 180, 140));
		button.setBounds(42, 340, 235, 33);
		add(button);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("./img/index1.jpg"));
		imageLabel.setBounds(0, 0, 310, 512);
		add(imageLabel);
		
		

	}
}
