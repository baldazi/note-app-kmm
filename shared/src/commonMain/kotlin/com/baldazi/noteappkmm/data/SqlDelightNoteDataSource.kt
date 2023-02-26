package com.baldazi.noteappkmm.data

import com.baldazi.noteappkmm.database.NoteDatabase
import com.baldazi.noteappkmm.domain.note.Note
import com.baldazi.noteappkmm.domain.note.NoteDataSource
import com.baldazi.noteappkmm.domain.time.DataTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {
    private val query = db.noteQueries
    override suspend fun insertNote(note: Note) {
        query.insertNote(
            note.id, note.title, note.content, note.colorHex,
            DataTimeUtil.toEpochMillis(note.createdAt),
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return query.getNotesById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return query.getALLNotes().executeAsList().map{it.toNote()}
    }

    override suspend fun deleteNoteById(id: Long) {
        query.deleteNote(id)
    }

}