import HealthSystem.HealthSystem;
import HealthSystem.HealthSystem1L;

/**
 * Another demonstration of the HealthSystem component in different scenarios.
 */
public class HealthSystemDemo2 {

    /**
     * Main method to demonstrate the use of HealthSystem in a variety of use
     * cases.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example 1: Group of entities
        HealthSystem tank = new HealthSystem1L();
        HealthSystem healer = new HealthSystem1L();

        tank.setMaxHealth(200);
        healer.setMaxHealth(80);

        tank.resetHealth();
        healer.resetHealth();

        System.out.println("Tank: " + tank.toString());
        System.out.println("Healer: " + healer.toString());

        // Damage tank and heal it with healer
        tank.takeDamage(50);
        System.out.println(
                "Tank health after taking 50 damage: " + tank.getHealth());

        tank.heal(50); // Healer heals Tank
        System.out.println(
                "Tank health after being healed 50: " + tank.getHealth());

        // Example 2: Overhealing and updating max health
        HealthSystem wizard = new HealthSystem1L();
        wizard.setMaxHealth(70);
        wizard.resetHealth();

        System.out.println("Wizard: " + wizard.toString());

        wizard.heal(20); // Attempt overhealing
        System.out.println(
                "Wizard health after overhealing by 20: " + wizard.getHealth());

        wizard.setMaxHealth(100); // Increase max health
        System.out.println("Wizard max health updated to 100. Current health: "
                + wizard.getHealth());

        System.out.println(wizard.toString());
    }

}
