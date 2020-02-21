package com.faskn.app.weatherapp.utils.domain

import androidx.annotation.NonNull
import com.faskn.app.weatherapp.utils.domain.Status.*

/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */

class Resource<T> constructor(val status: Status, val data: T?, val error: Throwable? = null) {

    companion object {

        fun <T> success(@NonNull data: T): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(throwable: Throwable): Resource<T> {
            return Resource(status = Status.ERROR, data = null, error = throwable)
        }

        fun <T> loading(): Resource<T> = Resource(Status.LOADING, null)
    }
}