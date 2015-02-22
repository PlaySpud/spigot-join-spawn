package rocks.spud.server.joinspawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Provides a simple plugin which forces players to return to spawn every time they login.
 * @author {@literal Johannes Donath <johannesd@torchmind.com>}
 */
public class JoinSpawnPlugin extends JavaPlugin implements Listener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onEnable () {
		super.onEnable ();

		this.getServer ().getPluginManager ().registerEvents (this, this);
	}

	/**
	 * Handles player joins.
	 * @param event The event.
	 */
	@EventHandler (priority = EventPriority.HIGH)
	public void onPlayerJoin (PlayerJoinEvent event) {
		event.getPlayer ().teleport (event.getPlayer ().getWorld ().getSpawnLocation ().add (0.5d, 0.0d, 0.5d));
	}
}
