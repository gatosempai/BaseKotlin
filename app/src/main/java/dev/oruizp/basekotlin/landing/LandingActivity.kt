package dev.oruizp.basekotlin.landing

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.oruizp.basekotlin.R
import dev.oruizp.basekotlin.feature.room.view.TaskActivity
import dev.oruizp.basekotlin.landing.LandingFeature.*
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity(), ItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        setUpRecyclerView()
    }

    override fun onItemClicked(item: LandingData) {
        goToFeature(item.feature)
    }

    private fun setUpRecyclerView() {
        recyclerViewLandingFeatures.layoutManager = LinearLayoutManager(this)
        recyclerViewLandingFeatures.adapter = LandingDataAdapter(this, fillList())
    }

    private fun goToFeature(feature: LandingFeature) {
        when (feature) {
            PAGING -> launchPaging()
            LIVEDATA -> launchLiveData()
            BROADCAST -> launchBroadcast()
            SERVICE -> launchService()
            ROOM -> launchRoom()
        }
    }

    private fun launchRoom() {
        launchActivity(TaskActivity::class.java)
    }

    private fun launchService() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun launchBroadcast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun launchLiveData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun launchPaging() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun launchActivity(calledActivity: Class<*>) {
        val launchingIntent = Intent(this, calledActivity)
        startActivity(launchingIntent)
    }

    private fun fillList(): List<LandingData> {
        val list: ArrayList<LandingData> = arrayListOf()
        list.add(LandingData("How to use Paging", PAGING))
        list.add(LandingData("How to use Room", ROOM))
        list.add(LandingData("How to use LiveData", LIVEDATA))
        list.add(LandingData("How to use Broadcast", BROADCAST))
        list.add(LandingData("How to use Service", SERVICE))
        return list
    }
}
