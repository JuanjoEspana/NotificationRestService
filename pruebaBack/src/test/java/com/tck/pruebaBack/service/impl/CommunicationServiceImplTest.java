package com.tck.pruebaBack.service.impl;

import com.tck.pruebaBack.PruebaBackApplication;
import com.tck.pruebaBack.dao.NotificationDao;
import com.tck.pruebaBack.entities.NotificationStatus;
import com.tck.pruebaBack.entities.NotificationType;
import com.tck.pruebaBack.service.CommunicationService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tck.pruebaBack.entities.Notification;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = PruebaBackApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommunicationServiceImplTest {

    @Autowired
    CommunicationService service;

    @Mock
    NotificationDao dao;

    Notification notification;
    Notification result;

    @Before
    public void setUp(){
        notification = new Notification(61223344L,"Unit test", 1, NotificationType.SMS);
        result = new Notification(61223344L,"Unit test", 1, NotificationType.SMS);
        result.setId(1);
        result.setStatus(NotificationStatus.OK);
    }
    @Test
    public void testSend(){
        Mockito.when(dao.save(Mockito.any(Notification.class))).thenReturn(result);
        Whitebox.setInternalState(service, "dao", dao);

        final Notification testResult = service.send(notification);

        Assert.assertNotNull(testResult);
        Assert.assertEquals(testResult.getId() , result.getId());
    }
}
