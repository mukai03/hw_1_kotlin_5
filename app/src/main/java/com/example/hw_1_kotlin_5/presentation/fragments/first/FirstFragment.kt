package com.example.hw_1_kotlin_5.presentation.fragments.first

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_1_kotlin_5.R
import com.example.hw_1_kotlin_5.databinding.FragmentFirstBinding
import com.example.hw_1_kotlin_5.domain.model.Note
import com.example.hw_1_kotlin_5.presentation.activity.MainViewModel
import com.example.hw_1_kotlin_5.presentation.fragments.second.NoteListAdapter
import com.example.noteapp.presentation.base.BaseFragment
import com.google.android.material.snackbar.Snackbar

class FirstFragment : BaseFragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: MainViewModel by viewModels()
    private val noteListAdapter by lazy{ NoteListAdapter(this::onItemClick,this::onItemLongClick) }
    private var ischanged : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.recyclerView.adapter = noteListAdapter

        viewModel.getAllNotes()
        initListener()
        createNoteResponse()
        getAllNotesResponse()

        parentFragmentManager.setFragmentResultListener(
            "note",
            viewLifecycleOwner
        ) { requestKey, bundle ->
            val note = bundle.getSerializable("note") as Note
            Log.e("notee", "text :${note.text} title: ${note.title}")
            val position:Int? = null
            if (ischanged){
                position?.let {
                    viewModel.editNote(note)
                }
            }
            viewModel.createNote(Note(title = note.title, text = note.text))
        }
    }

    private fun onItemClick(position: Int) {
        val list = noteListAdapter.currentList.get(position)
        val bundle = Bundle()
        val currentList = noteListAdapter.currentList.toMutableList()
        currentList.removeAt(position)
        viewModel.deleteNote(list)
        noteListAdapter.submitList(currentList)
        bundle.putSerializable("note",list)
        ischanged = true
        findNavController().navigate(R.id.secondFragment,bundle)

    }
    private fun onItemLongClick(position: Int) {
        val currentList = noteListAdapter.currentList.toMutableList()
        val list = noteListAdapter.currentList.get(position)
        AlertDialog.Builder(view?.context).setTitle("Внимание!")
            .setMessage("Вы точно хотите удалить данный элемент?")
            .setNegativeButton("отмена",null)
            .setPositiveButton("удалить"){dialog, which->

                currentList.removeAt(position)
                noteListAdapter.submitList(currentList)
                viewModel.deleteNote(list)
                Snackbar.make(binding.constraintLay,"Данные были удалены...", Snackbar.LENGTH_LONG).setAction("toast"){
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }.show()
            }.show()
    }


    private fun getAllNotesResponse() {
        viewModel.getNoteAllState.collectStates(
            onLoading = { //progress
            },
            onError = {error->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                noteListAdapter.submitList(it)
            }
        )
    }

    private fun createNoteResponse() {
        viewModel.createNoteState.collectStates(
            onLoading = {

            },
            onError = {error->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                viewModel.getAllNotes()
            }
        )
    }

    private fun initListener() {
        binding.FloatBtn.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
    }
}