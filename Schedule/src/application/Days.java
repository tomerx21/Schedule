package application;

public class Days {
	private String name;
	private int num;

	public Days(int num) {
		if (num == 0) {
			this.num = 7-num;
			this.name = new String("��� ���");
		}
		if (num == 1) {
			this.num = 7-num;
			this.name = new String("�����");
		}
		else if (num == 2) {
			this.num = 7-num;
			this.name = new String("���");
		}
		else if (num == 3) {
			this.num = 7-num;
			this.name = new String("�����");
		}
		else if (num == 4) {
			this.num = 7-num;
			this.name = new String("�����");
		}
		else if (num == 5) {
			this.num = 7-num;
			this.name = new String("�����");
		}
		else if (num == 6) {
			this.num = 7-num;
			this.name = new String("����");
		}
		else if (num == 7) {
			this.num = 7-num;
			this.name = new String("���");
		}
	}
	
	public String toString() {
		return this.name;
	}
	public int getNum() {
		return this.num;
	}
}