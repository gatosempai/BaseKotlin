package dev.oruizp.basekotlin.feature.paging.model

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import dev.oruizp.basekotlin.R
import java.util.*

data class Movie(
    @SerializedName("vote_count") @Expose
    private var voteCount: Int? = null,
    @SerializedName("id") @Expose
    private val id: Int? = null,
    @SerializedName("video")
    @Expose
    private val video: Boolean? = null,
    @SerializedName("vote_average")
    @Expose
    private val voteAverage: Double? = null,
    @SerializedName("title")
    @Expose
    private val title: String? = null,
    @SerializedName("popularity")
    @Expose
    private val popularity: Double? = null,
    @SerializedName("poster_path")
    @Expose
    private val posterPath: String? = null,
    @SerializedName("original_language")
    @Expose
    private val originalLanguage: String? = null,
    @SerializedName("original_title")
    @Expose
    private val originalTitle: String? = null,
    @SerializedName("genre_ids")
    @Expose
    private val genreIds: List<Int> = ArrayList(),
    @SerializedName("backdrop_path")
    @Expose
    private val backdropPath: String? = null,
    @SerializedName("adult")
    @Expose
    private val adult: Boolean? = null,
    @SerializedName("overview")
    @Expose
    private val overview: String? = null,
    @SerializedName("release_date")
    @Expose
    private val releaseDate: String? = null,
    private val finalPosterPath: String? = null

) : BaseObservable(), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        arrayListOf<Int>().apply {
            parcel.readList(this, Int::class.java.classLoader)
        },
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    var bindableCountVote: Int?
        @Bindable get() = voteCount
        set(value) {
            voteCount = value
            notifyPropertyChanged(BR.bindableCountVote)
        }

    @BindingAdapter("posterPath")
    fun loadImage(imageView: ImageView, imageURL: String?) {
        Glide.with(imageView.context)
            .load(imageURL)
            .placeholder(R.drawable.loading)
            .into(imageView)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(voteCount)
        parcel.writeValue(id)
        parcel.writeValue(video)
        parcel.writeValue(voteAverage)
        parcel.writeString(title)
        parcel.writeValue(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeValue(adult)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeString(finalPosterPath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}