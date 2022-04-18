package org.example;

public class TestClass {

    private static TestClass testClass;

    private TestClass(){
        //todo логика создания
    }

    public static TestClass getTestClass(){

        if(testClass==null) testClass = new TestClass();

        return testClass;
    }
}
