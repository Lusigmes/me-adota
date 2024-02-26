package br.petshop.meadota.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.jetbrains.annotations.NotNull

@Embeddable
data class Address(
    @NotNull @Column(nullable = false)
    var street: String = "",
    @NotNull @Column(nullable = false)
    var zipCode: String = "",
    @NotNull @Column(nullable = false)
    var numberHouse: Int = 0
)