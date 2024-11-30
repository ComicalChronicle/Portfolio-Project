import HealthSystem.HealthSystem;
import HealthSystem.HealthSystem1L;

/**
 * A simple demonstration of the HealthSystem component.
 */
public class HealthSystemDemo {

    /**
     * Main method to demonstrate the use of HealthSystem in a variety of use
     * cases.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example 1: Basic usage of HealthSystem
        HealthSystem player = new HealthSystem1L();

        // Set initial health and max health
        player.setMaxHealth(100);
        player.resetHealth();

        // Simulate taking damage and healing
        player.takeDamage(30);
        System.out.println(
                "Player health after taking 30 damage: " + player.getHealth());

        player.heal(20);
        System.out.println(
                "Player health after healing 20: " + player.getHealth());

        // Check if the player is critical or alive
        System.out.println("Is player critical? " + player.isCritical());
        System.out.println("Is player alive? " + player.isAlive());

        // Update max health
        player.setMaxHealth(150);
        System.out.println("Player max health updated to 150. Current health: "
                + player.getHealth());

        System.out.println(player.toString());

        // Example 2: Zero health scenario
        HealthSystem enemy = new HealthSystem1L();
        enemy.setMaxHealth(50);
        enemy.resetHealth();

        enemy.takeDamage(50);
        System.out.println(
                "Enemy health after taking 50 damage: " + enemy.getHealth());
        System.out.println("Is enemy alive? " + enemy.isAlive());

        enemy.heal(10); // Attempt to heal a dead entity
        System.out.println("Enemy health after healing 10 (should still be 0): "
                + enemy.getHealth());

        System.out.println(enemy.toString());
    }
}
