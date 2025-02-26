package com.Fishmod.mod_LavaCow.blocks;

import com.Fishmod.mod_LavaCow.mod_LavaCow;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBasic extends Block {

	public BlockBasic(String name, Material material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
	}
	
    public static Item setItemName(Item parItem, String parItemName)
    {
        parItem.setRegistryName(parItemName);
        parItem.setTranslationKey(parItemName);
        return parItem;
    }
	
    public static Block setBlockName(Block parBlock, String parBlockName)
    {
        parBlock.setRegistryName(parBlockName);
        parBlock.setTranslationKey(mod_LavaCow.MODID + "." + parBlockName);
        return parBlock;
    }
}
