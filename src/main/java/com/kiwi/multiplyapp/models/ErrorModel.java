package com.kiwi.multiplyapp.models;

public class ErrorModel {

  private String errorMessage;

  public ErrorModel(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

}