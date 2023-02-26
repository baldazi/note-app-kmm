package com.baldazi.noteappkmm.domain.note

import com.baldazi.noteappkmm.presentation.*
import kotlinx.datetime.LocalDateTime

class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val createdAt: LocalDateTime
) {
    companion object {
        private val colors = listOf(
            RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, violetHex
        )

        fun generateRandomColor() = colors.random()
    }
}