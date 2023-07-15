package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Travel travel1 = context.getBean(Travel.class);
        travel1.startJourney();
        ((AnnotationConfigApplicationContext) context).close();

        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Travel travel2 = context2.getBean(Travel.class);
        travel2.startJourney();
        ((AnnotationConfigApplicationContext) context2).close();
    }
}
