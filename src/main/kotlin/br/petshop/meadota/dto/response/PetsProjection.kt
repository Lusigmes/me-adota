package br.petshop.meadota.dto.response

import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.model.enums.Situation
import br.petshop.meadota.model.enums.TypesPets
import java.util.UUID

data class PetsProjection(
    var name: String,
    var petCode: UUID,
    var race: String,
    var color: String,
    var lifeTime: String,
    var types: TypesPets,
    var situation: Situation,
    var interestedId: Long?
    )
{
    constructor(pets: Pets): this(
        name = pets.name,
        petCode = pets.petCode,
        race=  pets.race,
        color = pets.color,
        lifeTime = pets.lifeTime,
        types = pets.typePet,
        situation = pets.situation,
        interestedId = pets.interested?.id
    )
}