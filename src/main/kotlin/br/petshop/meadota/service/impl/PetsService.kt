package br.petshop.meadota.service.impl

import br.petshop.meadota.exceptions.AdoptException
import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.repository.PetsRepository
import br.petshop.meadota.service.IPetsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
data class PetsService(
    private val petsRepository: PetsRepository,
    private val interestedService: InterestedService
) : IPetsService {

    override fun save(pet: Pets): Pets {
//       pet.apply {
//            interested = interestedService.findById(pet.interested?.id!!) // verificar id do interessado
////           interested = interestedService.findById(pet.interested?.id ?: throw IllegalArgumentException("Interested ID cannot be null"))
//
//       }
        return this.petsRepository.save(pet)

    }
    override fun findById(petId: Long): Pets =
        this.petsRepository.findById(petId).orElseThrow {
            throw AdoptException("Id $petId not found")
        }

    override fun findPetsByPetCode(interestedId: Long, petCode: UUID): Pets { //Pets
        val petByCode: Pets = (this.petsRepository.findPetsByPetCode(petCode)
            ?: throw AdoptException("Credit code $petCode not found"))

        return if(petByCode.interested?.id == interestedId) petByCode else
            throw AdoptException("Pet Code not found")

    }

    override fun findAllByInterestedId(interestedId: Long): List<Pets> =
        petsRepository.findAllByInterestedId(interestedId)

    override fun delete(petId: Long) {
        val pet: Pets = this.findById(petId)
        return petsRepository.delete(pet)
    }
}




