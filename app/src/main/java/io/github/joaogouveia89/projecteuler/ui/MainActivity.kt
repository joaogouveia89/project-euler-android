package io.github.joaogouveia89.projecteuler.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import io.github.joaogouveia89.projecteuler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var adapter: ProblemListAdapter

    private lateinit var viewBiding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBiding.root)

        adapter = ProblemListAdapter(mainViewModel.problemsList){
            mainViewModel.solveProblem(it)
        }

        viewBiding.problemsList.adapter = adapter

        mainViewModel.observeProblemSolution(this){ solvedProblemId ->
            adapter.notifyItemChanged(mainViewModel.problemsList.indexOfFirst{
                it.projectEulerId == solvedProblemId
            })
        }
    }

}