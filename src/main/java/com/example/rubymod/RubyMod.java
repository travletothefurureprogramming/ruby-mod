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

public class RubyMod implements ModInitializer {
    // Το μοναδικό αναγνωριστικό του mod σου (χρησιμοποιείται στα namespaces)
    public static final String MOD_ID = "rubymod";

    // 1. Δημιουργία του αντικειμένου Ruby Gem
    public static final Item RUBY_GEM = new Item(new Item.Settings());

    // 2. Δημιουργία του Block "Ruby Ore" με σκληρότητα 4.0 (Diamond Ore = 3.0)
    public static final Block RUBY_ORE = new Block(AbstractBlock.Settings.create().strength(4.0f));

    // 3. Δημιουργία της Ruby Αξίνας (Pickaxe)
    // Παράμετροι: Material, Bonus Attack Damage (1), Attack Speed (-2.8f), Item Settings
    public static final Item RUBY_PICKAXE = new PickaxeItem(RubyToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());

    @Override
    public void onInitialize() {
        // --- REGISTRATION (ΕΓΓΡΑΦΗ ΣΤΗ ΜΗΧΑΝΗ ΤΟΥ MINECRAFT) ---

        // Εγγράφουμε το Ruby Gem με ID "rubymod:ruby"
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby"), RUBY_GEM);

        // Εγγράφουμε την αξίνα με ID "rubymod:ruby_pickaxe"
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);

        // Εγγράφουμε το ίδιο το Block στον κόσμο
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);

        // Εγγράφουμε το Block ως Item, ώστε να μπορείς να το κρατάς στο inventory σου
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings()));
    }
}