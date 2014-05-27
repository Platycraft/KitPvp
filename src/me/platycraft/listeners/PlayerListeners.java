package me.platycraft.listeners;

import me.platycraft.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerListeners implements Listener {
	
	Main plugin;
	public PlayerListeners(Main instance){
		this.plugin = instance;
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String pname = p.getName();
		p.getInventory().clear();
		//Message to send the server on join!
		Bukkit.broadcastMessage("" + ChatColor.AQUA + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.GOLD + " has join the KIT PVP server!");
	    
		//Giving the player the Kit Selector
		ItemStack kitselector = new ItemStack(Material.COMPASS);
		ItemMeta m = kitselector.getItemMeta();
		m.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "KIT SELECTOR!");
		kitselector.setItemMeta(m);
		p.getInventory().setItem(4,kitselector);
	}
	// End of Player joining the server
	
	//When Player Leave/quits the Server 
	
	
    @EventHandler
    public void PlayerLeave(PlayerQuitEvent e){
    	Player p = e.getPlayer();
		String pname = p.getName();
		p.getInventory().clear();
		//Message to send the server on Leave!
		Bukkit.broadcastMessage("" + ChatColor.AQUA + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.GOLD + " has left the KIT PVP server!");
    }
    //End of player Leaving the server 
    
    @EventHandler
    public void Death(PlayerDeathEvent e){
    	
    	Player p = e.getEntity();
    	Player k = p.getKiller();
    	e.getDrops().clear();
    	e.setDeathMessage("" + ChatColor.BLUE + e.getEntity() + ChatColor.AQUA + "was killed by" + ChatColor.RED + p.getKiller());
    	p.sendMessage(ChatColor.AQUA + "Your death was by" + ChatColor.RED + k.getName());
    	k.sendMessage(ChatColor.AQUA + "Congrats! You killed " + ChatColor.RED + p.getName());
    	
    }
    
    @EventHandler
    public void Respawn(PlayerRespawnEvent e){
    	Player p = e.getPlayer();
    	
    	//Gives  Inventory 
    	ItemStack kitselector = new ItemStack(Material.COMPASS);
		ItemMeta m = kitselector.getItemMeta();
		m.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "KIT SELECTOR!");
		kitselector.setItemMeta(m);
		p.getInventory().setItem(4,kitselector);
    	
    }

}
