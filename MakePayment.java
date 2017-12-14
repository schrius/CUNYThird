package Register;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MakePayment {
	static boolean complete = false;
	public void pay(Student student) {
	Stage stage = new Stage();
	stage.initModality(Modality.APPLICATION_MODAL);
	VBox vBox = new VBox(10);
	HBox hBox = new HBox(5);
	vBox.setMinSize(280, 200);
	vBox.setAlignment(Pos.CENTER);
	hBox.setAlignment(Pos.CENTER);
	
	Label payTuition = new Label();
	Label owe = new Label();
	Label overpayLabel = new Label();
	payTuition.setText("Make a Payment");

	owe.setText(Double.toString(student.getDueTuition()+student.getFurtureTuition()));
	TextField pay = new TextField();
	pay.setPromptText("Enter amount");
	
	Button confirmButton = new Button();
	confirmButton.setText("Confirm");
	confirmButton.setOnAction(e -> {
		if(Double.parseDouble(pay.getText()) > (student.getDueTuition()+student.getFurtureTuition())) {
			overpayLabel.setStyle("-fx-text-fill: red");
			overpayLabel.setText("You cannot pay more than you owe.");
		}
		else {
			if(student.getDueTuition() < Double.parseDouble(pay.getText())) {
				double difference = Double.parseDouble(pay.getText()) - student.getDueTuition();
				student.setDueTuition(0);
				student.setFurtureTuition(student.getFurtureTuition() - difference);
			}
			else {
				student.setDueTuition(student.getDueTuition() - Double.parseDouble(pay.getText()));
			}
			try {
				String sql = "UPDATE Student SET DueTuition = " + student.getDueTuition() + ", FurtureTuition = " + student.getFurtureTuition() + " Where StudentID = " + student.getStudentId();
				RegisterJDBC.excuteSQL(sql);
				complete = true;
				stage.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	 
	});

	hBox.getChildren().addAll(owe,pay, confirmButton);
	vBox.getChildren().addAll(payTuition,hBox, overpayLabel);
	Scene scene = new Scene(vBox);
	stage.setScene(scene);
	stage.showAndWait();
	}
}
