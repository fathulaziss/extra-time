package com.example.extratime.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.extratime.core.data.Resource
import com.example.extratime.core.data.repository.LeagueRepository
import com.example.extratime.core.domain.interactor.LeagueInteractor
import com.example.extratime.core.domain.model.League
import com.example.extratime.core.domain.repository.ILeagueRepository
import com.example.extratime.core.domain.usecase.LeagueUseCase
import com.example.extratime.utils.getOrAwaitValue
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LeagueUseCaseTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var leagueUseCase: LeagueUseCase

    @Mock private lateinit var leagueRepository: ILeagueRepository

    private val dummyLeagues = listOf(
        League("4328", "English Premier League", "Soccer"),
        League("4329", "English League Championship", "Soccer"),
        League("4331", "German Bundesliga", "Soccer")
    )

    @Before
    fun setUp() {
        leagueUseCase = LeagueInteractor(leagueRepository)

        val dummyLiveData = MutableLiveData<Resource<List<League>>>()
        dummyLiveData.postValue(Resource.Success(dummyLeagues)) // ✅ postValue for JVM test

        `when`(leagueRepository.getLeagues()).thenReturn(dummyLiveData)
    }

    @Test fun `should get data from repository`() {
        val result = leagueUseCase.getLeagues().getOrAwaitValue()

        verify(leagueRepository).getLeagues()
        verifyNoMoreInteractions(leagueRepository)

        assert(result is Resource.Success)
        val success = result as Resource.Success
        Assert.assertEquals(dummyLeagues, success.data)
    }
}