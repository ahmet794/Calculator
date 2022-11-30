package uk.ac.rhul.cs2800;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI Driver.
 * 
 * @author ahmet
 *
 */

public class Launcher extends Application {

  private static Controller myController;

  /**
   * The entry point to begin the JavaFx framework.
   * 
   * @param controller that needs to be notified when the View is created.
   * @param args the arguments to be used in the Launcher classes main method.
   */
  public static void startJavaFX(Controller controller, String[] args) {
    myController = controller;
    Launcher.main(args);
  }


  @Override
  public void start(Stage primaryStage) {
    FXMLLoader loader;
    loader = new FXMLLoader(Driver.class.getResource("/myView.fxml"));

    Scene scene = null;
    try {
      scene = new Scene(loader.load(), 400, 400);
    } catch (IOException e) {
      // Do Nothing - there is nothing to be done.
      e.printStackTrace();
    }
    myController.addView(loader.getController());
    scene.getStylesheets().add(getClass().getResource("myView.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  /**
   * GUI method.
   * 
   * @param args takes the args argument.
   */
  public static void main(String[] args) {
    Application.launch(args);
  }

}
