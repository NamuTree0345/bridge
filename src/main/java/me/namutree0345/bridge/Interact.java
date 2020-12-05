package me.namutree0345.bridge;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Interact implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(e.getPlayer().getInventory().getItemInMainHand() != null && e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COBBLESTONE) {
                Location blockLoc = e.getPlayer().getLocation();
                blockLoc.setX(blockLoc.getX() + blockLoc.getDirection().getX());
                blockLoc.setY(blockLoc.getY() - 1);
                blockLoc.setZ(blockLoc.getZ() + blockLoc.getDirection().getZ());

                boolean notEnd = true;
                int num = 1;
                if (e.getPlayer().getWorld().getBlockAt(blockLoc).getType() != Material.AIR) {
                    while (notEnd) {
                        if (e.getPlayer().getWorld().getBlockAt(blockLoc).getType() != Material.AIR) {
                            num++;
                            blockLoc.setX(blockLoc.getX() + blockLoc.getDirection().getX());
                            blockLoc.setZ(blockLoc.getZ() + blockLoc.getDirection().getZ());
                        } else {
                            notEnd = false;
                        }
                    }
                }


                e.getPlayer().getWorld().getBlockAt(blockLoc).setType(Material.COBBLESTONE);

                ItemStack m = e.getPlayer().getInventory().getItemInMainHand();
                m.setAmount(1);

                e.getPlayer().getInventory().remove(m);
            }
        }
    }

}
