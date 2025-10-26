package cat.iticbcn.userapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuccesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_succes2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar datos enviados desde StartActivity
        val userName = intent.getStringExtra("USER_NAME") ?: "Usuari"
        val selectedNumber = intent.getIntExtra("SELECTED_NUMBER", 0)
        val correctNumber = intent.getIntExtra("CORRECT_NUMBER", 0)

        // Referencias a los elementos del layout
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Mostrar mensaje de éxito
        tvMessage.text = "Correcte!\n$userName, has triat el número $selectedNumber.\nEl número correcte era $correctNumber."

        // Botón para volver atrás
        btnBack.setOnClickListener { finish() }
    }
}
