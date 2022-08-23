package com.ansh.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)
        val database2 = ContactDatabase.getDatabase(this)

        GlobalScope.launch{
            database.contactDao().insertContact(Contact(0,"himan","9999", Date(),1))
        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer{
            Log.d("data",it.toString())
            val tv = findViewById<TextView>(R.id.data)
            tv.text = it.toString()
        })
    }
}