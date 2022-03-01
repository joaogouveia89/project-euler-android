package io.github.joaogouveia89.projecteuler.ui

import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.projecteuler.R
import io.github.joaogouveia89.projecteuler.problems.base.Problem

class ProblemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    private val problemName = view.findViewById<TextView>(R.id.tv_problem)
    private val btSolve = view.findViewById<TextView>(R.id.bt_solve)
    private val problemResult = view.findViewById<TextView>(R.id.tv_result)
    private val loading = view.findViewById<ProgressBar>(R.id.loading)
    private val elapsedTime = view.findViewById<TextView>(R.id.tv_elapsed_time)

    @SuppressLint("SetTextI18n")
    fun bind(problem: Problem<out Any>, onSolvingRequire: (Int) -> Unit){
        problemName.text = "${problem.projectEulerId} - ${problem.title}"
        if(problem.hasBeenCalculated){
            btSolve.visibility = View.GONE
            loading.visibility = View.GONE
            problemResult.visibility = View.VISIBLE
            elapsedTime.visibility = View.VISIBLE
            problemResult.text = problem.result.toString()
            elapsedTime.text = "${problem.elapsedTime} ms"
        }else{
            btSolve.setOnClickListener {
                btSolve.visibility = View.GONE
                loading.visibility = View.VISIBLE
                onSolvingRequire.invoke(problem.projectEulerId)
            }
        }
    }
}