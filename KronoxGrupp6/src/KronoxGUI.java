
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
	private JLabel room2;
	private JLabel moment2;
	private JLabel time1;
	private JLabel time2;
	private JLabel time3;
	private JLabel time4;
	private JLabel time5;
	private JLabel time6;
	private JLabel time7;
	private JLabel time8;
	private JTextArea room7;
	private ClockKronox clockKronox;
	private Parser parser;
	private Test test;
	private String kurs;// = "course";

	public ArrayList<Parser> PAR = new ArrayList<Parser>();
	
/**
	Timer tm;
	int x = 0;
	
	String[] list = {
			"/Users/johanneradford/Desktop/1.png",
			"/Users/johanneradford/Desktop/2.png",
	};
	*/
	


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
		labelTime.setFont(new Font("Futura", Font.PLAIN, 80));
		//labelTime.setBounds(349, 54, 197, 74);
		labelTime.setBounds(698, 108, 359, 135);
		contentPane.add(labelTime);
		
		
		
		//RUBRIKER
		
		JLabel lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 23));
		lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 14));
		lblProgramcourse.setForeground(Color.WHITE);
		lblProgramcourse.setBackground(Color.BLACK);
		//lblProgramcourse.setBounds(130, 129, 165, 49);
		lblProgramcourse.setBounds(260, 255, 249, 49);
		contentPane.add(lblProgramcourse);
		
		JLabel lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 23));
		lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 14));
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBackground(Color.BLACK);
		//lblRoom.setBounds(315, 129, 61, 49);
		lblRoom.setBounds(630, 255, 187, 49);
		contentPane.add(lblRoom);
		
		JLabel lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 23));
		lblStartEnd = new JLabel("START/END");
		lblStartEnd.setFont(new Font("Futura", Font.PLAIN, 14));
		lblStartEnd.setForeground(Color.WHITE);
		lblStartEnd.setBackground(Color.BLACK);
		//lblStartEnd.setBounds(6, 129, 85, 49);
		lblStartEnd.setBounds(30, 255, 156, 49);
		contentPane.add(lblStartEnd);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 23));
		lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 14));
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
		lblNiagara.setFont(new Font("Futura", Font.PLAIN, 50));
		//lblNiagara.setBounds(117, 6, 275, 60);
		lblNiagara.setBounds(245, 12, 399, 79);
		contentPane.add(lblNiagara);
		
		JLabel lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setFont(new Font("Futura", Font.PLAIN, 50));

		lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setFont(new Font("Futura", Font.PLAIN, 35));

		//lblSchedule.setBounds(130, 65, 207, 49);
		lblSchedule.setBounds(245, 108, 274, 49);
		contentPane.add(lblSchedule);
		
		labelDate = new JLabel("");
		labelDate.setFont(new Font("Futura", Font.PLAIN, 16));
		//labelDate.setBounds(404, 17, 126, 18);
		labelDate.setBounds(808, 34, 126, 18);
		contentPane.add(labelDate);
		
		//LOGGA
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/johanneradford/Desktop/Malmö-en1-127x150.png"));
		//lblNewLabel_1.setBounds(17, 6, 88, 110);
		lblNewLabel_1.setBounds(34, 12, 88, 110);
		contentPane.add(lblNewLabel_1);	
		contentPane.add(lblNewLabel_1);
		

		room2 = new JLabel("C0E11");
		room2.setForeground(Color.BLACK);
		room2.setFont(new Font("Futura", Font.PLAIN, 13));
		room2.setBackground(Color.BLACK);
		//room2.setBounds(315, 227, 61, 49);
		room2.setBounds(630, 454, 61, 49);
		contentPane.add(room2);
		
		moment2 = new JLabel("Föreläsning: Fackverk I");
		moment2.setForeground(Color.BLACK);
		moment2.setFont(new Font("Futura", Font.PLAIN, 10));
		moment2.setBackground(Color.BLACK);
		//moment2.setBounds(394, 232, 146, 41);
		moment2.setBounds(788, 464, 146, 41);
		contentPane.add(moment2);
		
		
		//TIDER
		time1 = new JLabel("08:15-12:00");
		time1.setForeground(Color.BLACK);
		time1.setFont(new Font("Futura", Font.PLAIN, 25));
		time1.setBackground(Color.BLACK);
		//time1.setBounds(6, 174, 85, 49);
		time1.setBounds(28, 310, 177, 70);
		contentPane.add(time1);
		
		time2 = new JLabel("08:15-12:00");
		time2.setForeground(Color.BLACK);
		time2.setFont(new Font("Futura", Font.PLAIN, 25));
		time2.setBackground(Color.BLACK);
		//time2.setBounds(6, 227, 85, 49);
		time2.setBounds(30, 380, 156, 70);
		contentPane.add(time2);
		
		time3 = new JLabel("08:15-12:00");
		time3.setForeground(Color.BLACK);
		time3.setFont(new Font("Futura", Font.PLAIN, 14));
		time3.setBackground(Color.BLACK);
		//time3.setBounds(6, 281, 85, 49);
		time3.setBounds(30, 562, 85, 49);
		contentPane.add(time3);
		
		time4 = new JLabel("08:15-12:00");
		time4.setForeground(Color.BLACK);
		time4.setFont(new Font("Futura", Font.PLAIN, 14));
		time4.setBackground(Color.BLACK);
		//time4.setBounds(6, 328, 85, 49);
		time4.setBounds(30, 656, 85, 49);
		contentPane.add(time4);
		
		time5 = new JLabel("08:15-12:00");
		time5.setForeground(Color.BLACK);
		time5.setFont(new Font("Futura", Font.PLAIN, 14));
		time5.setBackground(Color.BLACK);
		//time5.setBounds(6, 389, 85, 49);
		time5.setBounds(30, 778, 85, 49);
		contentPane.add(time5);
		
		time6 = new JLabel("08:15-12:00");
		time6.setForeground(Color.BLACK);
		time6.setFont(new Font("Futura", Font.PLAIN, 14));
		time6.setBackground(Color.BLACK);
		//time6.setBounds(6, 450, 85, 49);
		time6.setBounds(12, 900, 85, 49);
		contentPane.add(time6);
		
		time7 = new JLabel("08:15-12:00");
		time7.setForeground(Color.BLACK);
		time7.setFont(new Font("Futura", Font.PLAIN, 14));
		time7.setBackground(Color.BLACK);
		//time7.setBounds(6, 511, 85, 41);
		time7.setBounds(12, 1022, 85, 41);
		contentPane.add(time7);
		
		time8 = new JLabel("08:15-12:00");
		time8.setForeground(Color.BLACK);
		time8.setFont(new Font("Futura", Font.PLAIN, 14));
		time8.setBackground(Color.BLACK);
		//time8.setBounds(6, 696, 85, 49);
		time8.setBounds(12, 1392, 85, 49);
		contentPane.add(time8);
		
		
		//ROOMS
		JLabel room1 = new JLabel("A0513");
		room1.setForeground(Color.BLACK);
		room1.setFont(new Font("Futura", Font.PLAIN, 25));
		room1.setBackground(Color.BLACK);
		//room1.setBounds(315, 174, 61, 49);
		room1.setBounds(630, 310, 126, 70);
		contentPane.add(room1);
		
		JLabel room2 = new JLabel("C0E11");
		room2.setForeground(Color.BLACK);
		room2.setFont(new Font("Futura", Font.PLAIN, 13));
		room2.setBackground(Color.BLACK);
		//room2.setBounds(315, 227, 61, 49);
		room2.setBounds(630, 454, 61, 49);
		contentPane.add(room2);
		
		JLabel room3 = new JLabel("B0305");
		room3.setForeground(Color.BLACK);
		room3.setFont(new Font("Futura", Font.PLAIN, 13));
		room3.setBackground(Color.BLACK);
		//room3.setBounds(315, 281, 61, 49);
		room3.setBounds(630, 562, 61, 49);
		contentPane.add(room3);
		
		JLabel room4 = new JLabel("C0319");
		room4.setForeground(Color.BLACK);
		room4.setFont(new Font("Futura", Font.PLAIN, 13));
		room4.setBackground(Color.BLACK);
		//room4.setBounds(315, 328, 61, 49);
		room4.setBounds(630, 656, 61, 49);
		contentPane.add(room4);
		
		JLabel room5 = new JLabel("C0205");
		room5.setForeground(Color.BLACK);
		room5.setFont(new Font("Futura", Font.PLAIN, 13));
		room5.setBackground(Color.BLACK);
		//room5.setBounds(315, 389, 61, 49);
		room5.setBounds(630, 788, 61, 49);
		contentPane.add(room5);
		
		JLabel room6 = new JLabel("A0510");
		room6.setForeground(Color.BLACK);
		room6.setFont(new Font("Futura", Font.PLAIN, 13));
		room6.setBackground(Color.BLACK);
		//room6.setBounds(315, 450, 61, 49);
		room6.setBounds(630, 900, 61, 49);
		contentPane.add(room6);
		
		JLabel room8 = new JLabel("B0E15");
		room8.setForeground(Color.BLACK);
		room8.setFont(new Font("Futura", Font.PLAIN, 13));
		room8.setBackground(Color.BLACK);
		//room8.setBounds(315, 696, 61, 49);
		room8.setBounds(630, 1392, 61, 49);
		contentPane.add(room8);
		
		JTextArea room7 = new JTextArea();
		room7.setFont(new Font("Futura", Font.PLAIN, 13));
		room7.setText("A0304\nA0322\nB0203\nB0303\nB0321\nC0306\nC0309\nC0312\nC0325");
		//room7.setBounds(315, 511, 55, 162);
		room7.setBounds(630, 1022, 55, 162);
		contentPane.add(room7);
		
		
		//KURSER

		
		JTextArea kurs1 = new JTextArea();
		kurs1.setText("Verksamhetsförlagd utbildning\nVFU\n");
		kurs1.setFont(new Font("Futura", Font.PLAIN, 18));
		//kurs1.setBounds(103, 187, 151, 34);
		kurs1.setBounds(260, 320, 297, 60);
		contentPane.add(kurs1);
		
		JTextArea kurs2 = new JTextArea();
		kurs2.setText("Verksamhetsförlagd utbildning\nVFU\n");
		kurs2.setFont(new Font("Futura", Font.PLAIN, 10));
		//kurs2.setBounds(103, 245, 151, 34);
		kurs2.setBounds(206, 490, 151, 34);
		contentPane.add(kurs2);
		
		JTextArea kurs3 = new JTextArea();
		kurs3.setFont(new Font("Futura", Font.PLAIN, 10));
		kurs3.setText("Verksamhetsförlagd utbildning\nVFU\n");
		//kurs3.setBounds(103, 296, 151, 34);
		kurs3.setBounds(206, 592, 151, 34);
		contentPane.add(kurs3);
		
		JTextArea kurs4 = new JTextArea();
		kurs4.setText("Transport Management\n- Transporter och hållbar utveckling");
		kurs4.setBackground(new Color(155, 45, 45, 30));
		kurs4.setFont(new Font("Futura", Font.PLAIN, 10));
		//kurs4.setBounds(103, 333, 187, 34);
		kurs4.setBounds(206, 666, 187, 34);
		contentPane.add(kurs4);
		
		
		JTextArea kurs5 = new JTextArea();
		kurs5.setText("Visuell kommunikation\n- Visuell kommunikation: Examensarbete");
		kurs5.setFont(new Font("Futura", Font.PLAIN, 10));
		//kurs5.setBounds(103, 407, 187, 34);
		kurs5.setBounds(206, 814, 187, 34);
		contentPane.add(kurs5);
		
		JTextArea kurs6 = new JTextArea();
		kurs6.setText("International Programme for European \nStudies\n-Urban Images in Literature and Film");
		kurs6.setFont(new Font("Futura", Font.PLAIN, 10));
		kurs6.setBackground(new Color(155, 45, 45, 0));
		//kurs6.setBounds(103, 450, 221, 49);
		kurs6.setBounds(206, 900, 221, 49);
		contentPane.add(kurs6);
		
		JTextArea kurs7 = new JTextArea();
		kurs7.setText("Datavetenskap");
		kurs7.setFont(new Font("Futura", Font.PLAIN, 10));
		//kurs7.setBounds(103, 514, 187, 79);
		kurs7.setBounds(206, 1028, 187, 79);
		contentPane.add(kurs7);
	
	
		JTextArea kurs8 = new JTextArea();
		kurs8.setText("Socionomprogrammet\n- Forskningsmetodik\n");
		kurs8.setFont(new Font("Futura", Font.PLAIN, 10));
		kurs8.setBackground(new Color(155, 0, 0, 0));
		//kurs8.setBounds(103, 696, 177, 41);
		kurs8.setBounds(206, 1392, 177, 41);
		contentPane.add(kurs8);
			
			
			
		//txtrDatavetenskapOchApplikationsutveckling.setText(parser.ParserKurs());


		
		//MOMENT
		JLabel moment1 = new JLabel("Obligatory seminar (1 ECTS)");
		moment1.setForeground(Color.BLACK);
		moment1.setFont(new Font("Futura", Font.PLAIN, 18));
		moment1.setBackground(Color.BLACK);
		//moment1.setBounds(394, 175, 146, 49);
		moment1.setBounds(870, 310, 210, 70);
		contentPane.add(moment1);
		
		JLabel moment2 = new JLabel("Föreläsning: Fackverk I");
		moment2.setForeground(Color.BLACK);
		moment2.setFont(new Font("Futura", Font.PLAIN, 10));
		moment2.setBackground(Color.BLACK);
		//moment2.setBounds(394, 232, 146, 41);
		moment2.setBounds(788, 464, 146, 41);
		contentPane.add(moment2);
		
		JTextArea moment3 = new JTextArea();
		moment3.setText("Seminarium halva klassen:\nmiljöledning i transportföretag");
		moment3.setFont(new Font("Futura", Font.PLAIN, 10));
		moment3.setBackground(new Color(255, 228, 225));
		//moment3.setBounds(388, 285, 120, 34);
		moment3.setBounds(776, 570, 120, 34);
		contentPane.add(moment3);
		
		JTextArea moment4 = new JTextArea();
		moment4.setBackground(new Color(255, 228, 225));
		moment4.setText("Seminarium halva klassen:\nmiljöledning i transportföretag");
		moment4.setFont(new Font("Futura", Font.PLAIN, 10));
		//moment4.setBounds(394, 333, 120, 34);
		moment4.setBounds(788, 666, 120, 34);
		contentPane.add(moment4);
		
		
		JTextArea moment5 = new JTextArea();
		moment5.setText("50% Uppsats seminar\t");
		moment5.setFont(new Font("Futura", Font.PLAIN, 10));
		//moment5.setBounds(394, 407, 146, 31);
		moment5.setBounds(788, 814, 146, 31);
		contentPane.add(moment5);
		
		JTextArea moment6 = new JTextArea();
		moment6.setText("Seminar 3\t");
		moment6.setFont(new Font("Futura", Font.PLAIN, 10));
		moment6.setBackground(new Color(155, 45, 45, 0));
		//moment6.setBounds(394, 458, 136, 41);
		moment6.setBounds(788, 916, 136, 41);
		contentPane.add(moment6);
		
		JTextArea moment7 = new JTextArea();
		moment7.setText("Projektarbete och handledning");
		moment7.setFont(new Font("Futura", Font.PLAIN, 10));
		//moment7.setBounds(394, 517, 146, 34);
		moment7.setBounds(788, 1034, 146, 34);
		contentPane.add(moment7);
		
		JTextArea moment8 = new JTextArea();
		moment8.setText("Frågestund inför saltenta.\nÅterkoppling till övning om \ngranskning av C-Uppsats.");
		moment8.setFont(new Font("Futura", Font.PLAIN, 10));
		moment8.setBackground(new Color(155, 45, 45, 0));
		//moment8.setBounds(394, 696, 142, 43);
		moment8.setBounds(788, 1392, 142, 43);
		contentPane.add(moment8);

		

		
		
	//TEST PARSER
	//PAR = parser.ParserKurs();
		
	//	for(int i = 0; i < PAR.size(); i ++){
		
		//	JLabel testKurs = new JLabel((Icon) PAR.get(i));
			//testKurs.setBounds(134, 77, 187, 115);
		//	contentPane.add(PAR);
			//testKurs.add(PAR);
		
		
<<<<<<< Updated upstream

=======
		JTextArea moment3 = new JTextArea();
		moment3.setText("Seminarium halva klassen:\nmiljöledning i transportföretag");
		moment3.setFont(new Font("Futura", Font.PLAIN, 10));
		moment3.setBackground(new Color(255, 228, 225));
		//moment3.setBounds(388, 285, 120, 34);
		moment3.setBounds(776, 570, 120, 34);
		contentPane.add(moment3);
	
		
		
>>>>>>> Stashed changes

		//test.superDone.add()
			
			
			
		//txtrDatavetenskapOchApplikationsutveckling.append(parser.ParserKurs());
		//System.out.println(parser.ParserKurs());


		
	
		//txtrDatavetenskapOchApplikationsutveckling.setText(parser.ParserKurs(kurs));
		
<<<<<<< Updated upstream
=======

		
>>>>>>> Stashed changes
		
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
		
		
		
		clockKronox = new ClockKronox(this);
		
	/**	PAR = parser.ParserKurs();
		
		
		class getScheduleFromKronox extends Thread{
			@Override
			public void run(){
				PAR = parser.ParserKurs();
			}
			
		}
		*/
	}

}