package dad.javafx.main;

import dad.javafx.iniciosesion.InicioDeSesionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private InicioDeSesionController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new InicioDeSesionController();
		
		Scene scene = new Scene(controller.getRootView(), 320, 200);
		
		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
