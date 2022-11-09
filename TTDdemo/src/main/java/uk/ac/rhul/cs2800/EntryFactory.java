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
   * @return an Entry object with a string parameter.
   */
  public Entry createStringEntry(String string) {
    Entry strEntry = new Entry(string);
    return strEntry;
  }

  /**
   * This method creates an Entry object which has a float parameter.
   * 
   * @param num is the float for the Entry object.
   * @return an Entry object with a float parameter.
   */
  public Entry createFloatEntry(float num) {
    Entry floatEntry = new Entry(num);
    return floatEntry;
  }

  /**
   * This method creates an Entry object which has a float.
   * 
   * @param symbol is the Symbol ENUM for the Entry object.
   * @return an Entry object with a Symbol ENUM parameter.
   */
  public Entry createSymbolEntry(Symbol symbol) {
    Entry symbolEntry = new Entry(symbol);
    return symbolEntry;
  }



}
