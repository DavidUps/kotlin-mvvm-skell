package com.davidups.skell.core.extensions

class Constants {

    companion object {
        val LOG_ERROR_TAG = "Error"
        const val PRODUCT = "product"
        const val NEW = "new"
    }

    class Person {
        companion object {
            val PERSON = "person"
        }
    }

    class FirebaseCollections {
        companion object {
            const val AUTHENTICATION = "Authentication"
        }
    }

    class Maps {
        companion object {
            const val CURRENT_LOCATION = "current location"
            const val MARKER_LOCATION = "marker location"
            const val FULL_SCREEN = "full screen"
            const val FULL_SCREEN_MAP = "full screen map"
            const val SPAIN_LATITUDE = 40.4172994
            const val SPAIN_LONGITUDE = -3.7039477
        }

        class Zoom {
            companion object {
                const val WORLD = 1f
                const val CONTINENT = 5f
                const val CITY = 10f
                const val STREETS = 15f
                const val BUILDINGS = 20f
            }
        }
    }

}