package edu.temple.lab_4_multiple_activities

import android.app.backup.BackupManager.dataChanged
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
     var  name : MutableLiveData<String> = MutableLiveData()
     var image : MutableLiveData<Int>? = MutableLiveData()

    fun setName(_name: String){
        name.value = _name
    }

    fun setImage(_image:Int){
        image?.value = _image
    }

    fun getName():LiveData<String>{
        return name
    }

    fun getImage():LiveData<Int>{
        return image!!
    }


}