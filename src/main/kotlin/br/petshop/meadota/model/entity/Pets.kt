package br.petshop.meadota.model.entity

import br.petshop.meadota.model.enums.Situation
import br.petshop.meadota.model.enums.TypesPets
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.UUID

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pet")
data class Pets(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    var petCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    var name: String = "",
    @Column(nullable = false)
    var race: String = "",
    @Column(nullable = false)
    var color: String = "",
    @Column(nullable = false)
    var lifeTime: String = "",
    @ManyToOne @JoinColumn(name = "interested_id")
    var interested: Interested? = null,
    @Enumerated(EnumType.STRING)  @Column(nullable = false)
    val typePet: TypesPets = TypesPets.DOMESTIC,
    @Enumerated(EnumType.STRING)  @Column(nullable = false)
    var situation: Situation = Situation.ALIVE
) {
    override fun toString(): String {
        return super.toString()
    }
}