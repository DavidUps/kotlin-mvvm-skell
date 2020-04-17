package com.davidups.starwars.core.extensions

import kotlin.random.Random

fun String.Companion.empty() = ""

fun String.Companion.randomImage() = "https://i.picsum.photos/id/${(0..300).random()}/536/352.jpg"