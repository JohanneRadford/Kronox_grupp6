package se.mah.k3;

import java.util.Calendar;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JOptionPane;




public class ClockKronox {

	private ClockKronox kronoxGUI;
	
	private  KronoxGUI digKronoxGUI;

	
	public ClockKronox (KronoxGUI kronoxGUI){
		this.digKronoxGUI = kronoxGUI;
		ClockThread clockTread = new ClockThread();
		clockTread.start();
		
	}
	
	
	public static String addZero(int i){
		String s = String.valueOf(i);
		if( s.length() == 1) {
			s="0" + s;
		}
		return s;
	}
	
	private class ClockThread extends Thread{
		@Override
		public void run() {
			while(true){
				
				Calendar c = Calendar.getInstance();
				int hour = c.get(Calendar.HOUR_OF_DAY);
				int min = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND);
				int day = c.get(Calendar.DATE);
				int month = c.get(Calendar.MONTH);
				int year = c.get(Calendar.YEAR);
				
				digKronoxGUI.setDateOnLabel(addZero(day) + " / "+ addZero(month + 1) + " - " + addZero(year));
			

				digKronoxGUI.setTimeOnLabel(addZero(hour) + " : "+ addZero(min) );
				
				
			
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
					return;
				}
				
			
			}
			
			
		}

			
			
	}
	


		
	}

