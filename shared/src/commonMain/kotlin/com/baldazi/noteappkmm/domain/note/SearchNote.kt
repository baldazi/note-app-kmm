package com.baldazi.noteappkmm.domain.note

import com.baldazi.noteappkmm.domain.time.DataTimeUtil
class SearchNote {
    fun execute(notes: List<Note>, query: String): List<Note> {
        if (query.isBlank()) {
            return notes
        }
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase())||
                it.content.trim().lowercase().contains(query.lowercase())
        }.sortedBy {
            DataTimeUtil.toEpochMillis(it.createdAt)
        }
    }
}