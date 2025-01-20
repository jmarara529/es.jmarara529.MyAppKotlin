package es.jmarara529.miappkotlin

import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.jmarara529.miappkotlin.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.calcular -> {

                Log.d("Boton calcular", "Botón pulsado")

                val inputMath = binding.editTextTextMatematicas.text.toString().toIntOrNull()
                val inputFisica = binding.editTextTextFisica.text.toString().toIntOrNull()
                val inputQuimica = binding.editTextquimica.text.toString().toIntOrNull()

                if ( inputMath == null || inputFisica == null || inputQuimica == null  ) {
                    Toast.makeText(
                        this,
                        "Por favor, introduce valores numéricos",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                } else if (inputMath < 0 || inputMath > 100 || inputFisica < 0 || inputFisica > 100 || inputQuimica < 0 || inputQuimica > 100) {
                    Toast.makeText(
                        this,
                        "Por favor, introduce valores entre 0 y 100",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

            val media = (inputMath + inputFisica + inputQuimica) / 3

                binding.resultado.setText("Tu media es: $media")

            }
        }

    }
}