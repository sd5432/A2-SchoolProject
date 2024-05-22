package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SchoolUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTextField math;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolUi frame = new SchoolUi();
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
	public SchoolUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(41, 21, 347, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學校錄取系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 10, 124, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(41, 90, 347, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nameLabel = new JLabel("學生姓名:");
		nameLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		nameLabel.setBounds(23, 18, 73, 26);
		panel_1.add(nameLabel);
		
		JLabel mathLabel = new JLabel("數學:");
		mathLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		mathLabel.setBounds(50, 114, 36, 18);
		panel_1.add(mathLabel);
		
		JLabel chiLabel = new JLabel("國文:");
		chiLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		chiLabel.setBounds(50, 54, 46, 15);
		panel_1.add(chiLabel);
		
		name = new JTextField();
		name.setBounds(119, 21, 110, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setBounds(119, 52, 110, 21);
		panel_1.add(chi);
		chi.setColumns(10);
		
		eng = new JTextField();
		eng.setBounds(119, 83, 110, 21);
		panel_1.add(eng);
		eng.setColumns(10);
		
		JLabel engLabel = new JLabel("英文:");
		engLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		engLabel.setBounds(50, 79, 46, 28);
		panel_1.add(engLabel);
		
		math = new JTextField();
		math.setBounds(119, 114, 110, 21);
		panel_1.add(math);
		math.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 0));
		panel_2.setBounds(41, 293, 347, 259);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setBounds(10, 10, 327, 239);
		panel_2.add(show);
		
		/****Button 計算*****/
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取 getText()-->name,chi,eng,math
				 * 2.show-->setText()
				 */
				String Name=name.getText();
				String Chi=chi.getText();
				String Eng=eng.getText();
				String Math=math.getText();
				
				Integer C=new Integer(Chi);
				Integer E=new Integer(Eng);
				Integer M=new Integer(Math);
				
				School s=new School(Name,C,E,M);
				
				if(s.getSum()>=200)
				{
					if(s.getEng()>=75)
					{
						show.setText(s.Success());
					}
					else
					{
						show.setText(s.engError());
					}
				}
				else
				{
					show.setText(s.sumError());
				}

				
				
			}
		});
		btnNewButton.setBounds(88, 167, 203, 23);
		panel_1.add(btnNewButton);
	}

}