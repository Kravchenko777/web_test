package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssertAssumTest {

    Boolean myBoolean = true;
    Integer myInteger = 100;
    String myString = "str";

    @Test
    void notAtEST(){
        System.out.println("Это не тест");
    }

    @Test
    void test(){
        assertTrue(myBoolean, "Не true");
        assertFalse(!myBoolean, "Не False");
        assertEquals(100,myInteger.intValue(), "Не 100");
        assertEquals("str", myString, "Другое значение переменно myString");
        Assertions.assertSame(myString, myString);
        Assertions.assertNotNull(myInteger);

    }

    @Test
    void testNotGo(){
        assertFalse(myBoolean, "Не False");
        assertEquals("str1", myString, "Другое значение переменно myString");

    }

    @Test
    void exec() throws InterruptedException {
        Assertions.assertTimeout(ofMillis(10), () -> {
            Thread.sleep(200);
            return "result";
        });

/*        Assertions.assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Thread.sleep(200);
            return "result";
        });*/
    }

    @Test
    void testException(){
        Assertions.assertThrows(NullPointerException.class, ()-> getException(), "нет исключения");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("One");
        });
    }

    private String getException() throws NullPointerException{
        if(myBoolean) throw new NullPointerException();
        return "result";
    }

    @Test
    void allways(){
        Assertions.fail("Я так хочу");
    }

    @Test
    void assume(){
        assumeTrue(5 > 10);
        assertEquals(5 + 2, 7);

    }

    @Test
    void getAll(){

        Assertions.assertAll(
                () -> assertTrue(!myBoolean),
                () -> assertFalse(!myBoolean)
        );
    }
}
