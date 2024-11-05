package dev.wayne.mail.util;

import java.util.Properties;

public class MailPropUtil {

    public static Properties getProp() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.mail.ru");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtps.ssl.checkserveridentity", true);
        properties.put("mail.smtps.ssl.trust", "*");
        return properties;
    }
}
