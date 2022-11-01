package com.example.hw_1_kotlin_5.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.hw_1_kotlin_5.R
import com.example.hw_1_kotlin_5.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*viewModel.getAllNotes()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllNotesState.collect{
                    when(it){
                        is UIState.Loading -> {
                            TODO("show progress bar")
                        }
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            binding.tvNotes.text = it.data.toString()
                        }
                    }
                }
            }
        }

        var i = 0
        binding.fab.setOnClickListener {
            i++
            viewModel.createNote(Note(title = i.toString(), text = i.toString()) )
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.createNoteState.collect{
                    when(it){
                        is UIState.Loading -> {
                            TODO("show progress bar")
                        }
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            viewModel.getAllNotes()
                        }
                    }
                }
            }
        }
    }*/
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}