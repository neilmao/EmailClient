package com.neilmao;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: neil
 * Date: 30/09/14
 * Time: 4:55 PM
 */
public class GmailClient extends EmailClient {

    private static final Log LOG = LogFactory.getLog(GmailClient.class);

    @Override
    public void initProps() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }
}
