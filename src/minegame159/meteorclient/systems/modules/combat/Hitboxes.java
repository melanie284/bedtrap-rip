/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2BooleanMap
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 */
package minegame159.meteorclient.systems.modules.combat;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import minegame159.meteorclient.settings.DoubleSetting;
import minegame159.meteorclient.settings.EntityTypeListSetting;
import minegame159.meteorclient.settings.Setting;
import minegame159.meteorclient.settings.SettingGroup;
import minegame159.meteorclient.systems.modules.Categories;
import minegame159.meteorclient.systems.modules.Module;
import minegame159.meteorclient.utils.Utils;
import net.minecraft.class_1297;
import net.minecraft.class_1299;

public class Hitboxes
extends Module {
    private final /* synthetic */ Setting<Object2BooleanMap<class_1299<?>>> entities;
    private final /* synthetic */ Setting<Double> value;
    private final /* synthetic */ SettingGroup sgGeneral;

    public Hitboxes() {
        super(Categories.Combat, "hitboxes", "Expands an entity's hitboxes.");
        Hitboxes llllllllllllllllllIIIIllllllllll;
        llllllllllllllllllIIIIllllllllll.sgGeneral = llllllllllllllllllIIIIllllllllll.settings.getDefaultGroup();
        llllllllllllllllllIIIIllllllllll.entities = llllllllllllllllllIIIIllllllllll.sgGeneral.add(new EntityTypeListSetting.Builder().name("entities").description("Which entities to target.").defaultValue((Object2BooleanMap<class_1299<?>>)Utils.asObject2BooleanOpenHashMap(new class_1299[]{class_1299.field_6097})).build());
        llllllllllllllllllIIIIllllllllll.value = llllllllllllllllllIIIIllllllllll.sgGeneral.add(new DoubleSetting.Builder().name("expand").description("How much to expand the hitbox of the entity.").defaultValue(0.5).build());
    }

    public double getEntityValue(class_1297 llllllllllllllllllIIIIlllllllIlI) {
        Hitboxes llllllllllllllllllIIIIlllllllIll;
        if (!llllllllllllllllllIIIIlllllllIll.isActive()) {
            return 0.0;
        }
        if (llllllllllllllllllIIIIlllllllIll.entities.get().getBoolean((Object)llllllllllllllllllIIIIlllllllIlI.method_5864())) {
            return llllllllllllllllllIIIIlllllllIll.value.get();
        }
        return 0.0;
    }
}

