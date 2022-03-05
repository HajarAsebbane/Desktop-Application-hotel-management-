 package Interface_swing;

 import java.awt.BorderLayout;
 import java.awt.EventQueue;

 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.border.EmptyBorder;

import Classes.Chambre;
import Classes.Client;
import Classes.Employee;

import javax.swing.JLabel;
 import javax.swing.JOptionPane;

 import java.awt.Font;
 import javax.swing.JButton;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import javax.swing.ImageIcon;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.net.MalformedURLException;
 import java.sql.SQLException;
 import java.awt.Color;
 import java.awt.Desktop;
 import java.awt.SystemColor;

public class Menu_Administrateur extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Administrateur frame = new Menu_Administrateur();
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
	public Menu_Administrateur() {
		setBackground(new Color(0, 128, 128));

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 90, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Chambres");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		
			
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirmer si vous souhaitez quitter!","client",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});

		lblNewLabel_2.setBounds(1179, 0, 87, 99);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hotel-ISIL");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 60));
		lblNewLabel_1_1.setBackground(new Color(245, 255, 250));
		lblNewLabel_1_1.setBounds(232, 0, 299, 80);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_3.setFont(new Font("BankGothic Md BT", Font.BOLD, 37));
		lblNewLabel_3.setBounds(61, 331, 220, 35);
		contentPane.add(lblNewLabel_3);
		
		JButton chambre = new JButton("");
		chambre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chambre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				Gestion_chambre GC;
				try {
					GC = new Gestion_chambre();
					GC.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		chambre.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\room.jpeg"));
		chambre.setBounds(61, 91, 235, 218);
		contentPane.add(chambre);
		
		JButton CLIENTS = new JButton("");
		CLIENTS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gestion_Reservation GR = new Gestion_Reservation();
				GR.setVisible(true);
				
			}
		});
		
		CLIENTS.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\3201521.png"));
		CLIENTS.setBounds(492, 91, 235, 218);
		contentPane.add(CLIENTS);
		
		JButton EMPLOYEES = new JButton("");
		EMPLOYEES.setForeground(new Color(255, 255, 255));
		EMPLOYEES.setBackground(new Color(255, 255, 255));
		EMPLOYEES.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employer trav = new Employer();
				trav.update_table();
				trav.setVisible(true);
				
			}
		});
		EMPLOYEES.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\912216.png"));
		EMPLOYEES.setBounds(61, 383, 235, 218);
		contentPane.add(EMPLOYEES);
		
		JButton infoo = new JButton("");
		infoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Information inf = new Information();
				inf.setVisible(true);
				
			}
		});
		infoo.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\information.png"));
		infoo.setBounds(492, 377, 235, 218);
		contentPane.add(infoo);
		
		JLabel lblNewLabel_3_1 = new JLabel("Clients");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setFont(new Font("BankGothic Md BT", Font.BOLD, 37));
		lblNewLabel_3_1.setBounds(535, 331, 170, 35);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Employ\u00E9es");
		lblNewLabel_3_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1_1.setFont(new Font("BankGothic Md BT", Font.BOLD, 37));
		lblNewLabel_3_1_1.setBounds(61, 612, 235, 35);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("About");
		lblNewLabel_3_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1_1_1.setFont(new Font("BankGothic Md BT", Font.BOLD, 37));
		lblNewLabel_3_1_1_1.setBounds(542, 615, 144, 35);
		contentPane.add(lblNewLabel_3_1_1_1);
		ImageIcon backgroud=new ImageIcon("C:\\Users\\MARYAM\\Downloads\\\\J.jpeg");
	
	}
	

}
