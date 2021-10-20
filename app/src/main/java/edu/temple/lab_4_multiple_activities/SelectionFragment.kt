package edu.temple.lab_4_multiple_activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageAdapter
import edu.temple.Lab_4_Multiple_Activites.ImageObject
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SelectionFragment(var items:ArrayList<ImageObject>) : Fragment() {

    lateinit var layout: View
    lateinit var recyclerView: RecyclerView
    //var items = setDataInList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        recyclerView = layout.findViewById(R.id.recyclerView)

        recyclerView.adapter = ImageAdapter(items, onClickListener)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)


        return layout
    }


    val onClickListener = View.OnClickListener {
        val itemPosition = recyclerView.getChildAdapterPosition(it)

        //pull off all values to be sent to the response activity
        val name = items.get(itemPosition).name
        val image = items.get(itemPosition).resourceId
        val description = items.get(itemPosition).description
    }



 /*
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

    */



    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */
}