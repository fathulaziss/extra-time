package com.example.extratime.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LeagueUseCaseTest {

    private lateinit var leagueUseCase: LeagueUseCase

    @Mock private lateinit var leagueRepository: ILeagueRepository

    @Before
    fun setUp() {
        leagueUseCase = LeagueInteractor(leagueRepository)
        val dummyLeagues = listOf(
            LeagueEntity("4328", "English Premier League", "Soccer"),
            LeagueEntity("4329", "English League Championship", "Soccer"),
            LeagueEntity("4331", "German Bundesliga", "Soccer")
        )
        `when`(leagueRepository.getLeagues()).thenReturn(dummyLeagues)
    }

    @Test fun `should get data from repository`() {
        val leagues = leagueUseCase.getLeagues()

        verify(leagueRepository).getLeagues()
        verifyNoMoreInteractions(leagueRepository)
        Assert.assertEquals(
            listOf(
            LeagueEntity("4328", "English Premier League", "Soccer"),
            LeagueEntity("4329", "English League Championship", "Soccer"),
            LeagueEntity("4331", "German Bundesliga", "Soccer")),
            leagues
        )
    }
}