package application;

import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;

public class Course {
	
	String lectLabel, courseTF, lectTF, classTF;
	int StartTime, EndTime, Day;
	Color colorCP;
	RadioButton typeRBtn;
	VBox GridPaneVBox = new VBox(4);
	GridPane ScheduleGrid;
	
	public Course(String lectLabel, String courseTF, String lectTF, String classTF, int RowIndex, int ColumnIndex, int RowSpan, RadioButton typeRBtn, Color colorCP, GridPane ScheduleGrid) {
		this.lectLabel = lectLabel;
		this.courseTF = courseTF;
		this.lectTF = lectTF;
		this.classTF = classTF;
		this.StartTime = RowIndex;
		this.EndTime = ColumnIndex;
		this.Day = RowSpan;
		this.typeRBtn = typeRBtn;
		this.colorCP = colorCP;
		this.ScheduleGrid = ScheduleGrid; 
		changeGridPaneVBox();
		addToGrid();
	}
	public void editInfo(String lectLabel, String courseTF, String lectTF, String classTF, int RowIndex, int ColumnIndex, int RowSpan, RadioButton typeRBtn, Color colorCP, GridPane ScheduleGrid) {
		this.lectLabel = lectLabel;
		this.courseTF = courseTF;
		this.lectTF = lectTF;
		this.classTF = classTF;
		this.StartTime = RowIndex;
		this.EndTime = ColumnIndex;
		this.Day = RowSpan;
		this.typeRBtn = typeRBtn;
		this.colorCP = colorCP;
		this.ScheduleGrid = ScheduleGrid; 
		changeGridPaneVBox();
		addToGrid();
	}
	public void addToGrid() {
		ScheduleGrid.add(GridPaneVBox, Day, StartTime, 1, EndTime - StartTime);
	}
	
	private void changeGridPaneVBox() {
		GridPaneVBox = new VBox(4);
		String cssLayout = "-fx-border-color: black;\n" + "-fx-border-width: 1;\n" + "-fx-background-color: " + toRgbString(colorCP) + ";\n";
		GridPaneVBox.setStyle(cssLayout);
		GridPaneVBox.setAlignment(Pos.CENTER);
		Label L1 = new Label(lectLabel);
		L1.setStyle("-fx-font-weight: bold;");
		GridPaneVBox.getChildren().add(L1);
		GridPaneVBox.getChildren().add(new Label(courseTF));
		GridPaneVBox.getChildren().add(new Label(lectTF));
		GridPaneVBox.getChildren().add(new Label(classTF));
	}
	// Set for display the course info
	public void setCourse(ToggleGroup typeGroup, Label lectLabel, TextField classTF, TextField lectTF, TextField courseTF, ColorPicker colorCP) {
		typeGroup.selectToggle(typeRBtn);
		lectLabel.setText(this.lectLabel);
		classTF.setText(this.classTF);
		lectTF.setText(this.lectTF);
		courseTF.setText(this.courseTF);
		colorCP.setValue(this.colorCP);
	}
	//VBox Getter
	public VBox getVBox() { 
		return GridPaneVBox;
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

	//lectLabel Setter
	public void setLectLabel(String lectLabel) {
		this.lectLabel = lectLabel;
	}

	
	//courseTF Setter
	public void setCourseTF(String courseTF) {
		this.courseTF = courseTF;
	}

	
	//lectTF Setter
	public void setLectTF(String lectTF) {
		this.lectTF = lectTF;
	}

	
	//classTF Setter
	public void setClassTF(String classTF) {
		this.classTF = classTF;
	}

	
	//startTime Setter
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	
	//endTime Setter
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}

	
	//day Setter
	public void setDay(int day) {
		Day = day;
	}

	
	//colorCP Setter
	public void setColorCP(Color colorCP) {
		this.colorCP = colorCP;
	}

	
	//typeRBtn Setter
	public void setTypeRBtn(RadioButton typeRBtn) {
		this.typeRBtn = typeRBtn;
	}

	
	//scheduleGrid Setter
	public void setScheduleGrid(GridPane scheduleGrid) {
		ScheduleGrid = scheduleGrid;
	}
	
	// Function for changing color.
	private int to255Int(double f) {
		return (int) (f * 255);
	}

}
