package com.korol.myapplication.common

interface BaseSideEffect

data class IsNotHomeData(var errorMessage: String) : BaseSideEffect

