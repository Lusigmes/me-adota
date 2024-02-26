package br.petshop.meadota.dto.response

import br.petshop.meadota.model.entity.Interested
import java.time.LocalDate

data class InterestedProjection(
     var name: String,
     var cpf: String,
     var email: String,
     var birth: LocalDate,
     var zipCode: String,
     var numberHouse: Int,
     var street: String
)
{
    constructor(interested: Interested): this(
        name = interested.name,
        cpf = interested.cpf,
        email = interested.email,
        birth = interested.birth,
        zipCode = interested.address.zipCode,
        street = interested.address.street,
        numberHouse = interested.address.numberHouse

    )
}