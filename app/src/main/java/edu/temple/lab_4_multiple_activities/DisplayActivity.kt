package edu.temple.lab_4_multiple_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        //change the title of the actionbar to make it unqiue
        getSupportActionBar()!!.setTitle("Destination Decription")

        //grab a reference to each display element on the layout
        val imageView = findViewById<ImageView>(R.id.display_imageView)
        val displayName = findViewById<TextView>(R.id.display_textViewName)
        val descView = findViewById<TextView>(R.id.display_textViewDescription)

        //get the extras that were put into intent
        val intent =getIntent().getExtras()
        //set all values to be displayed
        val name = intent!!.getString("Name")
        val image = intent!!.getInt("Image")
        val desc = intent!!.getString("Description")

        //display all values into their respective Views
        imageView.setImageResource(image)
        displayName.text = name
        descView.text = desc

    }
}