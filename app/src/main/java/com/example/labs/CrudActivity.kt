package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CrudActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crudlayout)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.createFragment)
        }

        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.createFragment -> {
                    fab.hide()
                }
                R.id.readFragment -> {
                    fab.show()
                }
                R.id.updateFragment -> {
                    fab.hide()
                }
                R.id.deleteFragment -> {
                    fab.hide()
                }
            }
            toolbar.title = destination.label
        }
    }
}