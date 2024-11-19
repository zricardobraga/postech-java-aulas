import java.util.stream.Stream;

public class AprendendoMatch {
    public static void main(String[] args) {
        //verifica uma condição especifica e se encontrar na stream, retorna um boleano
        Double[] notas = {5.5, 5.5, 7.3, 7.2};

//        var aprovado_aprovada = Stream.of(notas).noneMatch(nota -> nota >=7);
//        var aprovado_aprovada = Stream.of(notas).allMatch(nota -> nota >=7);
        var aprovado_aprovada = Stream.of(notas).anyMatch(nota -> nota >=7);
        System.out.println("Teve aprovação: " + (aprovado_aprovada ? "Sim" : "Não"));
    }
}
