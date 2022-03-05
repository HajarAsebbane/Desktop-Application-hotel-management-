package Interface_swing;

import Classes.Chambre;
import Connection.Connect;
import Server.Serveur;
import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gestion_chambre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	String prix;
	String N_porte;
	private DefaultTableModel model;
	private JTable table_1;
	ResultSet rs=null;
	ObjectOutputStream out;
	ObjectInputStream in;
	BufferedReader in_string;
	PreparedStatement st=null;
	Connection con= Connect.getConnection();
	private JTextField textField_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_chambre frame = new Gestion_chambre();
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
	public Gestion_chambre() throws SQLException, IOException {
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
		
		JLabel lblNewLabel = new JLabel("Gestion de chambres ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(240, 11, 414, 43);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Administrateur menu=new Menu_Administrateur();
				menu.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("C:\\\\Users\\\\MARYAM\\\\Downloads\\\\\\\\2815404.png"));
		btnNewButton.setBounds(10, 5, 110, 62);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel("Numero Porte");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 78, 108, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 75, 119, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chambre ch=new Chambre(Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()),(String) "add");
				try {
					Socket client=new Socket("localhost",3002);
					out=new ObjectOutputStream(client.getOutputStream());
					out.writeObject(ch);
					DataInputStream in_string=new DataInputStream(client.getInputStream());
					String message=in_string.readUTF();
					System.out.println(message);
					update_table();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(10, 211, 102, 31);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(248, 248, 255));
		scrollPane.setBounds(308, 78, 466, 316);

		
		table_1 = new JTable();
		scrollPane.setRowHeaderView(table_1);
		String sql="select * from chambre";
		st=con.prepareStatement(sql);
		rs=st.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row= table_1.getSelectedRow();
				N_porte= table_1.getModel().getValueAt(row,0).toString();
				prix=table_1.getModel().getValueAt(row,1).toString();
				textField_1.setText(N_porte);
				textField_2.setText(prix);

			}
		});
		scrollPane.setViewportView(table_1);
		contentPane.add(scrollPane);
		JButton btnNewButton_1_1 = new JButton("Modifier");
		btnNewButton_1_1.setBounds(171, 211, 102, 31);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chambre ch= new Chambre(Integer.parseInt(String.valueOf(textField_1.getText())), Integer.parseInt(String.valueOf(textField_2.getText())), (String) "update");
				try {
					Socket client=new Socket("localhost",3002);
					out=new ObjectOutputStream(client.getOutputStream());
					out.writeObject(ch);
					DataInputStream in_string1=new DataInputStream(client.getInputStream());
					String message1=in_string1.readUTF().toString();
					System.out.println(message1);
					update_table();

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.setBounds(102, 278, 102, 31);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chambre ch= new Chambre(Integer.parseInt(String.valueOf(textField_1.getText())), Integer.parseInt(String.valueOf(textField_2.getText())), (String) "delete");
				try {
					Socket client=new Socket("localhost",3002);
					out=new ObjectOutputStream(client.getOutputStream());
					out.writeObject(ch);
					DataInputStream in_string1=new DataInputStream(client.getInputStream());
					String message1=in_string1.readUTF().toString();
					System.out.println(message1);
					update_table();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix par jours");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 138, 108, 25);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 136, 119, 31);
		contentPane.add(textField_2);
		
	}	
	public void update_table() {
		String sql="select * from chambre";
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
	

