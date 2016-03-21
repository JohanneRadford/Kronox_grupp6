package kronoxtest;

public class parser {

		private String lokal;
		private String kurs;
		private String endTime;
		private String startTime;
		

		public parser(String lokal, String kurs, String startTime, String endTime) {
			this.lokal = lokal;
			this.kurs = kurs;
			this.endTime = endTime;
			this.startTime = startTime;
			
		}


		public String toString(){
			String string = startTime + "-" + endTime + " " + lokal + " "  + kurs;
			return string;
		}
		

	}

