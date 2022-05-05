package io.ebs.arcade.rendering;

import java.awt.Color;
import java.util.ArrayList;


import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import io.ebs.arcade.rendering.RenderBlock.BlockColor;

import static io.ebs.arcade.Arcade.mc;
//CREDIT --> bebeli555/cookiclient


public class Renderer {
	public static String[] status;
	public static ArrayList<RenderBlock.BlockColor> rectangles = new ArrayList<RenderBlock.BlockColor>();

	@SubscribeEvent
	public void renderWorld(RenderWorldLastEvent event) {
		if (mc.player == null) {
			return;
		}
		
		try {
			//Render path
			BlockPos last = null;
			for (BlockPos pos : RenderPath.path) {
				if (last != null) {
					RenderUtil.drawLine(new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5), new Vec3d(last.getX() + 0.5, last.getY() + 0.5, last.getZ() + 0.5), 2, RenderPath.color);
				}
				
				last = pos;
			}
			
			//Render block bounding box
			for (BlockColor blockColor : RenderBlock.list) {
				Color c = blockColor.color;
				RenderUtil.drawBoundingBox(RenderUtil.getBB(blockColor.pos, 1), blockColor.width, c.getRed() / 255, c.getGreen() / 255, c.getBlue() / 255, 1f);
			}
			
			//Render 2d rectangles
			for (BlockColor rectangle : rectangles) {
				Color c = rectangle.color;
				RenderUtil.draw2DRec(RenderUtil.getBB(rectangle.pos, 1), rectangle.width, c.getRed() / 255, c.getGreen() / 255, c.getBlue() / 255, 1f);
			}
		} catch (Exception ignored) {
			
		}

		}
	}

