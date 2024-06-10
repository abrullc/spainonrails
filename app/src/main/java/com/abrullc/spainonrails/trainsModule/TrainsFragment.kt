package com.abrullc.spainonrails.trainsModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abrullc.spainonrails.R
import com.abrullc.spainonrails.SpainOnRailsApplication
import com.abrullc.spainonrails.databinding.FragmentTrainsBinding
import com.abrullc.spainonrails.trainsModule.adapters.TrainsListAdapter

class TrainsFragment : Fragment() {
    private lateinit var mBinding: FragmentTrainsBinding
    private lateinit var mTrainAdapter: TrainsListAdapter
    private lateinit var mTrainLinearLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTrainsBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return mBinding.root
    }

    private fun setupRecyclerView() {
        mTrainAdapter = TrainsListAdapter()
        mTrainAdapter.submitList(SpainOnRailsApplication.trenes)

        mTrainLinearLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        with(mBinding) {
            rcvTrains.apply {
                setHasFixedSize(true)
                layoutManager = mTrainLinearLayoutManager
                adapter = mTrainAdapter
            }
        }
    }
}