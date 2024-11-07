package model;

public class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Campeao(String nome, int vida, int ataque, int armadura) {
        if (nome == null || !nome.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Nome inválido! Deve conter apenas letras e espaços.");
        }
        if (vida <= 0) {
            throw new IllegalArgumentException("Vida deve ser um valor positivo.");
        }
        if (ataque <= 0) {
            throw new IllegalArgumentException("Ataque deve ser um valor positivo.");
        }
        if (armadura < 0) {
            throw new IllegalArgumentException("Armadura não pode ser negativa.");
        }

        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public void takeDamage(int ataqueOponente) {
        int dano = Math.max(1, ataqueOponente - this.armadura);
        this.vida = Math.max(0, this.vida - dano);
    }

    public String status() {
        if (vida == 0) {
            return nome + ": 0 de vida (morreu)";
        } else {
            return nome + ": " + vida + " de vida";
        }
    }

    public boolean isDead() {
        return vida == 0;
    }

    public int getAtaque() {
        return ataque;
    }
}
