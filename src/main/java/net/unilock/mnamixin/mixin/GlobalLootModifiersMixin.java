package net.unilock.mnamixin.mixin;

import com.mna.ManaAndArtifice;
import com.mna.loot.*;
import com.mna.tools.RLoc;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GlobalLootModifiers.class, remap = false)
public class GlobalLootModifiersMixin {
    @Inject(method = "init", at = @At(value = "HEAD"), cancellable = true)
    private static void register(FMLCommonSetupEvent event, CallbackInfo ci) {
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_spell_staff"), new LootItemFunctionType(new RandomSpellStaff.Serializer())
        );
        /*
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_journal_page"), new LootItemFunctionType(new RandomJournalPage.Serializer())
        );
         */
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_manaweave_recipe"), new LootItemFunctionType(new RandomManaweaveRecipe.Serializer())
        );
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE,
                RLoc.create("random_runescribe_recipe"),
                new LootItemFunctionType(new RandomRunescribeRecipe.Serializer())
        );
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_construct_part"), new LootItemFunctionType(new RandomConstructPart.Serializer())
        );
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE,
                RLoc.create("random_thaumaturgic_link"),
                new LootItemFunctionType(new RandomThaumaturgicLink.Serializer())
        );
        /*
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_joke_spell"), new LootItemFunctionType(new RandomJokeSpell.Serializer())
        );
         */
        Registry.register(
                Registry.LOOT_FUNCTION_TYPE, RLoc.create("random_artifact_spell"), new LootItemFunctionType(new RandomArtifactSpell.Serializer())
        );
        ManaAndArtifice.LOGGER.info("Mana And Artifice >> Registered loot functions");

        ci.cancel();
    }
}
