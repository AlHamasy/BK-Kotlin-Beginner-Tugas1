package id.asad.tugas1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(
    var nama : String,
    var alamat : String,
    var jenisKelamin : String,
    var jurusan : String,
    var semester : Int,
    var nomorTelepon : String
) : Parcelable



