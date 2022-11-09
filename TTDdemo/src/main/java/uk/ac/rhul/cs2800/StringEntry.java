package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects string methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class StringEntry {

  private Entry entry;

  /**
   * This constructor creates a StringEntry object with an Entry parameter.
   * 
   * @param entry is the Entry object with a string. 
   */
  public StringEntry(Entry entry) {
    this.entry = entry;
  }

  /**
   * This method is to return the string parameter of the Entry object.
   * 
   * @return the string that is the parameter.
   * @throws BadTypeException if it is not a string.
   */
  public String getString() throws BadTypeException {
    return entry.getString();
  }

  /**
   * This class should only return getString method other types should only throw exceptions.
   * 
   * @Throws BadTypeException if this method is called from this class.
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
