package id.asad.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.asad.tugas1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvResult = findViewById(R.id.tv_result)

        // usage
        tvResult.text = "Hello World"
    }
}



