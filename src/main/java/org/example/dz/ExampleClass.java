package org.example.dz;

//Аналог задачи по вычислению площади треугольника
public class ExampleClass {

    public int someMethod(int a, int b) throws MyException {
        if(testValue(a,b)) throw new MyException("Текст моей ошибки");
        int result = a+b;
        return result;
    }

    private boolean testValue(int a, int b){

        return a<0 || b<0;
    }


}
