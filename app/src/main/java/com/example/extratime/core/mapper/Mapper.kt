package com.example.extratime.core.mapper

interface Mapper<Entity, Domain, Dto> {
    fun mapEntityToDomain(entity: Entity): Domain
    fun mapDomainToEntity(domain: Domain): Entity
    fun mapDtoToDomain(dto: Dto): Domain

    fun mapEntitiesToDomain(entities: List<Entity>): List<Domain> =
        entities.map { mapEntityToDomain(it) }

    fun mapDtosToDomain(list: List<Dto>): List<Domain> =
        list.map { mapDtoToDomain(it) }
}