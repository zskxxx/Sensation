package fr.zsk.sensation.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.zsk.sensation.Sensation;
import fr.zsk.sensation.utils.SensationGamemodeMethods;

public class SensationGamemodeCommands implements CommandExecutor {

	
	private String str;
	private String str_r;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gm")){
			if(!(sender instanceof Player)){
				str = Sensation.getInstance().getConfig().getString("unauthorizedcmd-message");
				str_r = str.replace("-PLAYER-", sender.getName());
				str_r =  str_r.replace("-SERVER-", Sensation.getInstance().getConfig().getString("server-name"));
				str_r =  str_r.replace("-PREFIX-", Sensation.getInstance().getConfig().getString("prefix"));
				sender.sendMessage(str_r);
				return false;
			}
			Player p = (Player) sender;
			if(args.length == 0){
				p.sendMessage("");
				return false;
			}
			if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
				SensationGamemodeMethods.setGamemode(p, 0);
				return false;
			}
			if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
				SensationGamemodeMethods.setGamemode(p, 1);
				return false;
			}
			if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")){
				SensationGamemodeMethods.setGamemode(p, 2);
				return false;
			}
			if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")){
				SensationGamemodeMethods.setGamemode(p, 3);
				return false;
			}
			str = Sensation.getInstance().getConfig().getString("uncognizedgamemode-message");
			sender.sendMessage(str_r);
		}
		
		return false;
	}

}
