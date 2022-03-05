package Interface_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.Connect;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class Gestion_Reservation extends JFrame {
	String v_n_porte;
	String v_nom;
	String v_cin;
	String v_db;
	String v_df;
	String n_p_delete;
	Connection cnx =null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	

	private JPanel contentPane;
	private JTextField nom;
	private JTextField cin;
	private JTextField n_porte;
	private JTextField db;
	private JTextField df;
	private JTable table;
	DefaultTableModel model;
	ResultSet rs=null;
	PreparedStatement st=null;
	 Connection con= Connect.getConnection();
	 private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Reservation frame = new Gestion_Reservation();
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
	public Gestion_Reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enregistement des reservation");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 75, 271, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Client");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 135, 79, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIN");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 179, 79, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numero Porte");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 213, 79, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date debut");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 247, 79, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date fin");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 281, 79, 23);
		contentPane.add(lblNewLabel_1_4);
		
		nom = new JTextField();
		nom.setBounds(109, 138, 97, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(109, 180, 97, 20);
		contentPane.add(cin);
		
		n_porte = new JTextField();
		n_porte.setColumns(10);
		n_porte.setBounds(109, 217, 97, 20);
		contentPane.add(n_porte);
		
		db = new JTextField();
		db.setColumns(10);
		db.setBounds(109, 248, 97, 20);
		contentPane.add(db);
		
		df = new JTextField();
		df.setColumns(10);
		df.setBounds(109, 282, 97, 20);
		contentPane.add(df);
		
		JButton btnNewButton = new JButton("Reserver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no=n_porte.getText().toString();
				String n=nom.getText().toString();	
				String c=cin.getText().toString();
				String t=db.getText().toString();
				String a=df.getText().toString();
					try {
						String sql="Insert into reservation values(?,? , ? , ? , ?)";
						System.out.println(sql);
						if(!no.equals("")&& !n.equals("")&& !c.equals("")  && !t.equals("") && !a.equals("") )
						{
							cnx=Connect.getConnection();
							prepared = cnx.prepareStatement(sql);
							prepared.setString(1, no);
							prepared.setString(2, n);
							
							prepared.setString(3, c);
							prepared.setString(4, t);
							prepared.setString(5, a);
							prepared.execute();
							
						n_porte.setText("");
						nom.setText("");
						cin.setText("");
						db.setText("");
						df.setText("");
						update_table2();
						JOptionPane.showMessageDialog(null,"enregistré avec succès","Reservation",JOptionPane.DEFAULT_OPTION);

						}
						
						else JOptionPane.showMessageDialog(null,"Désolé: Il faut remplir tout les informations","Reservation",JOptionPane.OK_OPTION);
					}
					
					catch (SQLException e1)   {
								e1.printStackTrace();
							}
										
			}
			
				
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(40, 328, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Arial", Font.BOLD, 12));
		btnAnnuler.setBounds(165, 328, 89, 23);
		contentPane.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="delete from reservation where n_porte ="+n_p_delete;
				cnx=Connect.getConnection();
				Statement sta= null;
				try {
					sta = con.createStatement();
					boolean rs1=sta.execute(sql);
					update_table2();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 69, 416, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String sql="select * from chambre ";
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row= table.getSelectedRow();
				v_n_porte= table.getModel().getValueAt(row,0).toString();
				n_porte.setText(v_n_porte);
			}
		});

		
		table_1 = new JTable();
		String sql1="select * from reservation ";
		try {
			st=con.prepareStatement(sql1);
			rs=st.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row= table_1.getSelectedRow();
				n_p_delete= table_1.getModel().getValueAt(row,0).toString();
			}
		});
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 437, 764, 113);
//		contentPane.add(scrollPane_1);
//		scrollPane_1.setColumnHeaderView(table_1);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		contentPane.add(scrollPane_1);
		
		JLabel lblListe = new JLabel(" Liste des chambres disponibles");
		lblListe.setFont(new Font("Arial", Font.BOLD, 18));
		lblListe.setBounds(411, 21, 300, 30);
		contentPane.add(lblListe);
		
		
		JLabel lblListeDesChambres = new JLabel(" Liste des chambres reservees");
		lblListeDesChambres.setFont(new Font("Arial", Font.BOLD, 18));
		lblListeDesChambres.setBounds(10, 387, 300, 30);
		contentPane.add(lblListeDesChambres);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Administrateur menu=new Menu_Administrateur();
				menu.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setIcon(new ImageIcon("C:\\\\\\\\Users\\\\\\\\MARYAM\\\\\\\\Downloads\\\\\\\\\\\\\\\\2815404.png"));
		btnNewButton_2.setBounds(10, 11, 102, 64);
		contentPane.add(btnNewButton_2);
	}

	public void update_table() {
		String sql="select * from chambre";
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
public void update_table2() {
	String sql="select * from reservation ";
	try {
		st=con.prepareStatement(sql);
		rs=st.executeQuery();
    	table_1.setModel(DbUtils.resultSetToTableModel(rs));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
}
	