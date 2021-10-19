package edu.temple.lab_4_multiple_activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageObject


class SelectionFragment : Fragment() {
    lateinit var recylcerView: RecyclerView
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

        recylcerView.adapter = ImageAdapter(items)
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
}