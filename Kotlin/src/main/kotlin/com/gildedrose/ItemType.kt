package com.gildedrose

enum class ItemType {
    NORMAL,
    AGED_BRIE {
        override fun updateQuality(item: Item) {
            val qualityAging = if (item.sellIn < 0) 2 else 1
            val newQuality = item.quality + qualityAging
            item.quality = newQuality.coerceIn(0, 50)
        }
    },
    LEGENDARY {
        override fun updateQuality(item: Item) {
            return // Legendary items never change
        }

        override fun updateSellIn(item: Item) {
            return // Legendary items never change
        }
    },
    BACKSTAGE_PASS {
        override fun updateQuality(item: Item) {
            val qualityAging = when {
                item.sellIn < 0 -> -item.quality
                item.sellIn < 5 -> 3
                item.sellIn < 10 -> 2
                else -> 1
            }
            val newQuality = item.quality + qualityAging
            item.quality = newQuality.coerceIn(0, 50)
        }
    },
    CONJURED;

    open fun updateQuality(item: Item) {
        val qualityAging = if (item.sellIn < 0) 2 else 1
        val newQuality = item.quality - qualityAging
        item.quality = newQuality.coerceIn(0, 50)
    }

    open fun updateSellIn(item: Item) {
        item.sellIn -= 1
    }

    companion object {
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