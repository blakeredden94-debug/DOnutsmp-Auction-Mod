
package com.donutauctionpro;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AuctionScreen extends Screen {

    private String status = "Welcome! Select a tool below.";

    public AuctionScreen() {
        super(Component.literal("Donut Auction Pro"));
    }

    @Override
    protected void init() {
        int center = this.width / 2;
        int startY = this.height / 2 - 55;

        addRenderableWidget(Button.builder(
            Component.literal("Price Checker"),
            button -> status = "Price checker selected!"
        ).bounds(center - 100, startY, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Profit Calculator"),
            button -> status = "Profit calculator selected!"
        ).bounds(center - 100, startY + 25, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Favourite Items"),
            button -> status = "Your favourite items will appear here."
        ).bounds(center - 100, startY + 50, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Price Alerts"),
            button -> status = "No price alerts configured."
        ).bounds(center - 100, startY + 75, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Close"),
            button -> onClose()
        ).bounds(center - 100, startY + 105, 200, 20).build());
    }

    @Override
    public void extractRenderState(
        GuiGraphicsExtractor graphics,
        int mouseX,
        int mouseY,
        float delta
    ) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        int center = this.width / 2;

        graphics.fill(
            center - 125, 20,
            center + 125, this.height - 20,
            0xEE151520
        );

        graphics.text(
            this.font,
            "DONUT AUCTION PRO",
            center - 65,
            35,
            0xFFFFAA00,
            true
        );

        graphics.text(
            this.font,
            "Minecraft 1.21.11",
            center - 48,
            50,
            0xFFFFFFFF,
            true
        );

        graphics.text(
            this.font,
            status,
            center - 110,
            this.height / 2 + 85,
            0xFF55FFAA,
            true
        );

        graphics.text(
            this.font,
            "Demo dashboard - live listings coming soon",
            center - 100,
            this.height - 32,
            0xFFAAAAAA,
            true
        );
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
