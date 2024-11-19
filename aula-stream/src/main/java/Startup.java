import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Startup {

    public static void main(String[] args) {
        List<String> estudantes = Arrays.asList("Gustavo", "Luciano", "Ana Luísa", "Izabela");

        //diferentes formas de percorrer a lista
        System.out.println("***** Utilizando um foreach *****");
        for (String nome: estudantes) {
            System.out.println("Estudante: " + nome);
        }

        System.out.println("***** Utilizando o iterator *****");
        Iterator<String> iterator = estudantes.iterator();

        //enquanto tiver um próximo
        while (iterator.hasNext()) {
            System.out.println("Estudante: " + iterator.next());
        }

        System.out.println("***** Utilizando a stream *****");

        Stream<String> streamLambda = estudantes.stream();
        streamLambda.forEach(s -> {
            System.out.println(s);
        });

        Stream<String> streamMethodReference = estudantes.stream();
        streamMethodReference.forEach(System.out::println);
    }
}
