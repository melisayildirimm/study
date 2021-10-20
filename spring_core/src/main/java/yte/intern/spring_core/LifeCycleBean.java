package yte.intern.spring_core;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleBean {

    public LifeCycleBean(){
        System.out.println("Constructor print");
    }

    @PreDestroy
    void preDestroyPrint(){
        System.out.println("Predestroy Print");
    }

    @PostConstruct
    public void postConstructorPrint(){
        System.out.println("Post Constructor print");
    }

    public void print(){
        System.out.println("Normal print");
    }

}
