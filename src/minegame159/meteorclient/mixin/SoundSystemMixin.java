/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package minegame159.meteorclient.mixin;

import minegame159.meteorclient.MeteorClient;
import minegame159.meteorclient.events.world.PlaySoundEvent;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1140.class})
public class SoundSystemMixin {
    @Inject(method={"play(Lnet/minecraft/client/sound/SoundInstance;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlay(class_1113 soundInstance, CallbackInfo info) {
        PlaySoundEvent event = MeteorClient.EVENT_BUS.post(PlaySoundEvent.get(soundInstance));
        if (event.isCancelled()) {
            info.cancel();
        }
    }
}

