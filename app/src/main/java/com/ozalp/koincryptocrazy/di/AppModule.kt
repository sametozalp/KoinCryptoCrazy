package com.ozalp.koincryptocrazy.di

import com.ozalp.koincryptocrazy.repository.CryptoDownload
import com.ozalp.koincryptocrazy.repository.CryptoDownloadImpl
import com.ozalp.koincryptocrazy.service.CryptoAPI
import com.ozalp.koincryptocrazy.viewmodel.CryptoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    //singleton
    single {
        val BASE_URL = "https://raw.githubusercontent.com/"

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    single<CryptoDownload> {
        CryptoDownloadImpl(get())
    }

    viewModel {
        CryptoViewModel(get())
    }

    factory {

    }
}