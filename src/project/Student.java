package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import aide.Help;
import apropos.Apropos;
import connecteur.CreateAccount;
import connecteur.Logging;
import creation.NActivite;
import creation.NCours;
import creation.NEtudiant;
import creation.NProfesseur;
import editInfo.EditActivite;
import editInfo.EditCoursInfo;
import editInfo.EditProfesseurInfo;
import editInfo.EditStudentInfo;
import liraTable.TableActivite;
import liraTable.TableCours;
import liraTable.TableEtudiant;
import liraTable.TableProfesseur;
import liraTable.TableUser;
import tappedPanePanels.Tables;
import tappedPanePanels.Tools;

public class Student extends JFrame {
	private JPanel contentPane;
	
	private JLabel imagelabel;
	String imageList[]={"img/HNCK2685.jpg",
			            "img/HNCK0906.jpg",
			            "img/index2.jpg",
			            "img/HNCK2364.jpg",
			            "img/index4.jpg",
			            "img/index0.jpg",
			            "img/index6.jpg",
			            "img/HNCK4003.jpg",
			            "img/index3.jpg",
			            "img/index1.jpg",
			            "img/index5.jpg",
                        "img/HNCK2126.jpg"

	                   };
	

    
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args)throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 631);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 45);
		contentPane.add(menuBar);
		
		JMenu mnArchive = new JMenu("Archive");
		mnArchive.setIcon(new ImageIcon("./img/icon/zip-icon.png"));
		mnArchive.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnArchive);
		
		JMenu mnNewMenu = new JMenu("Nouveau");
		mnNewMenu.setIcon(new ImageIcon("./img/icon/new-icon.png"));
		mnNewMenu.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnArchive.add(mnNewMenu);
		
		JMenuItem mntmEtudiant = new JMenuItem("Etudiant");
		mntmEtudiant.setIcon(new ImageIcon("./img/icon/user-student-icon.png"));
		mntmEtudiant.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NEtudiant etudiant=new NEtudiant();
							etudiant.setVisible(true);
					        } catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmEtudiant.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnNewMenu.add(mntmEtudiant);
		
		JMenuItem mntmProfesseur = new JMenuItem("Professeur");
		mntmProfesseur.setIcon(new ImageIcon("./img/icon/teacher-female-icon.png"));
		mntmProfesseur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NProfesseur prof=new NProfesseur();
							prof.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		mntmProfesseur.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnNewMenu.add(mntmProfesseur);
		
		JMenuItem mntmCours = new JMenuItem("Cours");
		mntmCours.setIcon(new ImageIcon("./img/icon/Books0-icon.png"));
		mntmCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NCours cours=new NCours();
							cours.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmCours.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnNewMenu.add(mntmCours);
		
		JMenuItem mntmActivit = new JMenuItem("Activit\u00E9");
		mntmActivit.setIcon(new ImageIcon("./img/icon/Calendar0-icon.png"));
		mntmActivit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NActivite activite=new NActivite();
							activite.setVisible(true)	;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmActivit.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnNewMenu.add(mntmActivit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setIcon(new ImageIcon("./img/icon/Actions-edit-find-user-icon.png"));
		mnEdit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnArchive.add(mnEdit);
		
		JMenuItem menuItem = new JMenuItem("Etudiant");
		menuItem.setIcon(new ImageIcon("./img/icon/Student-3-icon.png"));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditStudentInfo etudiantinfo=new EditStudentInfo();
							etudiantinfo.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		menuItem.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnEdit.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Professeur");
		menuItem_1.setIcon(new ImageIcon("./img/icon/teacher-icon.png"));
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditProfesseurInfo professeursInfo =new EditProfesseurInfo();
							professeursInfo.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});				
			}
		});
		menuItem_1.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnEdit.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Cours");
		menuItem_2.setIcon(new ImageIcon("./img/icon/books-icon.png"));
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
             EditCoursInfo coursinfo=new  EditCoursInfo();
             coursinfo.setVisible(true);
			}
		});
		menuItem_2.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnEdit.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Activit\u00E9");
		menuItem_3.setIcon(new ImageIcon("./img/icon/calendar-icon.png"));
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
            EditActivite activite=new EditActivite();
            activite.setVisible(true);
			}
		});
		menuItem_3.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnEdit.add(menuItem_3);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon("./img/icon/Button-Delete-icon.png"));
		mntmExit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnArchive.add(mntmExit);
		
		JMenu mnConsultation = new JMenu("Consultation");
		mnConsultation.setIcon(new ImageIcon("./img/icon/Construction-icon.png"));
		mnConsultation.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnConsultation);
		
		JMenu mnStructureTable = new JMenu("Structure Table");
		mnStructureTable.setIcon(new ImageIcon("./img/icon/Files-Edit-file-icon.png"));
		mnStructureTable.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnConsultation.add(mnStructureTable);
		
		JMenuItem mntmLireTableEtudiant = new JMenuItem("Lire Table Etudiant");
		mntmLireTableEtudiant.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		mntmLireTableEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TableEtudiant tableEtudiant=new TableEtudiant();
							tableEtudiant.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmLireTableEtudiant.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnStructureTable.add(mntmLireTableEtudiant);
		
		JMenuItem mntmLireTableProfesseur = new JMenuItem("Lire Table Professeur");
		mntmLireTableProfesseur.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		mntmLireTableProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TableProfesseur tableProf=new TableProfesseur();
							tableProf.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmLireTableProfesseur.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnStructureTable.add(mntmLireTableProfesseur);
		
		JMenuItem mntmLireTableCours = new JMenuItem("Lire Table Cours");
		mntmLireTableCours.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		mntmLireTableCours.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TableCours tableCours=new TableCours();
							tableCours.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});				
			}
		});
		mntmLireTableCours.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnStructureTable.add(mntmLireTableCours);
		
		JMenuItem mntmLireTableActivit = new JMenuItem("Lire Table Activit\u00E9");
		mntmLireTableActivit.setIcon(new ImageIcon("./img/icon/edit-file-icon.png"));
		mntmLireTableActivit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TableActivite tableActivite=new TableActivite();
							tableActivite.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});				
			}
		});
		mntmLireTableActivit.setFont(new Font("Arial Black", Font.ITALIC, 12));
		mnStructureTable.add(mntmLireTableActivit);
		
		JMenu mnAdmin = new JMenu("Admin");
		mnAdmin.setIcon(new ImageIcon("./img/icon/administrator-icon.png"));
		mnAdmin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnAdmin);
		
		JMenuItem mntmCreeCompte = new JMenuItem("Cr\u00E9e Compte");
		mntmCreeCompte.setIcon(new ImageIcon("./img/icon/client-account-template-icon.png"));
		mntmCreeCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateAccount account=new CreateAccount();
							account.setVisible(true);
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmCreeCompte.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnAdmin.add(mntmCreeCompte);
		
		JMenuItem mntmLireTableAdmin = new JMenuItem("Lire Table Admin");
		mntmLireTableAdmin.setIcon(new ImageIcon("./img/icon/User-Group-icon.png"));
		mntmLireTableAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TableUser tableUser=new TableUser();
							tableUser.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});				
			}
		});
		mntmLireTableAdmin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnAdmin.add(mntmLireTableAdmin);
		
		JMenuItem mntmConnexion = new JMenuItem("Connexion");
		mntmConnexion.setIcon(new ImageIcon("./img/icon/Key-icon.png"));
		mntmConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Logging login=new Logging();
							login.setVisible(true);
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});				
			}
		});
		mntmConnexion.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnAdmin.add(mntmConnexion);
		
		JMenu mnAPropos = new JMenu("About");
		mnAPropos.setIcon(new ImageIcon("./img/icon/Actions-help-about-icon.png"));
		mnAPropos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnAPropos);
		
		JMenuItem mntmSoftware = new JMenuItem("Software Cr\u00E9ateur");
		mntmSoftware.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Apropos propos=new Apropos();
							propos.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
				
			}
		});
		mntmSoftware.setIcon(new ImageIcon("./img/icon/createur-icon.png"));
		mntmSoftware.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnAPropos.add(mntmSoftware);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon("./img/icon/Button-Help-icon.png"));
		mnHelp.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnHelp);
		
		JMenuItem menuItem_4 = new JMenuItem("?");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Help help=new Help();
							help.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		menuItem_4.setIcon(new ImageIcon("./img/icon/FAQ-icon.png"));
		menuItem_4.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		mnHelp.add(menuItem_4);
	    
	    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    Tables tables = new Tables();
	    tables.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    tabbedPane.add("List",tables);
	    tabbedPane.setIconAt(0, new ImageIcon("./img/icon/Generate-tables-icon.png"));
	    Tools tools = new Tools();
	    tools.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    tabbedPane.add("Tools",tools);
	    tabbedPane.setForegroundAt(1, new Color(51, 0, 0));
	    tabbedPane.setIconAt(1, new ImageIcon("./img/icon/Administrative-Tools-icon.png"));
	    tabbedPane.setBackground(Color.WHITE);
	    tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    tabbedPane.setBounds(0, 45, 310, 558);
	    contentPane.add(tabbedPane);
		
	    imagelabel = new JLabel("");
	    imagelabel.setBounds(0, 45, 1000, 547);
	    contentPane.add(imagelabel);
	    imagelabel.setBackground(Color.WHITE);
		Thread t=new Thread(){
			int count=0;
			public void run(){
				while(true){
					for(count=0;count<=imageList.length;count++){
						if(count==imageList.length){
							count=0;
						}
						try{
							imagelabel.setIcon(new ImageIcon(imageList[count]));
							Thread.sleep(3000);
							count++;
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
				}
			}
		};
		t.start();
		
	}
	
	}
	

