package com.example.kidsstoryapp.storybook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kidsstoryapp.R
import org.w3c.dom.Text

class StoryAdapter (private  var list:ArrayList<StoryModel>):
    RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemListImage)
        val textView: TextView = itemView.findViewById(R.id.tvItemListTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val buz = list[position]
        holder.textView.setText(buz.title)
        holder.imageView.setImageResource(buz.img)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, StoryActivity::class.java)
            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}