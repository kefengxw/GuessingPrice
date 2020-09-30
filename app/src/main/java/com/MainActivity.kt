package com

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.WelcomePage.Companion.USERNAME
import com.r.listview.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome_page.*
import kotlin.random.Random

//
class MainActivity : AppCompatActivity(),ExampleAdapter.OnItemClickListener{

    private val exampleList=generateDummyList(10)
    private val adapter = ExampleAdapter(exampleList,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //transfer "intent" ande username here
        val username= intent?.getStringExtra(USERNAME)

        title="Welcome $username!"

        //set recyclerviews features, for example, adapter, layoutManager, setHasFixedSize.
        //
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this,2)
        recycler_view.setHasFixedSize(true)
}

    fun insertItem(view:View){
        val index = Random.nextInt(8)

        val newItem = ExampleItem(
            R.drawable.ic_android,
            "New item at position $index",
            "Line 2"
        )

        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

    fun removeItem(view: View){
        val index =Random.nextInt(8)

        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)
    }

    private fun generateDummyList(size:Int):ArrayList<ExampleItem>{
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