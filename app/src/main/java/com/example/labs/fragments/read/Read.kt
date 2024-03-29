package com.example.labs.fragments.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.R.id.recyclerview
import com.example.labs.data.vm.NoteViewModel

class Read : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
        observeData()
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(recyclerview)
        adapter = NoteListAdapter(
            onNoteUpdate = { note ->
                val action = ReadDirections.actionReadFragmentToUpdateFragment(note)
                findNavController().navigate(action)
            },
            onNoteDelete = { note ->
                val action = ReadDirections.actionReadFragmentToDeleteFragment(note)
                findNavController().navigate(action)
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeData() {
        noteViewModel.allNotes.observe(viewLifecycleOwner, { notes ->
            notes?.let { adapter.setNotes(it) }
        })
    }
}