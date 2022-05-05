package io.ebs.arcade.module.client.DDR;

import io.ebs.arcade.module.Category;
import io.ebs.arcade.module.Module;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import java.util.Random;


public class DDR extends Module {
    public DDR() {
        super("DDR", "DDR games", Category.ARCADE);
    }
    public static DDR instance;
    public static int fromX, toX;
    public static int fromY, toY;
    public static int bottomFromY, bottomToY;
    public static int bottomFromYOne, bottomToYOne;
    public static int bottomFromYTwo, bottomToYTwo;
    public static int bottomFromYThree, bottomToYThree;
    public static int bottomFromYFour, bottomToYFour;
    public static int bottomFromX, bottomToX;
    public static int bottomFromXOne, bottomToXOne;
    public static int bottomFromXTwo, bottomToXTwo;
    public static int bottomFromXThree, bottomToXThree;
    public static int bottomFromXFour, bottomToXFour;
    public static int beenDown = 0;
    public static boolean gameOver = true;
    public static int score = 0;
    public static long lastSec = 0;
    public static long lastSecMove = 0;
    Random pos = new Random();

    @Override
    public void onGuiDrawScreen(int mouseX, int mouseY, float partialTicks) {
        //Set values
        fromX = 400;
        toX = fromX + 150;
        fromY = 150;
        toY = fromY + 250;

        bottomFromX = fromX -30;
        bottomToY = fromY -30;

        bottomFromXOne = fromX +60;
        bottomToYOne = fromY -30;

        bottomFromXTwo = fromX +90;
        bottomToYTwo = fromY -30;

        bottomFromXThree = fromX +120;
        bottomToYThree = fromY -30;

        bottomFromXFour = fromX +150;
        bottomToYFour = fromY -30;


        GuiScreen.drawRect(fromX, fromY, toX, toY, 0xFF000000);

        GuiScreen.drawRect(bottomFromX, bottomFromY, bottomToX, bottomToY, 0xf70a0a);
        GuiScreen.drawRect(bottomFromXOne, bottomFromYOne, bottomToXOne, bottomToYOne, 0xf7eb0a);
        GuiScreen.drawRect(bottomFromXTwo, bottomFromYTwo, bottomToXTwo, bottomToYTwo, 0x12f70a);
        GuiScreen.drawRect(bottomFromXThree, bottomFromYThree, bottomToXThree, bottomToYThree, 0x0a1ef7);


        int Divided = 150 - (score / 10);
        if (Divided < 10) {
            Divided = 10;
        }


        long sec = System.currentTimeMillis() / Divided;
        if (sec != lastSec && !gameOver) {
                if(pos.nextInt(4) == 1){

                }
            }
        }


    private void spawnNode(int pos){

    }

    @Override
    public void onGuiKeyPress(int keycode) {
        rightPress(keycode);
    }

    private void rightPress(int keycode){

    }


}
