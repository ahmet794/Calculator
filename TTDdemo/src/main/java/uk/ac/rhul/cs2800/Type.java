package uk.ac.rhul.cs2800;

/**
 * Types that we use in Entry class.
 * 
 * @author ahmet
 *
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbol"), STRING("String"), INVALID("N/A");
  
  private String type;
  
  private Type(String type) {
    this.type = type;
  }
  
  @Override
  public String toString() {
    return this.type;
  }
  
}
