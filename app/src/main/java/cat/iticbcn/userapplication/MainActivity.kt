package cat.iticbcn.userapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDate = findViewById<TextView>(R.id.tvDate)
        val inputNombreUser = findViewById<EditText>(R.id.etUsername)
        val btnStart = findViewById<Button>(R.id.btnStart)

        // Mostrar data actual
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        tvDate.text = "Data: $currentDate"

        btnStart.setOnClickListener {
            val name = inputNombreUser.text.toString().trim()
            if (name.isNotEmpty()) {
                val intent = Intent(this, StartActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            } else {
                inputNombreUser.error = "Introdueix el teu nom"
            }
        }
    }
}
