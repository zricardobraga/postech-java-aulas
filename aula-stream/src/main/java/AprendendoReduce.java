import java.util.stream.Stream;

public class AprendendoReduce {
    public static void main(String[] args) {
        //o reduce modifica a stream de várias formas
        Double[] notas = {5.5, 5.5, 7.3, 7.2};
        //variavel abaixo está transformando o array de notas em uma stream,
        //usando reduce para somas as notas, usando o map para fazer a média, usando o filter para buscar as notas maiores e iguais a 7
        //por fim o isPresent verifica se tem algum valor depois dele percorrer toda a stream
        var aprovado_aprovada = Stream.of(notas).reduce((acumulador, nota) -> acumulador+nota)
                .map(somaDasNotas -> somaDasNotas/notas.length)
                .filter(nota -> nota >=7)
                .isPresent();
        //as notas são mostradas no terminal usando um ternário, ou seja, se a nota final for maior que sete, retorna SIM, senão retorna NÃO
        System.out.println("Você foi aprovado: " + (aprovado_aprovada ? "Sim" : "Não"));
    }
}
