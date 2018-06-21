package application;

public class Times {
	
	private int num;
	private String name;
	
	public Times(int num, int startOrEndFlag) {
		if (startOrEndFlag == 1) { //Starting time
			if (num == 0) {
				this.num = num;
				this.name = new String("בחר שעה");
			}
			if ((num > 0) && (num < 5)) {
				this.num = num;
				this.name = new String( + (num + 7) + ":30");
			}
			else if ((num > 5) && (num < 10)) {
				this.num = num;
				this.name = new String( + (num + 7) + ":50");
			}
		}
		else if (startOrEndFlag == 2) { //Ending time
				if (num == 0) {
					this.num = num;
					this.name = new String("בחר שעה");
				}
				if ((num > 0) && (num < 5)) {
					this.num = num;
					this.name = new String( + (num + 7 + 1) + ":20");
				}
				else if ((num > 5) && (num < 11)) {
					this.num = num;
					this.name = new String( + (num + 7) + ":40");
				}
			}
		}
	
	public String toString() {
		return this.name;
	}
	public int getNum() {
		return this.num;
	}
}
