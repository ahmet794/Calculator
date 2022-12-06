package uk.ac.rhul.cs2800;

/**
 * Create our own observer.
 * 
 * @author ahmet
 *
 */

@FunctionalInterface
public interface Observer {
  /**
   * The method to notify the other observers.
   * 
   */
  public void notifyObservers();
}
