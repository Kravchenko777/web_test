package org.example.lesson4;

import org.junit.jupiter.api.*;

public class LFTest {

    static Integer myTestInt = 0;

    @BeforeAll
    static void init(){
        myTestInt++;
        System.out.println("Запускаем до всех тестов "+ myTestInt);
    }

    @BeforeEach
    void initTest(){
        myTestInt++;
        System.out.println("Запускаем для каждого теста "+myTestInt);
    }

    @AfterEach
     void afterTest(){
        myTestInt++;
        System.out.println("Запускаем после каждого теста "+myTestInt);
    }


    @AfterAll
    static void close(){
        myTestInt++;
        System.out.println("Запускаем в конце "+myTestInt);
    }

    @Test
    void test1(){
        myTestInt++;
        System.out.println("Первый тест "+myTestInt);
    }

    @Test
    void test2(){
        myTestInt++;
        System.out.println("Второй тест "+myTestInt);
    }

    @Test
    @RepeatedTest(2)
    void test3(){
        myTestInt++;
        System.out.println("Третий тест "+myTestInt);
    }

    @Nested
    @DisplayName("Группируем тесты")
    class WhenNew {

        @BeforeEach
        void groupBeforeEach() {

        }

        @Test
        @DisplayName("тест в группе")
        void isEmptyTest() {
            System.out.println("Тест в группе "+myTestInt);
        }
    }


}
