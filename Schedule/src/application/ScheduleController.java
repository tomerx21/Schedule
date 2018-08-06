
package application;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class ScheduleController {
	
	boolean courseTFFlag = false, lectTFFlag = false, classTFFlag = false, startTimeCBFlag = false, endTimeCBFlag = false, dayCBFlag = false;
	boolean editCourseFlag = false;
	private Days days[] = new Days[8];
	private Times StartTimes[] = new Times[10];
	private Times EndTimes[] = new Times[10];
	private int indexToEdit;
	private static final int lectTime = 10;
	private ArrayList<Course> CourseArr = new ArrayList<Course>(); // Course array
	@FXML private Button saveBtn; // Save as image button
	@FXML private GridPane ScheduleGrid; // All the GridPane
	@FXML private VBox courseVbox; // Course VBox
	@FXML private ColorPicker colorCP; // Color
	@FXML private RadioButton lectRB; // Lecture RadioButton
	@FXML private RadioButton execRB; // Exercise RadioButton
	@FXML private RadioButton labRB; // Lab RadioButton
	@FXML private RadioButton wsRB; // Sadna RadioButton
	@FXML private Label lectLabel; // Lecture label
	@FXML private TextField courseTF; // Course TextField
	@FXML private TextField lectTF; // Lecturer TextField
	@FXML private TextField classTF; // Class TextField
	@FXML private ComboBox<Days> dayCB; // Day ComboBox
	@FXML private ComboBox<Times> startTimeCB; // Lecture start time ComboBox
	@FXML private ComboBox<Times> endTimeCB; // Lecture end time ComboBox
	@FXML private Button addBtn; // Add button
	@FXML private Button deleteBtn; // Delete button
	@FXML private Label colorLabel; // Color label
	@FXML private ToggleGroup typeGroup; // Radio buttons group
	@FXML private Button endBtn; // End button
	
	// Initialize.
	@FXML public void initialize() {
		for (int i = 0; i < 8; i++) {
			days[i] = new Days(i);
			dayCB.getItems().add(days[i]);
		}
		for (int i = 0; i < 10; i++) {
			StartTimes[i] = new Times(i, 1);
			EndTimes[i] = new Times(i, 2);
		}
		setTimeCB(1, startTimeCB, StartTimes);
		setTimeCB(1, endTimeCB, EndTimes);
		dayCB.setValue(dayCB.getItems().get(0));
		endTimeCB.setValue(endTimeCB.getItems().get(0));
		startTimeCB.setValue(startTimeCB.getItems().get(0));
		colorCP.getStyleClass().add("split-button");
		colorCP.setStyle("-fx-color-label-visible: false ;");
		colorLabel.setVisible(false);
		courseVbox.setVisible(false);
		colorCP.setVisible(false);
//		endBtn.setVisible(false);
//		addBtn.setDisable(true);
		saveBtn.setVisible(false);
	}
 
	// If add button pressed
	@FXML void add(ActionEvent event) {
		final Course tempCourse;
		final VBox tempVBox;
		if (editCourseFlag == true) {
			ScheduleGrid.getChildren().remove(CourseArr.get(indexToEdit).getVBox());
			if (CourseArr.get(indexToEdit).getIfDoubleVBox() == true)
				ScheduleGrid.getChildren().remove(CourseArr.get(indexToEdit).getSecondVBox());
			tempCourse = CourseArr.get(indexToEdit);
			tempCourse.editInfo(lectLabel.getText().toString(), courseTF.getText().toString(), lectTF.getText().toString(), classTF.getText().toString(), startTimeCB.getValue().getNum(), endTimeCB.getValue().getNum(), dayCB.getValue().getNum(), (RadioButton) typeGroup.getSelectedToggle(), colorCP.getValue(), ScheduleGrid);
			endBtn.setVisible(false);
		} 
		else {
			// creating new course object.
			tempCourse = new Course(lectLabel.getText().toString(), courseTF.getText().toString(), lectTF.getText().toString(), classTF.getText().toString(), startTimeCB.getValue().getNum(), endTimeCB.getValue().getNum(), dayCB.getValue().getNum(), (RadioButton) typeGroup.getSelectedToggle(), colorCP.getValue(), ScheduleGrid);
			addBtn.setText("הוסף");
			saveBtn.setVisible(true);
			deleteBtn.setText("מחק");
			CourseArr.add(tempCourse);
			editCourseFlag = false;
		}
			tempVBox = tempCourse.getVBox();
			// If course was clicked from the grid pane (LAMBDA IS BIG SHIT)
			tempVBox.setOnMouseClicked((e) -> { lambdaMethod(tempVBox, tempCourse); });
			// If course contains 2 VBoxes, lambda for the second VBox (LAMBDA IS BIG SHIT)
			if (tempCourse.getSecondVBox() != null) {
				final VBox tempVBox2 = tempCourse.getSecondVBox();
				tempVBox2.setOnMouseClicked((e) -> { lambdaMethod(tempVBox2, tempCourse); });
			}
			clearFields();
		}
	
	private void lambdaMethod(VBox vbox, Course course) {
		editCourseFlag = true; // If user wants to edit\delete
		addBtn.setText("ערוך");
		deleteBtn.setText("מחק");
		endBtn.setVisible(true);
		indexToEdit = checkPos(vbox); // Get the index of the course in the arraylist
		course.setCourse(typeGroup, lectLabel, classTF, lectTF, courseTF, colorCP); // set for display the course info
		dayCB.setValue(days[7 - course.getDay()]); // set course day
		startTimeCB.setValue(StartTimes[course.getStartTime()]); // set course start time
		endTimeCB.setValue(EndTimes[course.getEndTime() - 1]); // set course end time
		classTFFlag = courseTFFlag = dayCBFlag = endTimeCBFlag = lectTFFlag = startTimeCBFlag = true;
		addBtn.setDisable(false);
	}
	
	// Return index of the course in the arraylist
	private int checkPos(VBox tempVBox) {
		int i = 0;
		for (Course course : CourseArr) {
			if (course.getVBox().equals(tempVBox) == true)
				return i;
			else if (course.getIfDoubleVBox() == true)
				if (course.getSecondVBox().equals(tempVBox) == true)
					return i;
			i++;
		}
		return i;
	}
	
	// The button end pressed
	@FXML void end(ActionEvent event) {
		clearFields();
		endBtn.setVisible(false);
	}

	// The button delete pressed.
	@FXML void deleted(ActionEvent event) {
		if (editCourseFlag == true) {
			ScheduleGrid.getChildren().remove(CourseArr.get(indexToEdit).getVBox());
			if (CourseArr.get(indexToEdit).getIfDoubleVBox() == true)
				ScheduleGrid.getChildren().remove(CourseArr.get(indexToEdit).getSecondVBox());
			CourseArr.remove(indexToEdit);
		}
		endBtn.setVisible(false);
		clearFields();
	}

	// The button new course pressed.
	@FXML void newCourse(ActionEvent event) {
		courseVbox.setVisible(true);
		colorCP.setVisible(true);
		colorLabel.setVisible(true);
	}

	// Function to re-set the starting and the ending time ComboBoxes.
	private void setTimeCB(int startIndex, ComboBox<Times> CB, Times arr[]) {
		CB.getItems().clear();
		CB.getItems().add(arr[0] = new Times(0, 1));

		for (int i = startIndex; i < lectTime; i++) {
			if (i != 5) {
				if (dayCB.getValue() == null)
					CB.getItems().add(arr[i]);
				else {
					if ((dayCB.getValue().getNum() != 4) || ((i != 6) && (i != 7))) //
						CB.getItems().add(arr[i]);
				}
			}
		}
		CB.setValue(CB.getItems().get(0));
	}

	// Function to reset all the fields.
	private void clearFields() {
		editCourseFlag = false;
		addBtn.setText("הוסף");
		deleteBtn.setText("מחק");
		courseTF.clear();
		lectTF.clear();
		classTF.clear();
		dayCB.setValue(dayCB.getItems().get(0));
		endTimeCB.setValue(endTimeCB.getItems().get(0));
		startTimeCB.setValue(startTimeCB.getItems().get(0));
		lectLabel.setText(lectRB.getText());
		typeGroup.selectToggle(lectRB);
		colorCP.setValue(Color.WHITE);
		classTFFlag = courseTFFlag = dayCBFlag = endTimeCBFlag = lectTFFlag = startTimeCBFlag = false;
	}

	// If exercise radio button pressed.
	@FXML void execAction(ActionEvent event) { lectLabel.setText(execRB.getText()); }

	// If sadna radio button pressed.
	@FXML void wsAction(ActionEvent event) { lectLabel.setText(wsRB.getText()); }

	// If lecture radio button pressed.
	@FXML void lectAction(ActionEvent event) { lectLabel.setText(lectRB.getText()); }

	// If lab radio button pressed.
	@FXML void labAction(ActionEvent event) { lectLabel.setText(labRB.getText()); }
	
	// ***************** ALL THE FUNCTIONS BELOW IS TO CHECK IF ALL THE FIELDS ARE FILLED TO ENABLE THE ADD BUTTON *****************

	// If course name filled.
	@FXML void keyTypedCourseTF(KeyEvent event) {
		if (courseTF.getText().trim().equals(""))
			courseTFFlag = false;
		else
			courseTFFlag = true;
		checkIfDisableBtn();
	}

	// If lecture name filled.
	@FXML void keyTypedLectTF(KeyEvent event) {
		if (lectTF.getText().trim().equals(""))
			lectTFFlag = false;
		else
			lectTFFlag = true;
		checkIfDisableBtn();
	}

	// If lecturer name filled.
	@FXML void keyTypedClassTF(KeyEvent event) {
		if (classTF.getText().trim().equals(""))
			classTFFlag = false;
		else
			classTFFlag = true;
		checkIfDisableBtn();
	}

	// If start time were chosen.
	@FXML void startHiding(ActionEvent event) {
		if ((startTimeCB.getValue() == null) || (startTimeCB.getValue().getNum() == 0)) {
			startTimeCBFlag = false;
			setTimeCB(1, endTimeCB, EndTimes); // Re-set the ending times in the Combobox for all the options.
		}

		else {
			startTimeCBFlag = true;
			setTimeCB(startTimeCB.getValue().getNum(), endTimeCB, EndTimes); // Re-set the ending times in the Combobox from start time till the end.
		}
		checkIfDisableBtn();
	}

	// If end time were chosen.
	@FXML void endHiding(ActionEvent event) {
		if ((endTimeCB.getValue() == null) || (endTimeCB.getValue().getNum() == 0))
			endTimeCBFlag = false;
		else
			endTimeCBFlag = true;
		checkIfDisableBtn();
	}
	
	// If day were chosen.
	@FXML void dayHiding(ActionEvent event) {
		if ((dayCB.getValue() == null) || (dayCB.getValue().getNum() == 7))
			dayCBFlag = false;
		else {
			dayCBFlag = true;
			if (dayCB.getValue().getNum() == 4) { // if tuesday
				setTimeCB(1, startTimeCB, StartTimes);
				if (startTimeCB.getValue() != null) // if start time was chosen
					setTimeCB(startTimeCB.getValue().getNum(), endTimeCB, EndTimes);
				else {
					setTimeCB(1, endTimeCB, EndTimes);
				}
			}
		}
		checkIfDisableBtn();
	}

	// Function checks according to flags from the all the fields if the add button needs to be endabled or disabled.
	private void checkIfDisableBtn() {
		if ((courseTFFlag == true) && (lectTFFlag == true) && (classTFFlag == true) && (startTimeCBFlag == true)
				&& (endTimeCBFlag == true) && (dayCBFlag == true))
			addBtn.setDisable(false);
		else
			addBtn.setDisable(true);
	}

	// ***************** ALL THE FUNCTIONS ABOVE IS TO CHECK IF ALL THE FIELDS ARE FILLED TO ENABLE THE ADD BUTTON *****************
	
	// the button pressed to save image
	@FXML void captureAndSaveDisplay(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();
			// Set extension filter
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
			// Prompt user to select a file
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				try {
					// Pad the capture area
					WritableImage writableImage = new WritableImage((int) ScheduleGrid.getWidth() + 5,
							(int) ScheduleGrid.getHeight() + 5);
					WritableImage snapshot = ScheduleGrid.snapshot(new SnapshotParameters(), writableImage);
					RenderedImage renderedImage = SwingFXUtils.fromFXImage(snapshot, null);
					// Write the snapshot to the chosen file
					ImageIO.write(renderedImage, "png", file);
				}
				catch (IOException ex) { ex.printStackTrace(); }
			}
	}
}
