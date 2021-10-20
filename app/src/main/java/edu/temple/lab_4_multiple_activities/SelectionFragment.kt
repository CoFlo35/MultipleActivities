package edu.temple.lab_4_multiple_activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.Lab_4_Multiple_Activites.ImageAdapter
import edu.temple.Lab_4_Multiple_Activites.ImageObject
import org.w3c.dom.Text
import java.lang.Exception
import java.security.AccessController.getContext
import java.util.List.of

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var items:ArrayList<ImageObject>

class SelectionFragment() : Fragment() {

    lateinit var viewModel:SharedViewModel
    lateinit var layout: View
    lateinit var recyclerView: RecyclerView



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

        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        return layout
    }

    val onClickListener = View.OnClickListener {

        val itemPosition = recyclerView.getChildAdapterPosition(it)

        //pull off all values to be sent to the response activity
        val name = items.get(itemPosition).name
        val image = items.get(itemPosition).resourceId
        viewModel.setName(name)
        viewModel.setImage(image)
        DisplayFragment.updateDisplay(name,image)

        //val image = items.get(itemPosition).resourceId
        //val description = items.get(itemPosition).description





    }


    companion object {
        fun newInstance(_items: ArrayList<ImageObject>) =
            SelectionFragment().apply {
                items = _items
            }

    }


}