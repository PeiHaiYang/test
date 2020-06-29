/**
 * @author PHY
 * @date 2020-06-20$-22:43
 */
public class SingloadInnerStatic {
    //静态内部类加载
    private SingloadInnerStatic(){}
    private  static class SingloadInner{
        private static final SingloadInnerStatic getSingLoad=new SingloadInnerStatic();
    }
    public static SingloadInnerStatic getInstance(){
        return SingloadInner.getSingLoad;
    }
}
