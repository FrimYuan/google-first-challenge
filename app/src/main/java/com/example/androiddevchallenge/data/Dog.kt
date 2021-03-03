package com.example.androiddevchallenge.data

import android.os.Parcel
import android.os.Parcelable
import kotlin.random.Random

data class Dog(
    val name: String,
    val species: String,
    val gender: String,
    val location: String,
    val netPhoto: String,
    var isAdopt: Boolean = false,
    val age: Int = Random.nextInt(3) + 1,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(species)
        parcel.writeString(gender)
        parcel.writeString(location)
        parcel.writeString(netPhoto)
        parcel.writeByte(if (isAdopt) 1 else 0)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }

}
