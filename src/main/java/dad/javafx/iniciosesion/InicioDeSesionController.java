package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioDeSesionController {

	private final String usuarios = "users.csv";

	private InicioDeSesionModel model;
	private InicioDeSesionView view;

	public InicioDeSesionController() {

		model = new InicioDeSesionModel();
		view = new InicioDeSesionView();

		model.userProperty().bindBidirectional(view.getUserTxt().textProperty());
		model.passwordProperty().bindBidirectional(view.getPasswordFd().textProperty());

		view.getLoginBt().setOnAction(evt -> onLoginBtAction(evt));
		view.getCancelBt().setOnAction(evt -> Platform.exit());
	}

	private void onLoginBtAction(ActionEvent evt) {

		String user = model.getUser();
		String password = model.getPassword();

		if (user.isEmpty() || password.isEmpty() || !validacion(user, password)) {
			loginDenegado();
		}

		else {
			loginPermitido();
		}
	}

	private boolean validacion(String userName, String password) {

		FileInputStream file = null;
		InputStreamReader in = null;
		BufferedReader buff = null;

		try {

			file = new FileInputStream(usuarios);
			in = new InputStreamReader(file, StandardCharsets.UTF_8);
			buff = new BufferedReader(in);

			String line;
			while ((line = buff.readLine()) != null) {

				String[] data = line.split(",");
				if (userName.equals(data[0]) && codigoMD5(password).equals(data[1])) {
					return true;
				}
			}

		} catch (IOException e) {
		} finally {

			try {
				if (buff != null) {
					buff.close();
				}

				if (in != null) {
					in.close();
				}

				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
			}
		}

		return false;
	}

	private String codigoMD5(String text) {
		return DigestUtils.md5Hex(text).toUpperCase();
	}

	private void loginPermitido() {

		Alert confAlert = new Alert(AlertType.INFORMATION);
		confAlert.setHeaderText("Acceso permitido");
		confAlert.setContentText("Las credenciales de acceso son válidas.");
		confAlert.showAndWait();
	}

	private void loginDenegado() {

		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Acceso denegado");
		errorAlert.setContentText("El usuario y/o la contraseña no son válidos.");
		errorAlert.showAndWait();
	}

	public InicioDeSesionView getRootView() {
		return view;
	}
}
