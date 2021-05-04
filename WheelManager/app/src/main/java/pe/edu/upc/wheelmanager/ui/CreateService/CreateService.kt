package pe.edu.upc.wheelmanager.ui.CreateService

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.upc.wheelmanager.R

class CreateService : Fragment() {

    companion object {
        fun newInstance() = CreateService()
    }

    private lateinit var viewModel: CreateViewModel_CreateService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_fragment_service, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateViewModel_CreateService::class.java)
        // TODO: Use the ViewModel
    }

}