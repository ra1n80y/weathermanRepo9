package com.WEATHER.config;

import java.util.HashMap;
import java.util.Map;
import com.WEATHER.model.Customer;
import com.WEATHER.util.AppConstants;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

//Class' purpose is to configure publishing of this app's data 2 Kafka Server in JSON format
@Configuration
public class KafkaPubConfig
{
    @Bean
    public ProducerFactory<String, Customer> producerFactory()
    {
        Map<String, Object> configProps = new HashMap<> ();

        //Server location
        configProps.put (ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST_URL);

        //Key(String/Topic name)
        configProps.put (ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        //Value(Entity/JSON data)
        configProps.put (ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<> (configProps);
    }

    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String,Customer>kafkaTemplate()
    {
        //Formats data B4 publishing
        return new KafkaTemplate<> (producerFactory ());
    }
}
