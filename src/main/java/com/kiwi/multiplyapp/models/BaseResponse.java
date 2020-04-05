package com.kiwi.multiplyapp.models;

public class BaseResponse {
  private boolean success;

  public BaseResponse(boolean success) {
    this.success = success;
  }

  /**
   * @return boolean return the success
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @param success the success to set
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

}