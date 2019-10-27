package com.jcaique.dialetus.presentation.regions

import com.jcaique.dialetus.domain.regions.RegionsService
import com.jcaique.dialetus.utils.dataflow.StateMachine
import com.jcaique.dialetus.utils.dataflow.StateTransition
import com.jcaique.dialetus.utils.dataflow.UnsupportedUserInteraction
import com.jcaique.dialetus.utils.dataflow.UserInteraction

internal class RegionsViewModel(
  private val service: RegionsService,
  private val machine: StateMachine<RegionsPresentation>
) {

    fun bind() = machine.states()

    fun handle(interaction: UserInteraction) {
        interpret(interaction)
            .let(machine::consume)
    }

    private fun interpret(interaction: UserInteraction) =
        when (interaction) {
            UserInteraction.OpenedScreen,
            UserInteraction.RequestedFreshContent -> StateTransition(
                ::showRegions
            )
            else -> throw UnsupportedUserInteraction
        }

    private suspend fun showRegions() =
        service
            .fetchRegions()
            .map { it.copy(it.name.capitalize()) }
            .let(::RegionsPresentation)
}