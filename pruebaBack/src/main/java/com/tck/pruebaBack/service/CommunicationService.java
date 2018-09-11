package com.tck.pruebaBack.service;

import com.tck.pruebaBack.entities.Notification;

public interface CommunicationService {

    public Notification send (final Notification notification);

    public Notification save (final Notification notification);


}
