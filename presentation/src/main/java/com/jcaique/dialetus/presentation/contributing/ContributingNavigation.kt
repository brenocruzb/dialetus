package com.jcaique.dialetus.presentation.contributing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jcaique.dialetus.presentation.R
import kotlinx.android.synthetic.main.regions_menu_view.*

internal class ContributingNavigation : BottomSheetDialogFragment() {

    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.regions_menu_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.android -> handleClick(ContributingInteraction.OpenAndroid)
                R.id.web -> handleClick(ContributingInteraction.OpenWeb)
            }
            true
        }
    }

    private fun handleClick(interaction: ContributingInteraction) =
        navigate(interaction.url)

    private fun navigate(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        dismiss()
    }
}
