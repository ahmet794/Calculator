package uk.ac.rhul.cs2800;

/**
 * This interface is for that a View can add itself to a controller.
 * 
 * @author ahmet
 *
 */
// This class is inspired by Dave's many many examples, MVC-separated.
public interface ControllerInterface {
  
  /**
   * This method calls a View to use it in a Controller.
   * 
   * @param v a reference to a new View that will be used in the Controller.
   */
  public void addView(ViewInterface v);
}
