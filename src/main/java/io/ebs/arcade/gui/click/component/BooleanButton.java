package io.ebs.arcade.gui.click.component;

import io.ebs.arcade.Arcade;
import io.ebs.arcade.setting.Setting;
import io.ebs.arcade.util.ColourUtils;
import net.minecraft.client.gui.Gui;

public class BooleanButton {
    Button button;
    Setting setting;
    int width, height, x, y;

    public BooleanButton(Button button, Setting setting, int x, int y, int width, int height) {
        this.button = button;
        this.setting = setting;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void render(int mouseX, int mouseY, int x, int y) {
        if (button.open) {
            this.x = x;
            this.y = y;
            if (setting.getBVal()) {
                Gui.drawRect(this.x, this.y + Arcade.clickGui.getYOffset(), this.x + this.width, this.y + this.height + Arcade.clickGui.getYOffset() - 1, Arcade.clickGui.getEnabledButtonColour());
                Arcade.clickGui.drawString(Arcade.clickGui.mc.fontRenderer, setting.getName(), this.x + 3, (this.y + this.height / 2) + Arcade.clickGui.getYOffset() - Arcade.clickGui.getTextYOffset(), Arcade.clickGui.getEnabledButtonTextColour());
            } else {
                Gui.drawRect(this.x, this.y + Arcade.clickGui.getYOffset(), this.x + this.width, this.y + this.height + Arcade.clickGui.getYOffset() - 1, Arcade.clickGui.getButtonColour());
                Arcade.clickGui.drawString(Arcade.clickGui.mc.fontRenderer, setting.getName(), this.x + 3, (this.y + this.height / 2) + Arcade.clickGui.getYOffset() - Arcade.clickGui.getTextYOffset(), Arcade.clickGui.getButtonTextColour());
            }

            if (isOver(mouseX, mouseY))
                Gui.drawRect(this.x, this.y + Arcade.clickGui.getYOffset(), this.x + this.width, this.y + this.height + Arcade.clickGui.getYOffset() - 1, ColourUtils.ColorUtils.toRGBA(255, 255, 255, 50));
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (button.open && mouseButton == 0 && isOver(mouseX, mouseY) && button.open) setting.setBVal(!setting.getBVal());
    }

    public boolean isOver(int x, int y) {
        return x >= this.x && y > this.y + Arcade.clickGui.getYOffset() && x <= this.x + this.width && y <= this.y + this.height + Arcade.clickGui.getYOffset();
    }
}
