package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEach { it.age() }
    }

}

