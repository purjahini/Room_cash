package net.bedev.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cashentity")
data class UangMasuk(
    @PrimaryKey(autoGenerate = true) var UangMasukId:Int,
    @ColumnInfo(name = "TerimaDari") var TerimaDari : String,
    @ColumnInfo(name = "Keterangan") var Keterangan : String,
    @ColumnInfo(name = "Jumlah") var Jumlah : Int

)
