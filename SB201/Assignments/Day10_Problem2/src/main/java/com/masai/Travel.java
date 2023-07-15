package com.masai;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {
    private Car car;
    private Bike bike;

    @Autowired
    public Travel(Car car, Bike bike) {
        this.car = car;
        this.bike = bike;
    }

    @PostConstruct
    public void init() {
        System.out.println("Travel object created.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Travel object destroyed.");
    }

    public void startJourney() {
        car.drive();
        bike.ride();
    }
}
