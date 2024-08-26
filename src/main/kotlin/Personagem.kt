package org.example

class Personagem(
    val raca: Raca,
    var forca: Int = 8,
    var destreza: Int = 8,
    var constituicao: Int = 8,
    var inteligencia: Int = 8,
    var sabedoria: Int = 8,
    var carisma: Int = 8
) {

    init {
        aplicarBonusRaca()
    }

    private fun aplicarBonusRaca() {
        forca += raca.forca
        destreza += raca.destreza
        constituicao += raca.constituicao
        inteligencia += raca.inteligencia
        sabedoria += raca.sabedoria
        carisma += raca.carisma
    }

    fun mostrarInformacoesPersonagem(){
        println("Raça: ${raca::class.simpleName}")
        println("Força: $forca")
        println("Destreza: $destreza")
        println("Constituicao: $constituicao")
        println("Inteligencia: $inteligencia")
        println("Sabedoria: $sabedoria")
        println("Carisma: $carisma")
    }
}