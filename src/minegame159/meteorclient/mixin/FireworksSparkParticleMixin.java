/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_677$class_680
 *  net.minecraft.class_677$class_681
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package minegame159.meteorclient.mixin;

import net.minecraft.class_677;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={class_677.class_681.class})
public class FireworksSparkParticleMixin {
    @Inject(method={"addExplosionParticle"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/particle/FireworksSparkParticle$Explosion;setTrail(Z)V")}, cancellable=true, locals=LocalCapture.CAPTURE_FAILSOFT)
    private void onAddExplosion(double d, double d2, double d3, double d4, double d5, double d6, int[] arrn, int[] arrn2, boolean bl, boolean bl2, CallbackInfo callbackInfo, class_677.class_680 class_6802) {
        if (class_6802 == null) {
            callbackInfo.cancel();
        }
    }
}

