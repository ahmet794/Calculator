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
   * @throws BadTypeException if the wrong type of getter is called.
   * @throws InvalidExpression if the written expression is wrong.
   */
  public static void main(String[] args) throws InvalidExpression, BadTypeException {
    if (System.console() != null) {
      AsciiView view = new AsciiView();
      new Controller(view);
      view.menu();
    } else {
      Launcher.startJavaFX(new Controller(), args);
    }
  }

}
