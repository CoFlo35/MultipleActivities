package edu.temple.lab_4_multiple_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        //change the title of the actionbar to make it unqiue
        getSupportActionBar()!!.setTitle("Destination Display")
    }
}