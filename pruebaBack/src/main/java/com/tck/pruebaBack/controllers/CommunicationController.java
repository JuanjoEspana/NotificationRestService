package com.tck.pruebaBack.controllers;

import com.tck.pruebaBack.entities.Notification;
import com.tck.pruebaBack.entities.NotificationStatus;
import com.tck.pruebaBack.entities.NotificationType;
import com.tck.pruebaBack.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunicationController {

    @Autowired
    CommunicationService commService;

    @RequestMapping(value="/notification/fax/{phone}", method = RequestMethod.GET)
    public String sendFax(@PathVariable("phone") long phone,
                                @RequestParam(value="serviceId") Integer serviceId,
                                @RequestParam(value="message") String message){

        return null;
    }

    @RequestMapping(value="/notification/sms/{phone}", method = RequestMethod.GET)
    public String sendSMS(@PathVariable("phone") long phone,
                                @RequestParam(value="serviceId") Integer serviceId,
                                @RequestParam(value="message") String message){

        return sendNotification(phone, serviceId, message);
    }

    private String sendNotification(@PathVariable("phone") long phone,
                                          @RequestParam(value = "serviceId") Integer serviceId,
                                          @RequestParam(value = "message") String message) {

        final String strPhone = String.valueOf(phone);

        if('6' != strPhone.charAt(0) ) {
            return "Invalid phone number. It has to be a mobile phone number.";
        }

        Notification notification = new Notification(phone, message, serviceId, NotificationType.SMS);

        try {
            notification = commService.send(notification);
            notification.setStatus(NotificationStatus.OK);
        }catch(Exception e){
            System.out.println("CommunicationController.sendSMS - Error while trying to send the notification: "
                + e.getMessage());
            e.printStackTrace();
        }

        return "Ok";
    }

}
