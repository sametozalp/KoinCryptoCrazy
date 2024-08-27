package com.ozalp.koincryptocrazy.repository

import com.ozalp.koincryptocrazy.model.Crypto
import com.ozalp.koincryptocrazy.service.CryptoAPI
import com.ozalp.koincryptocrazy.util.Resource

class CryptoDownloadImpl(private val api: CryptoAPI) : CryptoDownload {

    override suspend fun downloadCryptos(): Resource<List<Crypto>> {

        return try {
            val response = api.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("Error", null)
            }
        } catch (e: Exception) {
            Resource.error("No data", null)
        }
    }
}