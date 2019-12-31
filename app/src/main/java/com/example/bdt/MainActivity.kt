package com.example.bdt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bdNewModel: bdNewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = bdAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            bdDatabase::class.java, "birthday_database"
//        ).build()
        val testing = bdDatabase.getInstance(application)
     //   testing.insertDB( DB(1,"asd","asd"))


        fab.setOnClickListener {
            val intent = Intent(this,addActivity::class)
            startActivityForResult(intent,REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val _name :String? = data?.getStringExtra(addActivity.EXTRA_NAME)
                val _dob : Long? = data?.getLongExtra(addActivity.EXTRA_DOB,0)
                val bd: DB = DB(id = 0, name = _name!!,dob = _dob!! )
                bdNewModel = ViewModelProvider(this).get(bdNewModel :: class.java)
                bdNewModel.allBDs.observe(this,)
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    companion object{
        const val REQUEST_CODE = 1
    }
}
