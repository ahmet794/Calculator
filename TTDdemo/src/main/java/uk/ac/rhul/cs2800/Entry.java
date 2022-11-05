package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Entry class takes a float or a string or the Symbol ENUMs or the Type ENUMs and store these
 * values in the Stack class.
 * 
 * @author ahmet
 *
 */
public class Entry {
  private float number;
  private Symbol other;
  private Type type;
  private String str;

  /**
   * This constructor is to create an Entry object with a value of float.
   * 
   * @param value is a float.
   */
  public Entry(float value) {
    number = value;
  }

  /**
   * This constructor is to create an Entry object with a value of the Symbol ENUM.
   * 
   * @param which is the Symbol ENUM.
   */
  public Entry(Symbol which) {
    other = which;
  }


  /**
   * This constructor is to create an Entry object with a value of the Type ENUM.
   * 
   * @param kind is the Type ENUM.
   */
  public Entry(Type kind) {
    type = kind;
  }

  /**
   * This constructor is to create an Entry object with a String.
   * 
   * @param string is a String that defines the Entry object.
   */
  public Entry(String string) {
    str = string;
  }

  /**
   * This method gives the value of the Entry object.
   * 
   * @return float value of the object.
   * @throws BadTypeException If the type of the value is not matching the type of the get method.
   */
  public float getValue() throws BadTypeException {
    if (number != 0.0f) { // When a float is not used it is automatically assigned to 0.0f.
      return number;
    } else {
      throw new BadTypeException();
    }
  }

  /**
   * This method is to give the value of Symbol ENUM.
   * 
   * @return Symbol ENUM.
   * @throws BadTypeException If the type of the value is not matching the type of the get method.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (other != null) { // When a Symbol ENUM is not used it is automatically assigned to null.
      return other;
    } else {
      throw new BadTypeException();
    }
  }

  /**
   * This method is to give the value of Type ENUM.
   * 
   * @return Type ENUM.
   * @throws BadTypeException If the type of the value is not matching the type of the get method.
   */
  public Type getType() throws BadTypeException {
    if (type != null) { // When a Type ENUM is not used it is automatically assigned to null.
      return type;
    } else {
      throw new BadTypeException();
    }
  }

  /**
   * This method is to get the String value of the Entry object.
   * 
   * @return a string.
   * @throws BadTypeException If the type of the value is not matching the type of the get method.
   */
  public String getString() throws BadTypeException {
    if (str != null) { // When a String is not used it is automatically assigned to null.
      return str;
    } else {
      throw new BadTypeException();
    }
  }

  @Override
  public String toString() {
    return "Entry [number=" + number + ", other=" + other + ", type=" + type + ", str=" + str + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
  }



}

