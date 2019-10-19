package com.jcaique.data.common

internal fun Any.loadFile(path: String) =
    this.javaClass.classLoader.getResourceAsStream(path).bufferedReader().use { it.readText() }
