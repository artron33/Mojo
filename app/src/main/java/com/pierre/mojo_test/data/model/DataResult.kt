package com.pierre.mojo_test.data.model
/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class DataResult<out R> {

    data class Success<out T>(val data: T) : DataResult<T>()
    object ErrorGeneric : DataResult<Nothing>()

}

/**
 * `true` if [DataResult] is of type [Success] & holds non-null [Success.data].
 */
val DataResult<*>.succeeded
    get() = this is DataResult.Success && data != null