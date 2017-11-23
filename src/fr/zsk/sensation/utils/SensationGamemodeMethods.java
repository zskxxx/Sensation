package fr.zsk.sensation.utils;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SensationGamemodeMethods {
	
	public static void setGamemode(Player p, int i){
		
		if(i == 0){
			p.setGameMode(GameMode.SURVIVAL);
			return;
		}
		
		if(i == 1){
			p.setGameMode(GameMode.CREATIVE);
			return;
		}
		
		if(i == 2){
			p.setGameMode(GameMode.ADVENTURE);
			return;
		}
		
		if(i == 3){
			p.setGameMode(GameMode.SPECTATOR);
			return;
		}
		return;
	}
	
}
