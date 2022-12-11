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

    // If the passed string is an infix expression then throw an InvalidExpression exception.
    if (isInfix(str) == true) {
      throw new InvalidExpression();
    }

    // Iterate through the String array that has been created.
    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        // If at the ith index, it is a number then parse the string to a float and push it to the
        // stack.
        value = Float.parseFloat(exp[i]);
        entry = facEntry.createEntry(value);
        val.push(entry);
      } else if (exp[i].matches("[()+-/*]")) {
        operation = exp[i];
        result = operate(operation, val, result);
      } else {
        throw new InvalidExpression();
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

  @Override
  public boolean isInfix(String exp) {
    boolean infix = false;
    String[] arr = exp.split(" ");
    for (int i = 0; i < arr.length; i++) {
      if ((i + 1) < arr.length && arr[i + 1].matches("[()+-/*]") && (i + 2) < arr.length
          && !(arr[i + 2].matches("[()+-/*]")) && (i + 1) != arr.length - 1) {
        infix = true;
        break;
      } else {
        infix = false;
      }
    }
    return infix;
  }

}
