package modelCalc;

import javax.persistence.*;


@Entity
@Table
public class Calculadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable = false)
    private int id;
    @Column(name = "valor1",length = 20,nullable = false)
    private double valor1;
    @Column(name = "operacao", length = 2,nullable = false)
    private String operacao;
    @Column(name = "valor2",length = 20,nullable = false)
    private double valor2;
    @Column(name = "resultado",length = 20,nullable = false)
    private double resultado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
