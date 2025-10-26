package cat.iticbcn.userapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val userName = intent.getStringExtra("USER_NAME") ?: "Usuari"
        val selectedNumber = intent.getIntExtra("SELECTED_NUMBER", 0)
        val correctNumber = intent.getIntExtra("CORRECT_NUMBER", 0)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        tvMessage.text = "Incorrecte!\n$userName, has triat el número $selectedNumber.\nEl número correcte era $correctNumber."

        btnBack.setOnClickListener { finish() }
    }
}
