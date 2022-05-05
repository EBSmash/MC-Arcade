package io.ebs.arcade.mixin.mixins;

import io.ebs.arcade.Arcade;
import io.ebs.arcade.event.TickEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {
    @Inject(method = "onUpdate", at = @At("HEAD"))
    public void preUpdate(CallbackInfo ci) {
        TickEvent.Pre event = new TickEvent.Pre();
        Arcade.EVENT_BUS.post(event);
    }

    @Inject(method = "onUpdate", at = @At("TAIL"))
    public void postUpdate(CallbackInfo ci) {
        TickEvent.Post event = new TickEvent.Post();
        Arcade.EVENT_BUS.post(event);
    }
}
