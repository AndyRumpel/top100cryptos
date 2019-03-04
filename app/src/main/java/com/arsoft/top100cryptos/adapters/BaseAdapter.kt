package com.arsoft.top100cryptos.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

open class BaseAdapter<VH: BaseAdapter.BaseViewHolder>: RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VH {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var items: ArrayList<Any> = ArrayList()



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Any {
        return items[position]
    }

    fun add(newItem: Any) {
        items.add(newItem)
    }

    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }


    abstract class BaseViewHolder(protected val view: View): RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Any)
    }
}