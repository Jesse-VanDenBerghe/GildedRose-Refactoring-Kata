package com.gildedrose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ItemTypeTest{

    @Nested
    @DisplayName("ItemType.fromItem(item: Item)")
    inner class ItemTypeFormItemTest{

        @Test
        fun `should return LEGENDARY when item name is Sulfuras, Hand of Ragnaros`(){
            val item = Item("Sulfuras, Hand of Ragnaros", 0, 0)
            assertEquals(ItemType.LEGENDARY, ItemType.fromItem(item))
        }

        @Test
        fun `should return AGED_BRIE when item name is Aged Brie`(){
            val item = Item("Aged Brie", 0, 0)
            assertEquals(ItemType.AGED_BRIE, ItemType.fromItem(item))
        }

        @Test
        fun `should return BACKSTAGE_PASS when item name contains Backstage pass`(){
            val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)
            assertEquals(ItemType.BACKSTAGE_PASS, ItemType.fromItem(item))
        }

        @Test
        fun `should return CONJURED when item name contains Conjured`(){
            val item = Item("Conjured", 0, 0)
            assertEquals(ItemType.CONJURED, ItemType.fromItem(item))
        }

        @Test
        fun `should return NORMAL when item name is not any of the special cases`(){
            val item = Item("foo", 0, 0)
            assertEquals(ItemType.NORMAL, ItemType.fromItem(item))
        }

    }

}