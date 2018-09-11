package com.tck.pruebaBack.dao;

import org.springframework.data.repository.CrudRepository;
import  com.tck.pruebaBack.entities.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDao extends CrudRepository<Notification, Integer> {
}
