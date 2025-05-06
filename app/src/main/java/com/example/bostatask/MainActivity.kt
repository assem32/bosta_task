package com.example.bostatask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bostatask.core.network.ApiCalls
import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.databinding.ActivityMainBinding
import com.example.bostatask.feature.data.model.Data
import com.example.bostatask.feature.data.model.District
import com.example.bostatask.feature.domain.useCase.getCitiesUseCase
import com.example.bostatask.feature.presentation.adapter.CitiesAdapter
import com.example.bostatask.feature.presentation.viewModel.CitiesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: CitiesViewModel by viewModels()

    private lateinit var adapter: CitiesAdapter

    private lateinit var binding: ActivityMainBinding

//    @Inject
//    lateinit var useCase: getCitiesUseCase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    adapter = CitiesAdapter(
        onClick = { index ->
            adapter.list!![index].isExpanded = !adapter.list!![index].isExpanded
            adapter.notifyItemChanged(index)
        }
    )

    binding.recyclerCities.layoutManager = LinearLayoutManager(this)
    binding.recyclerCities.adapter = adapter
    viewModel.getCities("60e4482c7cb7d4bc4849c4d5")

    binding.etSearch.addTextChangedListener{
        val query = it.toString()
        viewModel.search(query)
    }

    viewModel.filteredCityList.observe(this) {
        adapter.list = it
        adapter.notifyDataSetChanged()
    }

    viewModel.citiesMutableLiveData.observe(this){
        when(it){
            is  ResponseState.Success->{
                binding.progressBar.visibility=View.INVISIBLE
            }
            is ResponseState.Loading->{
                binding.progressBar.visibility= View.VISIBLE
            }
            else -> {
                Log.d("tag", "no internt")
            }
        }

    }
    }

}