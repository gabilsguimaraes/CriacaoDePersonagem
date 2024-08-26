package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var raca: Raca? = null
    var pontosRestantes = 27

    while (raca == null) {

        println("ESCOLHA UMA RAÇA: ")
        println("1 - Anão")
        println("2 - Elfo")
        println("3 - Halfling")
        println("4 - Humano")

        val choice = readLine()?.toIntOrNull()

        raca = when (choice) {
            1 -> Anao()
            2 -> Elfo()
            3 -> Halfling()
            4 -> Humano()
            else -> {
            println("Opção inválida. Por favor selecione um número da lista")
                null
            }
        }
    }

    val personagem = Personagem(raca!!)
    personagem.mostrarInformacoesPersonagem()

    println("Você tem $pontosRestantes pontos para distribuir entre suas habilidades.")

    while (pontosRestantes > 0) {
        println("\nPontos restantes: $pontosRestantes")
        println("Escolha uma habilidade para adicionar pontos:")
        println("1 - Força (atual: ${personagem.forca})")
        println("2 - Destreza (atual: ${personagem.destreza})")
        println("3 - Constituição (atual: ${personagem.constituicao})")
        println("4 - Inteligência (atual: ${personagem.inteligencia})")
        println("5 - Sabedoria (atual: ${personagem.sabedoria})")
        println("6 - Carisma (atual: ${personagem.carisma})")

        val escolhaHabilidade = readLine()?.toIntOrNull()


        println("Quantos pontos deseja adicionar?")

        val pontosAdicionar = readLine()?.toIntOrNull()

        if (pontosAdicionar != null && pontosAdicionar in 1..pontosRestantes) {
            when (escolhaHabilidade) {
                1 -> personagem.forca += pontosAdicionar
                2 -> personagem.destreza += pontosAdicionar
                3 -> personagem.constituicao += pontosAdicionar
                4 -> personagem.inteligencia += pontosAdicionar
                5 -> personagem.sabedoria += pontosAdicionar
                6 -> personagem.carisma += pontosAdicionar
                else -> println("Opção inválida. Por favor selecione um número da lista.")
            }
            pontosRestantes -= pontosAdicionar
        } else {
            println("Número de pontos inválido. Por favor, insira um valor entre 1 e $pontosRestantes.")
        }
    }

    personagem.mostrarInformacoesPersonagem()
}

