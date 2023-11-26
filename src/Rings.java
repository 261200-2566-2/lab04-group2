public class Rings implements Accessory{
    private double damage;
    private double shield;
    public Rings(double damage,double shield){
        this.damage=damage;
        this.shield=shield;
    }
    @Override
    public double damage() {
        return damage;
    }

    @Override
    public double shield() {
        return shield;
    }

}
