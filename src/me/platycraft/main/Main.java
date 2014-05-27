package me.platycraft.main;

import me.platycraft.listeners.PlayerListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main instance;
	
	public void log(String string){
		System.out.println(string);
	}
	
	public static Main getInstance(){
		return instance; 
	}
	
	public void registerListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListeners(this), this);
	}
	
	public void registerCommands(){
		//Not using this just yet
	}
	
	@Override
	public void  onEnable(){
		getLogger().info("has been enabled successfully!");
		instance = this;
		registerListeners();
		registerCommands();
	}
	
	@Override
	public void onDisable(){
		getLogger().info("has been disabled successfully!");
		instance = null;
	}
	
	//COMMANDS 
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Starter Command
		
		if (cmd.getName().equalsIgnoreCase("starter") && sender instanceof Player){
			
			Player p = (Player) sender;
			p.getInventory().clear();
			ItemStack starterbow = new ItemStack(Material.BOW);
			ItemMeta m = starterbow.getItemMeta();
			m.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "STARTER BOW!");
			starterbow.setItemMeta(m);
			starterbow.addEnchantment(Enchantment.DURABILITY, 1);
			starterbow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			p.getInventory().addItem(starterbow);
			p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_BOOTS));
			p.setMaxHealth(30);
			p.setHealth(30);
			p.sendMessage(ChatColor.AQUA + "You was given the" + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.GREEN + "Starter Bow");
			
			
		}
		// End of start command
		
		//Amature Command 
		
if (cmd.getName().equalsIgnoreCase("amateur") && sender instanceof Player){
			
			Player p = (Player) sender;
			p.getInventory().clear();
			ItemStack amateurbow = new ItemStack(Material.BOW);
			ItemMeta m = amateurbow.getItemMeta();
			m.setDisplayName("" + ChatColor.YELLOW + ChatColor.BOLD + "AMATEUR BOW!");
			amateurbow.setItemMeta(m);
			amateurbow.addEnchantment(Enchantment.DURABILITY, 1);
			amateurbow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			p.getInventory().addItem(amateurbow);
			p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_BOOTS));
			p.setMaxHealth(30);
			p.setHealth(30);
			p.sendMessage(ChatColor.AQUA + "You was given the" + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.GREEN + "Starter KIT !");
			ItemStack amateursword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta n = amateursword.getItemMeta();
			n.setDisplayName("" + ChatColor.YELLOW + ChatColor.BOLD + "AMATUER BOW!");
			amateursword.setItemMeta(n);
			amateursword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			amateursword.addEnchantment(Enchantment.KNOCKBACK, 1);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			p.getInventory().addItem(amateursword);
			p.getInventory().addItem(amateurbow);
			p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			p.sendMessage(ChatColor.AQUA + "You was given the" + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.YELLOW + "Amateur KIT !");
			}
		return false;		
	}

}
