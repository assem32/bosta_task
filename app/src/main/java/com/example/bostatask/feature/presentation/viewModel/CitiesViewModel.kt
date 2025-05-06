package com.example.bostatask.feature.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.model.CityModel
import com.example.bostatask.feature.data.model.Data
import com.example.bostatask.feature.domain.useCase.getCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(private val useCase: getCitiesUseCase): ViewModel() {
    private val _citiesMutableLiveData = MutableLiveData<ResponseState<CityModel>>()
    private val _filteredCitiesMutableLiveData = MutableLiveData<ResponseState<CityModel>>()
    val citiesMutableLiveData :LiveData<ResponseState<CityModel>> = _citiesMutableLiveData


    private var originalCityList: List<Data> = emptyList()

    private val _filteredCityList = MutableLiveData<List<Data>>()
    val filteredCityList: LiveData<List<Data>> = _filteredCityList


    fun getCities(countryId:String){
        viewModelScope.launch {
            _citiesMutableLiveData.value=ResponseState.Loading
            try {
                val state = useCase.invoke(countryId)
                _citiesMutableLiveData.value=(state)
                _filteredCitiesMutableLiveData.value=useCase.invoke(countryId)
                if(state is ResponseState.Success){
                    originalCityList = state.data.data
                    _filteredCityList.value=originalCityList
                }
            }catch (e:Exception){
                _citiesMutableLiveData.value= ResponseState.NoInternetS
            }
        }
    }

    fun search(query: String) {
        _filteredCityList.value = if (query.isBlank()) {
            originalCityList
        } else {
            originalCityList.filter {
                it.cityName.contains(query, ignoreCase = true)
            }
        }
    }
}