
package com.donutauctionpro;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class DonutAuctionPro implements ClientModInitializer {

    private static KeyMapping auctionKey;

    @Override
    public void onInitializeClient() {

        auctionKey = KeyBindingHelper.registerKeyBinding(
            new KeyMapping(
                "key.donutauctionpro.open",
                GLFW.GLFW_KEY_O,
                "category.donutauctionpro"
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (auctionKey.consumeClick()) {

                if (client.player != null) {
                    client.player.displayClientMessage(
                        Component.literal(
                            "§6[Donut Auction Pro] §fAuction Helper activated!"
                        ),
                        false
                    );

                    client.player.displayClientMessage(
                        Component.literal(
                            "§eAuction dashboard coming soon!"
                        ),
                        false
                    );
                }
            }
        });
    }
}
