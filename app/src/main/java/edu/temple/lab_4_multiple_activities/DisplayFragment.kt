package edu.temple.lab_4_multiple_activities

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


lateinit var layout:View
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    private  var viewModel: SharedViewModel = SharedViewModel()
    var name : String? = null
    var image : Int = R.drawable.app_icon.toInt()

class DisplayFragment() : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = inflater.inflate(R.layout.fragment_display, container, false)

        textView = layout.findViewById(R.id.display_textViewName)
        imageView = layout.findViewById(R.id.displayImageView)
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        name = "Select a Location"
        textView.text = name
        imageView.setImageResource(image)


        return layout
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DisplayFragment.
         */
        // TODO: Rename and change types and number of parameters
       // @JvmStatic

        fun updateDisplay(_name:String, _image:Int){
            textView.text = _name
            imageView.setImageResource(_image)

        }


    }






}