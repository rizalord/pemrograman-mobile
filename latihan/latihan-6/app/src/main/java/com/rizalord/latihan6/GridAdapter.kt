package com.rizalord.latihan6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(context: Context, var cats: ArrayList<Cat>) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return cats.size
    }

    override fun getItem(position: Int): Any {
        return cats[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (layoutInflater == null) {
            layoutInflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            val view = layoutInflater?.inflate(R.layout.grid_item, parent, false)
            val cat = cats[position]
            view?.findViewById<ImageView>(R.id.grid_image)?.setImageResource(cat.image)
            view?.findViewById<TextView>(R.id.item_name)?.text = cat.name
            return view!!
        } else {
            return convertView
        }
    }
}