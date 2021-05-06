package pe.edu.upc.wheelmanager.ui.service

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
import pe.edu.upc.wheelmanager.models.Service

class ServiceAdapter(private val services: ArrayList<Service>, private val context: Context) :
 RecyclerView.Adapter<ServiceAdapter.ServicePrototype>() {

     inner class ServicePrototype(itemView: View) : RecyclerView.ViewHolder(itemView){
         private lateinit var cvService: CardView
         private lateinit var tvName: TextView
         private lateinit var btDelete: ImageButton

         fun bindTo(service: Service){
             cvService = itemView.findViewById(R.id.cvService)
             btDelete = itemView.findViewById(R.id.btDelete)
             tvName = itemView.findViewById(R.id.cvService)

             tvName.text = service.name

             btDelete.setOnClickListener{
                 services.remove(service)
                 this@ServiceAdapter.notifyDataSetChanged()
             }

             cvService.setOnClickListener{
                 val intent = Intent(context, ServiceFragment::class.java)
                 intent.putExtra("name", service.name)
                 (context as Activity).startActivityForResult(intent, 0)
             }

         }

     }

    fun onFragmentResult(name: String?){
        services[0].name = name!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicePrototype {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_prototype_service, parent, false)
        return ServicePrototype(view)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    override fun onBindViewHolder(holder: ServicePrototype, position: Int) {
        holder.bindTo(services[position])
    }
}