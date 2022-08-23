package com.ansh.roomdatabase

import androidx.room.TypeConverters
import java.util.*

class Converters {
@TypeConverters
    fun fromDateToLong(value:Date):Long{

        return value.time
    }
    @TypeConverters
    fun fromLongToDate(value:Long):Date{
        return Date(value)
    }
}