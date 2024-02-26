package br.petshop.meadota.dto.request

import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.model.enums.Situation
import br.petshop.meadota.model.enums.TypesPets
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PetUpdateDTO(
    @field:NotBlank var name: String,
    @field:NotBlank var lifeTime: String,
    @field:NotNull var situation: Situation,
    var interestedId: Long
) {
    fun toEntity(pet: Pets): Pets {
        pet.name = this.name
        pet.lifeTime = this.lifeTime
        pet.situation = this.situation
        pet.interested?.id = this.interestedId

        return pet
    }
}