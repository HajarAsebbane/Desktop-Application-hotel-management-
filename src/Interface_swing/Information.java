package Interface_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Information extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information frame = new Information();
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
	public Information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 10, 774, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel ISIL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(354, 35, 145, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(new Color(139, 69, 19), 3));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\\\hotel1.jpeg"));
		lblNewLabel_1.setBounds(72, 84, 281, 180);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("- Email : hotelisill@gmail.com");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(452, 78, 263, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("- Tel : 06.54.67.32.00");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(452, 123, 263, 55);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("- Adresse : elghazoua-Essaouira\r\n");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(452, 166, 263, 55);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("- Site web :www.hotelisil.com ");
		lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(452, 209, 263, 55);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\\\hotel2.jpeg"));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(139, 69, 19), 3));
		lblNewLabel_1_1.setBounds(434, 353, 281, 180);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("-La categorie :  5 etoile");
		lblNewLabel_2_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(150, 320, 263, 55);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("-Les chambres spacieuses ");
		lblNewLabel_2_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(150, 374, 263, 55);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("-Le service en chambre");
		lblNewLabel_2_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(150, 435, 263, 55);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("-L'acces internet");
		lblNewLabel_2_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(150, 495, 263, 55);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1);
	}
}