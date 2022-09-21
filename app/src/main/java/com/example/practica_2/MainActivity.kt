package com.example.practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val producto1 = Producto("audifonos", 1670.00, "", R.drawable.audifonos)
        val producto2 = Producto("laptop", 10780.00, "", R.drawable.laptop)
        val producto3 = Producto("smartwach", 3457.00, "", R.drawable.smartwach)

        val listaProductos = ListOf(producto1, producto2, producto3)

        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }
}