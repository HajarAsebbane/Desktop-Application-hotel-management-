package Interface_swing;


import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;



import Connection.Connect;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {
	

	private JPanel contentPane;
	private JPasswordField pwdPassword;
	
	ResultSet rs=null;
	PreparedStatement st=null;
	

		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 255, 240));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Connection con= Connect.getConnection();
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 176, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textUserName = new JTextArea();
		textUserName.setBorder(null);
		textUserName.setFont(new Font("Arial", Font.BOLD, 12));
		textUserName.setText("UserName");
		textUserName.setBounds(10, 11, 216, 18);
		panel.add(textUserName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(202, 227, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBorder(null);
		pwdPassword.setText("PassWord");
		pwdPassword.setBounds(10, 11, 215, 18);
		panel_1.add(pwdPassword);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Authentification.this.dispose();
				}
			}
		});
		lblX.setForeground(new Color(240, 255, 240));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(250, 11, 133, 134);
		contentPane.add(lblIconLogo);
		setUndecorated(true);
		lblIconLogo.setIcon(new ImageIcon("C:\\Users\\MARYAM\\Downloads\\logo3.png"));
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground(new Color(105, 105, 105));
		loginButton.setFont(new Font("Arial", Font.BOLD, 16));
		loginButton.setForeground(new Color(0, 128, 128));
		loginButton.setActionCommand("");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName =textUserName.getText().toString();
				String passWord=pwdPassword.getText().toString();
	
				
				String req="select user_name, user_password from Utilisateur ";
				try {
					st=con.prepareStatement(req);
					rs=st.executeQuery();
					int i=0;
					while(rs.next()) {
						String username1=rs.getString("user_name");
						String passWord1=rs.getString("user_password");
						if(username1.equals(userName) && passWord1.equals(passWord)) {
							JOptionPane.showMessageDialog(null, "Connection reussite");
							Menu_Administrateur Menu_admin=new Menu_Administrateur(); 
							Menu_admin.setVisible(true);						
					}
						else {
//						JOptionPane.showMessageDialog(null, "Connection erronne");
						}	
					}
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBounds(250, 295, 162, 46);
		contentPane.add(loginButton);
		
	}
}
