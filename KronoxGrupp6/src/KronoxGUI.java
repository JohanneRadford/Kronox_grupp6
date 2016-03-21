
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
		
		
		//TIDER
		time1 = new JLabel("08:15-12:00");
		time1.setForeground(Color.BLACK);
		time1.setFont(new Font("Futura", Font.PLAIN, 25));
		time1.setBackground(Color.BLACK);
		//time1.setBounds(6, 174, 85, 49);
		time1.setBounds(28, 310, 177, 70);
		contentPane.add(time1);
		
		
		//ROOMS
		JLabel room1 = new JLabel("A0513");
		room1.setForeground(Color.BLACK);
		room1.setFont(new Font("Futura", Font.PLAIN, 25));
		room1.setBackground(Color.BLACK);
		//room1.setBounds(315, 174, 61, 49);
		room1.setBounds(630, 310, 126, 70);
		contentPane.add(room1);
	
		
		//KURSER

		
		JTextArea kurs1 = new JTextArea();
		kurs1.setText("Verksamhetsförlagd utbildning\nVFU\n");
		kurs1.setFont(new Font("Futura", Font.PLAIN, 18));
		//kurs1.setBounds(103, 187, 151, 34);
		kurs1.setBounds(260, 320, 297, 60);
		contentPane.add(kurs1);
		

			
			
		//txtrDatavetenskapOchApplikationsutveckling.setText(parser.ParserKurs());


		
		//MOMENT
		JLabel moment1 = new JLabel("Obligatory seminar (1 ECTS)");
		moment1.setForeground(Color.BLACK);
		moment1.setFont(new Font("Futura", Font.PLAIN, 18));
		moment1.setBackground(Color.BLACK);
		//moment1.setBounds(394, 175, 146, 49);
		moment1.setBounds(870, 310, 210, 70);
		contentPane.add(moment1);
		
	
		

		
		
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