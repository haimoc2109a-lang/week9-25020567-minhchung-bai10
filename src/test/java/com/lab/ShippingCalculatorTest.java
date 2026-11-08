package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ShippingCalculatorTest {
  private final ShippingCalculator calculator = new ShippingCalculator();

  @Test
  void standardShipping() {
    assertEquals(16000.0, calculator.calculate(5, "STANDARD"));
  }

  @Test
  void expressShipping() {
    assertEquals(45000.0, calculator.calculate(5, "EXPRESS"));
  }

  @Test
  void rejectsNonPositiveWeight() {
    assertThrows(IllegalArgumentException.class,
        () -> calculator.calculate(-1, "STANDARD"));
  }

  @Test
  void rejectsUnknownType() {
    assertThrows(IllegalArgumentException.class,
        () -> calculator.calculate(1, "OTHER"));
  }
}
