package com.gildedrose

// Since I don't want to anger the Goblin around the corner, I'll keep the original Item class and add an extension function to it

val Item.type
    get() = ItemType.fromItem(this)

fun Item.age() {
    updateSellIn()
    updateQuality()
}

private fun Item.updateQuality() = type.updateQuality(this)

private fun Item.updateSellIn() = type.updateSellIn(this)