package net.bedev.room.presenter

import androidx.room.*
import net.bedev.room.model.UangMasuk

@Dao
interface CashDao {
    @Query("select * from cashentity")
    fun getAll() :List<UangMasuk>

    @Query ("SELECT * FROM cashentity where UangMasukId like :UangMasukId")
    fun findByname(UangMasukId : Int) : UangMasuk

    @Insert
    fun  insertAll(vararg CashData: UangMasuk)

    @Delete
    fun delete(Cash : UangMasuk)

    @Update
    fun updateData (vararg CashData: UangMasuk)

}