package com.ompava.p2_master_detail_series.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ompava.p2_master_detail_series.Extension.toBitmap
import com.ompava.p2_master_detail_series.Model.SerieModel
import com.ompava.p2_master_detail_series.R
private const val ARG_SERIE = "ARG_HERO"
class DetailFragment : Fragment() {

    private var serieId: Int? = null
    private var serie: SerieModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            serieId = it.getInt(ARG_SERIE,-1)
            serie = SerieModel.getSerieById(serieId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvDetailName).text = serie?.name
        view.findViewById<TextView>(R.id.tvDetailSummary).text  = serie?.summary
        view.findViewById<TextView>(R.id.tvDetailGenres).text  = serie?.genres.toString()

        view.findViewById<ImageView>(R.id.ivDetailImage).setImageBitmap(serie?.image?.toBitmap(view.context))

    }




    companion object {
        @JvmStatic
        fun newInstance(serieId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SERIE, serieId)
                }
            }
    }
}