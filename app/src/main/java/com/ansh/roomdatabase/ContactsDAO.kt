package com.ansh.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactsDAO{
    @Insert
   suspend fun insertContact(contact: Contact)

  @Delete
    suspend fun deleteContact(contact: Contact)

  @Update
    suspend fun updateContact(contact: Contact)

  @Query("SELECT * FROM contact")
    suspend fun getContact(): LiveData<List<Contact>>


}
