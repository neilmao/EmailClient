package com.neilmao;

/**
 * Created with IntelliJ IDEA.
 * User: neil
 * Date: 3/10/14
 * Time: 2:51 PM
 */
public class SendEmailException extends Throwable {

    public SendEmailException() {
    }

    public SendEmailException(String message) {
        super(message);
    }

    public SendEmailException(Exception e) {
        super(e);
    }
}
