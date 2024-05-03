package com.gildedrose

enum class ItemType {
    NORMAL, AGED_BRIE, LEGENDARY, BACKSTAGE_PASS, CONJURED;

    open fun updateQuality(item: Item){
        val newQuality = item.quality - 1
        item.quality = newQuality.coerceIn(0, 50)
    }

    open fun updateSellIn(item: Item){
        item.sellIn -= 1
    }

    companion object{
        private val LEGENDARY_ITEMS = listOf(
            "Sulfuras, Hand of Ragnaros"
        )

        fun fromItem(item: Item): ItemType = when {
            item.name in LEGENDARY_ITEMS -> LEGENDARY
            item.name == "Aged Brie" -> AGED_BRIE
            item.name.contains("Backstage pass") -> BACKSTAGE_PASS
            item.name.contains("Conjured") -> CONJURED
            else -> ItemType.NORMAL
        }
    }
}