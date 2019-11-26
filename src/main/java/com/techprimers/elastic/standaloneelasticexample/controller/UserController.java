package com.techprimers.elastic.standaloneelasticexample.controller;

import com.techprimers.elastic.standaloneelasticexample.constants.Constants;
import com.techprimers.elastic.standaloneelasticexample.domain.User;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TransportClient client;

    @GetMapping("/get/{id}")
    public Map<String, Object> getUser(@PathVariable final String id) {
        GetResponse response = client.prepareGet(Constants.EMPLOYEE, Constants.ID, id).get();
        return response.getSource();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        IndexResponse response = null;
        try {
            response = client.prepareIndex(Constants.EMPLOYEE, Constants.ID, user.getId())
                    .setSource(jsonBuilder()
                            .field("name", user.getName())
                            .field("userSettings", user.getUserSettings())
                            .endObject())
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null ? response.getResult().toString() : "ERROR";
    }
}
