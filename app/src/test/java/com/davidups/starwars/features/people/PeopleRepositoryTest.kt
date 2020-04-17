package com.davidups.starwars.features.people

import android.content.Context
import com.davidups.starwars.UnitTest
import com.davidups.skell.core.exception.Failure
import com.davidups.starwars.core.functional.Either
import com.davidups.skell.core.platform.NetworkHandler
import com.davidups.starwars.features.people.models.People
import com.davidups.starwars.features.people.models.PeopleEntity
import com.davidups.starwars.features.people.models.Person
import com.davidups.skell.features.people.models.PersonEntity
import com.davidups.skell.features.people.services.PeopleLocal
import com.davidups.skell.features.people.services.PeopleService
import com.davidups.skell.features.people.usecases.PeopleRepository
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.davidups.skell.features.fetch.services.FetchLocal
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response

@RunWith(MockitoJUnitRunner.Silent::class)
class PeopleRepositoryTest : UnitTest() {

    companion object {
        const val brown = "Marrón"
    }

    private lateinit var networkRepository: PeopleRepository.Network
    @Mock private lateinit var networkHandler: NetworkHandler
    @Mock private lateinit var service: PeopleService

    @Mock private lateinit var peopleCall: Call<PeopleEntity>
    @Mock private lateinit var peopleResponse: Response<PeopleEntity>

    @Mock private lateinit var local: PeopleLocal
    @Mock private lateinit var fetchLocal: FetchLocal

    @Mock private lateinit var context: Context

    @Before
    fun setUp(){
        networkRepository = PeopleRepository.Network(networkHandler, service, local, fetchLocal)
    }

    @Test fun shouldReturnEmptyListByDefault() {
        given { networkHandler.isConnected }.willReturn(true)
        given { peopleResponse.body() }.willReturn(null)
        given { peopleResponse.isSuccessful }.willReturn(true)
        given { peopleCall.execute() }.willReturn(peopleResponse)
        given { service.getPeople() }.willReturn(peopleCall)

        val people = networkRepository.getRemotePeople()

        people shouldEqual Either.Right(emptyList<People>())
        verify(service).getPeople()
    }

    @Test fun shouldGetPeopleListFromService() {
        given { networkHandler.isConnected }.willReturn(true)
        given { peopleResponse.body() }.willReturn(
            PeopleEntity(
                1,
                "siguiente",
                "anterior",
                arrayListOf(
                    PersonEntity(
                        0,
                        "1996",
                        brown,
                        "Masculino",
                        brown,
                        180,
                        "https://www.google.es",
                        75,
                        "David",
                        "blanca"
                    )
                ))
        )
        given { peopleResponse.isSuccessful }.willReturn(true)
        given { peopleCall.execute() }.willReturn(peopleResponse)
        given { service.getPeople() }.willReturn(peopleCall)

        val articles = networkRepository.getPeople()

        articles shouldEqual Either.Right(listOf(
            Person(
                "1996",
                brown,
                "Masculino",
                brown,
                180,
                "https://www.google.es",
                75,
                "David",
                "blanca"
            )))
        verify(service).getPeople()
    }

    @Test
    fun peopleServiceShouldReturnNetworkFailureWhenNoConnection() {
        given { networkHandler.isConnected }.willReturn(false)

        val movies = networkRepository.getPeople()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test
    fun peopleServiceShouldReturnNetworkFailureWhenUndefinedConnection() {
        given { networkHandler.isConnected }.willReturn(null)

        val movies = networkRepository.getPeople()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test
    fun peopleServiceShouldReturnServerErrorIfNoSuccessfulResponse() {
        given { networkHandler.isConnected }.willReturn(true)

        val movies = networkRepository.getPeople()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }
}