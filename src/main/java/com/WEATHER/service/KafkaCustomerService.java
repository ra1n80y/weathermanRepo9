package com.WEATHER.service;

import com.WEATHER.model.Customer;
import com.WEATHER.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

//Class utilizing KafkaPubConfig's logic
@Service
public class KafkaCustomerService
{
    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    //Publish one
    public String addMsg(Customer cs)
    {
        kafkaTemplate.send (AppConstants.TOPIC_NAME,cs);
        return "Entity published to Server";
    }

    //Publish many
    public String add(List<Customer>customers)
    {
        if(!customers.isEmpty ())
        {
            for (Customer c:customers)
            {
               kafkaTemplate.send (AppConstants.TOPIC_NAME,c);
               System.out.println ("*DATA PUBLISHED*");
            }
        }
        return "Entities published to Server";
    }
}
