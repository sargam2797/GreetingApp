package com.application.architecture.controllers;

import com.application.architecture.models.Greeting;
import com.application.architecture.models.MyUser;
import com.application.architecture.services.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;
    @Autowired
    private MyUser myUser;

    @RequestMapping("/greetingService")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        myUser.setName(name);
        return greetingService.addGreeting(myUser);
    }

    @RequestMapping(value = "/greetingService/id")
    public Greeting getId(@PathVariable long id) {
        return greetingService.getMessageById(id);
    }

    @RequestMapping(value = "/greetingService/AllId")
    public List<Greeting> getAllId() {
        return greetingService.listAllGreetingMessages();
    }

    @RequestMapping(value = "greetingService/edit", method = RequestMethod.PUT)
    public Greeting editId(@RequestParam(value = "id")  long findById, @RequestParam(value = "replaceWith") String replacedMessage) {
        return greetingService.editGreetingMessage(findById,replacedMessage);
    }

    @RequestMapping(value = "greetingService/delete")
    public Greeting deleteId(@RequestParam (value = "id") long deletById) {
        return greetingService.deleteGreetingMessage(deletById);
    }

}
