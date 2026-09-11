package com.example.notasapp_sqlite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notasapp_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NotasDatabaseHelper
    private lateinit var notasAdapter: NotasAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)
        notasAdapter = NotasAdaptador(db.getAllNotas(), this)

        binding.notasRv.layoutManager = LinearLayoutManager(this)
        binding.notasRv.adapter = notasAdapter

        binding.FABAgregarNota.setOnClickListener {
            startActivity(Intent(this, AgregarNotaActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        notasAdapter.refreshData(db.getAllNotas())
    }
}
