package com.example.rubymod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class RubyMod implements ModInitializer {
    public static final String MOD_ID = "rubymod";

    public static final Item RUBY_GEM = new Item(new Item.Settings());

    public static final Block RUBY_ORE = new Block(AbstractBlock.Settings.create().strength(4.0f));

    public static final Item RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());

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
            })
            .build()
    );
    
    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby"), RUBY_GEM);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings()));
    }
}