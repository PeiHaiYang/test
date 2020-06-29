import java.io.Serializable;

/**
 * @author PHY
 * @date 2020-06-17$-15:30
 */
public class Person implements Serializable {

    public static String  show(){
        String string = "hhh";
        System.out.println("nihao");
        return string;
    }
    public  static final long serialVersionUID = 54667710L;
    private int id;
    private String name;
    private Accunt accunt;

    public Person(int id,String name,Accunt accunt) {
        this.id=id;
        this.name=name;
        this.accunt =accunt;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accunt getAccunt() {
        return accunt;
    }

    public void setAccunt(Accunt accunt) {
        this.accunt = accunt;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accunt=" + accunt +
                '}';
    }
}
