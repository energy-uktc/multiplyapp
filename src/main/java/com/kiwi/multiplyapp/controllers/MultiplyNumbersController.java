package com.kiwi.multiplyapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiwi.multiplyapp.models.ErrorModel;
import com.kiwi.multiplyapp.models.MultiplyResponse;

@RestController
public class MultiplyNumbersController {

  @RequestMapping("/multiply")
  public MultiplyResponse index(@RequestParam(value = "operand1", defaultValue = "0") String operand1,
      @RequestParam(value = "operand2", defaultValue = "0") String operand2) {

    MultiplyResponse response = new MultiplyResponse();
    String sign = "";
    String result = "";
    operand1 = operand1.trim();
    operand2 = operand2.trim();

    if (operand1.length() == 0 || operand2.length() == 0) {
      response.setResult("0");
      return response;
    }
    if (operand1.charAt(0) == '-' ^ operand2.charAt(0) == '-') {
      sign = "-";
    }

    operand1 = operand1.replaceAll("^[-+]+", "");
    operand2 = operand2.replaceAll("^[-+]+", "");

    int[] resultArr = new int[operand1.length() + operand2.length()];

    for (int i = operand1.length() - 1; i >= 0; i--) {
      int carry = 0;
      int idx = 0;
      int n1 = Integer.parseInt(Character.toString(operand1.charAt(i)));

      for (int j = operand2.length() - 1; j >= 0; j--) {
        int n2 = Integer.parseInt(Character.toString(operand2.charAt(j)));
        idx = (operand1.length() + operand2.length()) - (i + j) - 2;

        int res = n1 * n2 + carry + resultArr[idx];
        carry = res / 10;
        resultArr[idx] = res % 10;
      }
      if (carry > 0) {
        resultArr[idx + 1] = carry;
      }
    }

    for (int i = resultArr.length - 1; i >= 0; i--) {
      result += resultArr[i];
    }

    result = result.replaceAll("^0+", "").trim();
    if (result.isEmpty()) {
      response.setResult("0");
      return response;
    }

    response.setResult(sign + result);
    return response;
  }

  @ExceptionHandler(value = NumberFormatException.class)
  public ResponseEntity<ErrorModel> exception(NumberFormatException exception) {
    return new ResponseEntity<ErrorModel>(
        new ErrorModel("Illegal format....Please specify correct number values for operand1 and operand2 parameters."),
        HttpStatus.BAD_REQUEST);
  }
}