package edu.temple.Lab_4_Multiple_Activites

import android.os.Parcel
import android.os.Parcelable

/**
 * A data class is used to hold basic information
 * with setters and getters
 */
data class ImageObject (val resourceId: Int, val description: String, val name:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(resourceId)
        parcel.writeString(description)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageObject> {
        override fun createFromParcel(parcel: Parcel): ImageObject {
            return ImageObject(parcel)
        }

        override fun newArray(size: Int): Array<ImageObject?> {
            return arrayOfNulls(size)
        }
    }
}