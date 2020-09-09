package net.bedev.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.bedev.room.presenter.CashDao
import net.bedev.room.model.UangMasuk

@Database(entities = arrayOf(UangMasuk::class), version = 6)
abstract class CashDatabase : RoomDatabase() {
    abstract fun cashDao(): CashDao

    companion object {
        @Volatile
        private var instance: CashDatabase? = null

        private val Lock = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(Lock) {
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, CashDatabase::class.java, "Cashier.db").build()

    }
}