package com.application.architecture.services;

import com.application.architecture.models.Greeting;
import com.application.architecture.models.MyUser;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(MyUser myUser);
    Greeting getMessageById(long id);
    List<Greeting> listAllGreetingMessages();
    Greeting editGreetingMessage(long id,String messageToBeUpdated);
    Greeting deleteGreetingMessage(long deleteById);
}
