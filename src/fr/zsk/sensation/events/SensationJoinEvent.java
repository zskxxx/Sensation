package fr.zsk.sensation.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.zsk.sensation.Sensation;

public class SensationJoinEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage("§7[§a+§7] Le joueur §a"+ e.getPlayer().getName() +" §7a rejoins le serveur ! ");
		
		
		File f = new File(Sensation.getInstance().getDataFolder(), e.getPlayer().getUniqueId()+".yml");
		if(!f.exists()) { 
		    try {
				f.createNewFile();
				Player p = e.getPlayer();
				Bukkit.broadcastMessage("§7[§aVirtuaLife§7] Bienvenue à §c"+ p.getName() +" sur le serveur roleplayer VirtuaLife");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				Bukkit.getLogger().log(Level.SEVERE, "CAN'T WRITE PLAYERS FILE ! Error (for expert): "+ e1.getMessage());
			}
			return;
		}
		
		// Debut code logs
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
		// Fin code logs

	}
	
}
