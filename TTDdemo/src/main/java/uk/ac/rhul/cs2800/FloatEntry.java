package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects float methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class FloatEntry implements Entry {

  private float value;

  /**
   * This constructor creates a FloatEntry object with a float parameter.
   * 
   * @param value is the string.
   */
  public FloatEntry(float value) {
    this.value = value;
  }

  /**
   * This method is to return the float parameter.
   * 
   * @return the value that is the parameter.
   */
  @Override
  public float getNum() {
    return value;
  }


  /**
   * This class should only return getNum method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  @Override
  public Symbol getOp() throws BadTypeException {
    throw new BadTypeException();
  }


}
