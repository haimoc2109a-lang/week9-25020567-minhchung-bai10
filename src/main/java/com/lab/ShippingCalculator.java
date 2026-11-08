package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Calculates shipping fees for two service types. */
public class ShippingCalculator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ShippingCalculator.class);

  /** Calculates the fee based on package weight and shipping type. */
  public double calculate(double weight, String type) {
    if (weight <= 0) {
      throw new IllegalArgumentException("Weight must be positive");
    }
    double fee;
    if ("EXPRESS".equals(type)) {
      fee = weight * 5000 + 20000;
    } else if ("STANDARD".equals(type)) {
      fee = weight * 3000;
    } else {
      throw new IllegalArgumentException("Unknown type: " + type);
    }
    LOGGER.info("Shipping calculated: type={}, weight={}, fee={}", type, weight, fee);
    return fee;
  }
}
