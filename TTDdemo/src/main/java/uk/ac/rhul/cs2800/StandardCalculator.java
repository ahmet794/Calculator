package uk.ac.rhul.cs2800;

/**
 * Evaluate standard (infix) notation expressions.
 * 
 * @author ahmet
 *
 */
public class StandardCalculator implements Calculator {
  private OpStack operationStack;
  private Entry entry;
  private EntryFactory facEntry;
  private RevPolishCalculator postfix;

  /**
   * This constructor initialises the OpStack, StrStack and EntryFactory objects to be used inside
   * this class.
   * 
   */
  public StandardCalculator() {
    operationStack = new OpStack();
    facEntry = new EntryFactory();
    postfix = new RevPolishCalculator();
  }

  @Override
  public float evaluate(String str) throws InvalidExpression, BadTypeException {

    return postfix.evaluate(parsePostfix(str));

  }

  /**
   * This method will parse infix expressions to postfix.
   * 
   * @param str is the expression to be parsed.
   * @return postfix expression.
   * @throws BadTypeException if the wrong type is getter is called.
   */
  // BadTypeException wont ever be called.
  public String parsePostfix(String str) throws BadTypeException {
    String[] exp = str.split(" ");
    String postfix = "";
    Symbol operation = null;
    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        postfix += (exp[i] + " ");
      } else {
        operation = Symbol.valueOf(parseOp(exp[i]));
        if (operation == Symbol.LEFT_BRACKET) {
          while (operation != Symbol.RIGHT_BRACKET) {
            i++;
            postfix += (exp[i] + " ");
            if (!(exp[i].matches("\\d+"))) {
              operation = Symbol.valueOf(parseOp(exp[i]));
            }
          }
          postfix = parsePostfix(postfix) + " ";
        } else {
          if (!(operation == Symbol.RIGHT_BRACKET)) {
            entry = facEntry.createEntry(operation);
            operationStack.push(entry);
          }
        }
      }
    }
    while (!(operationStack.isEmpty())) {
      if (operationStack.size() == 1) {
        postfix += operationStack.pop().toString();
      } else {
        postfix += operationStack.pop().toString() + " ";
      }
    }
    return postfix;
  }

  /**
   * This method should convert an operator sign to its string value.
   * 
   * @param operator is the sign.
   * @return the string value.
   */
  public String parseOp(String operator) {
    if (operator.equals("+")) {
      operator = "PLUS";

    } else if (operator.equals("-")) {
      operator = "MINUS";

    } else if (operator.equals("*")) {
      operator = "TIMES";

    } else if (operator.equals("/")) {
      operator = "DIVIDE";

    } else if (operator.equals("(")) {
      operator = "LEFT_BRACKET";

    } else if (operator.equals(")")) {
      operator = "RIGHT_BRACKET";
    }

    return operator;
  }

}
