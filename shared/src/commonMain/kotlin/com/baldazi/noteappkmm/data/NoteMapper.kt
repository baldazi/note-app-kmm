package com.baldazi.noteappkmm.data

import com.baldazi.noteappkmm.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        createdAt = Instant.fromEpochMilliseconds(createdAt)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}