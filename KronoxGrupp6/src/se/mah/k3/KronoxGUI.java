                         package se.mah.k3;



import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.swing.Timer;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;


public class KronoxGUI extends JFrame {
	
	private JPanel contentPane;
	private JLabel labelTime;
	private JLabel labelDate;
	private JLabel lblProgramcourse;
	private JLabel lblRoom;
	private JLabel lblStartEnd;
	private JLabel lblInfo;
	private JTextArea textArea;
	private JLabel lblNiagara;
	private JLabel lblSchedule;
	private JLabel lblNewLabel_1;
	private JLabel time1;
	public JTextArea momentTextArea;
	public JTextArea courseTextArea;
	public JTextArea roomTextArea;
	
	private ClockKronox clockKronox;
	private Parser parser;
	private Test test;
	private String kurs;// = "course";

	public ArrayList<Parser> PAR = new ArrayList<Parser>();
	private ParserNew parserNew;
	


	public void setTimeOnLabel(String time){
		labelTime.setText(time);
	}
	public void setDateOnLabel(String date){
		labelDate.setText(date);
		
	}


	
	public static void main(String[] args) {
		new KronoxGUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KronoxGUI frame = new KronoxGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public KronoxGUI() {
			
	
		/**
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 1920);
		
		setMinimumSize(new Dimension(1920, 1080));
		setSize(new Dimension(1920, 1080));
		this.setUndecorated(true);
		*/
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(0, 0, (int)width, (int)height);
			this.setUndecorated(true);
			
			System.out.println(width);
			System.out.println(height);	
			
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelTime = new JLabel("");
		labelTime.setFont(new Font("Futura", Font.PLAIN, 95));
		//labelTime.setBounds(349, 54, 197, 74);
		labelTime.setBounds(728, 89, 359, 135);
		contentPane.add(labelTime);
		
		
		
		//RUBRIKER
		
		JLabel lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 23));
		lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 25));
		lblProgramcourse.setForeground(Color.WHITE);
		lblProgramcourse.setBackground(Color.BLACK);
		//lblProgramcourse.setBounds(130, 129, 165, 49);
		lblProgramcourse.setBounds(260, 255, 249, 49);
		contentPane.add(lblProgramcourse);
		
		JLabel lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 23));
		lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 25));
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBackground(Color.BLACK);
		//lblRoom.setBounds(315, 129, 61, 49);
		lblRoom.setBounds(630, 255, 187, 49);
		contentPane.add(lblRoom);
		
		JLabel lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 23));
		lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 25));
		lblStartEnd.setForeground(Color.WHITE);
		lblStartEnd.setBackground(Color.BLACK);
		//lblStartEnd.setBounds(6, 129, 85, 49);
		lblStartEnd.setBounds(30, 255, 156, 49);
		contentPane.add(lblStartEnd);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 23));
		lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 25));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBackground(Color.BLACK);
		//lblInfo.setBounds(435, 129, 55, 49);
		lblInfo.setBounds(870, 255, 110, 49);
		contentPane.add(lblInfo);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		//textArea.setBounds(0, 126, 540, 49);
		textArea.setBounds(0, 250, 1080, 60);
		contentPane.add(textArea);
		
		JLabel lblNiagara = new JLabel("NIAGARA");
		lblNiagara.setFont(new Font("Futura", Font.PLAIN, 80));
		lblNiagara = new JLabel("NIAGARA");
		lblNiagara.setFont(new Font("Futura", Font.PLAIN, 85));
		//lblNiagara.setBounds(117, 6, 275, 60);
		lblNiagara.setBounds(278, 44, 438, 90);
		contentPane.add(lblNiagara);
		
		JLabel lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setFont(new Font("Futura", Font.PLAIN, 50));

		lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setFont(new Font("Futura", Font.PLAIN, 65));

		//lblSchedule.setBounds(130, 65, 207, 49);
		lblSchedule.setBounds(278, 120, 399, 94);
		contentPane.add(lblSchedule);
		
		labelDate = new JLabel("");
		labelDate.setFont(new Font("Futura", Font.PLAIN, 30));
		//labelDate.setBounds(404, 17, 126, 18);
		labelDate.setBounds(825, 44, 255, 85);
		contentPane.add(labelDate);
		
		//LOGGA
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(KronoxGUI.class.getResource("/images1/Logotyp_Malmo_hogskola4.png")));
		//lblNewLabel_1.setBounds(17, 6, 88, 110);
		lblNewLabel_1.setBounds(30, -1, 226, 244);
		contentPane.add(lblNewLabel_1);	
		contentPane.add(lblNewLabel_1);
		
		
		//TIDER
		time1 = new JLabel("08:15-12:00");
		time1.setForeground(Color.BLACK);
		time1.setFont(new Font("Futura", Font.PLAIN, 25));
		time1.setBackground(Color.BLACK);
		//time1.setBounds(6, 174, 85, 49);
		time1.setBounds(28, 310, 177, 70);
		contentPane.add(time1);
		
		// ROM
		roomTextArea = new JTextArea();
		roomTextArea.setFont(new Font("Futura", Font.PLAIN, 26));
		roomTextArea.setBackground(new Color(0,0,0,0));
		roomTextArea.setOpaque(false);
		roomTextArea.setBounds(619, 327, 122, 493);
		contentPane.add(roomTextArea);
		
		//Moment
		
		courseTextArea = new JTextArea();
		courseTextArea.setFont(new Font("Futura", Font.PLAIN, 18));

		courseTextArea.setBackground(new Color(0,0,0,0));
		courseTextArea.setOpaque(false);
		courseTextArea.setBounds(260, 324, 326, 383);
		contentPane.add(courseTextArea);
	
		
		//KURSER
		
		momentTextArea = new JTextArea();
		momentTextArea.setFont(new Font("Futura", Font.PLAIN, 18));
		momentTextArea.setBackground(new Color(0,0,0,0));
		momentTextArea.setOpaque(false);
		momentTextArea.setBounds(775, 322, 294, 420);
		contentPane.add(momentTextArea);
		//courseTextArea.setBackground(new Color(0,0,0,0));
		//momentTextArea.setOpaque(true);
	

		//RADER

		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.PINK);
		textArea_1.setBackground(new Color(155, 45, 45, 30));
		textArea_1.setBounds(0, 380, 1080, 70);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setForeground(Color.PINK);
		textArea_2.setBackground(new Color(155, 45, 45, 30));
		textArea_2.setBounds(0, 520, 1080, 70);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setForeground(Color.PINK);
		textArea_3.setBackground(new Color(155, 45, 45, 30));
		textArea_3.setBounds(0, 660, 1080, 70);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setForeground(Color.PINK);
		textArea_4.setBackground(new Color(155, 45, 45, 30));
		textArea_4.setBounds(0, 800, 1080, 70);
		contentPane.add(textArea_4);
		
