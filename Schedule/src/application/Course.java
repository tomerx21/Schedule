package application;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;

public class Course {
	
	private String lectLabel, courseTF, lectTF, classTF;
	private int StartTime, EndTime, Day;
	private Color colorCP = new Color(0, 0, 0, 0);
	private RadioButton typeRBtn = new RadioButton();
	private VBox GridPaneVBox1, GridPaneVBox2;
	private GridPane ScheduleGrid;
	private boolean ifDoubleVBox = false;
	public Course(String lectLabel, String courseTF, String lectTF, String classTF, int StartTime, int EndTime, int Day, String typeRBtn, Color colorCP, GridPane ScheduleGrid) {
		editInfo(lectLabel, courseTF, lectTF, classTF, StartTime, EndTime, Day, typeRBtn, colorCP, ScheduleGrid);
	}
	public Course(String lectLabel, String courseTF, String lectTF, String classTF, int StartTime, int EndTime, int Day, String typeRBtn, String colorCP, GridPane ScheduleGrid) {
		this.colorCP = Color.valueOf(colorCP);
		editInfo(lectLabel, courseTF, lectTF, classTF, StartTime, EndTime, Day, typeRBtn, this.colorCP, ScheduleGrid);
	}
	public void editInfo(String lectLabel, String courseTF, String lectTF, String classTF, int RowIndex, int ColumnIndex, int Day, String typeRBtn, Color colorCP, GridPane ScheduleGrid) {
		this.lectLabel = lectLabel;
		this.courseTF = courseTF;
		this.lectTF = lectTF;
		this.classTF = classTF;
		this.StartTime = RowIndex;
		this.EndTime = ColumnIndex;
		this.Day = Day;
		this.typeRBtn = new RadioButton(lectLabel);
		this.typeRBtn.setId(typeRBtn);
		this.colorCP = colorCP;
		this.ScheduleGrid = ScheduleGrid; 
		changeGridPaneVBox();
		addToGrid();
	}

//	@Override
//	public String toString() {
//		return ("lecture type: " + lectLabel + "\n" +
//				"course: " + courseTF + "\n" +
//				"lecturer: " + lectTF + "\n" +
//				"class: " + classTF + "\n" +
//				"start time " + StartTime + "\n" +
//				"end time " + EndTime + "\n" +
//				"day " + Day + "\n" 
//				);
//	}
	
	@Override
	public String toString() {
		return (lectLabel + " " +
				courseTF + " " +
				lectTF + " " +
				classTF + " " +
				StartTime + " " +
				EndTime + " " +
				Day + " " +
				typeRBtn.getId() + " " +
				colorCP + " " 
				);
	}
	
	public void addToGrid() {
		
		if (ifDoubleVBox == true) { //If there is a break
			ScheduleGrid.add(GridPaneVBox1, Day, StartTime, 1, 5 - StartTime);
			if (Day == 4) //if tuesday
				ScheduleGrid.add(GridPaneVBox2, Day, 8, 1, EndTime - 8);
			else
				ScheduleGrid.add(GridPaneVBox2, Day, 6, 1, EndTime - 6);
		}
		else 
			ScheduleGrid.add(GridPaneVBox1, Day, StartTime, 1, EndTime - StartTime);
	}
	
	private void changeGridPaneVBox() {
		GridPaneVBox1 = new VBox(4);
		String cssLayout = "-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: " + toRgbString(colorCP) + ";\n";
		GridPaneVBox1.setStyle(cssLayout);
		GridPaneVBox1.setAlignment(Pos.CENTER);
		Label L1 = new Label(lectLabel);
		L1.setStyle("-fx-font-weight: bold;");
		GridPaneVBox1.getChildren().add(L1);
		GridPaneVBox1.getChildren().add(new Label(courseTF));
		GridPaneVBox1.getChildren().add(new Label(lectTF));
		GridPaneVBox1.getChildren().add(new Label(classTF));
		
		if ((StartTime < 5) && (EndTime > 5)) {
			ifDoubleVBox = true;
			GridPaneVBox2 = new VBox(4);
			cssLayout = "-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: " + toRgbString(colorCP) + ";\n";
			GridPaneVBox2.setStyle(cssLayout);
			GridPaneVBox2.setAlignment(Pos.CENTER);
			L1 = new Label(lectLabel + " - המשך");
			L1.setStyle("-fx-font-weight: bold;");
			GridPaneVBox2.getChildren().add(L1);
			GridPaneVBox2.getChildren().add(new Label(courseTF));
			GridPaneVBox2.getChildren().add(new Label(lectTF));
			GridPaneVBox2.getChildren().add(new Label(classTF));
		}
	}
	// Set for display the course info
	public void setCourse(ToggleGroup typeGroup, Label lectLabel, TextField classTF, TextField lectTF, TextField courseTF, ColorPicker colorCP) {
		List<Toggle> list = typeGroup.getToggles();
		for (Toggle toggle : list) {
			if (((RadioButton) toggle).getId().equals(typeRBtn.getId()))
				typeGroup.selectToggle((RadioButton) toggle);
		}
		lectLabel.setText(this.lectLabel);
		classTF.setText(this.classTF);
		lectTF.setText(this.lectTF);
		courseTF.setText(this.courseTF);
		colorCP.setValue(this.colorCP);
	}
	//doubleVBox Getter
	public boolean getIfDoubleVBox() { 
		return ifDoubleVBox;
	}
	//VBox Getter
	public VBox getVBox() { 
		return GridPaneVBox1;
	}
	//second VBox Getter
	public VBox getSecondVBox() { 
		return GridPaneVBox2;
	}
	//startTime Getter
	public int getStartTime() {
		return StartTime;
	}
	
	//endTime Getter
	public int getEndTime() {
		return EndTime;
	}
	
	//day Getter
	public int getDay() {
		return Day;
	}
	//ColorPicker stuff, no idea...
	// Function for changing color.
	private String toRgbString(Color c) {
		return "rgb(" + to255Int(c.getRed()) + "," + to255Int(c.getGreen()) + "," + to255Int(c.getBlue()) + ")";
	}
	
	// Function for changing color.
	private int to255Int(double f) {
		return (int) (f * 255);
	}
	
	public String toDarkerRgbString() {
		return "rgb(" + toDarker255Int(this.colorCP.getRed()) + "," + toDarker255Int(this.colorCP.getGreen()) + "," + toDarker255Int(this.colorCP.getBlue()) + ")";
	}
	
	private int toDarker255Int(double f) {
		return (int) (f * 255 * 0.9f);
	}
	
	public Color getColorCP() {
		return colorCP;
	}

}
