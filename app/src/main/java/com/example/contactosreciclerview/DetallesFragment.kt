package com.example.contactosreciclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


class DetallesFragment : Fragment() {
    //zona de declaracion
    private lateinit var nombre: TextView
    private lateinit var imagenContacto: CircleImageView
    private lateinit var numero: TextView
    private lateinit var direccion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalles, container, false)


        nombre = view.findViewById(R.id.tvNombreDescripcion)
        imagenContacto = view.findViewById(R.id.imagenPerfilDescripcion)
        numero = view.findViewById(R.id.tvNumeroDescripcion)
        direccion = view.findViewById(R.id.tvDireccionDescripcion)

        nombre.text = "${arguments?.getString("nombre")}"
        //imagenContacto.getTag("imagenPerfil")
        numero.text = "${arguments?.getString("numero")}"
        direccion.text = "${arguments?.getString("direccion")}"

        return view
    }


}