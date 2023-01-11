package challenge;

public class Melon {
   private String name;
   private Integer value;

    public Melon() {
    }

    public Melon(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public void eat(@Ripe Melon this) {
        System.out.println("eat " + this.name);
    }
}
