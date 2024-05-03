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
    @DisplayName("Requirements to test")
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

    }

}


