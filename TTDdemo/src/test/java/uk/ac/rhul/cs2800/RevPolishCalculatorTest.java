package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalculatorTest {

  RevPolishCalculator postfix;
  String str;

  @BeforeEach
  void setup() {
    postfix = new RevPolishCalculator();
    str = "1 2 +";
  }

  // Testing the evaluate method for addition using the postfix type.
  @Test
  void testEvaluateAddition() {
    try {
      assertEquals(postfix.evaluate(str), 3.0f,
          "Using the postfix type and adding 1 to 2 should return 3 as a float.");
      str = "2 6 +";
      assertEquals(postfix.evaluate(str), 8.0f,
          "Using the postfix type and adding 2 to 6 should return 8 as a float.");
      str = "1 3 +";
      assertEquals(postfix.evaluate(str), 4.0f,
          "Using the postfix type and adding 1 to 3 should return 4 as a float.");
      str = "2 4 +";
      assertEquals(postfix.evaluate(str), 6.0f,
          "Using the postfix type and adding 2 to 4 should return 6 as a float.");

    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing the evaluate method for subtracting using the postfix type.
  @Test
  void testEvaluateSubtraction() {
    try {
      str = "6 1 -";
      assertEquals(postfix.evaluate(str), 5.0f,
          "Using the postfix type and subtracting 1 from 6 should return 5 as a float.");
      str = "4 2 -";
      assertEquals(postfix.evaluate(str), 2.0f,
          "Using the postfix type and subtracting 2 from 4 should return 2 as a float.");

    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing the evaluate method for multiplying using the postfix type.
  @Test
  void testEvaluateMultiplication() {
    try {
      str = "1 1 *";
      assertEquals(postfix.evaluate(str), 1.0f, "Multiplying 1 by 1 should return 1 as a float.");
      str = "2 7 *";
      assertEquals(postfix.evaluate(str), 14.0f, "Multiplying 2 by 7 should return 14 as a float.");
      str = "12 4 *";
      assertEquals(postfix.evaluate(str), 48.0f,
          "Multiplying 3 by 12 should return 36 as a float.");
    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing the evaluate method for division using the postfix type.
  @Test
  void testEvaluateDivision() {
    try {
      str = "4 2 /";
      assertEquals(postfix.evaluate(str), 2.0f, "Dividing 4 by 2 should return 2 as a float.");
      str = "12 3 /";
      assertEquals(postfix.evaluate(str), 4.0f, "Dividing 12 by 3 should return 4 as a float.");
    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing if the method works with two or more operators.
  @Test
  void testEvaluateTwoOp() {
    try {
      str = "4 2 1 + +";
      assertEquals(postfix.evaluate(str), 7.0f,
          "Adding 2 to 1 and then adding 4 should return 7 as a float.");
      str = "5 1 2 + *";
      assertEquals(postfix.evaluate(str), 15.0f,
          "Adding 1 to 2 and multiplying by 5 should return 15 as a float.");
      str = "12 2 4 6 + * *";
      assertEquals(postfix.evaluate(str), 240.0f,
          "Adding 6 to 4 and multiplying by 2 and then multiplying by 12 should return 240 as a float.");
      str = "5 4 3 2 1 + + * *";
      assertEquals(postfix.evaluate(str), 120.0f,
          "Adding 1 to 2 and then adding 3 then multiplying by 4 and 5 should return 120 as a float.");
    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing the evaluate method in more complex ways.
  @Test
  void testEvaluateFully() throws InvalidExpression, BadTypeException {
    str = "2 6 7 + -";
    try {
      assertEquals(postfix.evaluate(str), -11.0f,
          "Adding 6 to 7 then removing 2 should give 13 as a float.");
      str = "6 7 + 2 -";
      assertEquals(postfix.evaluate(str), 11.0f,
          "Adding 6 to 7 then removing 2 should give 13 as a float.");
      str = "5 6 7 * + 2 -";
      assertEquals(postfix.evaluate(str), 45.0f,
          "Adding 6 to 7 then removing 2 should give 13 as a float.");
      str = "5 6 7 + * 2 -";
      assertEquals(postfix.evaluate(str), 63.0f,
          "Adding 6 to 7 then removing 2 should give 13 as a float.");
      str = "5 6 7 + * 5 /";
      assertEquals(postfix.evaluate(str), 13.0f,
          "Adding 6 to 7 then removing 2 should give 13 as a float.");
      str = "1 3 + 4 *";
      assertEquals(postfix.evaluate(str), 16.0f);
    } catch (InvalidExpression | BadTypeException e) {
      ;
    }
  }

  // Testing the invalid expression exception is thrown in certain cases.
  @Test
  void testInvalidExpression() {
    str = "1 f 3";
    assertThrows(InvalidExpression.class, () -> postfix.evaluate(str),
        "An invalid exp should throw an exception");
    str = "1 + 3";
    assertThrows(InvalidExpression.class, () -> postfix.evaluate(str),
        "An infix expression should throw an exception.");
  }

  // Test if the expression given is unbalanced or not.
  @Test
  void testisUnbalanced() {
    str = "1 3 + +";
    assertEquals(postfix.isUnbalanced(str), true, "This is an unbalanced expression.");
    str = "1 3 +";
    assertEquals(postfix.isUnbalanced(str), false, "This is not an unbalanced expression.");
    str = "1 3 4 + - * /";
    assertEquals(postfix.isUnbalanced(str), true, "This is an unbalanced expression");
  }


}
