package pers.dzk.jdk;


import java.io.Serializable;

/**
 * 测试类实验体
 */
public class TestObject implements Serializable {
    private String name;
    private int age;

    public TestObject(){

    }

    public TestObject(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public void test(){
        System.out.println("test2");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}