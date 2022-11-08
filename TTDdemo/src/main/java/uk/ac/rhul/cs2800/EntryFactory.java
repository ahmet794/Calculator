package uk.ac.rhul.cs2800;

/**
 * This class is to create new entry objects.
 * 
 * @author ahmet
 *
 */

public class EntryFactory {
  
  
  /**
   * This constructor creates an EntryFactory object.
   * 
   */
  public EntryFactory() {
    
  }


  /**
   * This method creates an Entry object which has a string parameter.
   * 
   * @param string is the string for the Entry object.
   */
  public Entry createStringEntry(String string) {
    Entry strEntry = new Entry(string);
    return strEntry;
  }

}
