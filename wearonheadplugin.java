package asahi2986github.com.wearonheadplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class wearonheadplugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("WearOnHeadPlugin has been enabled.");
        getCommand("wearonhead").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("WearOnHeadPlugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("wearonhead") && sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack heldItem = player.getInventory().getItemInMainHand();

            if (heldItem != null && heldItem.getType() != Material.AIR) {
                ItemStack headItem = player.getInventory().getHelmet();
                player.getInventory().setHelmet(heldItem);
                player.getInventory().setItemInMainHand(headItem);

                player.sendMessage("You're now wearing the item on your head!");
                return true;
            } else {
                player.sendMessage("You need to hold an item in your hand to put it on your head!");
                return true;
            }
        }
        return false;
    }
}

