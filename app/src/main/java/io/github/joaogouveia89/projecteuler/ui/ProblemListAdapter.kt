package io.github.joaogouveia89.projecteuler.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.github.joaogouveia89.projecteuler.R
import io.github.joaogouveia89.projecteuler.problems.base.Problem

val problemDiff = object: DiffUtil.ItemCallback<Problem<out Any>>() {
    override fun areItemsTheSame(oldItem: Problem<out Any>, newItem: Problem<out Any>): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Problem<out Any>, newItem: Problem<out Any>): Boolean = oldItem.projectEulerId != newItem.projectEulerId
}

class ProblemListAdapter(list: List<Problem<out Any>>, private val onAskingToSolve: (Int) -> Unit): ListAdapter<Problem<out Any>, ProblemViewHolder>(problemDiff) {
    init {
        submitList(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemViewHolder =
         ProblemViewHolder(
             LayoutInflater.from(parent.context)
                 .inflate(R.layout.item_problem_list, parent, false)
         )

    override fun onBindViewHolder(holder: ProblemViewHolder, position: Int) {
        holder.bind(getItem(position), onAskingToSolve)
    }
}