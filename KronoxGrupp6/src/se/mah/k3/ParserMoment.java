package se.mah.k3;

public class ParserMoment {
	
	private String moment;

	public ParserMoment(String moment) {
		this.moment = moment;
		
	}
	
	public String toString(){
		String string =  "MOMENT: " + moment + "\n";
		return string;
	}

}
