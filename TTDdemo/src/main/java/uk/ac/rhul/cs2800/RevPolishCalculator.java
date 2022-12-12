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
    if (isInfix(str) == true || isUnbalanced(str) == true) {
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

    // Create an array by splitting by the whitespace and then iterate.
    for (int i = 0; i < arr.length; i++) {

      // Check if the last element of the array is an operator.
      if (arr[arr.length - 1].matches("[+-/*]")) {
        infix = false;
        break;

        // Check if there are two consecutive operators and it is not only one element.
      } else if ((i + 1) < arr.length && arr[i + 1].matches("[()+-/*]") && (i + 2) < arr.length
          && !(arr[i + 2].matches("[()+-/*]")) && (i + 1) != arr.length - 1) {
        infix = true;
        break;
      } else {
        infix = false;
      }
    }
    return infix;
  }

  /**
   * This method checks if the expression is unbalanced or not.
   * 
   * @return if the expression is unbalanced.
   */
  public boolean isUnbalanced(String str) {
    String[] arr = str.split(" ");
    int countOp = 0;
    int countNum = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i].matches("\\d+")) {
        countNum++;
      } else if (arr[i].matches("[()*/+-]")) {
        countOp++;
      }
    }

    if (countNum == countOp + 1) {
      return false;
    } else {
      return true;
    }
  }
}
