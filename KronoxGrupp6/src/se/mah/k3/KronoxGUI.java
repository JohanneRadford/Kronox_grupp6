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
	public JTextArea momentTextArea;
	public JTextArea courseTextArea;
	public JTextArea roomTextArea;
	public JTextArea timeTextArea;
	public JTextArea kurs1;
	
	private ClockKronox clockKronox;
	private Parser parser;
	private Test test;
	private String kurs;// = "course";
	
	private Font Futura;

	public ArrayList<Parser> PAR = new ArrayList<Parser>();
	private ParserNew parserNew;
	


	public void setTimeOnLabel(String time){
		labelTime.setText(time);
	}
	public void setDateOnLabel(String date){
		labelDate.setText(date);
		
	}
	

	//Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/Futura_ICG_Book_Oblique.ttf");
	//textview.setTypeface(tf);



	
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
		FontMethods.setStyle();
	
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
		labelTime.setBounds(789, 103, 291, 135);
		contentPane.add(labelTime);
		
		
		
		//RUBRIKER
		
		JLabel lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 23));
		lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 35));
		lblProgramcourse.setForeground(Color.WHITE);
		lblProgramcourse.setBackground(Color.BLACK);
		//lblProgramcourse.setBounds(130, 129, 165, 49);
		lblProgramcourse.setBounds(260, 275, 358, 49);
		contentPane.add(lblProgramcourse);
		
		JLabel lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 23));
		lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 35));
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBackground(Color.BLACK);
		//lblRoom.setBounds(315, 129, 61, 49);
		lblRoom.setBounds(659, 275, 187, 49);
		contentPane.add(lblRoom);
		
		JLabel lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 23));
		lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 35));
		lblStartEnd.setForeground(Color.WHITE);
		lblStartEnd.setBackground(Color.BLACK);
		//lblStartEnd.setBounds(6, 129, 85, 49);
		lblStartEnd.setBounds(30, 275, 208, 49);
		contentPane.add(lblStartEnd);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 23));
		lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 35));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBackground(Color.BLACK);
		//lblInfo.setBounds(435, 129, 55, 49);
		lblInfo.setBounds(867, 275, 110, 49);
		contentPane.add(lblInfo);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		//textArea.setBounds(0, 126, 540, 49);
		textArea.setBounds(0, 250, 1080, 100);
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
		
		// ROM
		roomTextArea = new JTextArea();
		roomTextArea.setFont(new Font("Futura", Font.PLAIN, 32));
		roomTextArea.setBackground(new Color(0,0,0,0));
		roomTextArea.setOpaque(false);
		roomTextArea.setBounds(640, 372, 420, 1875);
		contentPane.add(roomTextArea);
		
		//Moment
		/**
		courseTextArea = new JTextArea();
		courseTextArea.setFont(new Font("Futura", Font.PLAIN, 25));

		courseTextArea.setBackground(new Color(0,0,0,0));
		courseTextArea.setOpaque(false);
		courseTextArea.setBounds(260, 324, 326, 1920);
		contentPane.add(courseTextArea);
	
		
		//KURSER
		
		momentTextArea = new JTextArea();
		momentTextArea.setFont(new Font("Futura", Font.PLAIN, 25));
		momentTextArea.setBackground(new Color(0,0,0,0));
		momentTextArea.setOpaque(false);
		momentTextArea.setBounds(775, 322, 294, 1920);
		contentPane.add(momentTextArea);
		//courseTextArea.setBackground(new Color(0,0,0,0));
		//momentTextArea.setOpaque(true);
	
*/
		//RADER

		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(155, 45, 45, 35));
		textArea_1.setBounds(0, 373, 1080, 43);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(155, 45, 45, 35));
		textArea_2.setBounds(0, 449, 1080, 43);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBackground(new Color(155, 45, 45, 35));
		textArea_3.setBounds(0, 525, 1080, 43);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBackground(new Color(155, 45, 45, 35));
		textArea_4.setBounds(0, 601, 1080, 43);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBackground(new Color(155, 45, 45, 35));
		textArea_5.setBounds(0, 677, 1080, 43);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBackground(new Color(155, 45, 45, 35));
		textArea_6.setBounds(0, 753, 1080, 43);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBackground(new Color(155, 45, 45, 35));
		textArea_7.setBounds(0, 829, 1080, 43);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBackground(new Color(155, 45, 45, 35));
		textArea_8.setBounds(0, 905, 1080, 43);
		contentPane.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setBackground(new Color(155, 45, 45, 35));
		textArea_9.setBounds(0, 981, 1080, 43);
		contentPane.add(textArea_9);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBackground(new Color(155, 45, 45, 35));
		textArea_10.setBounds(0, 1057, 1080, 43);
		contentPane.add(textArea_10);


		JTextArea textArea_11 = new JTextArea();
		textArea_11.setBackground(new Color(155, 45, 45, 35));
		textArea_11.setBounds(0, 1133, 1080, 43);
		contentPane.add(textArea_11);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setBackground(new Color(155, 45, 45, 35));
		textArea_12.setBounds(0, 1209, 1080, 43);
		contentPane.add(textArea_12);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setBackground(new Color(155, 45, 45, 35));
		textArea_13.setBounds(0, 1285, 1080, 43);
		contentPane.add(textArea_13);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setBackground(new Color(155, 45, 45, 35));
		textArea_14.setBounds(0, 1361, 1080, 43);
		contentPane.add(textArea_14);
		
		JTextArea textArea_15 = new JTextArea();
		textArea_15.setBackground(new Color(155, 45, 45, 35));
		textArea_15.setBounds(0, 1437, 1080, 43);
		contentPane.add(textArea_15);
		
		JTextArea textArea_16 = new JTextArea();
		textArea_16.setBackground(new Color(155, 45, 45, 35));
		textArea_16.setBounds(0, 1513, 1080, 43);
		contentPane.add(textArea_16);
		
		
		JTextArea textArea_17 = new JTextArea();
		textArea_17.setBackground(new Color(155, 45, 45, 35));
		textArea_17.setBounds(0, 1589, 1080, 43);
		contentPane.add(textArea_17);
		
		JTextArea textArea_18 = new JTextArea();
		textArea_18.setBackground(new Color(155, 45, 45, 35));
		textArea_18.setBounds(0, 1665, 1080, 43);
		contentPane.add(textArea_18);
		
		JTextArea textArea_19 = new JTextArea();
		textArea_19.setBackground(new Color(155, 45, 45, 35));
		textArea_19.setBounds(0, 1741, 1080, 43);
		contentPane.add(textArea_19);
		
		JTextArea textArea_20 = new JTextArea();
		textArea_20.setBackground(new Color(155, 45, 45, 35));
		textArea_20.setBounds(0, 1817, 1080, 43);
		contentPane.add(textArea_20);
		
		JTextArea textArea_21 = new JTextArea();
		textArea_21.setBackground(new Color(155, 45, 45, 35));
		textArea_21.setBounds(0, 1893, 1080, 43);
		contentPane.add(textArea_21);
		
		
		
		
		kurs1 = new JTextArea();
		kurs1.setFont(new Font("Futura", Font.PLAIN, 32));
		kurs1.setBounds(27, 336, 605, 1910);

		contentPane.add(kurs1);
		
		JLabel label = new JLabel("Å");
		label.setBounds(30, 231, 61, 16);
		contentPane.add(label);
		
		
		/**timeTextArea = new JTextArea();
		timeTextArea.setOpaque(false);
		timeTextArea.setFont(new Font("Futura", Font.PLAIN, 30));
		timeTextArea.setBackground(new Color(0, 0, 0, 0));
		timeTextArea.setBounds(30, 327, 156, 1920);
		contentPane.add(timeTextArea);*/
		
		clockKronox = new ClockKronox(this);
		
		parserNew = new ParserNew(this);
		
		parserNew.parse();
		
	
	}
}


