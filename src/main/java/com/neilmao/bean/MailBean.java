package com.neilmao.bean;

/**
 * Created with IntelliJ IDEA.
 * User: neil
 * Date: 30/09/14
 * Time: 5:02 PM
 */
public class MailBean {

    private String title;
    private String content;
    private String charset;
    private String sender;
    private String receiver;
    private int port;
    private boolean authenticationRequired;

    public MailBean() {
        this.authenticationRequired = false;
        this.port = 25;
        this.charset = "charset=UTF-8";
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

    public void setAuthenticationRequired(boolean authenticationRequired) {
        this.authenticationRequired = authenticationRequired;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
