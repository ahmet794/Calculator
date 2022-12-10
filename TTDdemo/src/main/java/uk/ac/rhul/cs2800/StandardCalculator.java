package uk.ac.rhul.cs2800;

/**
 * Evaluate standard (infix) notation expressions.
 * 
 * @author ahmet
 *
 */
public class StandardCalculator implements Calculator {
  private OpStack operatorStack;
  private Entry entry;
  private EntryFactory facEntry;
  private RevPolishCalculator postfix;

  /**
   * This constructor initialises the OpStack, RevPolishCalculator and EntryFactory objects to be
   * used inside this class.
   * 
   */
  public StandardCalculator() {
    operatorStack = new OpStack();
    facEntry = new EntryFactory();
    postfix = new RevPolishCalculator();
  }

  @Override
  public float evaluate(String str) throws InvalidExpression, BadTypeException {

    return postfix.evaluate(parsePostfix(str));

  }

  /**
   * This method will parse infix expressions to postfix. It is very similar to shunting yard
   * algorithm.
   * 
   * @param str is the expression to be parsed.
   * @return postfix expression.
   * @throws BadTypeException if the wrong type is getter is called.
   */
  // BadTypeException wont ever be called.
  public String parsePostfix(String str) throws BadTypeException {
    String[] exp = str.split(" ");
    String postfix = "";
    Symbol operator = null;
    // Create a String array and then iterate until a number is not found.
    for (int i = 0; i < exp.length; i++) {
      if (exp[i].matches("\\d+")) {
        postfix += (exp[i] + " ");
      } else {
        operator = Symbol.valueOf(parseOp(exp[i]));

        // When a left bracket is found its parsing is done in a separate way.
        if (operator == Symbol.LEFT_BRACKET) {
          while (operator != Symbol.RIGHT_BRACKET) {
            i++;
            if (!(exp[i].matches("\\d+"))) {
              operator = Symbol.valueOf(parseOp(exp[i]));

              // When the operator is not a right bracket push it in to operatorStack.
              // If it is a right bracket then pop the stack and then add it to postfix.
              if (!(operator == Symbol.RIGHT_BRACKET || operator == Symbol.LEFT_BRACKET)) {
                entry = facEntry.createEntry(operator);
                operatorStack.push(entry);
              } else if (operator == Symbol.RIGHT_BRACKET) {
                while (!(operatorStack.isEmpty())) {
                  postfix += operatorStack.pop() + " ";
                }
              }
              // If any operators are not found then add it to the postfix.
            } else {
              postfix += exp[i] + " ";
            }
          }
          // Else statement is called if the operator is not a left bracket.
        } else {
          if (!(operator == Symbol.RIGHT_BRACKET)) {
            entry = facEntry.createEntry(operator);
            operatorStack.push(entry);
          }
        }
      }
    }
    // After the for loop is done pop the stack that was created during the for long and add it to
    // postfix.
    while (!(operatorStack.isEmpty())) {
      postfix += operatorStack.pop() + " ";
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

  /**
   * This method checks if the expression is infix.
   * 
   * @param exp is the expression.
   * @return if it is an infix expression.
   */
  public boolean isInfix(String exp) {
    boolean infix = false;
    String[] arr = exp.split(" ");
    for (int i = 0; i < arr.length; i++) {
      if ((i + 1) < arr.length && arr[i + 1].matches("[()+-/*]") && (i + 1) != arr.length - 1) {
        infix = true;
        break;
      } else {
        infix = false;
      }
    }
    return infix;
  }

}
