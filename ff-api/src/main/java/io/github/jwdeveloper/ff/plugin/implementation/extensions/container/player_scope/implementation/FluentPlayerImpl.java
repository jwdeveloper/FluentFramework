package io.github.jwdeveloper.ff.plugin.implementation.extensions.container.player_scope.implementation;

import io.github.jwdeveloper.ff.plugin.implementation.extensions.container.player_scope.api.FluentPlayer;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FluentPlayerImpl implements FluentPlayer {
    @Getter
    private final UUID uuid;
    private Player player;

    public FluentPlayerImpl(UUID uuid)
    {
        this.uuid = uuid;
    }

    @Override
    public Player get()
    {
        if(player == null)
        {
            player = Bukkit.getPlayer(uuid);
        }
        return player;
    }

    public void clear()
    {
        player = null;
    }
}
