package es.jmarara529.miappkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.jmarara529.miappkotlin.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.calcular -> {

                Log.d("Boton calcular", "Botón pulsado")

                val inputMath= binding.editTextTextMatematicas.text.toString().toDoubleOrNull()
                val inputFisica = binding.editTextTextFisica.text.toString().toDoubleOrNull()
                val inputQuimica = binding.editTextquimica.text.toString().toDoubleOrNull()

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

                val media= (inputMath + inputFisica + inputQuimica) / 3
                val mediaBigDecimal = BigDecimal(media)
                val mediaRedondeada = mediaBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)


                binding.resultado.text= getString(R.string.tu_media_es) + " " + mediaRedondeada

            }
        }

    }
}