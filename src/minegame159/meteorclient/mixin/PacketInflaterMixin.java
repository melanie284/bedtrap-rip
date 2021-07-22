/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.DecoderException
 *  net.minecraft.class_2532
 *  net.minecraft.class_2540
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package minegame159.meteorclient.mixin;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import minegame159.meteorclient.systems.modules.Modules;
import minegame159.meteorclient.systems.modules.misc.AntiPacketKick;
import net.minecraft.class_2532;
import net.minecraft.class_2540;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2532.class})
public class PacketInflaterMixin {
    @Shadow
    private int field_11623;
    @Shadow
    @Final
    private Inflater field_11622;

    @Inject(method={"decode"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list, CallbackInfo callbackInfo) throws DataFormatException {
        block3: {
            int n;
            class_2540 class_25402;
            block4: {
                block2: {
                    if (!Modules.get().isActive(AntiPacketKick.class)) break block2;
                    callbackInfo.cancel();
                    if (byteBuf.readableBytes() == 0) break block3;
                    class_25402 = new class_2540(byteBuf);
                    n = class_25402.method_10816();
                    if (n != 0) break block4;
                    list.add((Object)class_25402.readBytes(class_25402.readableBytes()));
                    break block3;
                }
                return;
            }
            if (n < this.field_11623) {
                throw new DecoderException("Badly compressed packet - size of " + n + " is below server threshold of " + this.field_11623);
            }
            if (n > 0x200000) {
                throw new DecoderException("Badly compressed packet - size of " + n + " is larger than protocol maximum of " + 0x200000);
            }
            byte[] arrby = new byte[class_25402.readableBytes()];
            class_25402.readBytes(arrby);
            this.field_11622.setInput(arrby);
            byte[] arrby2 = new byte[n];
            this.field_11622.inflate(arrby2);
            list.add((Object)Unpooled.wrappedBuffer((byte[])arrby2));
            this.field_11622.reset();
        }
    }
}

