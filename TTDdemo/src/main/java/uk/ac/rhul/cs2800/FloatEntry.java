package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects float methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class FloatEntry {

  private float value;

  /**
   * This constructor creates a FloatEntry object with an Entry parameter.
   * 
   * @param value is the Entry object with a string.
   */
  public FloatEntry(float value) {
    this.value = value;
  }

  /**
   * This method is to return the float parameter.
   * 
   * @return the value that is the parameter.
   */
  public float getNum() {
    return value;
  }

  /**
   * This class should only return getNum method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  public void getString() throws BadTypeException {
    throw new BadTypeException();
  }

  /**
   * This class should only return getNum method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */

  public void getOp() throws BadTypeException {
    throw new BadTypeException();
  }
  

}
