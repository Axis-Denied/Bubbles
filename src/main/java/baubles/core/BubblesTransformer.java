package baubles.core;

import baubles.core.transformers.*;
import net.minecraft.launchwrapper.IClassTransformer;

@SuppressWarnings("unused")
public class BubblesTransformer implements IClassTransformer {

    private boolean isRLArtifact = false;

    public static byte[] applyArtifactsTransforms(String name, String transformedName, byte[] basicClass, boolean isRLArtifact) {
        switch (transformedName) {
            case "artifacts.client.model.layer.LayerAmulet":
                return ArtifactsTransformer.transformLayerAmulet(basicClass, isRLArtifact);
            case "artifacts.client.model.layer.LayerBelt":
                return ArtifactsTransformer.transformLayerBelt(basicClass, isRLArtifact);
            case "artifacts.client.model.layer.LayerCloak":
                return ArtifactsTransformer.transformLayerCloak(basicClass, isRLArtifact);
            case "artifacts.client.model.layer.LayerDrinkingHat":
                return ArtifactsTransformer.transformLayerDrinkingHat(basicClass, isRLArtifact);
            case "artifacts.client.model.layer.LayerGloves":
                return ArtifactsTransformer.transformLayerGloves(basicClass);
            case "artifacts.client.model.layer.LayerNightVisionGoggles":
                return ArtifactsTransformer.transformLayerNightVisionGoggles(basicClass, isRLArtifact);
            case "artifacts.client.model.layer.LayerSnorkel":
                return ArtifactsTransformer.transformLayerSnorkel(basicClass, isRLArtifact);
            case "artifacts.common.item.AttributeModifierBauble":
                return ArtifactsTransformer.transformAttributeModifierBauble(basicClass);
            case "artifacts.common.item.BaubleAmulet":
                return ArtifactsTransformer.transformBaubleAmulet(basicClass, isRLArtifact);
            case "artifacts.common.item.BaubleBottledCloud":
                return ArtifactsTransformer.transformBaubleBottledCloud(basicClass); // Non-RL
            default:
                return basicClass;
        }
    }

