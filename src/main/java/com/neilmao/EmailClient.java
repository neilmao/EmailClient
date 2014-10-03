package com.neilmao;

import com.neilmao.bean.MailBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
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

    private String mail_properties_filename = "/credentials.properties";
    private Properties credentials;

    // init in subclass
    protected Properties props;
    protected MailBean mailBean;

    protected EmailClient() {

        mailBean = new MailBean();
        props = new Properties();
        credentials = new Properties();

        try {
            credentials.load(getClass().getResourceAsStream(mail_properties_filename));
            readCredentials();
        } catch (IOException e) {
            LOG.error("Failed to load file 'credentials.properties': " + e.toString());
        } catch (SendEmailException e) {
            LOG.warn(e.toString());
        }
    }

    private void readCredentials() throws SendEmailException {

        String username = credentials.getProperty(MailBean.USERNAME);
        String password = credentials.getProperty(MailBean.PASSWORD);

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new SendEmailException("Credentials are not set in the properties file.");
        }
        mailBean.setUsername(username);
        mailBean.setPassword(password);
    }

    public void send(MailBean bean) throws SendEmailException {
        mergeMailBeans(bean);
        initProps();
        Message message = new MimeMessage(prepareSession(props));
        try {
            message.setFrom(mailBean.getSender());
            message.setRecipients(Message.RecipientType.TO, mailBean.getReceivers());
            message.setSubject(mailBean.getSubject());
            message.setText(mailBean.getContent());

            Transport.send(message);

        } catch (MessagingException e) {
            throw new SendEmailException(e);
        }
    }

    private Session prepareSession(Properties props) {
         return Session.getDefaultInstance(props, new Authenticator() {
             @Override
             protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(mailBean.getUsername(), mailBean.getPassword());
             }
         });
    }

    private void mergeMailBeans(MailBean bean) {
        if (StringUtils.isNotBlank(bean.getUsername()))
            mailBean.setUsername(bean.getUsername());
        if (StringUtils.isNotBlank(bean.getPassword()))
            mailBean.setPassword(bean.getPassword());
        if (StringUtils.isNotBlank(bean.getSubject()))
            mailBean.setSubject(bean.getSubject());
        if (StringUtils.isNotBlank(bean.getContent()))
            mailBean.setContent(bean.getContent());
        if (StringUtils.isNotBlank(bean.getCharset()))
            mailBean.setCharset(bean.getCharset());
        if (StringUtils.isNotBlank(bean.getCharset()))
            mailBean.setCharset(bean.getCharset());
        if (bean.getSender() != null)
            mailBean.setSender(bean.getSender());
        if (bean.getReceivers() != null)
            mailBean.setReceivers(bean.getReceivers());
    }
}
