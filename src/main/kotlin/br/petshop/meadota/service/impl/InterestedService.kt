package br.petshop.meadota.service.impl

import br.petshop.meadota.exceptions.AdoptException
import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.repository.InterestedRepository
import br.petshop.meadota.service.IInterestedService
import org.springframework.stereotype.Service

@Service
data class InterestedService(
    private val interestedRepository: InterestedRepository): IInterestedService {

    override fun save(interested: Interested): Interested =
        this.interestedRepository.save(interested)

    override fun findById(interestedId: Long): Interested =
        this.interestedRepository.findById(interestedId).orElseThrow {
            throw AdoptException("Id $interestedId not found")
        }

    override fun delete(interestedId: Long) {
        val delInterested: Interested = this.findById(interestedId)
        this.interestedRepository.delete(delInterested)
    }
}