/**
 * @author PHY
 * @date 2020-06-20$-22:33
 */
public class LazyLoad02 {
    //懒汉式加载
    private LazyLoad02(){}
    private static LazyLoad02 instances;
  //这个是懒加载可能会有线程不安全的 synchronized
    //有延迟加载过程
    public static synchronized LazyLoad02 getInstances(){
        if (instances == null) {
            instances=new LazyLoad02();
        }

            return instances;

    }
}
