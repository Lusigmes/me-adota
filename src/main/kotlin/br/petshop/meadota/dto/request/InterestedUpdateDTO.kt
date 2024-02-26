package br.petshop.meadota.dto.request

import br.petshop.meadota.model.entity.Address
import br.petshop.meadota.model.entity.Interested
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate

data class InterestedUpdateDTO(
    @field:NotBlank(message = "Invalid field name")var name: String,
    @field:NotNull(message = "Invalid field birth") var birth: LocalDate,
    @field:NotBlank(message = "Invalid field zipCode") var zipCode: String,
    @field:NotNull(message = "Invalid field numberHouse") var numberHouse: Int,
    @field:NotBlank(message = "Invalid field street") var street: String,
) {
    fun toEntity(interested: Interested): Interested {
        interested.name = this.name
        interested.birth = this.birth
        interested.address.zipCode = this.zipCode
        interested.address.numberHouse = this.numberHouse
        interested.address.street = this.street

        return interested
    }

}