package com.kiwi.multiplyapp.models;

public class ErrorModel extends BaseResponse {

  private String errorMessage;

  public ErrorModel(String errorMessage) {
    super(false);
    this.errorMessage = errorMessage;
  }

  public ErrorModel(String errorMessage, int status) {
    super(false);
    this.errorMessage = errorMessage;
    this.setStatus(status);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

}