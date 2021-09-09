package com.example.favoritelistapplication.ui.favList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.favoritelistapplication.R
import com.example.favoritelistapplication.databinding.FragmentFavListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavListFragment : Fragment() {

    private val homeViewModel: FavListViewModel by viewModels()
    private lateinit var binding: FragmentFavListBinding
    private var isClicked: Boolean = false

    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_open_button
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_close_button
        )
    }
    private val animFrom: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.anim_from_button
        )
    }
    private val animTo: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.anim_to_button
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavListBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddMenu.setOnClickListener {
            onAddButtonClick()
        }

        binding.fabNavPersonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_fav_list_fragment_to_fav_register_fragment)
        }

        binding.fabNavImageRegister.setOnClickListener {
            findNavController().navigate(R.id.action_fav_list_fragment_to_fav_image_register_fragment)
        }
    }

    private fun onAddButtonClick() {
        setVisibility()
        setClickable()
        setAnimation()
        isClicked = !isClicked
    }

    private fun setVisibility() {
        val fabPerson = binding.fabNavPersonRegister
        val fabImage = binding.fabNavImageRegister

        if (!isClicked) {
            fabPerson.visibility = View.VISIBLE
            fabImage.visibility = View.VISIBLE

        } else {
            fabPerson.visibility = View.GONE
            fabImage.visibility = View.GONE

        }
    }

    private fun setAnimation() {
        val fabMenu = binding.fabAddMenu
        val fabPerson = binding.fabNavPersonRegister
        val fabImage = binding.fabNavImageRegister

        if (!isClicked) {
            fabMenu.startAnimation(rotateOpen)
            fabPerson.startAnimation(animFrom)
            fabImage.startAnimation(animFrom)

        } else {
            fabMenu.startAnimation(rotateClose)
            fabPerson.startAnimation(animTo)
            fabImage.startAnimation(animTo)
        }
    }

    /*
     * Visibilityを変更しても，animのfillAfterのバグ？でGONEにしてもタップできてしまうため
     */
    private fun setClickable() {
        val fabPerson = binding.fabNavPersonRegister
        val fabImage = binding.fabNavImageRegister

        if (!isClicked) {
            fabPerson.isClickable = true
            fabImage.isClickable = true

        } else {
            fabPerson.isClickable = false
            fabImage.isClickable = false

        }
    }

}