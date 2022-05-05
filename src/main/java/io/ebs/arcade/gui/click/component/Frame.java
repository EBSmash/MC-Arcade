package io.ebs.arcade.gui.click.component;

import io.ebs.arcade.Arcade;
import io.ebs.arcade.module.Category;
import io.ebs.arcade.module.Module;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;

public class Frame {
    ArrayList<Button> buttons;
    Category category;
    boolean selected, open;
    int width, height, x, y, dragX = 0, dragY = 0;

    public Frame(Category category, int x, int y, int width, int height) {
        buttons = new ArrayList<>();
        this.category = category;
        selected = false;
        open = true;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        for (Module module : Arcade.moduleManager.getModules()) if (module.getCategory() == this.category) buttons.add(new Button(module, this, this.x + 1, this.y , this.width - 2, this.height));
    }

    public void render(int mouseX, int mouseY) {
        if (selected) {
            this.x = mouseX - dragX;
            this.y = mouseY - dragY;
        }
        Gui.drawRect(x, y + Arcade.clickGui.getYOffset(), x + width, y + height + Arcade.clickGui.getYOffset(), Arcade.clickGui.getFrameColour());
        Arcade.clickGui.drawString(Arcade.clickGui.mc.fontRenderer, this.category.name().charAt(0) + category.name().toLowerCase().substring(1), this.x + 3, (y + this.height  / 2 - Arcade.clickGui.getTextYOffset() + Arcade.clickGui.getYOffset()), Arcade.clickGui.getFrameTextColour());
        if (open) Gui.drawRect(this.x, this.y + this.height + Arcade.clickGui.getYOffset() + 1, this.x + this.width, this.y + this.height + Arcade.clickGui.getYOffset() + 2, Arcade.clickGui.getBg());

        int offset = y + height + 2;
        for (Button button : buttons) {
            if (open) {
                Gui.drawRect(this.x, offset + + Arcade.clickGui.getYOffset(), this.x + this.width, offset + this.height + Arcade.clickGui.getYOffset(), Arcade.clickGui.getBg());
                if (button.open)
                    Gui.drawRect(this.x, offset + this.height + Arcade.clickGui.getYOffset(), this.x + this.width, offset + this.height * (button.module.getSettings().size() + 2) + 1 + Arcade.clickGui.getYOffset(), Arcade.clickGui.getBg());
            }
            button.render(mouseX, mouseY, x + 1, offset);
            if (button.open) offset += height * (button.module.getSettings().size() + 1) + 1;
            offset += height;
        }
    }

    public void mouseReleased(int state) {
        if (state == 0 && selected) {
            selected = false;
        }

        for (Button button : buttons) button.mouseReleased(state);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (open) for (Button button : buttons) button.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void select(int x, int y, int button) {
        if (button == 0) {
            selected = true;
            this.dragX = x - this.x;
            this.dragY = y - this.y;
        } else if (button == 1) {
            open = !open;
        }
    }

    public void keyTyped(int keyCode) {
        for (Button button : buttons) button.keyTyped(keyCode);
    }

    public boolean isOver(int x, int y) {
        return x >= this.x && y >= this.y + Arcade.clickGui.getYOffset() && x <= this.x + this.width && y <= this.y + this.height + Arcade.clickGui.getYOffset();
    }
}
