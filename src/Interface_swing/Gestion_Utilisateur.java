package Interface_swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gestion_Utilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtDkkf;
	private JTextField txtEntrerUneValeur;
	private JTextField txtEntrerUneValeur_1;
	private JTextField txtEntrerUneValeur_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Gestion_Utilisateur frame = new Gestion_Utilisateur();
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
	public Gestion_Utilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 10, 774, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestionner Les Utilisateurs");
		lblNewLabel.setBounds(231, 37, 329, 25);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(245, 255, 250));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero matricule :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(47, 109, 151, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Salaire :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(47, 276, 126, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(47, 170, 126, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(47, 233, 126, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtDkkf = new JTextField();
		txtDkkf.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDkkf.setText("Entrer une Valeur ...");
		txtDkkf.setBounds(223, 109, 151, 32);
		contentPane.add(txtDkkf);
		txtDkkf.setColumns(10);
		
		txtEntrerUneValeur = new JTextField();
		txtEntrerUneValeur.setText("Entrer une Valeur ...");
		txtEntrerUneValeur.setColumns(10);
		txtEntrerUneValeur.setBounds(223, 170, 151, 32);
		contentPane.add(txtEntrerUneValeur);
		
		txtEntrerUneValeur_1 = new JTextField();
		txtEntrerUneValeur_1.setText("Entrer une Valeur ...");
		txtEntrerUneValeur_1.setColumns(10);
		txtEntrerUneValeur_1.setBounds(223, 223, 151, 32);
		contentPane.add(txtEntrerUneValeur_1);
		
		txtEntrerUneValeur_2 = new JTextField();
		txtEntrerUneValeur_2.setText("Entrer une Valeur ...");
		txtEntrerUneValeur_2.setColumns(10);
		txtEntrerUneValeur_2.setBounds(223, 276, 151, 32);
		contentPane.add(txtEntrerUneValeur_2);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(501, 134, 142, 46);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(47, 79, 79));
		btnSupprimer.setFont(new Font("Arial", Font.BOLD, 16));
		btnSupprimer.setBounds(501, 226, 142, 46);
		contentPane.add(btnSupprimer);
		
		JList list = new JList();
		list.setBounds(169, 490, 391, -86);
		contentPane.add(list);
		
		
	}
}
