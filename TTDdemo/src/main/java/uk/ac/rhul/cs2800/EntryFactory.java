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
  public EntryInt createStringEntry(String string) {
    StringEntry strEntry = new StringEntry(string);
    return strEntry;
  }

  /**
   * This method creates an Entry object which has a float parameter.
   * 
   * @param num is the float for the Entry object.
   * @return an Entry object with a float parameter.
   */
  public EntryInt createFloatEntry(float num) {
    FloatEntry floatEntry = new FloatEntry(num);
    return floatEntry;
  }

  /**
   * This method creates an Entry object which has a float.
   * 
   * @param symbol is the Symbol ENUM for the Entry object.
   * @return an Entry object with a Symbol ENUM parameter.
   */
  public EntryInt createSymbolEntry(Symbol symbol) {
    OperationEntry symbolEntry = new OperationEntry(symbol);
    return symbolEntry;
  }



}