<<<<<<< Updated upstream
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setForeground(Color.PINK);
		textArea_5.setBackground(new Color(155, 45, 45, 30));
		textArea_5.setBounds(0, 940, 1080, 70);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setForeground(Color.PINK);
		textArea_6.setBackground(new Color(155, 45, 45, 30));
		textArea_6.setBounds(0, 1080, 1080, 70);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setForeground(Color.PINK);
		textArea_7.setBackground(new Color(155, 45, 45, 30));
		textArea_7.setBounds(0, 1250, 1080, 70);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setForeground(Color.PINK);
		textArea_8.setBackground(new Color(155, 45, 45, 30));
		textArea_8.setBounds(0, 1390, 1080, 70);
		contentPane.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setForeground(Color.PINK);
		textArea_9.setBackground(new Color(155, 45, 45, 30));
		textArea_9.setBounds(0, 1530, 1080, 70);
		contentPane.add(textArea_9);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setForeground(Color.PINK);
		textArea_10.setBackground(new Color(155, 45, 45, 30));
		textArea_10.setBounds(0, 1670, 1080, 70);
		contentPane.add(textArea_10);
=======
	
	
		
>>>>>>> Stashed changes

		JTextArea textArea_11 = new JTextArea();
		textArea_11.setForeground(Color.PINK);
		textArea_11.setBackground(new Color(155, 45, 45, 30));
		textArea_11.setBounds(0, 1810, 1080, 30);
		contentPane.add(textArea_11);
		
		clockKronox = new ClockKronox(this);
		
		parserNew = new ParserNew(this);
		
		parserNew.parse();
	
	}
}


