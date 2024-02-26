package br.petshop.meadota.model.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDate

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="interested")
data class Interested(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     var id: Long? = null,
    @Column(nullable = false)
     var name: String = "",
    @Column(nullable = false, unique = true)
     var cpf: String = "",
    @Column(nullable = false)
     var email: String = "",
    @Column(nullable = false)
     var birth: LocalDate = LocalDate.now(),
    @Column(nullable = false) @Embedded
     var address: Address = Address(),
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "interested",
        cascade = [CascadeType.REMOVE])//cascade = arrayOf(CascadeType.REMOVE))
     var pets: List<Pets> = mutableListOf()
) {

    fun toAdopt(): String{
        return "Adotado!"
    }
}