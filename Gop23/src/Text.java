/**
 * @author PHY
 * @date 2020-06-20$-23:07
 */
public class Text {
    public static void main(String[] args) {
        LazyLoad lazyLoad01=LazyLoad.getInstance();
        LazyLoad lazyLoad02=LazyLoad.getInstance();
        System.out.println(lazyLoad01);
        System.out.println(lazyLoad02);
        System.out.println("##########");
        LazyLoad02 lazyLoad05=LazyLoad02.getInstances();
        LazyLoad02 lazyLoad04=LazyLoad02.getInstances();
        System.out.println(lazyLoad05);
        System.out.println(lazyLoad04);
        System.out.println(SingLoadEnvm.INSTANCE==SingLoadEnvm.INSTANCE);
    }
}
