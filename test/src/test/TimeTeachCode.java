package test;

public class TimeTeachCode {
	private String lokal;
	private String kurs;
	private String endTime;
	private String courseID;
	

	public TimeTeachCode(String lokal, String kurs) {
		this.lokal = lokal;
		this.kurs = kurs;
		this.endTime = endTime;
		this.courseID = courseID;
		
	}


	public String toString(){
		String string = lokal + " "  + kurs;
		return string;
	}
	

}
