import java.util.stream.Stream;

public class ConstruçãoStream {
    public static void main(String[] args) {
        //stream criada atraves do método of
        //o tipo Number agrega todos os tipos primitivos de numeros
        //o .of está construindo a stream
        Stream<Number> numeros = Stream.of(10, 10, 9.6, 8.2, 9.7, 10);
        numeros.forEach(System.out::println);

        System.out.println("***** <hr/> *****");

        Number[] maisNotas = {7, 6.5, 7,2, 9};
        Stream.of(maisNotas).forEach(System.out::println);

        System.out.println("***** <hr/> *****");
        //stream paralela
        Stream.of(maisNotas).parallel().forEach(System.out::println);
    }
}
