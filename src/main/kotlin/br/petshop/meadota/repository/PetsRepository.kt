package br.petshop.meadota.repository

import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.model.entity.Pets
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
@RepositoryRestResource(path = "pets", collectionResourceRel = "pets")
interface PetsRepository: JpaRepository<Pets, Long> {

    fun findPetsByPetCode(petCode: UUID): Pets?

    @Query("select * from pet where interested_id = ?1", nativeQuery = true)
    fun findAllByInterestedId(interestedId: Long): List<Pets>
}