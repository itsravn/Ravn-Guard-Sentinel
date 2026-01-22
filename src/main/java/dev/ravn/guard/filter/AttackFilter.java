package dev.ravn.guard.filter;

import org.bukkit.entity.Player;

/**
 * Interface for defining traffic analysis filters.
 * Used to detect high-rate traffic or malformed packets.
 */
public interface AttackFilter {

    /**
     * Unique identifier for the filter (e.g., "NULL_PING", "RATE_LIMIT").
     * 
     * @return The filter name.
     */
    String getName();

    /**
     * Determines if an incoming packet should be blocked provided the context.
     *
     * @param player Ideally the player sending the packet, or null during
     *               handshake/login.
     * @param packet The raw packet object (NMS/Protocol).
     * @return true if the packet constitutes an attack and should be dropped.
     */
    boolean check(Player player, Object packet);

    /**
     * Callback when a violation is detected.
     *
     * @param player The player (if available) who triggered the filter.
     */
    void onViolation(Player player);
}
