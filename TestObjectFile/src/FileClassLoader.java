import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author PHY
 * @date 2020-06-19$-16:36
 */
public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir){
        this.rootDir=rootDir;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class <?> c = findLoadedClass(name);
        //查询一下有没有加载这个类，否则加载新的类；
        if (c != null) {
            return c;
        }else {
            //双亲委托机制，这个意思是没有加载到这个类
            ClassLoader loader = null;
            try {
                loader = this.getParent();
                c=loader.loadClass(name);
            } catch (Exception e) {

            }
             if (c!=null){
                 return c;
             }
             else {
                 //自定义加载类
                 byte [] bytes=getDate(name);
                 if (bytes==null){
                     new ClassNotFoundException();
                 }else {
                    c =defineClass(name,bytes,0,bytes.length);
                 }
             }
        }

        return c;
    }

    private byte[] getDate(String name) {
        String path=rootDir+"/"+name.replace(".","/");
        InputStream inputStream=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
             inputStream = new FileInputStream(path);
             int len=0;
            byte[] bytes = new byte[1024];
             while ((len=inputStream.read(bytes))!=-1){
                 byteArrayOutputStream.write(bytes,0,len);
             }
             return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();

                }
                if (inputStream != null) {
                    inputStream.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
