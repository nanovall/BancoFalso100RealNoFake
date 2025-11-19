package com.example.bancofalso123_100realnofake

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class DineroViewModel : ViewModel()
{

    private val _saldoactual = mutableStateOf(0.0)
    val saldoactual: State<Double> = _saldoactual


    fun retirarDinero(monto: Double) {
        if (monto > 0 && monto <= _saldoactual.value) {
            _saldoactual.value -= monto
        }
    }

    fun depositarDinero(monto: Double) {
        if (monto > 0) {
            _saldoactual.value += monto
        }
    }
}
