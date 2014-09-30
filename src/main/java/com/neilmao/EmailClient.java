package com.neilmao;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: neil
 * Date: 30/09/14
 * Time: 5:10 PM
 */
public abstract class EmailClient implements Mailer {

    private static Log LOG = LogFactory.getLog(EmailClient.class);

    private String mail_properties_filename = "/mail.properties";

    private Properties properties;

    protected EmailClient() {

        properties = new Properties();

        try {
            properties.load(getClass().getResourceAsStream(mail_properties_filename));
        } catch (IOException e) {
            LOG.error("Failed to load 'mail.properties' file: " + e.toString());
        }
    }

    protected Properties getProperties() {
        return properties;
    }

    protected void setMail_properties_filename(String mail_properties_filename) {
        this.mail_properties_filename = mail_properties_filename;
    }
}
