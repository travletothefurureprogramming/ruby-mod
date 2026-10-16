package com.example.rubymod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {
    public static final RubyToolMaterial INSTANCE = new RubyToolMaterial();

    @Override
    public int getDurability() { return 2000; } 

    @Override
    public float getMiningSpeedMultiplier() { return 9.0f; } 

    @Override
    public float getAttackDamage() { return 4.0f; } 

    @Override
    public int getMiningLevel() { return 3; } 

    @Override
    public int getEnchantability() { return 15; }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RubyMod.RUBY_GEM);
    }
}