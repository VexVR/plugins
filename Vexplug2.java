package gg.vexsoftwares.vexplug2;

import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public final class Vexplug2 extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        System.out.println("Vex's sexy fuckin plugin has launched!");
        getServer().getPluginManager().registerEvents(this,this);
    }
    @EventHandler
    public void onPlayerJoin(EntityShootBowEvent shootBowEvent){
        Arrow a = (Arrow) shootBowEvent.getProjectile();
        a.setMetadata("sigma", new FixedMetadataValue(this, 0));
    }
    @EventHandler
    public void changeArrowDamage(EntityDamageByEntityEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE){
            if(e.getDamager() instanceof Arrow){
                if(e.getDamager().hasMetadata("sigma")){
                    e.setDamage(e.getDamage()*2);
                }
            }
        }
    }
}
