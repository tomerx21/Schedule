package application;

public class Days {
	private String name;
	private int num;

	public Days(int num) {
		if (num == 1) {
			this.num = num;
			this.name = "ראשון";
		}
		else if (num == 2) {
			this.num = num;
			this.name = "שני";
		}
		else if (num == 3) {
			this.num = num;
			this.name = "שלישי";
		}
		else if (num == 4) {
			this.num = num;
			this.name = "רביעי";
		}
		else if (num == 5) {
			this.num = num;
			this.name = "חמישי";
		}
		else if (num == 6) {
			this.num = num;
			this.name = "שישי";
		}
		else if (num == 7) {
			this.num = num;
			this.name = "שבת";
		}
	}
}
