package edu.gatech.cs2340.spacetrader.models
import android.os.Parcel
import android.os.Parcelable

class user(val username: String, val password: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    fun checkPasswordStrength(): Int {
        return checkPasswordStrength(password)
    }

    //constructor() : this("", "")

    //constructor(username: String): this(username, password)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<user> {
        override fun createFromParcel(parcel: Parcel): user {
            return user(parcel)
        }

        override fun newArray(size: Int): Array<user?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        fun checkPasswordStrength(password: String):Int {
            var passwordStrength = 0
            if (password.length >= 8) {
                passwordStrength++
            }

            if ((Regex("[~@#$%^&*:;<>.,/}{+]")).containsMatchIn(password)) {
                passwordStrength++
            }

            if ((Regex("[0-9]")).containsMatchIn(password)) {
                passwordStrength++
            }

            if (password.compareTo(password.toLowerCase()) != 0 && password.compareTo(password.toUpperCase()) != 0) {
                passwordStrength++
            }

            return passwordStrength

        }
    }
}
