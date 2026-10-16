package com.example.rubymod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {
    // Δημιουργούμε ένα σταθερό σημείο αναφοράς (Instance) για να το χρησιμοποιούμε παντού
    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();

    // 1. Αντοχή (Durability): Πόσα χτυπήματα/σπασίματα αντέχει πριν σπάσει (Diamond = 1561)
    @Override
    public int getDurability() { return 2000; } 

    // 2. Ταχύτητα Εξόρυξης (Mining Speed): Πόσο γρήγορα σπάει τα blocks (Diamond = 8.0f)
    @Override
    public float getMiningSpeedMultiplier() { return 9.0f; } 

    // 3. Bonus Ζημιάς (Attack Damage): Επιπλέον damage όταν χτυπάς entities
    @Override
    public float getAttackDamage() { return 4.0f; } 

    // 4. Επίπεδο Εξόρυξης (Mining Level): Ποια blocks μπορεί να σπάσει (3 = Diamond Level)
    @Override
    public int getMiningLevel() { return 3; } 

    // 5. Enchantability: Πόσο καλές μαγείες παίρνει στο Enchantment Table (Gold = 22, Diamond = 10)
    @Override
    public int getEnchantability() { return 15; }

    // 6. Υλικό Επισκευής (Repair Ingredient): Τι υλικό χρησιμοποιείς στο Anvil για να το επισκευάσεις
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RubyMod.RUBY_GEM);
    }
}