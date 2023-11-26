// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double[] boots = new double[2];
        boots[0]=10;
        boots[1]=10;


        Accessory theLord = new Rings(10,10);
        Accessory boostie = new Boots(boots);


        System.out.println(theLord.damage());
        System.out.println(boostie.shield());

    }
}