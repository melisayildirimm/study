package yte.intern.spring_core;

import org.springframework.stereotype.Component;

@Component
class FieldInjectionBean{

    public void print(){
        System.out.println("Ben bir field injection beaniyim");
    }
}