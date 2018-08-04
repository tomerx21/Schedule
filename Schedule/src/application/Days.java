package application;

public class Days {
	private String name;
	private int num;

	public Days(int num) {
		if (num == 0) {
			this.num = 7-num;
			this.name = new String("בחר יום");
		}
		if (num == 1) {
			this.num = 7-num;
			this.name = new String("ראשון");
		}
		else if (num == 2) {
			this.num = 7-num;
			this.name = new String("שני");
		}
		else if (num == 3) {
			this.num = 7-num;
			this.name = new String("שלישי");
		}
		else if (num == 4) {
			this.num = 7-num;
			this.name = new String("רביעי");
		}
		else if (num == 5) {
			this.num = 7-num;
			this.name = new String("חמישי");
		}
		else if (num == 6) {
			this.num = 7-num;
			this.name = new String("שישי");
		}
		else if (num == 7) {
			this.num = 7-num;
			this.name = new String("שבת");
		}
	}
	
	public String toString() {
		return this.name;
	}
	public int getNum() {
		return this.num;
	}
}