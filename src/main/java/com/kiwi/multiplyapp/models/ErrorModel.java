package com.kiwi.multiplyapp.models;

public class ErrorModel extends BaseResponse {

  private String errorMessage;

  public ErrorModel(String errorMessage) {
    super(false);
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

}