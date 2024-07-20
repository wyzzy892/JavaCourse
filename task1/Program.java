package task1;
import java.lang.reflect.Field;

class Person {
    private int age;

    // геттер
    public int getAge(){
        return this.age;
    }

    // сеттер
    public void setAge(int age) {
        this.age = (age >= 0 && age <= 120)? age : 0;
    }
}

public class Program {
    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(36);
        int personAge = -1;
		
        // Вывод при помощи геттера
        System.out.println("Print age with getter: " + person.getAge());

        // Задаем невалидное значение при помощи рефлексии
        try{
            Field field = person.getClass().getDeclaredField("age");
            field.setAccessible(true);
            field.set(person, 301);
            personAge = (int) field.get(person);
        } catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println("Age after invalid setting: "+person.getAge());

        // Вывод без геттера
        System.out.println("Print age without getter: " + personAge);
    }
}