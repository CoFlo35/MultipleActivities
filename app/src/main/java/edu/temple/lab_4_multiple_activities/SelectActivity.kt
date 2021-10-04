package edu.temple.lab_4_multiple_activities

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = setDataInList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textView = findViewById<TextView>(R.id.textView)


        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            textView.text = items[itemPosition].description
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

    }

    // Test data
    private fun setDataInList(): ArrayList<ImageObject> {
        var items: ArrayList<ImageObject> = ArrayList()

        items.add(ImageObject(R.drawable.australia, "Australia"))
        items.add(ImageObject(R.drawable.brazil, "Brazil"))
        items.add(ImageObject(R.drawable.china, "China"))
        items.add(ImageObject(R.drawable.dubai, "Dubai"))
        items.add(ImageObject(R.drawable.egypt, "Egypt"))
        items.add(ImageObject(R.drawable.france, "France"))
        items.add(ImageObject(R.drawable.india, "India"))
        items.add(ImageObject(R.drawable.italy, "Italy"))
        items.add(ImageObject(R.drawable.new_york, "New York"))
        items.add(ImageObject(R.drawable.rome, "Rome"))
        items.add(ImageObject(R.drawable.russia, "Russia"))
        return items
    }

}