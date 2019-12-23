package dev.oruizp.basekotlin.feature.paging.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDBResponse(
    @SerializedName("page") @Expose
    private var page: Int,
    @SerializedName("total_results")
    @Expose
    private val totalMovies: Int,
    @SerializedName("total_pages")
    @Expose
    private val totalPages: Int,
    @SerializedName("results")
    @Expose
    private val Movies: List<Movie> = listOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.createTypedArrayList(Movie)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
        parcel.writeInt(totalMovies)
        parcel.writeInt(totalPages)
        parcel.writeTypedList(Movies)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDBResponse> {
        override fun createFromParcel(parcel: Parcel): MovieDBResponse {
            return MovieDBResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieDBResponse?> {
            return arrayOfNulls(size)
        }
    }
}