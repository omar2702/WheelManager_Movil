package pe.edu.upc.wheelmanager.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upc.wheelmanager.R
import pe.edu.upc.wheelmanager.adapters.ProductAdapter
import pe.edu.upc.wheelmanager.models.Product

class MainActivity : AppCompatActivity() {


    private lateinit var btAdd: Button
    private lateinit var etName: EditText
    private lateinit var rvProducts: RecyclerView

    private var products = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btAdd.setOnClickListener {
            val name = etName.text.toString()
            val product = Product(name)
            if (name.isEmpty()) {
                Toast.makeText(this, "Product's name is missing", Toast.LENGTH_SHORT).show()
            } else {
                products.add(product)
                rvProducts.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun initViews() {
        btAdd = findViewById(R.id.btAdd)
        etName = findViewById(R.id.etName)
        rvProducts = findViewById(R.id.rvProducts)

        val productAdapter = ProductAdapter(products, this)
        rvProducts.adapter = productAdapter
        rvProducts.layoutManager = LinearLayoutManager(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 0) {
                val name = data?.getStringExtra("name")
                (rvProducts.adapter as ProductAdapter).onActivityResult(name)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}