package com.example.rubymod;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.HoeItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class RubyMod implements ModInitializer {
    public static final String MOD_ID = "rubymod";

    public static final Item RUBY_GEM = new Item(new Item.Settings());
    public static final Block RUBY_ORE = new Block(AbstractBlock.Settings.create().strength(4.0f));
    public static final Item RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());
    public static final Block RUBY_BLOCK = new Block(AbstractBlock.Settings.create().strength(5.0f).requiresTool());
    public static final Item RUBY_BLOCK_ITEM = new BlockItem(RUBY_BLOCK, new Item.Settings());

    public static final Item RUBY_SWORD = new SwordItem(RubyToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings());
    public static final Item RUBY_AXE = new AxeItem(RubyToolMaterial.INSTANCE, 6.0f, -3.0f, new Item.Settings());
    public static final Item RUBY_SHOVEL = new ShovelItem(RubyToolMaterial.INSTANCE, 1.5f, -3.0f, new Item.Settings());
    public static final Item RUBY_HOE = new HoeItem(RubyToolMaterial.INSTANCE, -2, -0.0f, new Item.Settings());

    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(
        RegistryKeys.PLACED_FEATURE, 
        new Identifier(MOD_ID, "ruby_ore_placed")
    );

    public static final ItemGroup RUBY_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier(MOD_ID, "ruby_group"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.rubymod.ruby_group"))
            .icon(() -> new ItemStack(RUBY_GEM))
            .entries((displayContext, entries) -> {
                entries.add(RUBY_GEM);
                entries.add(RUBY_ORE);
                entries.add(RUBY_PICKAXE);
                entries.add(RUBY_BLOCK);
                entries.add(RUBY_SWORD);
                entries.add(RUBY_AXE);
                entries.add(RUBY_SHOVEL);
                entries.add(RUBY_HOE);
            })
            .build()
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby"), RUBY_GEM);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);
        
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings()));

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK_ITEM);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_axe"), RUBY_AXE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_hoe"), RUBY_HOE);

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RUBY_ORE_PLACED_KEY
        );
        
    }
}