import java.util.stream.Stream;

public class AprendendoMap {
    public static void main(String[] args) {
        Double[] notas = {5.5, 5.5, 7.3, 7.2};
        //o of transforma o array de notas em uma stream, ou seja, faz a build
        //o map é a operação intermediária do Stream, que consiste em adicionar dois pontos em cada nota
        //a lambda está adicionando em cada nota dois pontos
        //o foreach é uma operação de finalização, que vai printar as notas modificadas, finalizando a operação
        Stream.of(notas)
                .map(nota -> nota+2)
                //é possível encadear vários métodos intermediários
                .map(nota -> nota-1)
                .forEach(System.out::println);

        //obs: o map retorna SEMPRE a mesma quantidade de dados
    }
}
