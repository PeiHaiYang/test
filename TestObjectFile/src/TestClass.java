import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author PHY
 * @date 2020-06-27$-9:54
 */
public class TestClass {

    @Test
    public void textreflection() throws Exception {
         Class clazz=Person.class;
        Constructor constructor = clazz.getConstructor(int.class,String.class);
       Object obj= constructor.newInstance(1,"你好小明");
       Person person = (Person) obj;
        System.out.println(person.toString());
        //调用class的三种方式
        Class class1=Person.class;
        System.out.println(class1);
        //第二种
        Person person1=new Person();
        Class class2= person1.getClass();
        System.out.println(class2);

        Class person3 = Class.forName("Person");

        System.out.println(person3);
        //第四种
        ClassLoader loader = TestClass.class.getClassLoader();
        Class<?> person4 = loader.loadClass("Person");
        System.out.println(person4);
    }


}
