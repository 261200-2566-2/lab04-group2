public class Rings implements Accessory{
    private double damage;
    public Rings(double damage){
        this.damage=damage;
    }
    @Override
    public double damage() {
        return damage;
    }

    @Override
    public double shield() {
        return 0;
    }

}
