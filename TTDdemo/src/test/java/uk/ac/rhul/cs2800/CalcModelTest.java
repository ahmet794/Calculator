package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  CalcModel calculator;
  String str;

  @BeforeEach
  void setup() {
    calculator = CalcModel.getInstance();
  }

  @Test
  void testCalculate() throws InvalidExpression, BadTypeException {
    str = "3 1 +";
    assertEquals(calculator.calculate(str), 4.0f);
  }

}
