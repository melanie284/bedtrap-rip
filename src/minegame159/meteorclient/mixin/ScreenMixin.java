/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_310
 *  net.minecraft.class_339
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package minegame159.meteorclient.mixin;

import java.util.List;
import minegame159.meteorclient.MeteorClient;
import minegame159.meteorclient.events.game.GetTooltipEvent;
import minegame159.meteorclient.systems.modules.Modules;
import minegame159.meteorclient.systems.modules.render.NoRender;
import minegame159.meteorclient.utils.Utils;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_339;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_437.class})
public abstract class ScreenMixin {
    @Shadow
    public int field_22789;
    @Shadow
    public int field_22790;
    @Shadow
    @Nullable
    protected class_310 field_22787;

    @Shadow
    protected <T extends class_339> T method_25411(T button) {
        return null;
    }

    @Shadow
    public abstract void method_25393();

    @Inject(method={"renderBackground(Lnet/minecraft/client/util/math/MatrixStack;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderBackground(CallbackInfo info) {
        if (Utils.canUpdate() && Modules.get().get(NoRender.class).noGuiBackground()) {
            info.cancel();
        }
    }

    @ModifyArgs(method={"renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/item/ItemStack;II)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Ljava/util/List;II)V"))
    private void getList(Args args, class_4587 matrixStack, class_1799 itemStack, int x, int y) {
        GetTooltipEvent.Modify event = MeteorClient.EVENT_BUS.post(GetTooltipEvent.Modify.get(itemStack, (List)args.get(1), matrixStack, x, y));
        args.set(0, (Object)event.matrixStack);
        args.set(1, (Object)event.list);
        args.set(2, (Object)event.x);
        args.set(3, (Object)event.y);
    }
}

