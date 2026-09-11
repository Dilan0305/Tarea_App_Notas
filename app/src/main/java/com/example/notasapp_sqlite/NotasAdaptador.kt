package com.example.notasapp_sqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotasAdaptador(
    private var notas: List<Nota>,
    context: Context
) : RecyclerView.Adapter<NotasAdaptador.NotaViewHolder>() {

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitulo: TextView = itemView.findViewById(R.id.item_titulo)
        val itemDescripcion: TextView = itemView.findViewById(R.id.item_descripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotaViewHolder(view)
    }

    override fun getItemCount(): Int{
        return notas.size
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val note = notas[position]
        holder.itemTitulo.text = note.titulo
        holder.itemDescripcion.text = note.descripcion
    }

    fun refrescarLista(nuevaNotas: List<Nota>) {
        notas = nuevaNotas
        notifyDataSetChanged()
    }
}
