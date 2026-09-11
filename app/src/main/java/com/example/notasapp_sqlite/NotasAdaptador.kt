package com.example.notasapp_sqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NotasAdaptador(
    private var notas: List<Nota>,
    context: Context
) : RecyclerView.Adapter<NotasAdaptador.NotaViewHolder>() {

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitulo: TextView = itemView.findViewById(R.id.item_titulo)
        val itemDescripcion: TextView = itemView.findViewById(R.id.item_descripcion)
        val ivActualizarNota: TextView = itemView.findViewById(R.id.ivActualizarNota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotaViewHolder(view)
    }

    override fun getItemCount(): Int{
        return notas.size
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota = notas[position]
        holder.itemTitulo.text = nota.titulo
        holder.itemDescripcion.text = nota.descripcion

        holder.ivActualizarNota.setOnClickListener {
            val intent = Intent(holder.itemView.context, ActualizarNotaActivity::class.java).apply {
                putExtra("id_nota", nota.id)

            }

            holder.itemView.context.startActivity(intent)
            Toast.makeText(
                holder.itemView.context,
                "El id de la nota seleccionada es: ${nota.id}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    fun refrescarLista(nuevaNotas: List<Nota>) {
        notas = nuevaNotas
        notifyDataSetChanged()
    }
}
