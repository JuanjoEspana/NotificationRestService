package com.tck.pruebaBack.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String message;

    @Column
    private Long phone;

    @Column
    private Date created;

    @Column
    private Integer serviceId;

    @Column
    private NotificationType type;

    @Column
    private NotificationStatus status;

    public Notification(final Long phone, final String message, final Integer serviceId,
                        final NotificationType type){
        this.phone = phone;
        this.message = message;
        this.serviceId = serviceId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
