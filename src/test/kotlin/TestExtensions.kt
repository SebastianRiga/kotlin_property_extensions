import com.riga.sebastian.propertiesextended.BackingField
import java.io.InputStream

var InputStream.tag by BackingField { "$it" }