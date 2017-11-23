package fr.zsk.sensation;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.zsk.sensation.commands.SensationGamemodeCommands;
import fr.zsk.sensation.events.SensationJoinEvent;
import fr.zsk.sensation.events.SensationQuitEvent;

public class Sensation extends JavaPlugin{
	
	/*
	 * Plugin commenc� le : 26/05/2017 � 14H00
	 * Autheur : ZeSowK
	 * Remerciement : Les personnes qui m'on aider � conna�tre le Java et savoir l'utiliser.
	 */
	
	
	//Je cr�er une instance
	public static Sensation instance;
	public static Sensation getInstance(){
		return instance;
	}
	
	public ArrayList<String> toChange = new ArrayList<>();
	public static String prefix;
	
	@Override
	public void onEnable() {
		//Initialisation de la Config
		
		
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new SensationJoinEvent(), this);
		pm.registerEvents(new SensationQuitEvent(), this);
		
		getCommand("gm").setExecutor(new SensationGamemodeCommands());
		prefix = getConfig().getString("prefix");
		instance = this;
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	
}
