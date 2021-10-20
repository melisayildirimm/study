package yte.intern.spring_web;



public class Student {
    private String name;
    private Integer age;
    private String email;

    public Student(String name, Integer age, String email) {
        System.out.println("Constructora girildi");
        this.name = name;
        this.age = age;
        this.email = email;

        System.out.println("Constructordan çıkıldı");
    }

    public String getName() {
        System.out.println("Gettername e girildi");
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
