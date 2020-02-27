import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.murataydin.app.mvvmstruct.domain.usecase.ComicsUseCase
import com.murataydin.app.mvvmstruct.ui.home.HomeFragmentViewModel
import com.murataydin.app.mvvmstruct.ui.home.HomeViewState
import com.murataydin.app.mvvmstruct.utils.domain.Status
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

@Config(sdk = [Build.VERSION_CODES.P])
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
        homeFragmentViewModel.getComicsViewState().observeForever(viewStateObserver)

        val viewStateLiveData: MutableLiveData<HomeViewState> = MutableLiveData()
        viewStateLiveData.postValue(HomeViewState(Status.SUCCESS, null, null))

        // When
        every { comicsUseCase.execute(any()) } returns viewStateLiveData
        homeFragmentViewModel.setComicsParams(ComicsUseCase.ComicsParams())

        // Then
        val comicsViewStateSlots = mutableListOf<HomeViewState>()
        verify { viewStateObserver.onChanged(capture(comicsViewStateSlots)) }

        val loadingState = comicsViewStateSlots[0]
        Truth.assertThat(loadingState.status).isEqualTo(Status.SUCCESS)
    }
}


