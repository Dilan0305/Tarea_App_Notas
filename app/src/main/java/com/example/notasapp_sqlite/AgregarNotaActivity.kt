package com.example.notasapp_sqlite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notasapp_sqlite.databinding.ActivityAgregarNotaBinding

class AgregarNotaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAgregarNotaBinding
    private lateinit var db : NotasDatabaseHelper






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAgregarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NotasDatabaseHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ivGuardarNota.setOnClickListener {
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()

            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                guardarNota(titulo, descripcion)
            } else {
                Toast.makeText(applicationContext, "Llene los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun guardarNota(titulo: String, descripcion: String){
        val nota = Nota(0, titulo, descripcion)
        db.insertNota(nota)
        finish()
        Toast.makeText(applicationContext, "Se ha agregado la nota", Toast.LENGTH_SHORT).show()
    }
}