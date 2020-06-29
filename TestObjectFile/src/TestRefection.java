import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * @author PHY
 * @date 2020-06-28$-19:39
 */
public class TestRefection {



    @Test
    public void text01() throws ClassNotFoundException {
        Class  person = Class.forName("Person");
       // Field[] fields = person.getFields();
        Field[] declaredFields = person.getDeclaredFields();
        for (Field f : declaredFields) {
            //首先获取的是属性的限制符
           int i= f.getModifiers();
            System.out.print(Modifier.toString(i)+"\t");
            //类型
            Class type = f.getType();
            System.out.print(type.getName()+"\t");
            //属性的名字
            System.out.println(f.getName());

            System.out.println();
        }

        Method[] methods = person.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        Method[] declaredMethods = person.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }
    @Test
    public void test02() throws Exception {
        Class clazz=Person.class;
        Person o = (Person) clazz.newInstance();
        int field = o.getId();
        //
        Field id = clazz.getDeclaredField("name");
        //安全监测，证明这个是可以访问的
        id.setAccessible(true);
        id.set(o,"Tom");

        //o.setId(1);
        System.out.println(o.getName());
       // System.out.println(field);

    }

    @Test
    public void test03() throws Exception {
        Class clazz=Person.class;
        Person o = (Person) clazz.newInstance();

        Method setName = clazz.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);
        Object tom01 = setName.invoke(o, "Tom01");
        System.out.println(tom01);


        System.out.println("@@@@@@@@@@@@@@@@@@@@************");
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        Object invoke = show.invoke(o);
        System.out.println(invoke);


        System.out.println("**************");

        Constructor constructor = clazz.getDeclaredConstructor(int.class,String.class);
        Type[] name = constructor.getGenericParameterTypes();
        System.out.println(name[0].getTypeName()+name[1].getTypeName());
        System.out.println("#################");

    }


    @Test
    public void test04{
        InputStream inputStream = null;
        try {
            Properties pro=new Properties();
            inputStream = new FileInputStream("JDBC.properties");
            pro.load(inputStream);

            String username= pro.getProperty("username");
            String password=pro.getProperty("password");
            System.out.println(username);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
