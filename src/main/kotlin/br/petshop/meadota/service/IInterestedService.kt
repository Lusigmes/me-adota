package br.petshop.meadota.service

import br.petshop.meadota.model.entity.Interested

interface IInterestedService {
    fun save(interested: Interested): Interested
    fun findById(interestedId: Long): Interested
    fun delete(interestedId: Long)

}