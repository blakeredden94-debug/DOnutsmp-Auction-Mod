
package com.donutauctionpro;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AuctionScreen extends Screen {

    private String status = "Welcome to Donut Auction Pro!";

    public AuctionScreen() {
        super(Component.literal("Donut Auction Pro"));
    }

    @Override
    protected void init() {
        int center = this.width / 2;
        int startY = this.height / 2 - 55;

        addRenderableWidget(Button.builder(
            Component.literal("Price Checker"),
            button -> status = "Price checker coming soon!"
        ).bounds(center - 100, startY, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Profit Calculator"),
            button -> status = "Profit calculator coming soon!"
        ).bounds(center - 100, startY + 25, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Favourite Items"),
            button -> status = "Favourite items coming soon!"
        ).bounds(center - 100, startY + 50, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Price Alerts"),
            button -> status = "Price alerts coming soon!"
        ).bounds(center - 100, startY + 75, 200, 20).build());

        addRenderableWidget(Button.builder(
            Component.literal("Close"),
            button -> onClose()
        ).bounds(center - 100, startY + 105, 200, 20).build());
    }

    @Override
    public void render(
        GuiGraphics graphics,
        int mouseX,
        int mouseY,
        float delta
    ) {
        graphics.fill(
            0, 0, this.width, this.height,
            0xCC080812
        );

        int center = this.width / 2;

        graphics.fill(
            center - 125, 20,
            center + 125, this.height - 20,
            0xFF151520
        );

        super.render(graphics, mouseX, mouseY, delta);

        graphics.drawCenteredString(
            this.font,
            "DONUT AUCTION PRO",
            center,
            35,
            0xFFFFAA00
        );

        graphics.drawCenteredString(
            this.font,
            "Minecraft 1.21.11",
            center,
            50,
            0xFFFFFFFF
        );

        graphics.drawCenteredString(
            this.font,
            status,
            center,
            this.height / 2 + 85,
            0xFF55FFAA
        );

        graphics.drawCenteredString(
            this.font,
            "Auction Helper",
            center,
            this.height - 32,
            0xFFAAAAAA
        );
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
