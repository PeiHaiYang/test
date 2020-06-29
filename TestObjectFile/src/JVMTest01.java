/**
 * @author PHY
 * @date 2020-06-19$-15:36
 */

public class JVMTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileClassLoader tesr=new FileClassLoader("D:\\test\\TestObjectFile\\src");
        Class <?> ClassLoader=tesr.loadClass("Test01");
        System.out.println(ClassLoader);
        System.out.println(ClassLoader.hashCode());

    }
}

