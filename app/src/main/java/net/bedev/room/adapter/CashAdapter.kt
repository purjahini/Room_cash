package net.bedev.room.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cash.view.*
import net.bedev.room.R
import net.bedev.room.model.UangMasuk

class CashAdapter (val listUangMasuk: List<UangMasuk>) :
    RecyclerView.Adapter<MvpHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MvpHolder {
        context = parent.context
        return MvpHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_cash,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = listUangMasuk.size

    override fun onBindViewHolder(holder: MvpHolder, position: Int) {
        val data = listUangMasuk[position]


//        val no = holder.itemView.TvLapNo
//        no.text = "${position + 1}"

        val terimaDari = holder.itemView.tv_terima_dari
        terimaDari.text = data.TerimaDari
        val jumlah = holder.itemView.tv_jumlah
        jumlah.text = data.Jumlah.toString()
        val keterangan = holder.itemView.tv_keterangan
        keterangan.text = data.Keterangan


    }
}