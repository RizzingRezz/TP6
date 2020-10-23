package com.example.listeelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_and_version.view.*

class MainActivity : AppCompatActivity() {
    data class AndVersion (var name: String = "Toto")
    var items = Array<AndVersion>(10) { AndVersion() })
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seedItems()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AndVersionAdapter(items)
    }
    fun seedItems()
    {
        val nameArray = resources.getStringArray(R.array.android_version)
        for (k in 0..2)
        {
            items[k] = AndVersion(nameArray[k])
        }
    }
    class AndVersionAdapter(val items: Array<AndVersion>) : RecyclerView.Adapter<AndVersionAdapter.ViewHolder>()
    {
        override fun getItemCount(): Int = items.size
        fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View
        {
            return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
            return ViewHolder(parent.inflate(R.layout.item_and_version))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int)
        {
            holder.bindAndVersion(items[position])
        }

        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
        {
            fun bindAndVersion(andVersion: AndVersion)
            {
                with(andVersion)
                {
                    itemView.andVersionName.text = "$name"
                }
            }
        }
    }
}
