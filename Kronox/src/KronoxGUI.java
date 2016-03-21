

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Image.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;


public class KronoxGUI extends JFrame {

	
	private JPanel contentPane;
	private JLabel timeLable;
	private JLabel dateLable;
	private ClockKronox clockKronox;
	
	JLabel pic;
	Timer tm;
	int x = 0;
	

	



	public void setTimeOnLabel(String time){
		timeLable.setText(time);
	}
	public void setDateOnLabel(String date){
		dateLable.setText(date);
		
	}
	

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public KronoxGUI() {
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 540, 960);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
<<<<<<< HEAD
		labelTime = new JLabel("");
		labelTime.setFont(new Font("Futura", Font.PLAIN, 55));
		labelTime.setBounds(321, 75, 197, 74);
		contentPane.add(labelTime);
		
		JLabel lblProgramcourse = new JLabel("PROGRAM/COURSE");
		lblProgramcourse.setFont(new Font("Futura", Font.PLAIN, 14));
		lblProgramcourse.setForeground(Color.WHITE);
		lblProgramcourse.setBackground(Color.BLACK);
		lblProgramcourse.setBounds(130, 161, 377, 49);
		contentPane.add(lblProgramcourse);
		
		JLabel lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 14));
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBackground(Color.BLACK);
		lblRoom.setBounds(315, 161, 61, 49);
		contentPane.add(lblRoom);
		
		JLabel lblNewLabel = new JLabel("START/END");
		lblNewLabel.setFont(new Font("Futura", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(6, 161, 85, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setFont(new Font("Futura", Font.PLAIN, 14));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBackground(Color.BLACK);
		lblInfo.setBounds(435, 161, 55, 49);
		contentPane.add(lblInfo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(0, 158, 540, 49);
		contentPane.add(textArea);
		
		JLabel lblNiagara = new JLabel("NIAGARA");
		lblNiagara.setFont(new Font("Futura", Font.PLAIN, 50));
		lblNiagara.setBounds(117, 16, 275, 60);
		contentPane.add(lblNiagara);
		
		JLabel lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setFont(new Font("Futura", Font.PLAIN, 35));
		lblSchedule.setBounds(130, 75, 207, 49);
		contentPane.add(lblSchedule);
		
		labelDate = new JLabel("");
		labelDate.setFont(new Font("Futura", Font.PLAIN, 16));
		labelDate.setBounds(408, 58, 126, 18);
		contentPane.add(labelDate);
	
		
      
		
		clockKronox = new ClockKronox(this);
		
		
=======
		timeLable = new JLabel("");
		timeLable.setFont(new Font("Futura", Font.PLAIN, 55));
		timeLable.setBounds(343, 75, 197, 74);
		contentPane.add(timeLable);
		
		JLabel programLable = new JLabel("PROGRAM/COURSE");
		programLable.setFont(new Font("Futura", Font.PLAIN, 14));
		programLable.setForeground(Color.WHITE);
		programLable.setBackground(Color.BLACK);
		programLable.setBounds(138, 161, 154, 49);
		contentPane.add(programLable);
		
		JLabel roomLable = new JLabel("ROOM");
		roomLable.setFont(new Font("Futura", Font.PLAIN, 14));
		roomLable.setForeground(Color.WHITE);
		roomLable.setBackground(Color.BLACK);
		roomLable.setBounds(315, 161, 61, 49);
		contentPane.add(roomLable);
		
		JLabel startEndLable = new JLabel("START/END");
		startEndLable.setFont(new Font("Futura", Font.PLAIN, 14));
		startEndLable.setForeground(Color.WHITE);
		startEndLable.setBackground(Color.BLACK);
		startEndLable.setBounds(20, 161, 85, 49);
		contentPane.add(startEndLable);
		
		JLabel infoLable = new JLabel("INFO");
		infoLable.setFont(new Font("Futura", Font.PLAIN, 14));
		infoLable.setForeground(Color.WHITE);
		infoLable.setBackground(Color.BLACK);
		infoLable.setBounds(435, 161, 55, 49);
		contentPane.add(infoLable);
		
		JTextArea textArea_black = new JTextArea();
		textArea_black.setBackground(Color.BLACK);
		textArea_black.setBounds(0, 161, 540, 49);
		contentPane.add(textArea_black);
		
		JLabel niagaraLable = new JLabel("NIAGARA");
		niagaraLable.setFont(new Font("Futura", Font.PLAIN, 50));
		niagaraLable.setBounds(117, 16, 275, 60);
		contentPane.add(niagaraLable);
		
		JLabel scheduleLable = new JLabel("SCHEDULE");
		scheduleLable.setFont(new Font("Futura", Font.PLAIN, 35));
		scheduleLable.setBounds(117, 71, 207, 49);
		contentPane.add(scheduleLable);
		
		dateLable = new JLabel("");
		dateLable.setFont(new Font("Futura", Font.PLAIN, 16));
		dateLable.setBounds(408, 58, 126, 18);
		contentPane.add(dateLable);
		
		clockKronox = new ClockKronox(this);
>>>>>>> origin/master
	}
	
}