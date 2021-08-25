package com.riga.sebastian.propertiesextended

import kotlin.reflect.KProperty

/**
 * Provides a delegation based backing field for the extension properties.
 * Memory management is delegated to the [store] field which stores the references
 * in a [WeakIdentityHashMap].
 * 
 * Example: var Int.tag by BackingField { "$it" }
 *
 * @author Sebastian Riga
 * @since 1.0
 */
class BackingField<R, T : Any>(private val init: (R) -> T = { throw IllegalStateException("Property not initialized!") }) {
	private val store = mutableWeakIdentityHashMap<R, T>()

	operator fun getValue(self: R, prop: KProperty<*>): T = store[self] ?: setValue(self, prop, init(self))

	operator fun setValue(self: R, prop: KProperty<*>, value: T): T = value.apply {
		store[self] = this
	}
}