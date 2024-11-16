package org.haos.portfolio.app.modules.portfolio.presentation

import cafe.adriel.voyager.core.model.screenModelScope
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.modules.portfolio.data.datasource.remote.GalleryRemoteDataSource
import org.haos.portfolio.app.modules.portfolio.data.repository.PhotoRepositoryImpl
import org.haos.portfolio.app.modules.portfolio.domain.PhotoUseCase
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioAction
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioEvent
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioViewState

class PortfolioScreenModel :
    BaseScreenModel<PortfolioViewState, PortfolioAction, PortfolioEvent>(initialState = PortfolioViewState()) {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    private val photoUseCase = PhotoUseCase(PhotoRepositoryImpl(GalleryRemoteDataSource(httpClient)))

    override fun obtainEvent(viewEvent: PortfolioEvent) {
    }

    init {
        println("init()")
        screenModelScope.launch {
            val count = photoUseCase.count()
            viewState = viewState.copy(count = count)
        }

    }

}