package uk.ac.rhul.cs2800;

/**
 * This class uses Reverse Polish (postfix) notation to evaluate expressions.
 * 
 * @author ahmet
 *
 */
public class RevPolishCalculator implements Calculator {
  private NumStack val;
  private Entry entry;
  private EntryFactory facEntry;

  /**
   * Create a NumStack object and a EntryFactory to create entries.
   * 
   */
  public RevPolishCalculator() {
    val = new NumStack();
    facEntry = new EntryFactory();
  }

  @Override
  public float evaluate(String str) throws InvalidExpression, BadTypeException {
    String[] exp = str.split(" ");
    String operation = "";
    float result = 0;
    float value = 0;

    // Iterate through the String array that has been created.
    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        // If at the ith index, it is a number then parse the string to a float and push it to the
        // stack.
        value = Float.parseFloat(exp[i]);
        entry = facEntry.createEntry(value);
        val.push(entry);
      } else {
        operation = exp[i];
        result = operate(operation, val, result);
      }
    }

    return result;

  }

  /**
   * This method will first assign the right operator of the expression and then the left operator
   * by popping the stack. Then it will choose which operation to use and then push it back to the
   * stack.
   * 
   * @return the sum
   * @throws BadTypeException if the wrong type is getter is called.
   */
  // BadTypeException wont ever be called.
  public float operate(String operation, NumStack val, float result) throws BadTypeException {


    float rightop = val.pop();
    float leftop = val.pop();


    if (operation.equals("+")) {
      result = leftop + rightop;
      entry = facEntry.createEntry(result);
      val.push(entry);

    } else if (operation.equals("-")) {
      result = leftop - rightop;
      entry = facEntry.createEntry(result);
      val.push(entry);

    } else if (operation.equals("*")) {
      result = leftop * rightop;
      entry = facEntry.createEntry(result);
      val.push(entry);

    } else if (operation.equals("/")) {
      result = leftop / rightop;
      entry = facEntry.createEntry(result);
      val.push(entry);
    }

    return result;
  }

}
