package com.example.contactosreciclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista: Fragment = ListaFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentoLista,lista).commit()

    }
}