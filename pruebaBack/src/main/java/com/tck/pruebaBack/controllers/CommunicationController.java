package com.tck.pruebaBack.controllers;

import com.tck.pruebaBack.entities.Notification;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunicationController {

    @RequestMapping(value="/notification/fax/{number}", method = RequestMethod.POST)
    public Notification sendFax(@PathVariable("number") long number,
                                @RequestParam(value="serviceId") String serviceId,
                                @RequestParam(value="message") String message){

        return null;
    }

    @RequestMapping(value="/notification/sms/{number}", method = RequestMethod.POST)
    public Notification sendSMS(@PathVariable("number") long number,
                                @RequestParam(value="serviceId") String serviceId,
                                @RequestParam(value="message") String message){
        return null;
    }

}
