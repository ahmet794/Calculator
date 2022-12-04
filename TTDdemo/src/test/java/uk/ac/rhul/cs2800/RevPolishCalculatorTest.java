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
          "Using the postfix type and adding 1 to 1 should return 2 as a float.");
      str = "2 6 +";
      assertEquals(postfix.evaluate(str), 8.0f,
          "Using the postfix type and adding 1 to 2 should return 3 as a float.");
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



}
