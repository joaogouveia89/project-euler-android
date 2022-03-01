package io.github.joaogouveia89.projecteuler.problems.base

sealed class SolutionState {
    object DidNotStarted: SolutionState()
    object InProgress: SolutionState()
    object Done: SolutionState()
}