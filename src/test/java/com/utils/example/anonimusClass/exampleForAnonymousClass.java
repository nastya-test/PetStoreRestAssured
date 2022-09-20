package com.utils.example.anonimusClass;

public class exampleForAnonymousClass {
    //У анонимного класса есть доступ к переменным внешнего класса, в том числе к статическим и приватным
    private static int count = 23;

    public static void main(String[] args) {
        //Создается безымянный Java-класс, реализующий интерфейс
        //реализуем все методы интерфейса
        //Мы одновременно объявляем класс (посредством фигурных скобок) и создаем его объект с помощью ();
        //анонимный класс не может содержать статические переменные и методы.
        //с помощью внутреннего анонимного класса мы «на лету» переопределили его метод click()
        //и задали нужное нам действие. Никаких дочерних классов создавать не потребовалось.
        var BtnClick1 = new BtnClick() {
            @Override
            public void click() {
                System.out.println("Первый");
            }

            public int getCount() {
                System.out.println(count);
                return count;
            }
        };

        //Лямбда
        BtnClick BtnClick2 = () -> System.out.println("Второй");

        BtnClick BtnClick3 = new BtnClick() {
            @Override
            public void click() {
                System.out.println("Третий");
            }
        };

        BtnClick1.click();
        BtnClick1.getCount();
        BtnClick2.click();
        BtnClick3.click();
    }
}
