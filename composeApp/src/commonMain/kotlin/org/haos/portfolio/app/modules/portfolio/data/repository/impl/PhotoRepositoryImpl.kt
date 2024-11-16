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
package org.haos.portfolio.app.modules.portfolio.data.repository.impl

import org.haos.portfolio.app.modules.portfolio.data.datasource.remote.PhotoRemoteDataSource
import org.haos.portfolio.app.modules.portfolio.data.model.Images
import org.haos.portfolio.app.modules.portfolio.data.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PhotoRepositoryImpl(
    private val remoteDataSource: PhotoRemoteDataSource,
) : PhotoRepository {
    override fun getAllPosts(): Flow<List<Images>> {
        return flow {
            emit(remoteDataSource.getAllPosts())
        }
    }

}