package org.example

import org.example.racas.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var nome = ""
    var raca: Raca? = null
    var pontosDisponiveis = 27

    while (nome.isBlank()) {
        println("Dê um nome ao seu personagem: ")
        nome = readLine().orEmpty()
        if (nome.isBlank()) {
            println("Seu personagem precisa de um nome. Por favor, dê um nome ao seu personagem: ")
        }
    }

    while (raca == null) {

        println("ESCOLHA UMA RAÇA: ")
        println("1 - Anão")
        println("2 - Elfo")
        println("3 - Halfling")
        println("4 - Humano")
        println("5 - Draconato")
        println("6 - Gnomo")
        println("7 - Meio-elfo")
        println("8 - Meio-orc")
        println("9 - Tiefling")

        val choice = readLine()?.toIntOrNull()

        raca = when (choice) {
            1 -> Anao()
            2 -> Elfo()
            3 -> Halfling()
            4 -> Humano()
            5 -> Draconato()
            6 -> Gnomo()
            7 -> MeioElfo()
            8 -> MeioOrc()
            9 -> Tiefling()
            else -> {
            println("Opção inválida. Por favor, selecione um número da lista")
                null
            }
        }
    }

    val personagem = Personagem(nome = nome, raca = raca)

    fun distribuirPontos(habilidade: String, valorAtual: Int, pontosAdicionar: Int): Int {
        val novoValor = valorAtual + pontosAdicionar
        return if (novoValor in 8..15) {
            novoValor
        } else {
            println("$habilidade deve ficar entre 8 e 15. Valor atual: $valorAtual")
            valorAtual
        }
    }

    while (pontosDisponiveis > 0) {
        println("Você tem $pontosDisponiveis pontos para distribuir entre suas habilidades, cada habilidade pode ter entre os valores de 8 a 15.")
        println("Escolha uma habilidade para adicionar pontos:")
        println("1 - Força (atual: ${personagem.forca})")
        println("2 - Destreza (atual: ${personagem.destreza})")
        println("3 - Constituição (atual: ${personagem.constituicao})")
        println("4 - Inteligência (atual: ${personagem.inteligencia})")
        println("5 - Sabedoria (atual: ${personagem.sabedoria})")
        println("6 - Carisma (atual: ${personagem.carisma})")

        val escolhaHabilidade = readLine()?.toIntOrNull()

        println("Quantos pontos deseja adicionar? Se você selecionou a habilidade errada, escolha 0.")

        val pontosAdicionar = readLine()?.toIntOrNull()

        if (pontosAdicionar != null && pontosAdicionar in 0..pontosDisponiveis) {
            when (escolhaHabilidade) {
                1 -> personagem.forca = distribuirPontos("Força", personagem.forca, pontosAdicionar)
                2 -> personagem.destreza = distribuirPontos("Destreza", personagem.destreza, pontosAdicionar)
                3 -> personagem.constituicao = distribuirPontos("Constituição", personagem.constituicao, pontosAdicionar)
                4 -> personagem.inteligencia = distribuirPontos("Inteligência", personagem.inteligencia, pontosAdicionar)
                5 -> personagem.sabedoria = distribuirPontos("Sabedoria", personagem.sabedoria, pontosAdicionar)
                6 -> personagem.carisma = distribuirPontos("Carisma", personagem.carisma, pontosAdicionar)
                else -> println("Opção inválida. Por favor, selecione um número da lista.")
            }
            pontosDisponiveis -= pontosAdicionar
        } else {
            println("Número de pontos inválido. Por favor, insira um valor entre 0 e $pontosDisponiveis.")
        }
    }

    personagem.mostrarInformacoesPersonagem()
}

