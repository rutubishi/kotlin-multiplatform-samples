import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.rutubishi.kmpdatastore.core_datastore.app.dataStorePreferences
import com.rutubishi.kmpdatastore.core_datastore.theme.ThemePreference
import com.rutubishi.kmpdatastore.core_datastore.theme.ThemePreferenceImpl
import kotlinx.coroutines.*

interface CoroutinesComponent {
    val mainImmediateDispatcher: CoroutineDispatcher
    val appScope: CoroutineScope
}

internal class CoroutinesComponentImpl
    private constructor(): CoroutinesComponent{
    override val mainImmediateDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main.immediate
    override val appScope: CoroutineScope
        get() = CoroutineScope(
            SupervisorJob() + mainImmediateDispatcher
        )

    companion object {
        fun create(): CoroutinesComponent = CoroutinesComponentImpl()
    }
}

interface CoreComponent: CoroutinesComponent {
    val themePreference: ThemePreference
}

internal class CoreComponentImpl
    internal  constructor(context: Any? = null) :
    CoreComponent, CoroutinesComponent by CoroutinesComponentImpl.create() {

        private val datastore: DataStore<Preferences> = dataStorePreferences(
            corruptionHandler = null,
            coroutineScope = appScope.plus(Dispatchers.IO),
            migrations = emptyList(),
            context = context
        )
        override val themePreference: ThemePreference
            get() = ThemePreferenceImpl(datastore)

}

object DataStoreAppComponent {
    private var _coreComponent: CoreComponent? = null
    val coreComponent
        get() = _coreComponent
            ?: throw IllegalStateException("Make sure to call ApplicationComponent.init()")

    fun init(context: Any? = null) {
        _coreComponent = CoreComponentImpl(context)
    }
}

val coreComponent = DataStoreAppComponent.coreComponent
