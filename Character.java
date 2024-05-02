
public abstract class Character {
    private int HP;
    private int defense;
    private int strength;
    private int agility;
    private int faith;
    private String name;
    private Weapon weapon;

    public Character(String name,int HP, int defense, int strength, int agility, int faith){
        this.HP = HP;
        this.defense = defense;
        this.strength = strength;
        this.agility = agility;
        this.faith = faith;
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public String getName() {
        return this.name;
    }

    void setWeapon(Weapon weapon) {
        this.weapon = weapon;

    }

    Weapon getWeapon(){
        return this.weapon;
    }

    // Method umum untuk menampilkan informasi karakter
    public void displayInfo() {
        System.out.println("Character Info:");
        System.out.println("HP: " + HP);
        System.out.println("Defense: " + defense);
        System.out.println("Strength: " + strength);
        System.out.println("Agility: " + agility);
        System.out.println("Faith: " + faith);
    }

    // Method umum untuk karakter melakukan serangan
    public void attack(Character target, int damage) {
        System.out.println(this.getName()+ " attacks " + target.getName() + " with damage: " + damage);
        target.takeDamage(damage);
    }

    // Method umum untuk karakter menerima kerusakan
    protected abstract void takeDamage(int damage);
}
