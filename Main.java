




import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Membuat karakter
        MainCharacter arlot = new MainCharacter("Arlot", 100, 20, 30, 20, 10);
        Enemy demon = new Enemy("Demon King", 100, 20, 20, 10, 0);

        // Membuat senjata
        Sword great_sword = new Sword(50, "Lion Claw");
        Sword demon_Sword = new Sword(60, "Cleave");

        arlot.setWeapon(great_sword);
        demon.setWeapon(demon_Sword);

        BodyArmor white_guard = new BodyArmor(30);
        HeadArmor black_guard = new HeadArmor(20);

        // Scanner untuk menerima input dari pemain
        Scanner scanner = new Scanner(System.in);

        // Variable untuk menentukan apakah Arlot sudah mendapatkan armor
        boolean arlotGotArmor = false;

        // Looping sampai salah satu karakter mati
        while (!arlot.isDead() && !demon.isDead()) {
            // Arlot melakukan aksi
            System.out.println("========== Arlot's turn ==========");
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Use skill");
            System.out.println("3. Skip");

            int arlotChoice = scanner.nextInt();
            switch (arlotChoice) {
                case 1:
                    System.out.println("Arlot attacks!");
                    arlot.attack(demon, arlot.getStrength());
                    break;
                case 2:
                    System.out.println("Arlot uses skill!");
                    arlot.getWeapon().Skill();
                    arlot.attack(demon, arlot.getWeapon().getPower());
                    break;
                case 3:
                    System.out.println("Arlot skips.");
                    arlot.heal();
                    System.out.println("Arlot cure their wounds!, restore 50 HP!");
                    
                    break;
                default:
                    System.out.println("Invalid choice. Arlot skips.");
                    break;
            }

            // Cek apakah Arlot belum mendapatkan armor
            if (!arlotGotArmor) {
                // Kemungkinan mendapatkan armor
                Random random = new Random();
                int chance = random.nextInt(100) + 1; // Angka acak antara 1 dan 100
                if (chance <= 30) { // Kemungkinan mendapatkan body armor
                    arlot.setArmor(white_guard);
                    arlotGotArmor = true;
                    System.out.println("Arlot got Body Armor!" );
                    System.out.println("Arlot defense : "  +  arlot.getDefense());
                } else if (chance <= 40) { // Kemungkinan mendapatkan head armor
                    arlot.setArmor(black_guard);
                    arlotGotArmor = true;
                    System.out.println("Arlot got Head Armor!");
                    System.out.println("Arlot defense : " +  arlot.getDefense());
                }
            }

            // Demon melakukan aksi
            if (!demon.isDead()) {
                System.out.println("========== Demon's turn ==========");
                // Implementasi aksi demon
                // Misalnya, secara acak:
                int demonChoice = (int) (Math.random() * 2); // Pilihan musuh: serang atau gunakan skill
                switch (demonChoice) {
                    case 0:
                        System.out.println("Demon attacks!");
                        demon.attack(arlot, demon.getStrength());
                        break;
                    case 1:
                        System.out.println("Demon uses skill!");
                        demon.getWeapon().Skill();
                        demon.attack(arlot, demon.getWeapon().getPower());
                        break;
                }
            }

            // Menampilkan status kedua karakter setelah setiap putaran
            System.out.println("Arlot's HP: " + arlot.getHP());
            System.out.println("Demon's HP: " + demon.getHP());
            System.out.println();
        }

        // Menentukan pemenang
        if (arlot.isDead()) {
            System.out.println("========== Demon wins! ==========");
        } else {
            System.out.println("========== Arlot wins! ==========");
        }

        // Menutup scanner setelah digunakan
        scanner.close();
    }
}
