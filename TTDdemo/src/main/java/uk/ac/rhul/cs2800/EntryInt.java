package uk.ac.rhul.cs2800;

/**
 * This interface is to create methods for Entry elements.
 * 
 * @author ahmet
 *
 */
public interface EntryInt {
  /**
   * This method should return the string of the parameter.
   * 
   * @return the string.
   */
  public String getString() throws BadTypeException;

  /**
   * This method should return the float of the parameter.
   * 
   * @return the float.
   */
  public float getNum() throws BadTypeException;

  /**
   * This method should return the Symbol ENUM of the parameter.
   * 
   * @return the Symbol ENUM.
   */
  public Symbol getOp() throws BadTypeException;

}
