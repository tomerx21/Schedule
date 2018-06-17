package application;

public class Times {
	
	private int num;
	private String name;
	
	public Times(int num) {
		if (num == 1) {
			this.num = num;
			this.name = new String("8:30");
		}
		else if (num == 2) {
			this.num = num;
			this.name = new String("9:30");
		}
		else if (num == 3) {
			this.num = num;
			this.name = new String("10:30");
		}
		else if (num == 4) {
			this.num = num;
			this.name = new String("11:30");
		}
		else if (num == 6) {
			this.num = num;
			this.name = new String("12:50");
		}
		else if (num == 7) {
			this.num = num;
			this.name = new String("13:50");
		}
		else if (num == 8) {
			this.num = num;
			this.name = new String("14:50");
		}
		else if (num == 9) {
			this.num = num;
			this.name = new String("15:50");
		}
	}
	public String toString() {
		return this.name;
	}
	public int getNum() {
		return this.num;
	}
}
