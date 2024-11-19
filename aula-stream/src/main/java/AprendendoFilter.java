import java.util.stream.Stream;

public class AprendendoFilter {
    public static void main(String[] args) {
        //o filter retorna os dados com base em um parametro de busca
        Double[] notas = {5.5, 5.5, 7.3, 7.2};
        Stream.of(notas)
                //filtra as notas que são maiores ou iguais a 7
                .filter(nota -> nota >=7)
                //retornando uma string com a nota
                .map(nota -> "Você foi aprovado com nota: " + nota )
                .forEach(System.out::println);
    }
}
