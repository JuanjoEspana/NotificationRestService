package com.tck.pruebaBack.service.impl;

import com.tck.pruebaBack.beans.NotificationRestResult;
import com.tck.pruebaBack.dao.NotificationDao;
import com.tck.pruebaBack.entities.Notification;
import com.tck.pruebaBack.entities.NotificationStatus;
import com.tck.pruebaBack.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    private static final String VENDOR_REST_SERVICE = "http://localhost:9100/tck/";

    @Autowired
    NotificationDao dao;
    @Override
    public Notification send(Notification notification) {
        RestTemplate restTemplate = new RestTemplate();
        // sms?phone=611122333&message=Test
        final StringBuffer url = new StringBuffer(VENDOR_REST_SERVICE);
        url.append(notification.getType().name().toLowerCase())
                .append('?')
                .append("phone=")
                .append(notification.getPhone())
                .append('&')
                .append("message=")
                .append(notification.getMessage());
        try {
            NotificationRestResult result = restTemplate.getForObject(url.toString(), NotificationRestResult.class);

            if ("ok".equals(result.getStatus())) {
                notification.setStatus(NotificationStatus.OK);
            }
        } catch(Exception e) {
            notification.setStatus(NotificationStatus.KO);
        }

        return save(notification);
    }

    @Override
    public Notification save(Notification notification) {
        final Notification result = dao.save(notification);

        return result;
    }
}
