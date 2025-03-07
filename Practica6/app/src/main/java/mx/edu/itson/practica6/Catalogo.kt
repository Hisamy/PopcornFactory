package mx.edu.itson.practica6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapter = PeliculaAdapter( this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView = findViewById(R.id.mseries_catalogo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }
    fun cargarPeliculas(){
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demo, R.drawable.demon,"Tanjiro y sus amigos entrenan con los Hashira para enfrentar nuevas amenazas demoníacas. La acción y la amistad se mezclan en esta aventura épica.",
            arrayListOf<Cliente>() ))
        peliculas.add(Pelicula("Dune", R.drawable.dune, R.drawable.dune2,"En un futuro lejano, Paul Atreides lidera una rebelión en el desértico planeta Arrakis para controlar el recurso más valioso del universo, la especia.",
            arrayListOf<Cliente>() ))
        peliculas.add(Pelicula( "Héroe Por Encargo", R.drawable.heroexencargo,R.drawable.heroeencargo, "Un hombre común se convierte en un héroe accidental al salvar a su ciudad de un desastre inminente, descubriendo su verdadero potencial en el proceso.",
            arrayListOf<Cliente>() ))
        peliculas.add(Pelicula( "Madame Web",R.drawable.madameweb, R.drawable.madame,"Mientras tanto, en Nueva York, una mujer con habilidades psíquicas lucha contra el crimen, utilizando su conexión con una red mística.",
            arrayListOf<Cliente>() ))
        peliculas.add(Pelicula( "Vidas Pasadas", R.drawable.vidaspasadas,R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia muy unidos, se separan después de que la familia de Nora emigra de Corea del Sur, pero el destino tiene otros planes para ellos.",
            arrayListOf<Cliente>() ))
    }

    fun cargarSeries(){
        series.add(Pelicula( "Halo",R.drawable.halo, R.drawable.halos, "Una evacuación mortal cambia la vida de la Dra. Halsey y la lleva a crear el programa de supersoldados Spartan para enfrentar a una amenaza alienígena.",
            arrayListOf<Cliente>() ))
        series.add(Pelicula( "Leveling", R.drawable.sololeveling,R.drawable.sololevelings,"En un mundo donde los cazadores luchan contra monstruos, un cazador de bajo nivel descubre un poder oculto que podría cambiarlo todo.",
            arrayListOf<Cliente>() ))
        series.add(Pelicula( "Mi adorable demonio", R.drawable.adorabledemonios,R.drawable.adorabledemonio,"Una joven descubre que su nuevo compañero de cuarto es un demonio adorable con un oscuro secreto y debe aprender a convivir con él.",
            arrayListOf<Cliente>() ))
        series.add(Pelicula("El Monstruo de la Vieja Seúl",R.drawable.elmonstruo, R.drawable.elmonstruovieja,"En la antigua Seúl, un monstruo despierta y aterroriza a la ciudad. Solo un grupo de héroes puede detenerlo.",
            arrayListOf<Cliente>() ))
        series.add(Pelicula( "Witcher", R.drawable.thewitcher, R.drawable.thewitchers,"Geralt de Rivia, un cazador de monstruos, lucha por encontrar su lugar en un mundo donde las personas suelen ser más perversas que las bestias.",
            arrayListOf<Cliente>()  ))
    }

    }
class PeliculaAdapter(var context: Context?, var peliculas: ArrayList<Pelicula>) : BaseAdapter() {
    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(p0: Int): Any {
        return peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var pelicula = peliculas[pe]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.pelicula, null)
        var image: ImageView = vista.findViewById(R.id.image_movie_cell)
        var title: TextView = vista.findViewById(R.id.movie_title_cell)

        image.setImageResource(pelicula.image)
        title.setText(pelicula.titulo)

        image.setOnClickListener() {
            val intento = Intent(context, detalle_pelicula::class.java)
            intento.putExtra("titulo", pelicula.titulo)
            intento.putExtra("imagen", pelicula.image)
            intento.putExtra("header", pelicula.header)
            intento.putExtra("sinopsis", pelicula.sinopsis)
            intento.putExtra("numberSeats",(20-pelicula.seats.size))
            context!!.startActivity(intento)
        }

        return vista
    }


}