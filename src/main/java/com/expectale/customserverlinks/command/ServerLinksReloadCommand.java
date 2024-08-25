package com.expectale.customserverlinks.command;

import com.expectale.customserverlinks.CustomServerLinks;
import com.expectale.customserverlinks.serverlinks.ServerLinkManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ServerLinksReloadCommand implements TabExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("reload")) return false;
        CustomServerLinks.INSTANCE.reloadConfig();
        ServerLinkManager.reloadLinks();
        sender.sendMessage("§a[!] CustomServerLinks config have been reloaded");
        return true;
    }
    
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of("reload");
    }
}
