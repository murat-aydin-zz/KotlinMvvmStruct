import android.content.SharedPreferences
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.faskn.app.weatherapp.utils.domain.Status
import com.google.common.truth.Truth
import com.murataydin.app.mvvmstruct.domain.usecase.ComicsUseCase
import com.murataydin.app.mvvmstruct.ui.main.home.HomeFragmentViewModel
import com.murataydin.app.mvvmstruct.ui.main.home.HomeViewState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var comicsUseCase: ComicsUseCase


    private lateinit var homeFragmentViewModel: HomeFragmentViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        homeFragmentViewModel = HomeFragmentViewModel(comicsUseCase)
    }

    @Test
    fun `given success state, when setComicsParams called, then update live data for success status`() {
        // Given
        val viewStateObserver: Observer<HomeViewState> = mockk(relaxUnitFun = true)
        homeFragmentViewModel.dummyComicLiveData.observeForever(viewStateObserver)

        val viewStateLiveData: MutableLiveData<HomeViewState> = MutableLiveData()
        viewStateLiveData.postValue(HomeViewState(Status.SUCCESS, null, null))

    }
}