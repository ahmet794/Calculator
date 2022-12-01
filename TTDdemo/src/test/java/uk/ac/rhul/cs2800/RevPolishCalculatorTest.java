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
    str = "11+";
  }

  @Test
  void testEvaluate() {
    try {
      assertEquals(postfix.evaluate(str), 2.0f,
          "Using the postfix type and adding 1 to 1 should return 2 as a float.");
    } catch (InvalidExpression e) {
      ;
    }
  }


}
