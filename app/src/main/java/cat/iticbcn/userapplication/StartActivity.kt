package cat.iticbcn.userapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class StartActivity : AppCompatActivity() {

    private lateinit var userName: String
    private var numberToGuess: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // Rebre el nom de l'usuari
        userName = intent.getStringExtra("USER_NAME") ?: "Usuari"

        // TextViews i Buttons
        val saludoUsusario = findViewById<TextView>(R.id.tvUserGreeting)
        val btnNumber1 = findViewById<Button>(R.id.btnNumber1)
        val btnNumber2 = findViewById<Button>(R.id.btnNumber2)
        val btnNumber3 = findViewById<Button>(R.id.btnNumber3)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Mostrar salutació
        saludoUsusario.text = "Hola, $userName!"

        // Generar número aleatori entre 1 i 3
        numberToGuess = Random.nextInt(1, 4)

        // Funció per comprovar el número escollit
        fun checkNumber(selectedNumber: Int) {
            if (selectedNumber == numberToGuess) {
                // Correcte
                val intent = Intent(this, SuccesActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("SELECTED_NUMBER", selectedNumber)
                intent.putExtra("CORRECT_NUMBER", numberToGuess)
                startActivity(intent)
            } else {
                // Error
                val intent = Intent(this, ErrorActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("SELECTED_NUMBER", selectedNumber)
                intent.putExtra("CORRECT_NUMBER", numberToGuess)
                startActivity(intent)
            }
        }

        // Assignar listeners als botons
        btnNumber1.setOnClickListener { checkNumber(1) }
        btnNumber2.setOnClickListener { checkNumber(2) }
        btnNumber3.setOnClickListener { checkNumber(3) }

        // Botó per tornar enrere
        btnBack.setOnClickListener { finish() }
    }
}
