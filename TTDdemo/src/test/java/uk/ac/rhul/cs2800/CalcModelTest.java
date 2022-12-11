package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  CalcModel calculator;
  String str;
  boolean isPostfix;

  @BeforeEach
  void setup() {
    calculator = CalcModel.getInstance();
  }

  @Test
  void testCalculatePostifx() throws InvalidExpression, BadTypeException {
    str = "3 1 +";
    isPostfix = true;
    assertEquals(calculator.calculate(str, isPostfix), 4.0f);
    str = "7 2 +";
    assertEquals(calculator.calculate(str, isPostfix), 9.0f);
  }

  @Test
  void testCalculateInfix() throws InvalidExpression, BadTypeException {
    str = "3 + 1";
    isPostfix = false;
    assertEquals(calculator.calculate(str, isPostfix), 4.0f);
  }

}
