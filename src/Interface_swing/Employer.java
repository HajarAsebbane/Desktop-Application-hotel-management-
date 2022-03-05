package Interface_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Connection.Connect;
import net.proteanit.sql.DbUtils;

public class Employer extends JFrame {
	String v_numero;
	String v_name;
	String v_prenom;
	String v_cin;
	String v_tele;
	String v_adresse;
	String v_fonction;
	

	private JPanel contentPane;
	
	private JTextField prenom;
	private JTextField cin;
	private JTextField tele;
	private JTextField fonction;
	private JTextField nom;
	private JTable table;
	DefaultTableModel model;
	private JTextField adresse;
	
	Connection cnx =null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	
	void fermer() {
		dispose();
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Employer frame = new Employer();
					frame.update_table();
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
	public Employer() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1280, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setForeground(new Color(240, 255, 240));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cnx=Connect.getConnection();
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirmer si vous souhaitez quitter!","client",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblNewLabel.setBounds(187, 167, 54, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblPrnom.setBounds(152, 221, 89, 41);
		contentPane.add(lblPrnom);
		
		JLabel lblCin = new JLabel("C.I.N");
		lblCin.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblCin.setBounds(177, 277, 64, 41);
		contentPane.add(lblCin);
		
		JLabel lblNDeTlephone = new JLabel("N\u00B0 de t\u00E9l\u00E9phone");
		lblNDeTlephone.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblNDeTlephone.setBounds(61, 329, 180, 34);
		contentPane.add(lblNDeTlephone);
		
		JLabel lblFonction = new JLabel("Fonction");
		lblFonction.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblFonction.setBounds(139, 438, 102, 41);
		contentPane.add(lblFonction);
		
		
		
		JTextField Numero = new JTextField();
		Numero.setBounds(261, 116, 209, 28);
		contentPane.add(Numero);
		Numero.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(261, 225, 209, 28);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(261, 281, 209, 28);
		contentPane.add(cin);
		
		tele = new JTextField();
		tele.setColumns(10);
		tele.setBounds(261, 330, 209, 28);
		contentPane.add(tele);
		
		fonction = new JTextField();
		fonction.setColumns(10);
		fonction.setBounds(261, 442, 209, 28);
		contentPane.add(fonction);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(261, 171, 209, 28);
		contentPane.add(nom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 135, 693, 448);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				int row= table.getSelectedRow();
				v_numero= table.getModel().getValueAt(row,0).toString();
				v_name=table.getModel().getValueAt(row,1).toString();
				v_prenom=table.getModel().getValueAt(row,2).toString();
				v_cin=table.getModel().getValueAt(row,3).toString();
				v_tele=table.getModel().getValueAt(row,4).toString();
				v_adresse=table.getModel().getValueAt(row,5).toString();
				v_fonction=table.getModel().getValueAt(row,6).toString();
				Numero.setText(v_numero);
				nom.setText(v_name);
				prenom.setText(v_prenom);
				cin.setText(v_cin);
				tele.setText(v_tele);
				adresse.setText(v_adresse);
				fonction.setText(v_fonction);
			}

		});
		model = new DefaultTableModel();
		Object[] column = {"N°","Genre","Nom","Prénom","C.I.N","Télé","Adresse","Fonction"};
		@SuppressWarnings("unused")
		Object[] row = new Object[8];
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton btnNewButton_1 = new JButton("restart");
		scrollPane.setColumnHeaderView(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setFont(new Font("Amiri", Font.BOLD, 22));
		ajouter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String no=Numero.getText().toString();	
				String n=nom.getText().toString();	
				String p= prenom.getText().toString();
				String c=cin.getText().toString();
				String t=tele.getText().toString();
				String a=adresse.getText().toString();
				String f=fonction.getText().toString();
					
				String sql="Insert into employee values(?,? , ? , ? , ? , ? , ?  )";
					try {
						if(!no.equals("")&& !n.equals("")&&!p.equals("") && !c.equals("")  && !t.equals("") && !a.equals("") && !f.equals(""))
						{
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, no);
						prepared.setString(2, n);
						prepared.setString(3, p);
						prepared.setString(4, c);
						prepared.setString(5, t);
						prepared.setString(6, a);
						prepared.setString(7, f);

						
						prepared.execute();
						
						Numero.setText("");
						prenom.setText("");
						nom.setText("");
						cin.setText("");
						tele.setText("");
						adresse.setText("");
						fonction.setText("");

						JOptionPane.showMessageDialog(null,"enregistré avec succès","Employe",JOptionPane.DEFAULT_OPTION);

						}
						
						else JOptionPane.showMessageDialog(null,"Désolé: Il faut remplir tout les informations","emloi",JOptionPane.OK_OPTION);
					}
					
					catch (SQLException e)   {
								e.printStackTrace();
							}
					    update_table();
										
			}
			
			 
		});
		 
		ajouter.setBounds(10, 513, 160, 34);
		contentPane.add(ajouter);
		
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Amiri", Font.BOLD, 20));
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int m= table.getSelectedRow();
				if(m>=0)
				{
				int lignee = table.getSelectedRow();
				String nummm =table.getModel().getValueAt(lignee, 0).toString();

				String sql = "Update employee set Numero =?,Nom=?,Prenom =?,cin=?,n_tele=?,Adresse=?,Fonction=? where Numero = '" + nummm +"'";
				try {
					
					prepared = cnx.prepareStatement(sql);
					
				    prepared.setString(1, Numero.getText().toString());
				    prepared.setString(2, nom.getText().toString());
				    prepared.setString(3, prenom.getText().toString());
				    prepared.setString(4, cin.getText().toString());
				    prepared.setString(5, tele.getText().toString());
				    prepared.setString(6, adresse.getText().toString());
				    prepared.setString(7, fonction.getText().toString());
				    prepared.execute();
				    JOptionPane.showMessageDialog(null,"Voulez vous vraiment de modifier?");
				    update_table();
					}	
				catch (SQLException e)   {
							e.printStackTrace();
						}
				}
				else JOptionPane.showMessageDialog(null,"SVP: Il faut sélectionner une ligne","emploi",JOptionPane.OK_OPTION);
				
				
				
		
				
			}
		});
		modifier.setBounds(187, 514, 160, 34);
		contentPane.add(modifier);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setFont(new Font("Amiri", Font.BOLD, 20));
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int s= table.getSelectedRow();
				if(s>=0) {
				int lignee = table.getSelectedRow();
				String nummm =table.getModel().getValueAt(lignee, 0).toString();

				String sql = "delete from employee  where Numero = '" + nummm +"'";
				try {
					
					prepared = cnx.prepareStatement(sql);
					prepared.execute();
					JOptionPane.showMessageDialog(null,"Voulez vous vraiment de Supprimé?");

				

				  
				   update_table();
					}	
				catch (SQLException e)   {
							e.printStackTrace();
						}
				
			}
				else JOptionPane.showMessageDialog(null,"SVP: Il faut sélectionner une ligne","emploi",JOptionPane.OK_OPTION);

			}

		});
		supprimer.setBounds(357, 514, 144, 34);
		contentPane.add(supprimer);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblAdresse.setBounds(152, 385, 89, 28);
		contentPane.add(lblAdresse);
		
		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(261, 383, 209, 28);
		contentPane.add(adresse);
		
		
		JLabel NumID = new JLabel("Num\u00E9ro");
		NumID.setFont(new Font("Sylfaen", Font.BOLD, 25));
		NumID.setBounds(149, 117, 92, 30);
		contentPane.add(NumID);

		
		JLabel lblNewLabel_1_1 = new JLabel("Gestionnement des employees");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_1_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1_1.setBounds(384, 0, 487, 80);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Administrateur menu=new Menu_Administrateur();
				menu.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("C:\\\\Users\\\\MARYAM\\\\Downloads\\\\\\\\2815404.png"));
		btnNewButton.setBounds(26, 25, 110, 62);
		contentPane.add(btnNewButton);
		
	}	
	public void update_table() {
		
		String sql="select * from employee";
		try {
			prepared=cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			System.out.println("afficher succes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
