package com.example.notasapp_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notasapp_sqlite.databinding.ActivityAgregarNota2Binding

class AgregarNotaActivity2 : AppCompatActivity() {

    private lateinit var bindig : ActivityAgregarNota2Binding
    private lateinit var db : NotasDatabaseHelper






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindig = ActivityAgregarNota2Binding.inflate(layoutInflater)
        db = NotasDatabaseHelper(this)

        bindig.ivGuardarNota.setOnClickListener {
            val titulo = bindig.etTitulo.text.toString()
            val descripcion = bindig.etDescripcion.text.toString()

            if (!titulo.isEmpty() && !descripcion.isEmpty()) {
                guardarNota(titulo, descripcion)
            }else{
                Toast.makeText(applicationContext, "LLene los campos", Toast.LENGTH_SHORT).show()

            }


        setContentView(bindig.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
private fun guardarNota(titulo: String, descripcion: String){
    val nota = Nota(0, titulo, descripcion)
    db.insertNota(nota)
    startActivity(Intent(applicationContext, MainActivity ::class.java))
    finishAffinity()
    Toast.makeText(applicationContext, "Se a agregado la nota", Toast.LENGTH_SHORT).show()



    }
}