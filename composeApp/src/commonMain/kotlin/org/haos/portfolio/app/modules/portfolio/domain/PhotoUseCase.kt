package org.haos.portfolio.app.modules.portfolio.domain

class PhotoUseCase(
    private val photoRepository: PhotoRepository
) {
    fun count() = photoRepository.count()
}