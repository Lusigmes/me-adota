package br.petshop.meadota.service

import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.model.entity.Pets
import java.util.UUID

interface IPetsService {

    fun save(pet: Pets): Pets
    fun findById(petId: Long): Pets
    fun findPetsByPetCode(interestedId: Long, petCode: UUID): Pets
    fun delete(petId: Long)
    fun findAllByInterestedId(interestedId: Long): List<Pets>
}