package academia;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor {
// Variaveis
    private final String nome;
    private final String CPF;
    private final List<Atividade> atividades = new ArrayList<>();

// Constructor
    public Professor(String nome, String CPF){
    this.nome = Objects.requireNonNull(nome, "Nome é obrigatorio");
    this.CPF = Objects.requireNonNull(CPF, "CPF é obrigatorio"); }
 
// Função
    public void adicionarAtividade(Atividade atividade){
    atividades.add(Objects.requireNonNull(atividade)); }

    public double getPercentualComissao(){
        return 0.30;} // 30%
    
    public String getNome() {return nome;}
    public String getCpf() {return CPF;}
    public List<Atividade> getAtividade() {return atividades;} 
    
    @Override
    public String toString(){
    return nome + " (" + CPF + ") - Atividades: " + atividades.size();
    }
}
