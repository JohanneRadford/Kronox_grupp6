package se.mah.k3;
import java.util.ArrayList;

public class Parser {

	private String lokal;
	private String kurs;
	private String endTime;
	private String startTime;
	private String moment;
	

	public Parser(String moment, String lokal, String kurs, String startTime, String endTime) {
		this.lokal = lokal;
		this.kurs = kurs;
		this.endTime = endTime;
		this.startTime = startTime;
		this.moment = moment;
		
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
		String string =  startTime + "-" + endTime + " " + lokal + " "  + kurs + " "+ "MOMENT: " + moment + "\n";
		return string;
	}

	
	
}
