package com.neilmao.bean;

import javax.mail.Address;

/**
 * Created with IntelliJ IDEA.
 * User: neil
 * Date: 30/09/14
 * Time: 5:02 PM
 */
public class MailBean {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    private String username;
    private String password;
    private String subject;
    private String content;
    private String charset;
    private Address sender;
    private Address[] receivers;

    public MailBean() {
        this.charset = "charset=UTF-8";
    }

    public Address[] getReceivers() {
        return receivers;
    }

    public void setReceivers(Address[] receivers) {
        this.receivers = receivers;
    }

    public Address getSender() {
        return sender;
    }

    public void setSender(Address sender) {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
