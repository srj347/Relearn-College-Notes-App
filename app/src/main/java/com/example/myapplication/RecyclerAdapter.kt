package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.model.SubjectName

class RecyclerAdapter(var context: Context, var arrayList: ArrayList<SubjectName>) :
    RecyclerView.Adapter<RecyclerAdapter.ItemHolder>()  {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val viewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.subject, parent, false)
            return ItemHolder(viewHolder)
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {

            val charItem: SubjectName = arrayList.get(position)

            holder.icons.setImageResource(charItem.Imageicon!!)
            holder.titles.text = charItem.Name

            holder.titles.setOnClickListener {
                Toast.makeText(context, charItem.Name, Toast.LENGTH_LONG).show()
            }

        }

        class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var icons = itemView.findViewById<ImageView>(R.id.icon_image_view)
            var titles = itemView.findViewById<TextView>(R.id.title_text_view)

        }

}