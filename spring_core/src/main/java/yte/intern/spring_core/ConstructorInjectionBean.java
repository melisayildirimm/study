package yte.intern.spring_core;

import org.springframework.stereotype.Component;

@Component
class ConstructorInjectionBean{

    public void print(){
        System.out.println("Ben bir constructor injection beaniyim");
    }
}