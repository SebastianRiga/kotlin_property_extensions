# Kotlin Typ Extensions with Properties

Enables existing types to be extended with properties/fields instead of only with
functions.

* Uses a [WeakIdentityHashMap](src/main/kotlin/com/riga/sebastian/propertiesextended/WeakIdentityHashMap.kt) to implement memory management for backing fields.
* Uses delegation pattern to simply add fields to existing types.

# Example

```kotlin

import java.io.InputStreamimport java.io.InputStream

var InputStream.tag by BackingField { "$it" }

val stream = InputStream.nullInputStream().also {
	it.tag = "Some tag"
}

println(stream.tag) // Prints: Some tag

// Reassign value
stream.tag = "$stream"

```