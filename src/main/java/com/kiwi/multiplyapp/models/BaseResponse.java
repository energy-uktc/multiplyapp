package com.kiwi.multiplyapp.models;

public class BaseResponse {
  private boolean success;
  private int status;

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

  /**
   * @return int return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(int status) {
    this.status = status;
  }

}