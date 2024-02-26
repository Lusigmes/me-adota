package br.petshop.meadota.exceptions

data class AdoptException(override val message: String?): RuntimeException(message) {
}