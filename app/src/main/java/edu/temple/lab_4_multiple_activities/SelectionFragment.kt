package edu.temple.lab_4_multiple_activities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageAdapter
import edu.temple.Lab_4_Multiple_Activites.ImageObject


class SelectionFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var layout : View
    val items = setDataInList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        recyclerView = layout.findViewById(R.id.recyclerView)

        recyclerView.adapter = ImageAdapter(items,onClickListener )
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        return layout
    }

    val onClickListener = View.OnClickListener {
        val itemPosition = recyclerView.getChildAdapterPosition(it)

        //pull off all values to be sent to the response activity
        val name = items.get(itemPosition).name
        val image = items.get(itemPosition).resourceId
        val description = items.get(itemPosition).description
        //create the intent of the second activity to be triggered



    }

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

    companion object{
        fun getInstance():SelectionFragment{
            val fragment = SelectionFragment()
            return fragment
        }
    }
}