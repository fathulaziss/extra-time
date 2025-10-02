package com.example.extratime.core.mapper

import com.example.extratime.core.data.source.local.entity.LeagueEntity
import com.example.extratime.core.data.source.remote.dto.LeagueDto
import com.example.extratime.core.domain.model.League

object LeagueMapper {

    fun mapResponseToEntities(input: List<LeagueDto>): List<LeagueEntity> {
        val leagues = ArrayList<LeagueEntity>()
        input.map {
            val league = LeagueEntity(
                idLeague = it.idLeague,
                strLeague = it.strLeague,
                strSport = it.strSport,
                isFavorite = false
            )
            leagues.add(league)
        }
        return leagues
    }

    fun mapEntitiesToDomain(entities: List<LeagueEntity>): List<League> {
        return entities.map { mapEntityToDomain(it) }
    }

    fun mapEntityToDomain(entity: LeagueEntity): League {
        return League(
            idLeague = entity.idLeague,
            strLeague = entity.strLeague,
            strSport = entity.strSport
        )
    }

    fun mapDomainToEntity(domain: League): LeagueEntity {
        return LeagueEntity(
            idLeague = domain.idLeague,
            strLeague = domain.strLeague,
            strSport = domain.strSport
        )
    }

//    fun mapDtosToDomain(dtos: List<LeagueDto>): List<League> {
//        return dtos.map { mapDtoToDomain(it) }
//    }
//
//    fun mapDtoToDomain(dto: LeagueDto): League {
//        return League(
//            idLeague = dto.idLeague,
//            strLeague = dto.strLeague,
//            strSport = dto.strSport
//        )
//    }
}