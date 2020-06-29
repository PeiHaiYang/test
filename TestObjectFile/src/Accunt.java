import java.io.Serializable;

class Accunt implements Serializable {
    private int accunt;
    public  static final long serialVersionUID = 54667710L;
    public Accunt(int accunt) {
        this.accunt = accunt;
    }

    public Accunt() {

    }

    public int getAccunt() {
        return accunt;
    }

    public void setAccunt(int accunt) {
        this.accunt = accunt;
    }

    @Override
    public String toString() {
        return "Accunt{" +
                "accunt=" + accunt +
                '}';
    }
}
