package com.davidups.starwars.features.people

import com.davidups.starwars.UnitTest
import com.davidups.starwars.core.functional.Either
import com.davidups.skell.core.interactor.UseCase
import com.davidups.starwars.features.people.models.Person
import com.davidups.skell.features.people.usecases.GetPeople
import com.davidups.skell.features.people.usecases.PeopleRepository
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetPeopleUnitTest : UnitTest() {

    @Mock private lateinit var mockPeopleRepository: PeopleRepository
    private lateinit var getPeople: GetPeople

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        getPeople = GetPeople(mockPeopleRepository)
        given { mockPeopleRepository.getPeople() }.willReturn(Either.Right(listOf(Person.empty())))
    }

    @Test
    fun `should get data from repository`() {

        runBlocking { getPeople.run(UseCase.None())}

        verify(mockPeopleRepository).getPeople()
        verifyNoMoreInteractions(mockPeopleRepository)
    }
}