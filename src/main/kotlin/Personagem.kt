package org.example

class Personagem(
    val nome: String,
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

    fun calcularModificador(habilidade : Int): Int {
        return(habilidade - 10) / 2
    }

    fun calcularPontosDeVida(): Int {
        return 10 + calcularModificador(constituicao)
    }

    fun mostrarInformacoesPersonagem(){
        println("Nome: $nome")
        println("Raça: ${raca::class.simpleName}")
        println("Força: $forca (Modificador: ${calcularModificador(forca)})")
        println("Destreza: $destreza (Modificador: ${calcularModificador(destreza)})")
        println("Constituicao: $constituicao (Modificador: ${calcularModificador(constituicao)})")
        println("Inteligencia: $inteligencia (Modificador: ${calcularModificador(inteligencia)})")
        println("Sabedoria: $sabedoria (Modificador: ${calcularModificador(sabedoria)})")
        println("Carisma: $carisma (Modificador: ${calcularModificador(carisma)})")
        println("Pontos de Vida: ${calcularPontosDeVida()}")
    }
}