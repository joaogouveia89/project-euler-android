package io.github.joaogouveia89.projecteuler.ui

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.github.joaogouveia89.projecteuler.problems.solutions.MultiplesOf3AndFive
import java.util.concurrent.Executors

class MainViewModel : ViewModel() {
    val problemsList = listOf(
        MultiplesOf3AndFive
    )

    private val pool = Executors.newCachedThreadPool()

    private var observerLifecycle: LifecycleOwner? = null

    private var onCompleteCallback: ((projectEulerId: Int) -> Unit)? = null

    fun solveProblem(projectEulerId: Int) {
        if(observerLifecycle == null && onCompleteCallback == null) return

        pool.submit {
            Log.i("JOAODEBUG", "Solving id = $projectEulerId")
            problemsList.single {
                it.projectEulerId == projectEulerId
            }.solve()
            onCompleteCallback?.invoke(projectEulerId)
        }
    }

    fun observeProblemSolution(lifecycleOwner: LifecycleOwner, onComplete: (projectEulerId: Int) -> Unit) {
        //lifecycleOwner.lifecycle.currentState == Lifecycle.State.DESTROYED
        observerLifecycle = lifecycleOwner
        onCompleteCallback = onComplete
        Log.i("JOAODEBUG", "observeProblemSolution")
    }
}