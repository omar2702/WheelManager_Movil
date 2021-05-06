package pe.edu.upc.wheelmanager.ui.service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upc.wheelmanager.R
import pe.edu.upc.wheelmanager.models.Service

class ServiceFragmentMain : Fragment() {

    private lateinit var btAdd: Button
    private lateinit var etName: EditText
    private lateinit var rvServices: RecyclerView

    private var services = ArrayList<Service>()

    override fun onCreateView(
        inflater: LayoutInflater,   container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btAdd.setOnClickListener {
            val name = etName.text.toString()
            val contact = Service(name)
            if (name.isEmpty()) {
                Toast.makeText(activity, "Service's name is missing", Toast.LENGTH_SHORT).show()
            } else {
                services.add(contact)
                rvServices.adapter?.notifyDataSetChanged()
            }
        }    }

    private fun initViews() {
        btAdd = (btAdd).findViewById(R.id.btAdd)
        etName = (etName).findViewById(R.id.etName)
        rvServices = (rvServices).findViewById(R.id.cvService)

        val serviceAdapter = ServiceAdapter(services, requireActivity())
        rvServices.adapter = serviceAdapter
        rvServices.layoutManager = LinearLayoutManager(requireActivity())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 0) {
                val name = data?.getStringExtra("name")
                (rvServices.adapter as ServiceAdapter).onFragmentResult(name)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}