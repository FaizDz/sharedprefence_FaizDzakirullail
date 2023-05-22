@file:Suppress("UNUSED_PARAMETER")

package com.example.sharedprefence_FaizDzakirullail.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedprefence_FaizDzakirullail.R
import com.example.sharedprefence_FaizDzakirullail.activities.NoteActivity
import com.example.sharedprefence_FaizDzakirullail.model.ModelNote
import kotlinx.android.synthetic.main.list_item_note.view.*


private var Any.visibility: Int
    get() {
        TODO("Not yet implemented")
    }
    set(v) {

    }


class NoteAdapter(private val modelNoteListFilter: List<ModelNote>,
                  private val onClickItem: NoteActivity) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_note, parent, false)
        return NoteViewHolder(view)
    }
        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val modelNote = modelNoteListFilter[position]

        holder.title.text = modelNote.title
        holder.text.text = modelNote.noteText
        holder.timeDate.text = modelNote.dateTime

        if (modelNote.imagePath != null) {
            holder.roundedImageView.setImageBitmap(BitmapFactory.decodeFile(modelNote.imagePath))
            holder.roundedImageView.visibility = View.VISIBLE
        } else {
            holder.roundedImageView.visibility = View.GONE
        }

        holder.cvNote.setOnClickListener {
            onClickItem.onClick(modelNote, position)
        }
    }

    override fun getItemCount(): Int {
        return modelNoteListFilter.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class NoteViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var roundedImageView: Any
        var title: TextView
        var text: TextView
        var timeDate: TextView
        var cvNote: CardView


        init {
            title = itemView.tvTitle
            text = itemView.tvText
            timeDate = itemView.tvTime
            cvNote = itemView.cvNote
        }
    }
}

private fun Any.setImageBitmap(decodeFile: Bitmap?) {
    TODO("Not yet implemented")
}
