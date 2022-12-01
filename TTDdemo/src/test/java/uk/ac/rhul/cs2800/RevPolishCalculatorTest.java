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
    str = "1 1 +";
  }

  // Testing the evaluate method for addition using the postfix type.
  @Test
  void testEvaluate() throws BadTypeException {
    try {
      assertEquals(postfix.evaluate(str), 2.0f,
          "Using the postfix type and adding 1 to 1 should return 2 as a float.");
      str = "1 2 +";
      assertEquals(postfix.evaluate(str), 3.0f,
          "Using the postfix type and adding 1 to 2 should return 3 as a float.");
      str = "1 3 +";
      assertEquals(postfix.evaluate(str), 4.0f,
          "Using the postfix type and adding 1 to 3 should return 4 as a float.");
      str = "2 4 +";
      assertEquals(postfix.evaluate(str), 6.0f,
          "Using the postfix type and adding 2 to 4 should return 6 as a float.");

    } catch (InvalidExpression e) {
      ;
    }
  }

  // Testing the evaluate method for subtracting using the postfix type.
  @Test
  void testEvaluateSubtraction() throws BadTypeException {
    try {
      str = "6 1 -";
      assertEquals(postfix.evaluate(str), 5.0f,
          "Using the postfix type and subtracting 1 from 6 should return 5 as a float.");
      str = "4 2 -";
      assertEquals(postfix.evaluate(str), 2.0f,
          "Using the postfix type and subtracting 2 from 4 should return 2 as a float.");

    } catch (InvalidExpression e) {
      ;
    }
  }

  @Test
  void testEvaluateMultiplication() throws BadTypeException {
    str = "1 1 *";
    try {
      assertEquals(postfix.evaluate(str), 1.0f, "Multiplying 1 by 1 should return 1 as a float.");
    } catch (InvalidExpression e) {
      ;
    }
  }



}
