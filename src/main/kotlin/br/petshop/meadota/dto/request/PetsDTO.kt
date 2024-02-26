package br.petshop.meadota.dto.request

import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.model.enums.Situation
import br.petshop.meadota.model.enums.TypesPets
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PetsDTO(
    @field:NotBlank var name: String,
    @field:NotBlank var race: String,
    @field:NotBlank var color: String,
    @field:NotBlank var lifeTime: String,
    @field:NotNull var typePet: TypesPets,
    @field:NotNull var situation: Situation,
    @field:NotNull var interestedId: Long
) {
    fun toEntity(): Pets = Pets(
        name = this.name,
        race = this.race,
        color = this.color,
        lifeTime = this.lifeTime,
        typePet = this.typePet,
        situation = this.situation,
        interested = Interested(id = this.interestedId)
    )
}