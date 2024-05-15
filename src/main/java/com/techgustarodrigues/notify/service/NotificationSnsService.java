package com.techgustarodrigues.notify.service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSnsService {

    @Autowired
    private AmazonSNS amazonSNS;

    public void notify(String telephone, String message) {
        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(telephone);
        amazonSNS.publish(publishRequest);
    }
}
