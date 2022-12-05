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
    float sum = 0;
    float value = 0;

    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        value = Float.parseFloat(exp[i]);
        entry = facEntry.createEntry(value);
        val.push(entry);
      } else {
        operation = exp[i];
        sum = operate(operation, val, sum);
      }
    }

    return sum;

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
  public float operate(String operation, NumStack val, float sum) throws BadTypeException {


    float rightop = val.pop();
    float leftop = val.pop();


    if (operation.equals("+")) {
      sum = leftop + rightop;
      entry = facEntry.createEntry(sum);
      val.push(entry);

    } else if (operation.equals("-")) {
      sum = leftop - rightop;
      entry = facEntry.createEntry(sum);
      val.push(entry);

    } else if (operation.equals("*")) {
      sum = leftop * rightop;
      entry = facEntry.createEntry(sum);
      val.push(entry);

    } else if (operation.equals("/")) {
      sum = leftop / rightop;
      entry = facEntry.createEntry(sum);
      val.push(entry);
    }

    return sum;
  }

}
