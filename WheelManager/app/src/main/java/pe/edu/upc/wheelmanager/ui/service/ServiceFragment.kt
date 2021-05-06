package pe.edu.upc.wheelmanager.ui.service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import pe.edu.upc.wheelmanager.R

class ServiceFragment : AppCompatActivity() {
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