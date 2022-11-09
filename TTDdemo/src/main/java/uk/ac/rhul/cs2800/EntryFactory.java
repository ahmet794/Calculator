package uk.ac.rhul.cs2800;

/**
 * This class is to create new entry objects.
 * 
 * @author ahmet
 *
 */

public class EntryFactory {


  /**
   * This constructor creates an EntryFactory object.main
   * 
   */
  public EntryFactory() {

  }


  /**
   * This method creates an Entry object which has a string parameter.
   * 
   * @param string is the string for the Entry object.
   * @return an Entry object with a string parameter.
   */
  public Entry createStringEntry(String string) {
    Entry strEntry = new Entry(string);
    return strEntry;
  }

  /**
   * This method creates an Entry object which has a float parameter.
   * 
   * @param f is the float for the Entry object.
   * @return an Entry object with a float parameter.
   */
  public Entry createFloatEntry(float f) {
    Entry floatEntry = new Entry(f);
    return floatEntry;
  }
  
  


}
