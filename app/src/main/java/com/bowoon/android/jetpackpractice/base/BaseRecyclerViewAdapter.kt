//package com.bowoon.android.jetpackpractice.base
//
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bowoon.android.jetpackpractice.paging.adapters.ListType
//import com.bowoon.android.jetpackpractice.paging.adapters.ViewHolderFactory
//
//open class BaseRecyclerViewAdapter<I> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    var items: List<I>? = null
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//    var activityVM: BaseViewModel? = null
//    var fragmentVM: BaseViewModel? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
//        ViewHolderFactory.onCreateViewHolder(ListType.values()[viewType], parent, activityVM, fragmentVM)
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        items?.get(position)?.let {
//            ViewHolderFactory.onBindViewHolder(holder, it, position)
//        }
//    }
//
//    override fun getItemCount(): Int = items?.size ?: 0
//}