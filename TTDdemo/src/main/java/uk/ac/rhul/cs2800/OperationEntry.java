package uk.ac.rhul.cs2800;

/**
 * This class is to use Entry objects Symbol methods in a more sufficient way.
 * 
 * @author ahmet
 *
 */
public class OperationEntry implements Entry {

  private Symbol symbol;

  /**
   * This constructor creates an Entry object with a Symbol ENUM parameter.
   * 
   * @param symbol is the Symbol ENUM.
   */
  public OperationEntry(Symbol symbol) {
    this.symbol = symbol;
  }

  /**
   * This method is to return the Symbol ENUM parameter.
   * 
   * @return the Symbol ENUM.
   */
  @Override
  public Symbol getOp() {
    return symbol;
  }

  /**
   * This class should only return getOp method other types should only throw exceptions.
   * 
   * @throws BadTypeException if this method is called from this class.
   */
  @Override
  public float getNum() throws BadTypeException {
    throw new BadTypeException();
  }
}


