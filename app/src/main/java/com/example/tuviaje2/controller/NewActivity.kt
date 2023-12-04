package com.example.tuviaje2.controller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje2.R
import com.example.tuviaje2.adapter.NoticiaAdapter
import com.example.tuviaje2.model.Noticia

class NewActivity : AppCompatActivity() {

    private lateinit var noticiasRecyclerView: RecyclerView
    private lateinit var noticiaAdapter: NoticiaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_activity)  // Configura el RecyclerView y el adaptador
        noticiasRecyclerView = findViewById(R.id.noticiasRecyclerView)
        noticiaAdapter = NoticiaAdapter(getNoticias()) { url ->
            // Manejar el clic en la noticia (abrir la URL)
            abrirURL(url)
        }
        noticiasRecyclerView.layoutManager = LinearLayoutManager(this)
        noticiasRecyclerView.adapter = noticiaAdapter
    }

    // Método para abrir la URL en un navegador web
    private fun abrirURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    // Método de ejemplo para obtener noticias
    private fun getNoticias(): List<Noticia> {
        val noticiasList = mutableListOf<Noticia>()

        // Agrega tus noticias con títulos y URLs aquí
        noticiasList.add(Noticia("Transportadores lanzan propuesta para ajustar la fórmula del precio del Acpm en Colombia",
            "Si el precio del Acpm sube, como el Gobierno lo ha manifestado, el valor del pasaje de transporte intermunicipal y los fletes de transporte de carga y mercancías aumentarían en 30 %, desencadenando un espiral inflacionario que retrasaría la reducción de las tasas de interés.",
            "https://www.vanguardia.com/economia/nacional/transportadores-lanzan-propuesta-para-ajustar-la-formula-del-precio-del-acpm-en-colombia-XH8090752","https://www.vanguardia.com/binrepository/717x538/0c0/716d477/none/12204/LNSW/precio-colombia-transportadores-de-carga_9143915_20231129161522.jpg"))
        noticiasList.add(Noticia("Ministerio de Transporte rechazó la agresión a una agente de tránsito en Medellín",
            "Ante este tipo de situaciones, el Ministerio de Transporte impulsó la implementación de BodyCams o cámaras corporales para reforzar la seguridad y salvaguardar los derechos de la ciudadanía.",
            "https://www.vanguardia.com/colombia/ministerio-de-transporte-rechazo-la-agresion-a-una-agente-de-transito-en-medellin-AC8062031","https://www.vanguardia.com/binrepository/717x478/0c0/716d477/none/12204/AOAL/rechazan-agresion-a-una-agente-de-tra_9129063_20231126203239.jpg"))
        noticiasList.add(Noticia("Transportadores rechazan aumento de los peajes, dicen que trabajarían a pérdida en 2024",
            "Fedetranscarga (gremio transportador) expresa que el aumento de las tarifas de los peajes y del aumento del precio del Diesel pueden rápidamente llegar a pesar un 70% en los costos operativos.",
            "https://www.vanguardia.com/colombia/transportadores-rechazan-aumento-de-los-peajes-dicen-que-trabajarian-a-perdida-en-2024-NE8053935",
            "https://www.vanguardia.com/binrepository/716x478/0c1/716d477/none/12204/CCOL/fedetranscarga-colombia_9123676_20231124212126.jpg"))
        noticiasList.add(Noticia("La próxima semana se definirá el porcentaje de segunda alza en peajes",
            "El primer incremento se hará entre el 15 y 16 de enero, será el acorde a la inflación de 2022, que fue de 13,12 porciento",
            "https://www.vanguardia.com/colombia/la-proxima-semana-se-definira-el-porcentaje-de-segunda-alza-en-peajes-ML8049835",
            "https://www.vanguardia.com/binrepository/908x478/0c0/716d477/none/12204/FETV/peajes-colprensa_9120828_20231124145504.png"))
        // Agrega más noticias según sea necesario

        return noticiasList
    }
}