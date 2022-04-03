package org.example.lesson4.dz;

import org.example.dz.ExampleClass;
import org.example.dz.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Dz4Test {

    @Test
    void test() throws MyException {
        ExampleClass exampleClass = new ExampleClass();
        Assertions.assertEquals(30,exampleClass.someMethod(10,20));
        Assertions.assertThrows(MyException.class,()-> exampleClass.someMethod(-10,20));
    }

    @ParameterizedTest
    @CsvSource({ "10,20,30","100, 200,300","1,2,3"})
    void testWithCsvSource(int a, int b, int result) throws MyException {
        ExampleClass exampleClass = new ExampleClass();
        Assertions.assertEquals(result,exampleClass.someMethod(a,b));

    }

    @ParameterizedTest
    @CsvSource({ "-10,20","-100, 200","1,-2"})
    void testWithCsvSourceN(int a, int b) throws MyException {
        ExampleClass exampleClass = new ExampleClass();
        Assertions.assertThrows(MyException.class,()-> exampleClass.someMethod(a,b));

    }
}
