package com

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.WelcomePage.Companion.USERNAME
import com.r.listview.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome_page.*
//
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //transfer "intent" ande username here
        val username= intent?.getStringExtra(USERNAME)

        title="Welcome $username!"

        val exampleList=generateDummyList(10)
        recycler_view.adapter=ExampleAdapter(exampleList)
        recycler_view.layoutManager= LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
}
    private fun generateDummyList(size:Int):List<ExampleItem>{
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size){
            val drawable =when(i%3){
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item =ExampleItem(drawable,"Item $i","Line 2")
            list += item
    }
        return list
        }
}