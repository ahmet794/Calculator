package uk.ac.rhul.cs2800;

/**
 * Basic Symbols that we use in Entry class.
 * 
 * @author ahmet
 *
 */
public enum Symbol {
  LEFT_BRACKET("{"), RIGHT_BRACKET("}"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "N/A");

  private String symbol;

  private Symbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return this.symbol;
  }

}
