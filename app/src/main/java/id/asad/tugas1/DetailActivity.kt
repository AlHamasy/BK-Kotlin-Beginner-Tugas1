package id.asad.tugas1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.asad.tugas1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // terima data dari MainActivity
        val mhs = intent.getParcelableExtra<Mahasiswa>("DETAIL")

        // tampilkan
        if (mhs != null){
            binding.tvNama.text = mhs.nama
            binding.tvAlamat.text = mhs.alamat
            binding.tvJenisKelamin.text = mhs.jenisKelamin
            binding.tvSemester.text = mhs.semester.toString()
            binding.tvJurusan.text = mhs.jurusan
            binding.tvNomorTelepon.text = mhs.nomorTelepon

            binding.btnTelepon.setOnClickListener {

                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:${mhs.nomorTelepon}")
                startActivity(intent)
            }
            binding.btnSms.setOnClickListener {

                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("sms:${mhs.nomorTelepon}")
                startActivity(intent)
            }
        }

    }
}