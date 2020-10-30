package com.example.snackbar.ui.detailGastos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto
import kotlinx.android.synthetic.main.fragment_detail_gastos.*
import kotlinx.android.synthetic.main.fragment_detail_gastos.view.*

class DetailGastosFragment : Fragment() {
    private var msg = 1
    private var listGastos = getListGastos()

    private fun getListGastos(): ArrayList<Gasto> {
        val gasto1 = Gasto("aluguel","fixo","10/03/1965",550.0)
        val gasto2 = Gasto("aluguel","fixo","10/03/1965",550.0)
        val gasto3 = Gasto("aluguel","fixo","10/03/1965",550.0)
        val gasto4 = Gasto("aluguel","fixo","10/03/1965",550.0)
    }

        private val adapter = DetailGastosAdapter(listGastos)

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_detail_gastos, container, false)
        // view.tvTitleDetailGastos.text = msg.toString()

        view.listaDeGastos.adapter = adapter
        view.listaDeGastos.layoutManager = LinearLayoutManager(context)
        view.listaDeGastos.setHasFixedSize(true)

        return  view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
            arguments?.getInt("key")?.let {
                msg = it
        }
    }

    companion object{
        @JvmStatic
        fun newInstance(msg: Int) = DetailGastosFragment()
            .apply {
            arguments = Bundle().apply {
                putInt("key", msg)
            }
        }
    }
}