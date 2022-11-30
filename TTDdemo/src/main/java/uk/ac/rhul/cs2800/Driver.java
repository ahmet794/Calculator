package uk.ac.rhul.cs2800;

/**
 * This class is to launch the JavaFX.
 * 
 * @author ahmet
 *
 */
public class Driver {
  /**
   * This program will run by executing a main method.
   * 
   * @param args is the command line arguments.
   */
  public static void main(String[] args) {
    Launcher.startJavaFX(new Controller(), args);
  }

}
