package se.mah.k3;
import java.util.ArrayList;

public class Parser {

	private String lokal;
	private String kurs;
	private String endTime;
	private String startTime;
	private String moment;
	

	public Parser(String kurs, String startTime, String endTime) {
		
		this.kurs = kurs;
		this.endTime = endTime;
		this.startTime = startTime;
		
		
	}
	
	public void ParserLokal (String lokal){
		this.lokal = lokal;
	}

	public ArrayList<Parser> ParserKurs(){
		this.kurs = kurs;
		return null;
	}
	
	
	public void ParserStartTime (String startTime, String endTime){
		this.startTime = startTime;
		this.endTime= endTime;
	}
	
	

	public String toString(){
		String string =  startTime + "-" + endTime + "\t "  + kurs + "\n " ;
		return string;
	}
	
	public String getKurs() {
		return kurs;
	}

	public void setKurs(String kurs) {
		this.kurs = kurs;
	}


	
	
}
