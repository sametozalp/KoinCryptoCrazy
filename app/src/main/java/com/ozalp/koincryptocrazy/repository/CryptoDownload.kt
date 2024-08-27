package com.ozalp.koincryptocrazy.repository

import com.ozalp.koincryptocrazy.model.Crypto
import com.ozalp.koincryptocrazy.util.Resource

interface CryptoDownload {
    suspend fun downloadCryptos(): Resource<List<Crypto>>
}