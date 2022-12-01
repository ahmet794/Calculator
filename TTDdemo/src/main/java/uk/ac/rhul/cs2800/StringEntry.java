package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects string methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class StringEntry implements Entry {

  private String str;

  /**
   * This constructor creates a StringEntry object with a String parameter.
   * 
   * @param str is the String. 
   */
  public StringEntry(String str) {
    this.str = str;
  }

  /**
   * This method is to return the string parameter.
   * 
   * @return the string that is the parameter.
   */
  @Override
  public String getString() {
    return str;
  }

  /**
   * This class should only return getString method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  @Override
  public float getNum() throws BadTypeException {
    throw new BadTypeException();
  }

  /**
   * This class should only return getString method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  @Override
  public Symbol getOp() throws BadTypeException {
    throw new BadTypeException();
  }

}