    public static byte[] applyBotaniaTransforms(String name, String transformedName, byte[] basicClass) {
        switch (transformedName) {
            case "vazkii.botania.common.item.equipment.bauble.ItemDivaCharm":
                return BotaniaTransformer.transformItemDivaCharm(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemTiara":
                return BotaniaTransformer.transformItemTiara(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemGoddessCharm":
                return BotaniaTransformer.transformItemGoddessCharm(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemHolyCloak":
                return BotaniaTransformer.transformItemHolyCloak(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemMonocle":
                return BotaniaTransformer.transformItemMonocle(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemTravelBelt":
                return BotaniaTransformer.transformItemTravelBelt(basicClass);
            case "vazkii.botania.common.item.equipment.bauble.ItemWaterRing":
                return BotaniaTransformer.transformItemWaterRing(basicClass);
            default:
                return basicClass;
        }
    }

    public static byte[] applyCorailTombstoneTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("ovh.corail.tombstone.compatibility.CompatibilityBaubles"))
            return CorailTombstoneTransformer.transformCompatibilityBaubles(basicClass);
        return basicClass;
    }

    public static byte[] applyCreativeInvTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("net.minecraft.client.gui.inventory.GuiContainerCreative"))
            return CreativeInvTransformer.transformGuiContainerCreative(basicClass);
        return basicClass;
    }

    public static byte[] applyEBWizardryTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("electroblob.wizardry.integration.baubles.WizardryBaublesIntegration"))
            return EBWizardryTransformer.transformWizardryBaublesIntegration(basicClass);
        return basicClass;
    }

    public static byte[] applyEnchantmentTransforms(String name, String transformedName, byte[] basicClass) {
        switch (transformedName) {
            case "net.minecraft.enchantment.Enchantment":
                return EnchantmentTransformer.transformEnchantment(basicClass);
            case "net.minecraft.item.Item":
                return EnchantmentTransformer.transformItem(basicClass);
            default:
                return basicClass;
        }
    }

    public static byte[] applyPotionFingersTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("vazkii.potionfingers.ItemRing"))
            return PotionFingersTransformer.transformItemRing(basicClass);
        return basicClass;
    }

    public static byte[] applyQualityToolsTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("com.tmtravlr.qualitytools.baubles.BaublesHandler"))
            return QualityToolsTransformer.transformBaublesHandler(basicClass);
        return basicClass;
    }

    public static byte[] applyReliquaryTransforms(String name, String transformedName, byte[] basicClass) {
        switch (transformedName) {
            case "xreliquary.items.ItemAngelheartVial":
                return ReliquaryTransformer.transformItemAngelHeartVial(basicClass);
            case "xreliquary.items.ItemPhoenixDown":
                return ReliquaryTransformer.transformItemPhoenixDown(basicClass);
            default:
                return basicClass;
        }
    }

    public static byte[] applySpartanWeaponryTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("com.oblivioussp.spartanweaponry.util.QuiverHelper"))
            return SpartanWeaponryTransformer.transformQuiverHelper(basicClass);
        return basicClass;
    }

    public static byte[] applyTrinketsAndBaublesTransforms(String name, String transformedName, byte[] basicClass) {
        switch (transformedName) {
            case "xzeroair.trinkets.util.compat.baubles.BaublesHelper":
                return TrinketsAndBaublesTransformer.transformBaublesHelper(basicClass);
            case "xzeroair.trinkets.client.gui.TrinketGuiButton":
                return TrinketsAndBaublesTransformer.transformTrinketGuiButton(basicClass);
            case "xzeroair.trinkets.container.TrinketInventoryContainer":
                return TrinketsAndBaublesTransformer.transformTrinketInventoryContainer(basicClass);
            default:
                return basicClass;
        }
    }

    public static byte[] applyWearableBackpacksTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("net.mcft.copy.backpacks.api.BackpackHelper"))
            return WearableBackpacksTransformer.transformBackpackHelper(basicClass);
        return basicClass;
    }

    public static byte[] applyWizardryTransforms(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("com.teamwizardry.wizardry.api.item.BaublesSupport$ArmorAccessor"))
            return WizardryTransformer.BaublesSupport$ArmorAccessor(basicClass);
        return basicClass;
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (transformedName.startsWith("baubles.core.transformers.")) return basicClass;
        if (transformedName.equals("artifacts.Artifacts")) this.isRLArtifact = ArtifactsTransformer.checkArtifacts(basicClass);
        basicClass = applyArtifactsTransforms(name, transformedName, basicClass, this.isRLArtifact); // Artifacts - Fix hardcoded stuff.
        basicClass = applyBotaniaTransforms(name, transformedName, basicClass); // Botania - Fix hardcoded slots.
        basicClass = applyCorailTombstoneTransforms(name, transformedName, basicClass); // Corail Tombstone - Fix drops on death.
        basicClass = applyCreativeInvTransforms(name, transformedName, basicClass); // Minecraft - Make creative inventory delete all action delete items in bauble slots too.
        basicClass = applyEBWizardryTransforms(name, transformedName, basicClass); // Electroblob's Wizardry - Fix bauble items not working.
        basicClass = applyEnchantmentTransforms(name, transformedName, basicClass); // Minecraft - Apply enchants of bauble items.
        basicClass = applyPotionFingersTransforms(name, transformedName, basicClass); // Potion Fingers - Fix hardcoded slots.
        basicClass = applyQualityToolsTransforms(name, transformedName, basicClass); // Quality Tools - Change it to check bauble capability instead of super class and add support for custom bauble types.
        basicClass = applyReliquaryTransforms(name, transformedName, basicClass); // Reliquary - Support reliquary items.
        basicClass = applySpartanWeaponryTransforms(name, transformedName, basicClass); // Spartan Weaponry - Fix Quiver.
        basicClass = applyTrinketsAndBaublesTransforms(name, transformedName, basicClass); // Trinkets and Baubles - Fix crash.
        basicClass = applyWearableBackpacksTransforms(name, transformedName, basicClass); // Wearable Backpacks - Fix casting crash.
        basicClass = applyWizardryTransforms(name, transformedName, basicClass); // Wizardry - Fix bauble items not working.
        return basicClass;
    }
}
