package com.example.labs.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.labs.R
import com.example.labs.data.entities.Note
import com.example.labs.data.vm.NoteViewModel

class UpdateFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var updateButton: Button
    private lateinit var note: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)

        note = UpdateFragmentArgs.fromBundle(requireArguments()).note!!
        titleEditText.setText(note.title)
        descriptionEditText.setText(note.description)

        setupButton()
    }

    private fun setupView(view: View) {
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        updateButton = view.findViewById(R.id.updateButton)
    }

    private fun setupButton() {
        updateButton.setOnClickListener {
            note.apply {
                title = titleEditText.text.toString()
                description = descriptionEditText.text.toString()
            }
            if (note.description.length < 5) {
                Toast.makeText(
                    requireContext(),
                    "Description must be more than 5 characters",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                noteViewModel.update(note)
                Toast.makeText(requireContext(), getString(R.string.UpdateFrontEnd), Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        }
    }
}