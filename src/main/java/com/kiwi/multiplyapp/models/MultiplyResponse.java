package com.kiwi.multiplyapp.models;

public class MultiplyResponse extends BaseResponse {
  private String result;

  public MultiplyResponse() {
    super(true);
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}