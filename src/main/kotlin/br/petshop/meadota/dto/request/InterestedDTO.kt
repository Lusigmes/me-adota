package br.petshop.meadota.dto.request

import br.petshop.meadota.model.entity.Address
import br.petshop.meadota.model.entity.Interested
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate

data class InterestedDTO(
    @field:NotBlank(message = "Invalid field name")var name: String,
    @field:NotBlank(message = "Invalid field CPF") @field:CPF(message = "Invalid CPF") var cpf: String,
    @field:NotBlank(message = "Invalid field email") @field:Email(message = "Invalid email") var email: String,
    @field:NotNull(message = "Invalid field birth") var birth: LocalDate,
    @field:NotBlank(message = "Invalid field zipCode") var zipCode: String,
    @field:NotNull(message = "Invalid field numberHouse") var numberHouse: Int,
    @field:NotBlank(message = "Invalid field street") var street: String,
) {
    fun toEntity(): Interested = Interested(
        name = this.name,
        cpf = this.cpf,
        email = this.email,
        birth = this.birth,
        address = Address(this.street, this.zipCode, this.numberHouse)
        )
}