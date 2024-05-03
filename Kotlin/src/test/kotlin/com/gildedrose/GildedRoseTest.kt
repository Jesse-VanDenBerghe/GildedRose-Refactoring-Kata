package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Nested
    @DisplayName("Test that was already in the original code which I'm not sure if I should rename or keep it")
    inner class OriginalTest {
        @Test
        fun foo() {
            val items = listOf(Item("foo", 0, 0))
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals("foo", app.items[0].name)
        }
    }

    @Nested
    inner class Requirements {

        @Nested
        @DisplayName("Once the sell by date has passed, Quality degrades twice as fast")
        inner class UpdatedQualityAfterSellInDate{

            @Test
            fun `Quality degrades normally before sellIn date`() {
                val items = listOf(Item("foo", 1, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(9, app.items[0].quality)
            }

            @Test
            fun `Quality degrades twice as fast on sellIn date`() {
                val items = listOf(Item("foo", 0, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(8, app.items[0].quality)
            }

            @Test
            fun `Quality degrades twice as fast after sellIn date`() {
                val items = listOf(Item("foo", -1, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(8, app.items[0].quality)
            }
        }

        @Nested
        @DisplayName("The Quality of an item is never negative")
        inner class QualityNeverNegative {

            @Test
            fun `Quality should decrease normally`() {
                val items = listOf(Item("foo", 1, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(9, app.items[0].quality)
            }

            @Test
            fun `Quality should not drop below 0`() {
                val items = listOf(Item("foo", 1, 0))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(0, app.items[0].quality)
            }

            @Test
            //This test failed on the original code, but I added it since the requirement said it should NEVER be negative
            fun `Quality should never be negative`() {
                val items = listOf(Item("foo", 1, -1))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(0, app.items[0].quality)
            }
        }

        @Nested
        @DisplayName("Aged Brie actually increases in Quality the older it gets")
        inner class AgedBrieQualityIncrease {

            @Test
            fun `Aged Brie increases in quality`() {
                val items = listOf(Item("Aged Brie", 1, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(11, app.items[0].quality)
            }

            @Test
            // This was not written in the requirements, but I added it since it was present in the original code
            fun `Aged Brie increases in quality twice as fast after sellIn date`() {
                val items = listOf(Item("Aged Brie", 0, 10))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(12, app.items[0].quality)
            }

            @Test
            fun `Aged Brie quality should not exceed 50`() {
                val items = listOf(Item("Aged Brie", 1, 50))
                val app = GildedRose(items)
                app.updateQuality()
                assertEquals(50, app.items[0].quality)
            }
        }

    }

}


