package com.example.hw_1_kotlin_5.presentation.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw_1_kotlin_5.R
import com.example.hw_1_kotlin_5.databinding.FragmentSecondBinding
import com.example.hw_1_kotlin_5.domain.model.Note

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var note: Note?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note = arguments?.getSerializable("note") as Note?

        note?.let {
            binding.edTitle.setText(it.title)
            binding.EdText.setText(it.text)
        }
        binding.btnSave.setOnClickListener{
            save()
        }
    }

    private fun save() {
        val text = binding.EdText.text.toString().trim()
        val title = binding.edTitle.text.toString().trim()
        val bundle = Bundle()

        if (note == null) {
            note = Note(0,title,text)
        }else {
            note?.text = text
            note?.title = title
        }
        bundle.putSerializable("note", note)
        parentFragmentManager.setFragmentResult("note", bundle)
        findNavController().navigateUp()
    }

}