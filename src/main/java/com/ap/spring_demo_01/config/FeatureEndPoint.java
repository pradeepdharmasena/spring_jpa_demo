package com.ap.spring_demo_01.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "fe")
public class FeatureEndPoint {
    private final Map<String, Feature> list = new ConcurrentHashMap<>();

    public  FeatureEndPoint(){
        list.put("Department save", new Feature(true));
        list.put("Department delete", new Feature(true));
        list.put("Department fetch by id", new Feature(true));
        list.put("Department fetch by name", new Feature(true));

    }

    @ReadOperation
    public  Map<String, Feature> features(){
        return list;
    }

    @ReadOperation
    public Feature  feature(@Selector String feature){
        return list.get(feature);
    }
}

