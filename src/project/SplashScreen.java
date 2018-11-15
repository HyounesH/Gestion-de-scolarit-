package project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
    private Thread t;
    private JProgressBar progressBar;
    private JLabel label;
    String imageList[]={"img/HNCK4880.jpg",
            "img/index2.jpg",
            "img/HNCK0906.jpg",
            "img/index4.jpg",
            "img/HNCK2364.jpg",
            "img/index6.jpg",
            "img/HNCK2126.jpg",
            "img/index3.jpg",
            "img/HNCK4003.jpg",
            "img/index5.jpg",
            "img/HNCK4067.jpg",
            "img/HNCK2685.jpg"

           };
	/**
	 * Launch the application.
	 */
    /*
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 443);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 128));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(0, 379, 724, 25);
		contentPane.add(progressBar);
		
		label = new JLabel("");
		label.setBounds(0, 0, 724, 381);
		contentPane.add(label);
	 t=new Thread(){
		public void run(){
			int i=0;
			while(i<=100){
				progressBar.setValue(i);
				try{
					sleep(90);
				}catch(Exception ex){
					ex.printStackTrace();
				}
				i++;
			}
		}
	};
	t.start();
	Thread t=new Thread(){
		int count=0;
		public void run(){
			while(true){
				for(count=0;count<=imageList.length;count++){
					if(count==imageList.length){
						count=0;
					}
					try{
						label.setIcon(new ImageIcon(imageList[count]));
						Thread.sleep(1500);
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
