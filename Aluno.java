package academia;
import java.time.LocalDate; 
public class Aluno {
// VARIAVEIS 
    private String nome, CPF; 
    private Atividade atividade; 
    private boolean ativo;
    private LocalDate dataMatricula; 

    public Aluno(String nome, String CPF, Atividade atividade){
    this.nome=nome;
    this.CPF=CPF;
    this.atividade=atividade;
    this.ativo=true;
    this.dataMatricula=LocalDate.now();
    }
    
    public String getNome() {return nome;}
    public String getCPF() {return CPF;} 
    public Atividade getAtividade() {return atividade;}
    public boolean isAtivo() {return ativo;} 
    public void desativar(){this.ativo=false;}
    
    @Override
    public String toString(){
    return nome + " - " + CPF + " - " + (ativo ? "Ativo" : "Inativo");}
    
}
