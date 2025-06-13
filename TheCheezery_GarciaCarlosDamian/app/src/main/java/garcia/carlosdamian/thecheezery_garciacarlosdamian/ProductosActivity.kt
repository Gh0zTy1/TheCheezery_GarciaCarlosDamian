package garcia.carlosdamian.thecheezery_garciacarlosdamian

import android.annotation.SuppressLint
import garcia.carlosdamian.thecheezery.R

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregaProductos()


        val listview: ListView = findViewById(R.id.listview)

        val adaptador = AdaptadorProductos(this, coldDrinks)
        listview.adapter = adaptador
    }

    fun agregaProductos(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
    }

    private class AdaptadorProductos(contexto: Context, productos: ArrayList<Product>): BaseAdapter() {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        init {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        // ERROR 2 CORREGIDO: El parámetro se llama 'position', no 'p0'.
        override fun getItem(position: Int): Any {
            return productos[position]
        }

        // ERROR 3 CORREGIDO: El parámetro se llama 'position', no 'p0'.
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // Parámetros renombrados para mayor claridad (de p0, p1, p2 a nombres descriptivos)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val prod = productos[position]
            val inflador = LayoutInflater.from(contexto)


            val vista = inflador.inflate(R.layout.producto_view, parent, false)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description


            precio.text = "$${prod.price}"

            return vista
        }
    }
}