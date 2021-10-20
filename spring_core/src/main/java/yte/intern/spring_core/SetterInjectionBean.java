package yte.intern.spring_core;

import org.springframework.stereotype.Component;

@Component
class SetterInjectionBean{

    public void print() {
        System.out.println("Ben bir setter injection beaniyim");
    }
}