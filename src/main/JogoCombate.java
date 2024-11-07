package main;

import model.Campeao;
import java.util.Scanner;

public class JogoCombate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura e validação dos dados do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        String nome1 = lerNome(sc);
        int vida1 = lerValorPositivo(sc, "Vida inicial");
        int ataque1 = lerValorPositivo(sc, "Ataque");
        int armadura1 = lerValorPositivo(sc, "Armadura");
        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);

        // Leitura e validação dos dados do segundo campeão
        System.out.println("Digite os dados do segundo campeão:");
        String nome2 = lerNome(sc);
        int vida2 = lerValorPositivo(sc, "Vida inicial");
        int ataque2 = lerValorPositivo(sc, "Ataque");
        int armadura2 = lerValorPositivo(sc, "Armadura");
        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        // Leitura e validação do número de turnos
        int turnos = lerValorPositivo(sc, "Quantos turnos você deseja executar?");

        // Execução do combate
        for (int i = 1; i <= turnos; i++) {
            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            // Mostra o resultado do turno
            System.out.println("Resultado do turno " + i + ":");
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());

            // Verifica se algum dos campeões morreu
            if (campeao1.isDead() || campeao2.isDead()) {
                break;
            }
        }

        System.out.println("### FIM DO COMBATE ###");
        sc.close();
    }

    // Método para ler e validar um nome (somente letras e espaços)
    private static String lerNome(Scanner sc) {
        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.matches("[A-Za-z ]+")) { // Verifica apenas letras e espaços
                break;
            } else {
                System.out.println("Nome inválido! Use apenas letras e espaços.");
            }
        }
        return nome;
    }

    // Método para ler e validar um valor positivo para vida, ataque, armadura e turnos
    private static int lerValorPositivo(Scanner sc, String campo) {
        int valor;
        while (true) {
            System.out.print(campo + ": ");
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0) {
                    sc.nextLine(); // Limpa o buffer
                    break;
                } else {
                    System.out.println(campo + " deve ser um número positivo.");
                }
            } else {
                System.out.println("Entrada inválida! Insira um número inteiro.");
                sc.next(); // Limpa a entrada inválida
            }
        }
        return valor;
    }
}
