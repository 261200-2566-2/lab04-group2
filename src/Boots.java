public class Boots implements Accessory {
    //stat[0]==damge,stat[1]==sheild
    private double[] state;
    public Boots(double[] state){
        this.state[0]=state[0];
        this.state[1]=state[1];
    }
    @Override
    public double damage() {
        return state[0];
    }

    @Override
    public double shield() {
        return state[1];
    }
}
