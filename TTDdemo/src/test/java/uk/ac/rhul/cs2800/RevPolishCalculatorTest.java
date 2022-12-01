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

  // Testing the evaluate method for the postfix type of evaluation.
  @Test
  void testEvaluate() {
    try {
      assertEquals(postfix.evaluate(str), 2.0f,
          "Using the postfix type and adding 1 to 1 should return 2 as a float.");
      String val = "1 2 +";
      assertEquals(postfix.evaluate(val), 3.0f,
          "Using the postfix type and adding 1 to 2 should return 3 as a float.");
    } catch (InvalidExpression e) {
      ;
    }
  }


}
