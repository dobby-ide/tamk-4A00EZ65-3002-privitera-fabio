package lab01
import kotlin.test.Test
import kotlin.test.*

class AppTest {


    @Test
    fun searchTestNotFoundValue() {
        var paramArray = arrayOf(1,2,3,4,5,6,7)
        var searchValue = 10
        var s:Int? = search(paramArray, searchValue)
        assertNull(s)

    }
    @Test
    fun searchTestSameValue() {
        //search value to be the array at index 0
        var paramArray = arrayOf(5,2,3,4,5,6,7)
        var searchValue = 5
        var s = search(paramArray, searchValue)
        assertEquals(0, s)

    }


}
