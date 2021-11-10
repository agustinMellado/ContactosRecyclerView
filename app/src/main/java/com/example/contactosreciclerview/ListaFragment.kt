package com.example.contactosreciclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var lista_de_Contactos: ArrayList<Contacto>
    private lateinit var adapter: AdapterContacto
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_lista, container, false)



        //instanciamos recycler y le asigno el manager
        recyclerView = view.findViewById(R.id.recyclerView_Lista)
        recyclerView.layoutManager = LinearLayoutManager(context)

        lista_de_Contactos = arrayListOf(
            Contacto("agustin", imagenPerfil = R.drawable.icon_user_a, "1111", "av. allem"),
            Contacto("facu", imagenPerfil = R.drawable.icon_user_a, "29954653", "roca 1233"),
            Contacto("javi", imagenPerfil = R.drawable.icon_user_a, "29956369", "rio negro 230"),
            Contacto("antonella", imagenPerfil = R.drawable.icon_user_a, "29963541", "lago fonck"),
            Contacto("jose", imagenPerfil = R.drawable.icon_user_a, "29968523", "dante alihieri"),
            Contacto("carla", imagenPerfil = R.drawable.icon_user_a, "299568743", "naciones unidos 2031"),
            Contacto("juan", imagenPerfil = R.drawable.icon_user_a, "29685423", "av argentina 2000"),

        )
        adapter= AdapterContacto(lista_de_Contactos)
        recyclerView.adapter=adapter
        //utilizo el itemClick del adaptador
        adapter.setOnItemClickListener(object : AdapterContacto.OnItemClickListener {
            override fun onItemClick(
                position: Int,
                nombre: String,
                imagenPerfil: String,
                numero: String,
                direccion: String
            ) {
                val bundle = Bundle()
                bundle.putString("nombre", nombre)
                //bundle.putString("imagenPerfil", imagenPerfil)
                bundle.putString("numero", numero)
                bundle.putString("direccion", direccion)

                val detalleContacto= DetallesFragment()
                detalleContacto.arguments=bundle


                //normal
                //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentoLista,detalleContacto)?.commit()
                //de lado
               activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragDetallesContacto,detalleContacto)?.commit()

               // activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentoLista,detalleContacto)?.addToBackStack(null)?.commit()
                //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragDetallesContacto,detalleContacto)?.addToBackStack(null)?.commit()
            }


        })
        return view
    }


}
