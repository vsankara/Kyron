package com.technobrain.trips.reports.conf;

import com.technobrain.trips.reports.Configuration;

public class EMailDeliveryConfiguration extends DeliveryConfiguration {

    public static String DEFAULT_EMAIL_FROM = "defaultfrom@trips2.technobrain.co.uk";
    public static String DEFAULT_EMAIL_BODY = "Default Email Body";
    public static String DEFAULT_EMAIL_TO = "defaultto@trips2.technobrain.co.uk";
    public static String DEFAULT_EMAIL_SUBJECT = "Default Subject";

    private java.lang.String emailBCC;

    private java.lang.String emailBody;

    private java.lang.String emailCC;

    private java.lang.String emailFrom;

    private java.lang.String emailReplyTo;

    private java.lang.String emailSubject;

    private java.lang.String emailTo;

    public void setEmailBCC(String emailBCC) {
        this.emailBCC = emailBCC;
    }

    public String getEmailBCC() {
        return emailBCC;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailCC(String emailCC) {
        this.emailCC = emailCC;
    }

    public String getEmailCC() {
        return emailCC;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailReplyTo(String emailReplyTo) {
        this.emailReplyTo = emailReplyTo;
    }

    public String getEmailReplyTo() {
        return emailReplyTo;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailTo() {
        return emailTo;
    }
}
