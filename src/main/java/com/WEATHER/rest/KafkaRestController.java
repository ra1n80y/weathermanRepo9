package com.WEATHER.rest;

import com.WEATHER.model.Customer;
import com.WEATHER.service.KafkaCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//API meant 2 rec data from other APIs in2 Service layer then Kafka Server
@RestController
public class KafkaRestController
{
    @Autowired
    private KafkaCustomerService service;

    @PostMapping("addOne")
    public String addCustomer(@RequestBody Customer cs)
    {
        System.out.println (cs);
        String status=service.addMsg (cs);
        System.out.println (status);
        return status;
    }

    @PostMapping("addMany")
    public String addCustomers(@RequestBody List<Customer> lcs)
    {
        return service.add (lcs);
    }
}
