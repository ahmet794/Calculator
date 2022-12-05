package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalculatorTest {
  StandardCalculator infix;
  String str;

  @BeforeEach
  void setup() {
    infix = new StandardCalculator();
    str = "1 + 2";
  }

  @Test
  void testEvaluateAddition() {
    try {
      assertEquals(infix.evaluate(str), 3.0f,
          "Using the postfix type and adding 1 to 2 should return 3 as a float.");
      str = "2 + 6";
      assertEquals(infix.evaluate(str), 8.0f,
          "Using the postfix type and adding 2 to 6 should return 8 as a float.");
    } catch (InvalidExpression e) {
      ;
    }
  }


}
