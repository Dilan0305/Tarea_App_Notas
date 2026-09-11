package com.example.notasapp_sqlite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.notasapp_sqlite.databinding.ActivityActualizarNotaBinding

class ActualizarNotaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityActualizarNotaBinding
    private lateinit var db : NotasDatabaseHelper
    private var idNota: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityActualizarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)

        idNota = intent.getIntExtra("id_nota", -1)
        if (idNota == -1) {
            finish()
            return
        }
        val nota = db.getNotaByID(idNota)
        binding.etTitulo.setText(nota.titulo)
        binding.etDescripcion.setText(nota.descripcion)

        binding.ivActualizarNota.setOnClickListener {
            val nuevoTitulo = binding.etTitulo.text.toString()
            val nuevaDescripcion = binding.etDescripcion.text.toString()
            val notaActualizada = Nota(idNota, nuevoTitulo, nuevaDescripcion)
            db.updateNota(notaActualizada)
            finish()
            Toast.makeText(this, "Cambios Guardados", Toast.LENGTH_SHORT).show()
        }
    }
}
