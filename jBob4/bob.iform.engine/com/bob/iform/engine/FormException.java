package com.bob.iform.engine;

/** all exceptions that FORM throws are FormException's 
 * (extends RuntimeException).*/
public class FormException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public FormException() {
    super();
  }
  public FormException(String msg, Throwable cause) {
    super(msg);
    super.initCause(cause);
  }
  public FormException(String msg) {
    super(msg);
  }
  public FormException(Throwable cause) {
    super();
    super.initCause(cause);
  }
}
