import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.murataydin.app.mvvmstruct.ui.home.HomeViewState
import com.murataydin.app.mvvmstruct.utils.domain.Status
import org.junit.Test
import org.junit.runner.RunWith

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(AndroidJUnit4::class)
class HomeViewStateTest {
    @Test
    fun `should not return loading false when status is success`() {
        // Given
        val givenViewState = HomeViewState(status = Status.ERROR)

        // When
        val actualResult = givenViewState.isLoading()

        // Then
        Truth.assertThat(actualResult).isFalse()
    }
}