package com.submission.bts.model

import android.os.Parcel
import android.os.Parcelable

data class TempatWisata(
    var img: String,
    var name: String,
    var open: String,
    var address: String,
    var description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
        parcel.writeString(name)
        parcel.writeString(open)
        parcel.writeString(address)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TempatWisata> {
        override fun createFromParcel(parcel: Parcel): TempatWisata {
            return TempatWisata(parcel)
        }

        override fun newArray(size: Int): Array<TempatWisata?> {
            return arrayOfNulls(size)
        }
    }
}
