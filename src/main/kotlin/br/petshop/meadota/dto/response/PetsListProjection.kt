package br.petshop.meadota.dto.response

import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.model.enums.Situation
import java.util.UUID


data class PetsListProjection(
    var petCode: UUID,
    var name: String,
    var lifeTime: String,
    var situation: Situation
) {
    constructor(pets: Pets): this(
        petCode = pets.petCode,
        name = pets.name,
        lifeTime = pets.lifeTime,
        situation = pets.situation
    )
}