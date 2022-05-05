package io.ebs.arcade.module.client.beatsaber;

import io.ebs.arcade.module.Category;
import io.ebs.arcade.module.Module;
import io.ebs.arcade.rendering.RenderBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Random;

public class BeatSaber extends Module {
    public BeatSaber() {
        super("BeatSaber", "BeatSaber game", Category.ARCADE);
    }
    int score =0;
    public static long lastSec = 0;
    int rows = 3;
    int cols = 2;

    boolean[][] mineLocations = new boolean[rows][cols];
    Random random = new Random();

    int counter = 0;

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {

        int Divided = 150 - (score / 10);
        if (Divided < 10) {
            Divided = 10;
        }

        long sec = System.currentTimeMillis() / Divided;
        if (sec != lastSec) {
                int x = random.nextInt(rows);
                int z = random.nextInt(cols);
                spawnMoving(x,z);
            }
    }

    private void spawnMoving(int x,int z) {
        if(mc.player.getHorizontalFacing() == EnumFacing.NORTH) {
            for(int i= 10; i>0; i--){
                RenderBlock.add(new BlockPos(x, mc.player.posY, z - i), Color.BLUE, 0.5F);
            }
        }
        if(mc.player.getHorizontalFacing() == EnumFacing.SOUTH) {
            for(int i = 10; i>0; i--){
                RenderBlock.add(new BlockPos(x, mc.player.posY, z + i), Color.BLUE, 0.5F);
            }
        }
        if(mc.player.getHorizontalFacing() == EnumFacing.EAST) {
            for(int i = 10; i>0; i--){
                RenderBlock.add(new BlockPos(x + i, mc.player.posY, z), Color.BLUE, 0.5F);
            }
        }
        if(mc.player.getHorizontalFacing() == EnumFacing.WEST) {
            for(int i = 10; i>0; i--){
                RenderBlock.add(new BlockPos(x - i, mc.player.posY, z), Color.BLUE, 0.5F);
            }
        }
}}


