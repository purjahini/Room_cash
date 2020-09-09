package net.bedev.room.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_uang_masuk.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.bedev.room.R
import net.bedev.room.adapter.CashAdapter
import net.bedev.room.database.CashDatabase

class ListUangMasuk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_uang_masuk)
        loadData()
    }

    private fun loadData() {
        GlobalScope.launch {
            var db = CashDatabase(this@ListUangMasuk)
            var data =db.cashDao().getAll()
            RvGetCash.adapter = CashAdapter(data)
        }

    }
}