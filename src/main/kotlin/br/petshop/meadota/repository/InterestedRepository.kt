package br.petshop.meadota.repository

import br.petshop.meadota.model.entity.Interested
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(path = "interesteds", collectionResourceRel = "interesteds")
interface InterestedRepository: JpaRepository<Interested, Long> {
}