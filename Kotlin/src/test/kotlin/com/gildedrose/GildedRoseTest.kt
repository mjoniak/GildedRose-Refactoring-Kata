package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `conjured items degrade twice as fast`() {
        val app = GildedRose(listOf(
            Item("Conjured Cheese", 1, 20),
            Item("Conjured Headphones", 0, 20)
        ))

        app.updateQuality()

        assertEquals(18, app.items[0].quality)
        assertEquals(16, app.items[1].quality)
    }
}


