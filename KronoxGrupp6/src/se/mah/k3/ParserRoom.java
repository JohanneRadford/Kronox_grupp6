package se.mah.k3;

public class ParserRoom {
	
	private String room;
	private String moment;
	
	public ParserRoom(String room, String moment){
		this.room = room;
		this.moment = moment;
	}
	
	public String toString(){
		String string =  room + "\t" +  moment + "\n";
		return string;
	}

}
