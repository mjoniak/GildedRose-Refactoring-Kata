package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.filterNot { it.isLegendary }) {
            item.sellIn -= 1
            item.quality = item.nextQuality()
        }
    }

    private fun Item.nextQuality() = when {
        name == AGED_BRIE -> when {
            sellIn < 0 -> quality + 2
            else -> quality + 1
        }
        name == BACKSTAGE_PASSES -> when {
            sellIn < 0 -> 0
            sellIn < 5 -> quality + 3
            sellIn < 10 -> quality + 2
            else -> quality + 1
        }
        name.startsWith(CONJURED_PREFIX) -> when {
            sellIn < 0 -> quality - 4
            else -> quality - 2
        }
        else -> when {
            sellIn < 0 -> quality - 2
            else -> quality - 1
        }
    }.coerceIn(MIN_QUALITY, MAX_QUALITY)

    private val Item.isLegendary
        get() = name == SULFURAS

    companion object {
        private const val AGED_BRIE = "Aged Brie"
        private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val CONJURED_PREFIX = "Conjured"

        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 50
    }
}

