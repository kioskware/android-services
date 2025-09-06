package kioskware.android.services

import android.content.Context
import com.kdroid.androidcontextprovider.ContextProvider

/**
 * Provides access to the application context in a lazy manner.
 */
val AppContext: Context
    get() = ContextProvider.getContext()