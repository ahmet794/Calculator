package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects string methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class StringEntry {

  private String str;

  /**
   * This constructor creates a StringEntry object with a String parameter.
   * 
   * @param str is the Entry object with a string. 
   */
  public StringEntry(String str) {
    this.str = str;
  }

  /**
   * This method is to return the string parameter.
   * 
   * @return the string that is the parameter.
   */
  public String getString() {
    return str;
  }

  /**
   * This class should only return getString method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  public void getNum() throws BadTypeException {
    throw new BadTypeException();
  }

  /**
   * This class should only return getString method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  public void getOp() throws BadTypeException {
    throw new BadTypeException();
  }

}
