

public class MainCharacter extends Character{
    


    public MainCharacter(String name,int HP, int defense, int strength, int agility, int faith) {
        super(name,HP, defense, strength, agility, faith);
    }



    @Override
    protected void takeDamage(int damage) {
        int totalDamage = damage - getDefense(); // Menggunakan defense dari superclass
        setHP(getHP() - totalDamage); // Menggunakan HP dari superclass

        System.out.println(this.getName()+ " takes " + totalDamage + " damage.");
        if (getHP() <= 0) {
            System.out.println(this.getName() + " is defeated!");
        }
    }

    public boolean isDead() {
        return this.getHP() <= 0;
    }

    public void setArmor(Armor armor){
        setDefense(armor.getDefense());
    }

    public void heal(){
        this.setHP(getHP()+50);
    }


    
}
