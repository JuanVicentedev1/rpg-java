package tech.buildrun.rpg;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int vidaMaxima;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
       this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void atacar(Personagem alvo){
        System.out.println(this.nome + ": Ataque Realizado!!");
        alvo.receberDano(ataque); // pegando o alvo ele esta recebendo o dano e estou passando dentro do () meu ataque
    }

    public void receberDano(int dano) {
        boolean podeDefender = this.executarEspecial();

        int danoReal = dano;

        if (podeDefender) {
            danoReal = dano - this.defesa;
            System.out.println(this.nome + ": Defesa realizada!");
        }

        if (danoReal < 0) {
            danoReal = 0;
        }

        this.vida -= danoReal;

        if (this.vida < 0) {
            this.vida = 0;
        }
        this.vida -= danoReal;
    }

    public boolean estaMorto() {
        return vida <= 0;
    }

    public String getNome(){
       return this.nome; // retornando o proprio nome do personagem
    }

    public void mostrarVida(){
        System.out.println(this.nome + " (Vida: " + this.vida + ")");
    }

    public abstract void monstrarApresentacao();

    public abstract void usarAtaqueEspecial(Personagem alvo);

    protected  boolean executarEspecial(){
       long umOuDois = Math.round(1 + Math.random()); // verificar se vai gerar numero 1 ou 2

        if(umOuDois == 1){
            return  false;
        }
        return true;
    }

}
