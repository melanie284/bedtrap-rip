/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2635
 */
package minegame159.meteorclient.systems.modules.bedtrap;

import meteordevelopment.orbit.EventHandler;
import minegame159.meteorclient.events.packets.PacketEvent;
import minegame159.meteorclient.settings.Setting;
import minegame159.meteorclient.settings.SettingGroup;
import minegame159.meteorclient.settings.StringSetting;
import minegame159.meteorclient.systems.modules.Categories;
import minegame159.meteorclient.systems.modules.Module;
import net.minecraft.class_2635;

public class AutoLogin
extends Module {
    private final /* synthetic */ SettingGroup autoLogin;
    private final /* synthetic */ Setting<String> loginText;

    @EventHandler
    public void onPacket(PacketEvent.Receive lllllllllllllllllllllIllIIIIIllI) {
        String[] lllllllllllllllllllllIllIIIIlIII;
        if (!(lllllllllllllllllllllIllIIIIIllI.packet instanceof class_2635)) {
            return;
        }
        String lllllllllllllllllllllIllIIIIlIIl = ((class_2635)lllllllllllllllllllllIllIIIIIllI.packet).method_11388().getString();
        for (String lllllllllllllllllllllIllIIIIllII : lllllllllllllllllllllIllIIIIlIII = new String[]{"/l"}) {
            AutoLogin lllllllllllllllllllllIllIIIIlIll;
            if (!lllllllllllllllllllllIllIIIIlIIl.contains(lllllllllllllllllllllIllIIIIllII)) continue;
            lllllllllllllllllllllIllIIIIlIll.mc.field_1724.method_3142(String.valueOf(new StringBuilder().append("/login ").append(lllllllllllllllllllllIllIIIIlIll.loginText)));
            break;
        }
    }

    public AutoLogin() {
        super(Categories.BedTrap, "auto-login", "Sends /login on cracked servers.");
        AutoLogin lllllllllllllllllllllIllIIIlIlIl;
        lllllllllllllllllllllIllIIIlIlIl.autoLogin = lllllllllllllllllllllIllIIIlIlIl.settings.createGroup("Auto Login");
        lllllllllllllllllllllIllIIIlIlIl.loginText = lllllllllllllllllllllIllIIIlIlIl.autoLogin.add(new StringSetting.Builder().name("password").description("/login *pass*").defaultValue("qwerty").build());
    }
}

