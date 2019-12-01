package dad.javafx.iniciosesion;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioDeSesionView extends VBox {

	private Label userLabel, passwordLabel;
	private TextField userText;
	private PasswordField passwordField;
	private Button accederButton, cancelarButton;
	
	public InicioDeSesionView() {
	
		userLabel = new Label("Usuario:");
		userLabel.setPrefWidth(80);
		
		passwordLabel = new Label("Contraseña:");
		passwordLabel.setPrefWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Usuario");
		userText.setPrefColumnCount(10);
		
		passwordField = new PasswordField();
		passwordField.setPromptText("Contraseña");
		passwordField.setPrefColumnCount(10);
		
		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		
		cancelarButton = new Button("Cancelar");
		
		HBox userBox = new HBox(20, userLabel, userText);
		userBox.setFillHeight(false);
		userLabel.setAlignment(Pos.BASELINE_LEFT);
		
		HBox passwordBox = new HBox(20, passwordLabel, passwordField);
		passwordBox.setFillHeight(false);
		passwordBox.setAlignment(Pos.BASELINE_LEFT);
		
		HBox botonesBox = new HBox(5, accederButton, cancelarButton);
		botonesBox.setFillHeight(false);
		botonesBox.setAlignment(Pos.BASELINE_CENTER);
		
		getChildren().addAll(userBox, passwordBox, botonesBox);
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setFillWidth(false);
	}

	public TextField getUserTxt() {
		return userText;
	}

	public PasswordField getPasswordFd() {
		return passwordField;
	}

	public Button getLoginBt() {
		return accederButton;
	}

	public Button getCancelBt() {
		return cancelarButton;
	}
}
