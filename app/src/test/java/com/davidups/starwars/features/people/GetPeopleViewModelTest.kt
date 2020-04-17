package com.davidups.starwars.features.people

import com.davidups.starwars.AndroidTest
import com.davidups.starwars.core.functional.Either.Right
import com.davidups.skell.core.interactor.UseCase.None
import com.davidups.starwars.features.people.models.Person
import com.davidups.skell.features.people.usecases.GetPeople
import com.davidups.skell.features.people.views.viewmodels.GetPeopleViewModel
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetPeopleViewModelTest : AndroidTest() {

    private lateinit var getPeopleViewModel: GetPeopleViewModel

    @Mock
    private lateinit var getPeople: GetPeople

    @Before
    fun setUp() {
        getPeopleViewModel = GetPeopleViewModel(getPeople)
    }

    @Test
    fun `loading people should update live data`() {

        val person = listOf(
            Person(
                "1996",
                "Marrón",
                "Masculino",
                "Marrón",
                180,
                "https://www.google.es",
                75,
                "David",
                "blanca"
            )
        )

        given { runBlocking { getPeople.run(eq(None())) } }.willReturn(Right(person))

        getPeopleViewModel.person.observeForever {
            with(it!!) {
                it!!.size shouldEqualTo 1
                it[0].birthYear shouldBeEqualTo "1996"
                it[0].eyeColor shouldBeEqualTo "Marrón"
                it[0].gender shouldBeEqualTo "Masculino"
                it[0].hairColor shouldBeEqualTo "Marrón"
                it[0].height shouldEqualTo 180
                it[0].homeworld shouldNotBeEqualTo "www.davidups.com"
                it[0].mass shouldEqualTo 75
                it[0].name shouldBeEqualTo "David"
                it[0].skinColor shouldBeEqualTo "blanca"
            }
        }

        getPeopleViewModel.person.value = person.map {
            it.toPersonView()
        }

        runBlocking { getPeopleViewModel.getPeople() }
    }
}