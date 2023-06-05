package com.udacity.shoestore.screens.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe_list.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = viewModel

        binding.saveButton.setOnClickListener {
            val name = binding.shoeNameInput.text.toString()
            val sizeString = binding.shoeSizeInput.text.toString()
            val company = binding.shoeCompanyInput.text.toString()
            val description = binding.shoeDescriptionInput.text.toString()

            if (name.isEmpty() || sizeString.isEmpty() || company.isEmpty() || description.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val size = sizeString.toDouble()
            val newShoe = Shoe(name, size, company, description, listOf(""))

            val currentShoeList = viewModel.shoeList.value

            val newShoeList = ArrayList<Shoe>()
            if (currentShoeList != null) {
                newShoeList.addAll(currentShoeList)
            }

            newShoeList.add(newShoe)

            viewModel.saveShoeDetail(newShoeList)

            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root

    }
}