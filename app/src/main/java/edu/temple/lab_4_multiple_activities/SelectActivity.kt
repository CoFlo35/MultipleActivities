package edu.temple.lab_4_multiple_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageAdapter
import edu.temple.Lab_4_Multiple_Activites.ImageObject

class SelectActivity : AppCompatActivity() {
    lateinit var fragment1 : DisplayFragment
    lateinit var fragment2 : SelectionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the list of objects
        val items = setDataInList()

        fragment1 = DisplayFragment()
        fragment2 = SelectionFragment(items)

        supportFragmentManager.beginTransaction()
           .add(R.id.container2, fragment1)
           .add(R.id.container1, fragment2)
            .commit()




        // val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        //change the title of the actionbar to be unique
        getSupportActionBar()!!.setTitle("Destination Image Viewer App")

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members

/*

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            //pull off all values to be sent to the response activity
            val name = items.get(itemPosition).name
            val image = items.get(itemPosition).resourceId
            val description = items.get(itemPosition).description
            //create the intent of the second activity to be triggered
            val intent = Intent(this, DisplayActivity::class.java)

            //add all values of chosen image to the intent
            intent.putExtra("Name", name)
            intent.putExtra("Image", image)
            intent.putExtra("Description",description)
            //start the response activity
            startActivity(intent)


        }


        //apply the adapter and layout manager to the recyclerView
        //Add in item Decoration to make a divider that seperates the photos in the grid verically(Horizontal line)
        recyclerView.apply {
            recyclerView.adapter = ImageAdapter(items, onClickListener)
            recyclerView.layoutManager = GridLayoutManager(this.context, 3)
            var itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(getDrawable(R.drawable.divider)!!)
            recyclerView.addItemDecoration(itemDecoration)

        }
        */



    }

    // Test data
    private fun setDataInList(): ArrayList<ImageObject> {
        var items: ArrayList<ImageObject> = ArrayList()
        val destinationName = this.resources.getStringArray(R.array.Destination_Names)
        val destinationDescription = this.resources.getStringArray(R.array.Destination_Description)

        items.add(ImageObject(R.drawable.australia, destinationDescription[0].toString(),destinationName[0].toString()))
        items.add(ImageObject(R.drawable.brazil,destinationDescription[1].toString(), destinationName[1].toString()))
        items.add(ImageObject(R.drawable.china,destinationDescription[2], destinationName[2]))
        items.add(ImageObject(R.drawable.dubai,destinationDescription[3], destinationName[3]))
        items.add(ImageObject(R.drawable.egypt,destinationDescription[4], destinationName[4]))
        items.add(ImageObject(R.drawable.france,destinationDescription[5], destinationName[5]))
        items.add(ImageObject(R.drawable.india,destinationDescription[6],destinationName[6]))
        items.add(ImageObject(R.drawable.italy,destinationDescription[7], destinationName[7]))
        items.add(ImageObject(R.drawable.new_york,destinationDescription[8],destinationName[8]))
        items.add(ImageObject(R.drawable.rome,destinationDescription[9], destinationName[9]))
        items.add(ImageObject(R.drawable.russia,destinationDescription[10], destinationName[10]))
        return items
    }



}