package com.application.architecture.services;

import com.application.architecture.repositories.GreetingRepository;
import com.application.architecture.models.Greeting;
import com.application.architecture.models.MyUser;
import com.application.architecture.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "hello %s!";
    private final AtomicLong greetingId = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private UserRepository userRepository;

    public GreetingService() {
    }

    @Override
    public Greeting addGreeting(MyUser myUser) {
        String message = String.format(template, myUser.toString());
        Greeting newGreeting = new Greeting(greetingId.incrementAndGet(), message);
        myUser.setUserId(greetingId.get());
        userRepository.save(myUser);
        greetingRepository.save(newGreeting);
        return newGreeting;
    }

    @Override
    public Greeting getMessageById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> listAllGreetingMessages() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editGreetingMessage(long id, String messageToBeUpdated) {
        Greeting greeting = greetingRepository.findById(id).get();
        if (greeting != null) {
            greeting.setMessage(messageToBeUpdated);
            greetingRepository.save(greeting);
            return greeting;
        }
        return null;
    }

    @Override
    public Greeting deleteGreetingMessage(long id) {
        greetingRepository.deleteById(id);
        return null;
    }
}

