import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.InputStream

class BaseTests {

	@Test
	fun inputStreamWithTag() {
		val tag = "Int with tag example"
		InputStream.nullInputStream().also {
			it.tag = tag
			Assertions.assertEquals(tag, it.tag)
		}
	}
}