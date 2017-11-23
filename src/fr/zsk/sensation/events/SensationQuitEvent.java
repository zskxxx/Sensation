package fr.zsk.sensation.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import fr.zsk.sensation.Sensation;

public class SensationQuitEvent implements Listener {
	public ItemStack[] strc;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		
		strc = p.getInventory().getContents();
		File f = new File(Sensation.getInstance().getDataFolder(), e.getPlayer().getUniqueId()+".yml");
		for(int i = 0; i < p.getInventory().getSize() + 1; i++){
			if(f.exists()) { 
			    try {
			    	 PrintWriter writer = new PrintWriter(f, "UTF-8");
			    	 writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Bukkit.getLogger().log(Level.SEVERE, "CAN'T WRITE PLAYERS FILE ! Error (for expert): "+ e1.getMessage());
					return;
				}
				
			}else{
				try {
					f.createNewFile();
					if(f.exists()) { 
					    try {
					    	 PrintWriter writer = new PrintWriter(f, "UTF-8");
					    	 writer.println(strc[i].toString());
					    	 writer.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							Bukkit.getLogger().log(Level.SEVERE, "CAN'T WRITE PLAYERS FILE ! Error (for expert): "+ e1.getMessage());
							return;
						}
						return;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Bukkit.getLogger().log(Level.SEVERE, "CAN'T WRITE PLAYERS FILE ! Error (for expert): "+ e1.getMessage());
				}
			}
		
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(f, true);
		} catch (IOException e1) {e1.printStackTrace();}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			try {
				int lines = 0;
				while (reader.readLine() != null) lines++;
				reader.close();
				int i;
				bw.write("["+Calendar.getInstance().getTime().getYear() +":"+Calendar.getInstance().getTime().getMonth() +":"+Calendar.getInstance().getTime().getDay() +":"+Calendar.getInstance().getTime().getHours() +":"+Calendar.getInstance().getTime().getMinutes() +":"+Calendar.getInstance().getTime().getSeconds() +"] "+ e.getPlayer().getName() +" a quitté le serveur.");
				for(i = 0; i < lines + 1; i++){
					bw.append(" ");
					bw.newLine();
				}
				bw.close();
			} catch (IOException e1) {e1.printStackTrace();}
		} catch (FileNotFoundException e2) {e2.printStackTrace();}
		e.setQuitMessage("§7[§4-§7] Le joueur §a"+ e.getPlayer().getName() +" §7a quitté le serveur ! ");
		
		
		
	}
	
	
}
