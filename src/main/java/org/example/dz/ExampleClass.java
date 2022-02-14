package org.example.dz;

//Аналог задачи по вычислению площади треугольника
public class ExampleClass {

    public int someMethod(int a, int b) throws MyException {
        if(a<0 || b<0) throw new MyException("Текст моей ошибки");
        int result = a+b;
        return result;
    }


}
