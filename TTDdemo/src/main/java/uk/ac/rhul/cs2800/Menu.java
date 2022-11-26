package uk.ac.rhul.cs2800;

/**
 * This class uses the State interface and has useful methods to use in the menu method of the
 * AsciView.
 * 
 * @author ahmet
 *
 */
public class Menu {

  private State state;
  private boolean finished = false;

  /**
   * This constructor creates a Menu object which assigns the state field.
   * 
   */
  public Menu() {
    this.state = new ExpressionState(this);
  }

  /**
   * This method changes the State.
   * 
   * @param state is the state that is being changed to.
   */
  public void changeState(State state) {
    this.state = state;
  }

  /**
   * Simple getter method for state.
   * 
   * @return the state.
   */

  public State getState() {
    return state;
  }

  /**
   * This method sets the finished boolean.
   * 
   * @param finished is the boolean that is set accordingly.
   */
  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  /**
   * Check if the quit method is called.
   * 
   * @return the finished parameter.
   */
  public boolean isFinished() {
    return finished;
  }



}
