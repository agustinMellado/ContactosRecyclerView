package com.example.contactosreciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
//toma los datos de las listas y genera
// myViewHolder es el que optiene la referencia del lo que vamos ingresando
class AdapterContacto(private val lista_de_Contacto: List<Contacto>) :
    RecyclerView.Adapter<AdapterContacto.AdapterContactoHolder>() {

    //declaro el click para seleccionar la informacion y mandar a otro contacto
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        //Al hacer click pasamos esta informacion al otro fragmento
        fun onItemClick(
            position: Int,
            nombre: String,
            imagenPerfil: String,
            numero: String,
            direccion: String
        )
    }

    //Creacion de funcion para clickear
    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterContactoHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return AdapterContactoHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: AdapterContactoHolder, position: Int) {
        val contacto: Contacto = lista_de_Contacto[position]

        holder.nombre.text = contacto.nombre
        holder.imagenPerfil.setImageResource(R.drawable.icon_user_a)
        holder.numero.text = contacto.numero
        holder.direccion.text = contacto.direccion

    }
    // retorna la cantidad de elementos que tenemos en liste
    override fun getItemCount(): Int {
        return lista_de_Contacto.size
    }
    //le enviamos la vista que pasa por viewHolder
    class AdapterContactoHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombreContacto)
        val imagenPerfil: ImageView = itemView.findViewById(R.id.imagenPerfil)
        val numero: TextView = itemView.findViewById(R.id.numeroContacto)
        val direccion: TextView = itemView.findViewById(R.id.direccionContacto)

        //Cargamos los datos en el listener para tenerlos listos para pasar
        init {

            itemView.setOnClickListener {

                listener.onItemClick (
                    bindingAdapterPosition,
                    nombre.text.toString(),
                    imagenPerfil.setImageResource(R.drawable.icon_user_a).toString()  ,
                    numero.text.toString(),
                    direccion.text.toString(),
                )

            }
        }
    }

}


/*

    class AdapterRecyclerView(val listaContacto: List<AdapterContacto>, val clickListener: ClickListener):RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerView.MyViewHolder {
            //inflamos el diseño
            val view= LayoutInflater.from(parent.context).inflate(R.layout.item_contacto,parent, false)

            return MyViewHolder(view)
        }



        override fun getItemCount(): Int= listaContacto.size

        class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
            //declaro las variables


            var nombre: TextView
            var imagenPerfil : CircleImageView
            var numero: TextView
            var direccion: TextView

            init {
                //las inicializo

                nombre = view.findViewById(R.id.nombreContacto)
                imagenPerfil = view.findViewById(R.id.imagenPerfil)
                numero= view.findViewById(R.id.numeroContacto)
                direccion=view.findViewById(R.id.direccionContacto)
            }

        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.nombre.text= listaContacto.get(position).nombre
            holder.imagenPerfil.circleBackgroundColor = listaContacto.get(position).imagenPerfil
            holder.numero.text= listaContacto.get(position).numero
            holder.direccion.text=listaContacto.get(position).direccion
            //Le vamos a mandar los datos al fragmento lista
            holder.itemView.setOnClickListener{
                // Al hacer click le mandamos el objeto Contacto
                clickListener.onItemClick(listaContacto.get(position))
            }
        }
        //cuando el usuario haga click
        interface ClickListener{
            fun onItemClick(adapterContacto: AdapterContacto)

        }
    }

 */