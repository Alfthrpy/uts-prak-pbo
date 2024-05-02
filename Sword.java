

public class Sword implements Weapon {
    private int power;
    private String skill;
    Sword(int power, String Skill) {
        this.power = power;
        this.skill = Skill;
    }

    @Override
    public void Skill() {
        this.power += 10;
        System.out.println("Use Skill : " + this.skill);
    }

    @Override
    public int getPower() {
        return this.power;
    }
    
}
