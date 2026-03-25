package io.github.blackbaroness.znpcplusmodern;

import lombok.RequiredArgsConstructor;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class NativeBukkitAudiences implements BukkitAudiences {

    private final Server server;

    @Override
    public @NotNull Audience sender(@NotNull CommandSender sender) {
        return sender;
    }

    @Override
    public @NotNull Audience player(@NotNull Player player) {
        return player;
    }

    @Override
    public @NotNull Audience filter(@NotNull Predicate<CommandSender> filter) {
        return Audience.audience(server.getOnlinePlayers().stream().filter(filter).toList());
    }

    @Override
    public @NotNull Audience all() {
        return server;
    }

    @Override
    public @NotNull Audience console() {
        return server.getConsoleSender();
    }

    @Override
    public @NotNull Audience players() {
        return Audience.audience(server.getOnlinePlayers());
    }

    @Override
    public @NotNull Audience player(@NotNull UUID playerId) {
        final Player player = server.getPlayer(playerId);
        return player == null ? Audience.empty() : player;
    }

    @Override
    public @NotNull Audience permission(@NotNull String permission) {
        return filter(sender -> sender.hasPermission(permission));
    }

    @Override
    public @NotNull Audience world(@NotNull Key world) {
        final World obj = server.getWorld(world.asString());
        return obj == null ? Audience.empty() : obj;
    }

    @Override
    public @NotNull Audience server(@NotNull String serverName) {
        return all();
    }

    @Override
    public @NotNull ComponentFlattener flattener() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void close() {
    }
}
