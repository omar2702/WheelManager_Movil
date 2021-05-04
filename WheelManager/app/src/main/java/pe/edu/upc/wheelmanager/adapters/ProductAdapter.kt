package pe.edu.upc.wheelmanager.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upc.wheelmanager.R
import pe.edu.upc.wheelmanager.models.Product
import pe.edu.upc.wheelmanager.ui.ProductActivity

class ProductAdapter(private val products: ArrayList<Product>, private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductPrototype>() {

    inner class ProductPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var cvProduct: CardView
        private lateinit var tvName: TextView
        private lateinit var btDelete: ImageButton

        fun bindTo(product: Product) {
            tvName = itemView.findViewById(R.id.tvName)
            btDelete = itemView.findViewById(R.id.btDelete)
            cvProduct = itemView.findViewById(R.id.cvProduct)

            tvName.text = product.name

            btDelete.setOnClickListener {
                products.remove(product)
                this@ProductAdapter.notifyDataSetChanged()
            }

            cvProduct.setOnClickListener {
                val intent = Intent(context, ProductActivity::class.java)
                intent.putExtra("name", product.name)
                (context as Activity).startActivityForResult(intent, 0)
            }
        }
    }

    fun onActivityResult(name: String?){
        products[0].name = name!!
        notifyDataSetChanged()
    }

    // Vista por cada fila de acuerdo al diseño del prototipo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPrototype {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_product, parent, false)
        return ProductPrototype(view)
    }

    // Cantidad de elementos del recyclerview
    override fun getItemCount(): Int {
        return products.size
    }

    // Información a mostrar en cada vista
    override fun onBindViewHolder(holder: ProductPrototype, position: Int) {
        holder.bindTo(products[position])
    }
}