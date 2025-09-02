package academia;
import java.time.LocalTime;
import java.util.Objects;

public class Atividade {
//VARIAVEIS
    private final String nome;
    private final LocalTime horario;
    private final int vagasTotais;
    private double valorMensalidade; 
    
    private int vagasOcupadas=0;

//CONSTRUTOR
    public Atividade(String nome, LocalTime horario, int vagasTotais, double valorMensalidade){
        this.nome=Objects.requireNonNull(nome, "Nome é Obrigatório");
        this.horario=Objects.requireNonNull(horario, "Horario é Obrigatorio");
            if (vagasTotais <=0) throw new IllegalArgumentException("Vagas Totais deve ser > 0");
            if (valorMensalidade <=0) throw new IllegalArgumentException("Valor Mensalidade deve ser > 0");
        this.vagasTotais=vagasTotais;
        this.valorMensalidade=valorMensalidade;
    }
    
    // Retorna se ainda tem vaga para Matricula
    public boolean temVaga(){ return vagasOcupadas < vagasTotais; }
    
    // Para ocupar vaga ao matricular um Alun
    public void ocuparVaga(){ 
        if (!temVaga()) throw new IllegalStateException("Sem vagas disponiveis");
        vagasOcupadas++; }
    
    // Liber uma vaga ao Cancelar
    public void liberarVaga(){ if(vagasOcupadas > 0) vagasOcupadas--; }
    
    //Atualizar o Preço Mensal da Atividade
    public void atualizarValorMensalidade(double novoValor){
        if(novoValor<=0) throw new IllegalArgumentException("Novo Valor Invalido");
        this.valorMensalidade = novoValor; }

// GETTERS SIMPLES
    public String getNome() {return nome;}
    public LocalTime getHorario() {return horario;}
    public int getVagasTotais() {return vagasTotais;}
    public int getVagasOcupadas() {return vagasOcupadas;}
    public int getVagasRestantes() {return vagasTotais-vagasOcupadas;}
    public double getValorMensalidade() {return valorMensalidade;} 
    
    @Override
    public String toString(){
    return nome + " (" + horario + ") - R$ " + valorMensalidade + " | Vagas: " + vagasOcupadas + "/" + vagasTotais; 
    }
    
 }

