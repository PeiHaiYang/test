/**
 * @author PHY
 * @date 2020-06-20$-22:14
 */
public class LazyLoad {
    //饿汉式加载
    private LazyLoad(){

    }
    //由于加载类时，天然的并发控制
    private static LazyLoad instance=new LazyLoad();//类初始化时立即加载
      public static LazyLoad getInstance(){
         return instance;

      }




}
