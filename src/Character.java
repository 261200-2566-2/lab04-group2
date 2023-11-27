public class Character {
    String name;
    private double maxHp=100;
    private double maxMana=50;
    private double runSpeed;
    private final double baseRunSpeed=10;
    Sword sword;
    private double atk=0;
    Shield shield;
    private double def=0;
    private int lvl=0;

    public Stat(String name,Sword sword,Shield shield){
        this.name = name;
        this.runSpeed=baseRunSpeed;

        if(sword!=null) {
            this.sword=new Sword(sword.name,sword.baseDamage);
            this.runSpeed-=(this.sword.lvl);
            atk = this.sword.swordDamage;
        }else this.sword=null;

        if(shield!=null) {
            this.shield=new Shield(shield.name,shield.baseDefense);
            this.runSpeed-=(shield.lvl);
            def = shield.shieldDefense;
        }else this.shield=null;

    }
    private void levelUp(){
        System.out.println("You level up!");
        if(sword!=null) sword.levelUp();
        if(shield!=null) shield.levelUp();
        lvl++;
        maxHp=100+(10*lvl);
        maxMana=100+(10*lvl);
        runSpeed=baseRunSpeed+(2*lvl);
        if(sword!=null)  {
            this.runSpeed-=(sword.lvl);
            atk = sword.swordDamage;
        }
        if(shield!=null) {
            this.runSpeed-=(shield.lvl);
            def = shield.shieldDefense;
        }
    }
    public void unequipSword(){
        sword=null;
        atk=0;
        runSpeed=baseRunSpeed+(2*lvl);
        if(shield!=null) this.runSpeed-=shield.lvl;
    }
    public void unequipShield(){
        shield=null;
        def=0;
        runSpeed=baseRunSpeed+(2*lvl);
        if(sword!=null) this.runSpeed-=sword.lvl;
    }
    public void equipSword(Sword sword){

        if(sword.lvl>runSpeed){
            System.out.println("Too heavy!");
        }else{
            this.sword=new Sword(sword.name,sword.baseDamage);
            atk = this.sword.swordDamage;
            runSpeed=baseRunSpeed+(2*lvl);
            this.runSpeed-=this.sword.lvl;
            if(shield!=null) this.runSpeed-=shield.lvl;
        }
    }
    public void equipShield(Shield shield){
        if(shield.lvl>runSpeed){
            System.out.println("Too heavy!");
        }else{
            this.shield=new Shield(shield.name,shield.baseDefense);
            def=this.shield.shieldDefense;
            runSpeed=baseRunSpeed+(2*lvl);
            this.runSpeed-=this.shield.lvl;
            if(sword!=null) this.runSpeed-=sword.lvl;
        }
    }

    public void show(){
        System.out.println("Name :"+name);
        System.out.println("Hp : "+this.maxHp);
        System.out.println("Mana : "+this.maxMana);
        System.out.println("damage : "+ this.atk);
        System.out.println("def : "+ this.def);
        System.out.println("level : "+this.lvl);
        System.out.println("runSpeed : "+this.runSpeed);
        if(sword==null) System.out.println("sword : none");
        else System.out.println("sword : "+sword.name);
        if(shield==null)  System.out.println("shield : none");
        else System.out.println("sword : "+shield.name);

    }

    public void attack(Stat op){
        if(atk>op.def) {
            double damage = atk-op.def;
            System.out.println(this.name+" attacked "+op.name+" "+damage +" damage ");
            if(op.maxHp<=damage){
                op.maxHp=0;
                this.levelUp();
                System.out.println(op.name+" is dead!");
            }else{
                op.maxHp-=atk-op.def;
            }
        }else{
            System.out.println(this.name+" attacked "+op.name+ "0 damage ");
        }
    }
}
