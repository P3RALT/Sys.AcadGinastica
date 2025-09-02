package academia;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
public class Mensalidade {
// Variaveis
    private final YearMonth competencia;
    private final double valorTabela;
    private final LocalDate vencimento; 
    private LocalDate dataPagamento; 
    
    public Mensalidade(YearMonth competencia,double valorTabela){
            if(valorTabela<=0) throw new IllegalArgumentException("Valor Tabela deve ser > 0");
        this.competencia=competencia;
        this.valorTabela=valorTabela;
        this.vencimento=competencia.atDay(20);} //Vence dia 20 
    
    // Marcar como pago na data atual
    public void pagarHoje(){this.dataPagamento=LocalDate.now();}
    
    //Marcar pagamento num a data especifica 
    public void pagarEM(LocalDate data){this.dataPagamento=data;}
    
    //Calcula o Valor devido coniderano a multa 
    public double calcularValorDevido(){
        if (dataPagamento == null) return valorTabela; // Nao pagou
        if (dataPagamento.isAfter(vencimento)){
            return valorTabela*1.10;} // Multa 10%
    return valorTabela; // Pago em Dia    
    }
    
    // Quantos dias de Atraso tve 
    public long diasAtraso(){
        if (dataPagamento == null) return 0;
        if (!dataPagamento.isAfter(vencimento)) return 0;
        return ChronoUnit.DAYS.between(vencimento, dataPagamento); }
    public boolean estaPaga(){ return dataPagamento != null; }
    public boolean estaEmAtrasoHoje(){ 
        return !estaPaga() && LocalDate.now().isAfter(vencimento); }
     
    public YearMonth getCompetencia(){ return competencia; }
    public LocalDate getVencimento() { return vencimento; }
    public LocalDate getDataPagamento() {return dataPagamento;} 
    public double getValorTabela () { return valorTabela;}
    
    
}






