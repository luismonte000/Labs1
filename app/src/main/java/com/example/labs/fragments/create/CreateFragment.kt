package com.example.labs.fragments.create

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
import java.util.Date

class CreateFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupButton()
    }

    private fun setupView(view: View) {
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        saveButton = view.findViewById(R.id.saveButton)
    }

    private fun setupButton() {
        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val Date = Date()

            if (description.length < 5) {
                Toast.makeText(requireContext(), "@string/Error2", Toast.LENGTH_LONG).show()
            } else {
                val note = Note(title = title, description = description)
                noteViewModel.insert(note)

                Toast.makeText(requireContext(), getString(R.string.Create_success), Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        }
    }
}