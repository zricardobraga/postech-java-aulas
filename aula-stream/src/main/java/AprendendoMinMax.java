import java.util.stream.Stream;

public class AprendendoMinMax {
    public static void main(String[] args) {
        Double[] notas = {5.5, 5.5, 7.3, 7.2};
        //depois de criada a stream com o of o método max vai percorrer a stream e pegar duas notas e comparar para saber qual é a maior
        //por fim o método get pega a maior nota e salva na variavel max
        var max = Stream.of(notas).max((nota1, nota2) -> {
            if (nota1 < nota2) return -1;
            if (nota1 > nota2) return 1;
            return 0;
        }).get();
        System.out.println("Maior nota: " + max);
        var min = Stream.of(notas).min((nota1, nota2) -> {
            if (nota1 < nota2) return -1;
            if (nota1 > nota2) return 1;
            return 0;
        }).get();
        System.out.println("Menor nota: " + min);
    }
}
