package com.example.labs.fragments.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.labs.R
import com.example.labs.data.entities.Note
import com.example.labs.data.vm.NoteViewModel

class DeleteFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var confirmDeleteButton: Button
    private lateinit var note: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        confirmDeleteButton = view.findViewById(R.id.confirmDeleteButton)

        setupButton()
    }

    private fun setupButton() {
        confirmDeleteButton.setOnClickListener {
            note = DeleteFragmentArgs.fromBundle(requireArguments()).note!!
            noteViewModel.delete(note)

            Toast.makeText(requireContext(), getString(R.string.Delete), Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }
    }

}