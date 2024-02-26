package br.petshop.meadota.controller


import br.petshop.meadota.dto.request.PetUpdateDTO
import br.petshop.meadota.dto.request.PetsDTO
import br.petshop.meadota.dto.response.PetsListProjection
import br.petshop.meadota.dto.response.PetsProjection

import br.petshop.meadota.model.entity.Pets
import br.petshop.meadota.service.impl.PetsService
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
import java.util.UUID
import java.util.stream.Collectors


@Controller
@RequestMapping("/api/pets")
class PetsController(private val petsService: PetsService)  {

    @PostMapping
    fun save(@RequestBody @Valid petsDTO: PetsDTO): ResponseEntity<PetsProjection> {
       val pet: Pets = this.petsService.save(petsDTO.toEntity())
       return ResponseEntity.status(HttpStatus.CREATED).body(PetsProjection(pet))
    }

    @PatchMapping
    fun updatePet(@RequestParam(value ="petId") petId: Long,
                 @RequestBody @Valid petUpdateDTO: PetUpdateDTO): ResponseEntity<PetsProjection>{

        val primary: Pets = this.petsService.findById(petId) //buscar o objeto a ser alterado
        val toUpdate: Pets = petUpdateDTO.toEntity(primary) // atualizar dados do objeto recebido
        val updated: Pets = this.petsService.save(toUpdate) //salvar alterrações no objeto existente

        return ResponseEntity.status(HttpStatus.OK).body(PetsProjection(updated))
    }


    @DeleteMapping("/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable petId: Long) = this.petsService.delete(petId)

    @GetMapping("/byId/{petId}")
    fun getById(@PathVariable petId: Long): ResponseEntity<PetsProjection> {
        val pet: Pets = this.petsService.findById(petId)
        return ResponseEntity.status(HttpStatus.OK).body(PetsProjection(pet))
    }

    @GetMapping("/byCode/{petCode}")
    fun getByPetCode(@RequestParam(value = "interestedId") interestedId: Long,
                     @PathVariable petCode: UUID): ResponseEntity<PetsProjection>{
        val pet: Pets = this.petsService.findPetsByPetCode(interestedId, petCode)
        return ResponseEntity.status(HttpStatus.OK).body(PetsProjection(pet))

    }

    @GetMapping
    fun getAllPetsByInterested(@RequestParam("interestedId") interestedId: Long): ResponseEntity<List<PetsListProjection>>{
        val petsList: List<PetsListProjection> =
            this.petsService.findAllByInterestedId(interestedId)
                .stream().map { pet: Pets -> PetsListProjection(pet) }
                .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(petsList)
    }


}