package org.haos.portfolio.app.modules.portfolio.data.model

@kotlinx.serialization.Serializable
data class Project(
    val folder: String,
    val title: String,
    val count: Int,
)