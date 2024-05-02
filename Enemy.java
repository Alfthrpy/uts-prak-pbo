

public class Enemy extends Character {

    public Enemy(String name,int HP, int defense, int strength, int agility, int faith) {
        super(name,HP + 100, defense, strength + 20, agility, faith);
    }


    @Override
    protected void takeDamage(int damage) {
        int totalDamage = damage - getDefense(); // Mengurangi damage dengan defense
        if (totalDamage > 0) {
            setHP(getHP() - totalDamage); // Mengurangi HP
            System.out.println(this.getName() + " takes " + totalDamage + " damage.");
            if (getHP() <= 0) {
                System.out.println(this.getName()+" is defeated!");
            }
        } else {
            System.out.println("Enemy's defense blocks the attack!");
        }
    }

    public boolean isDead() {
        return this.getHP() <= 0;
    }
    
}
