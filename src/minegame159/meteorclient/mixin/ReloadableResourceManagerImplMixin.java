/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3298
 *  net.minecraft.class_3304
 *  net.minecraft.class_3306
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package minegame159.meteorclient.mixin;

import minegame159.meteorclient.MeteorClient;
import net.minecraft.class_2960;
import net.minecraft.class_3298;
import net.minecraft.class_3304;
import net.minecraft.class_3306;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_3304.class})
public class ReloadableResourceManagerImplMixin {
    @Inject(method={"getResource"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetResource(class_2960 id, CallbackInfoReturnable<class_3298> info) {
        if (id.method_12836().equals("meteor-client")) {
            info.setReturnValue((Object)new class_3306("meteor-client", id, MeteorClient.class.getResourceAsStream("/assets/meteor-client/" + id.method_12832()), null));
        }
    }
}

