package pe.edu.upc.wheelmanager.ui.service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.upc.wheelmanager.R

class ServiceFragment : Activity() {
    private lateinit var etName: EditText
    private lateinit var btSave: Button
    private lateinit var btCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_serviceaddsave)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btCancel.setOnClickListener {
            finish()
        }
        btSave.setOnClickListener {
            val name = etName.text.toString()
            val intent = Intent()
            intent.putExtra("name", name)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        btSave = findViewById(R.id.btSave)
        btCancel = findViewById(R.id.btCancel)

        val name = intent.getStringExtra("name")
        etName.setText(name)
    }
}