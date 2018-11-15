package tappedPanePanels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connecteur.CreateAccount;
import connecteur.Logging;
import creation.NActivite;
import creation.NCours;
import creation.NEtudiant;
import creation.NProfesseur;
import project.Student;

public class Tools extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tools() {
setLayout(null);
		
		JButton btnListDesEtudiants = new JButton("Cr\u00E9e un Compte");
		btnListDesEtudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateAccount createAccount =new CreateAccount();
							createAccount.setVisible(true);
							Student student=new Student();
							student.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesEtudiants.setIcon(new ImageIcon("./img/icon/client-account-template-icon.png"));
		btnListDesEtudiants.setBackground(new Color(210, 180, 140));
		btnListDesEtudiants.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesEtudiants.setBounds(32, 47, 241, 33);
		add(btnListDesEtudiants);
		
		JButton btnListDesProfesseurs = new JButton("      Connexion");
		btnListDesProfesseurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Logging logging =new Logging();
							logging.setVisible(true);
							Student student=new  Student();
							student.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesProfesseurs.setIcon(new ImageIcon("./img/icon/Windows-Log-Off-icon.png"));
		btnListDesProfesseurs.setBackground(new Color(210, 180, 140));
		btnListDesProfesseurs.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesProfesseurs.setBounds(32, 121, 241, 33);
		add(btnListDesProfesseurs);
		
		JButton btnListDesCours = new JButton("Nouveau Etudiant");
		btnListDesCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NEtudiant nouveauE=new NEtudiant();
							nouveauE.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesCours.setIcon(new ImageIcon("./img/icon/new-icon.png"));
		btnListDesCours.setBackground(new Color(210, 180, 140));
		btnListDesCours.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesCours.setBounds(32, 193, 241, 33);
		add(btnListDesCours);
		
		JButton btnListDesActivites = new JButton("Nouveau Professeur");
		btnListDesActivites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NProfesseur nouveauP=new  NProfesseur();
							nouveauP.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnListDesActivites.setIcon(new ImageIcon("./img/icon/new-icon.png"));
		btnListDesActivites.setBackground(new Color(210, 180, 140));
		btnListDesActivites.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnListDesActivites.setBounds(32, 267, 241, 33);
		add(btnListDesActivites);
		JButton btnNouveauCours = new JButton("  Nouveau Cours");
		btnNouveauCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NCours nouveauC=new NCours();
							nouveauC.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNouveauCours.setIcon(new ImageIcon("./img/icon/new-icon.png"));
		btnNouveauCours.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnNouveauCours.setBackground(new Color(210, 180, 140));
		btnNouveauCours.setBounds(32, 345, 241, 33);
		add(btnNouveauCours);
		
		JButton btnNouveauActivite = new JButton("Nouveau Activite");
		btnNouveauActivite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NActivite nouveauA=new NActivite();
							nouveauA.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNouveauActivite.setIcon(new ImageIcon("./img/icon/new-icon.png"));
		btnNouveauActivite.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnNouveauActivite.setBackground(new Color(210, 180, 140));
		btnNouveauActivite.setBounds(32, 422, 241, 33);
		add(btnNouveauActivite);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("./img/index3.jpg"));
		imageLabel.setBounds(0, 0, 310, 532);
		add(imageLabel);
		
		

	}
}
