package id.asad.tugas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import id.asad.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // konfigurasi spinner jurusan

        val arrayJurusan = arrayOf("Teknik Informatika","Teknik Mesin","Teknik Sipil","Teknik Industri","Teknik Elektro")
        val spinAdapterJurusan = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayJurusan)
        binding.spinJurusan.adapter = spinAdapterJurusan


        // konfigurasi spinner semester
        val arraySemester = arrayOf(1,2,3,4,5,6,7,8)
        val spinAdapterSemester = ArrayAdapter(this, android.R.layout.simple_spinner_item, arraySemester)
        binding.spinSemester.adapter = spinAdapterSemester

        binding.btnTampil.setOnClickListener {

            // ambil data dari inputan user
            val nama = binding.edtNama.text.toString()
            val alamat = binding.edtAlamat.text.toString()
            val jenisKelamin : String
            if(binding.rbLaki.isChecked){
                jenisKelamin = "Laki-laki"
            }
            else{
                jenisKelamin = "Perempuan"
            }
            val jurusan = binding.spinJurusan.selectedItem.toString()
            val semester = binding.spinSemester.selectedItem.toString()
            val nomorTelepon = binding.edtTelepon.text.toString()

            // validasi jika kosong / belum terisi
            if (nama.isBlank()){
                binding.edtNama.error = "Nama tidak boleh kosong"

            }
            if(alamat.isBlank()){
                binding.edtAlamat.error = "Alamat tidak boleh kosong"

            }
            if(nomorTelepon.isBlank()){
                binding.edtTelepon.error = "Nomor telepon tidak boleh kosong"
            }

            // jika sudah terisi semua
            if(!nama.isBlank() && !alamat.isBlank() && !nomorTelepon.isBlank()){

                // kirim data ke DetailActivity
                val mhs = Mahasiswa(nama, alamat, jenisKelamin, jurusan, semester.toInt(), nomorTelepon)
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("DETAIL",mhs)
                startActivity(intent)
            }
        }
    }
}