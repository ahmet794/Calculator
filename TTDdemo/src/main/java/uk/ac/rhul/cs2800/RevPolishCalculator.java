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
    float sum = 0;
    float value = 0;
    String operation = "";

    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        value = Float.parseFloat(exp[i]);
        entry = facEntry.createEntry(value);
        val.push(entry);
      } else {
        operation = exp[i];
      }
    }

    if (operation.equals("+")) {
      sum = val.pop() + val.pop();
    } else if (operation.equals("-")) {
      sum = -val.pop() + val.pop();
    } else if (operation.equals("*")) {
      sum = val.pop() * val.pop();
    } else if (operation.equals("/")) {
      float valtwo = val.pop();
      float valone = val.pop();
      sum = valone / valtwo;
    }


    return sum;
  }

}
