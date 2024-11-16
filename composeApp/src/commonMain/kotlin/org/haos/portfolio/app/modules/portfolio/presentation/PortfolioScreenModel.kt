package org.haos.portfolio.app.modules.portfolio.presentation

import cafe.adriel.voyager.core.model.screenModelScope
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.modules.portfolio.data.datasource.remote.GalleryRemoteDataSource
import org.haos.portfolio.app.modules.portfolio.data.repository.PhotoRepositoryImpl
import org.haos.portfolio.app.modules.portfolio.domain.PhotoUseCase
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioAction
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioEvent
import org.haos.portfolio.app.modules.portfolio.presentation.models.PortfolioViewState
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PortfolioScreenModel :
    BaseScreenModel<PortfolioViewState, PortfolioAction, PortfolioEvent>(initialState = PortfolioViewState()) {

    private val photoUseCase = PhotoUseCase(PhotoRepositoryImpl(GalleryRemoteDataSource(provideHttpClient())))

    private fun provideHttpClient(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }


    override fun obtainEvent(viewEvent: PortfolioEvent) {
    }

    init {
        screenModelScope.launch {
            photoUseCase.count().catch {
                println("${it}")
            }.collect {
                viewState = viewState.copy(count = it.count)
                println("${it}")
            }
        }
    }

}