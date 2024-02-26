package br.petshop.meadota.controller

import br.petshop.meadota.dto.request.InterestedDTO
import br.petshop.meadota.dto.request.InterestedUpdateDTO
import br.petshop.meadota.dto.response.InterestedProjection
import br.petshop.meadota.model.entity.Interested
import br.petshop.meadota.service.impl.InterestedService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus


@Controller
@RequestMapping("/api/interesteds")
class InterestedController(private val interestedService: InterestedService) {

    @PostMapping
    fun save(@RequestBody @Valid interestedDTO: InterestedDTO): ResponseEntity<InterestedProjection>{
        val interestedSaved: Interested = this.interestedService.save(interestedDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(InterestedProjection(interestedSaved))
    }

    @PatchMapping
    fun updateInterested(@RequestParam(value = "interestedId") interestedId: Long,
                         @RequestBody interestedUpdateDTO: InterestedUpdateDTO): ResponseEntity<InterestedProjection>{
        ///passar o InterestedUpdateDTO por parametro e retornar o projection desta classe
        val primary: Interested = this.interestedService.findById(interestedId) //buscar o objeto a ser alterado
        val toUpdate: Interested = interestedUpdateDTO.toEntity(primary) // atualizar dados do objeto recebido
        val updated: Interested = this.interestedService.save(toUpdate) //salvar alterrações no objeto existente

        return ResponseEntity.status(HttpStatus.OK).body(InterestedProjection(updated))
    }

    @DeleteMapping("/{interestedId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable interestedId: Long) = this.interestedService.delete(interestedId)

    @GetMapping("/{interestedId}")
    fun findById(@PathVariable interestedId: Long): ResponseEntity<InterestedProjection>{
        val interested: Interested = this.interestedService.findById(interestedId)
        return ResponseEntity.status(HttpStatus.OK).body(InterestedProjection(interested))
    }


}