package com.aritra.notify.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aritra.notify.domain.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    /**
     *  method for insert the note
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: Note): Long

    /**
     * method for make it as descending order
     */
    @Query("SELECT * FROM note ORDER BY dateTime DESC")
    fun getAllNotesFlow(): Flow<List<Note>>

    /**
     * delete all the notes in the not
     */
    @Query("DELETE FROM note")
    suspend fun clear()

    /**
     * method for make it as descending order
     */
    @Query("SELECT * FROM note ORDER BY dateTime DESC")
    suspend fun getAllNotes(): List<Note>

    /**
     * method for delete the note
     */
    @Query("DELETE FROM note WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: Int)

    /**
     * method for get the note by id
     */
    @Query("SELECT * FROM note WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): Note?

    /**
     * method for insert list of notes
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfNotes(noteModels: List<Note>): List<Long>

    /**
     * method for update the notes
     */
    @Update
    suspend fun updateNote(noteModel: Note)

    /**
     *  method for delete the note
     */
    @Delete
    suspend fun deleteNote(noteModel: Note)

    /**
     *  method for delete the list of the notes
     */
    @Delete
    suspend fun deleteListOfNote(noteModel: List<Note>)

    /**
     * method for get the note by id
     */
    @Query("SELECT * FROM note WHERE id = :noteId")
    fun getNoteByIdFlow(noteId: Int): Flow<Note?>

}
