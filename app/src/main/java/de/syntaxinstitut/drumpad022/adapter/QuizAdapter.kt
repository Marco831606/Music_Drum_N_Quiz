package com.example.drumpad022.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.drumpad022.R
import de.syntaxinstitut.drumpad022.data.model.Question


class QuizAdapter() : RecyclerView.Adapter<QuizAdapter.ItemViewHolder>() {

    private var dataset = listOf<Question>()


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val quizText: TextView = view.findViewById(R.id.quiz_text)
    }

    fun submitList(list: List<Question>) {
        dataset = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.quiz_item, parent, false)


        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Question = dataset[position]

        holder.quizText.text = item.question

        holder.quizText.setOnClickListener {
            holder.quizText.text = item.correctAnswer
            holder.quizText.text = item.incorrectAnswers[0]
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }
}