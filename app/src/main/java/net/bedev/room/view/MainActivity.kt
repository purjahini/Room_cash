package net.bedev.room.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.bedev.room.R
import net.bedev.room.database.CashDatabase
import net.bedev.room.model.UangMasuk

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_lihat.setOnClickListener {

            val intent = Intent(this, ListUangMasuk::class.java)
            startActivity(intent)
        }


        btn_kirim.setOnClickListener {
            insertDataCash()

        }


    }


    private fun insertDataCash() {
        val Vterima_dari = et_terima_dari.text.toString()
        val VKeterangan = et_keterangan.text.toString()
        val VJumlah = et_jumlah.text.toString()

        when {
            Vterima_dari.isEmpty() -> {
                et_terima_dari.error = "Must not null"
                return
            }
            VKeterangan.isEmpty() -> {
                et_keterangan.error = "Must not null"
                return
            }
            VJumlah.isEmpty() -> {
                et_jumlah.error = "Must not null"
                return
            }
        }

        var db = CashDatabase(this@MainActivity)
        GlobalScope.launch {
            db.cashDao().insertAll(
                UangMasuk(
                    0,
                    Vterima_dari,
                    VKeterangan,
                    VJumlah.toInt()
                )


            )

        }
        btn_kirim.visibility = View.GONE
        et_terima_dari.setText("")
        et_keterangan.setText("")
        et_jumlah.setText("")
        Toast.makeText(this, "Input data berhasil", Toast.LENGTH_SHORT).show()

    }


}