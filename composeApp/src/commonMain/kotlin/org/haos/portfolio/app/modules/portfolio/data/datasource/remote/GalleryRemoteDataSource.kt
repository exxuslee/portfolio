/**
 * Copyright 2023 Shreyas Patil
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.haos.portfolio.app.modules.portfolio.data.datasource.remote

import org.haos.portfolio.app.modules.portfolio.data.model.Count
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class GalleryRemoteDataSource(private val httpClient: HttpClient) {
    suspend fun getCount(): Count {
        val response = httpClient.get(GET_COUNT).bodyAsText()
        return response.let { json ->
            Json.decodeFromString(json)
        }
    }

    companion object {
        private const val BASE_URL = "https://exxuslee.github.io/portfolio"
        private const val GET_COUNT = "$BASE_URL/gallery/count.json"
    }
}
