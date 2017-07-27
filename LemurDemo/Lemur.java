class Primate {
    private String name = "OliverLouisJulien";

    public Primate() {

    }

    public Primate(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void screech() {
        System.out.println("REEEE");
    }
}

interface CanSwing {
    public boolean isSwinging();
}

public class Lemur extends Primate implements CanSwing{
    public Lemur(String name) {
        super(name);
    }

    public Lemur() {
        this("Sam");
    }

    public boolean isSwinging() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.getName());

        Lemur lemur2 = new Lemur("Joseph");
        System.out.println(lemur2.getName());
    }
}