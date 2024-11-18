package br.com.fiap.api.usuarios_pet_tech.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//Indica que essa anotação pode ser aplicada somente a classes.
//Isso significa que você poderá anotar uma classe que represente um usuário para indicar que ela precisa passar por uma validação específica.
@Target({ElementType.TYPE})
//Define que a anotação será retida em tempo de execução.
//Isso permite que o framework Spring (ou qualquer outro framework que utilize reflexão) inspecione essa anotação e execute a lógica de validação correspondente.
@Retention(RetentionPolicy.RUNTIME)
//Essa parte é crucial. Ela associa a anotação a uma classe de validação específica: CriacaoUsuarioValidator.
//É essa classe que irá conter as regras de validação para a criação de um usuário.
//Quando o Spring encontrar uma classe anotada com @CriacaoUsuarioValid, ele irá instanciar CriacaoUsuarioValidator e executar seus métodos de validação.
@Constraint(validatedBy = CriacaoUsuarioValidator.class)
public @interface CriacaoUsuarioValid{
    //Boilerplate nada mais é um conjunto de códigos pré-escritos e reutilizáveis que servem como ponto de partida para novas funcionalidades.
    //Esse código base geralmente inclui configurações, classes, interfaces e outras estruturas fundamentais que são comuns a muitos projetos Spring.

    //Define um atributo da anotação chamado message.
    //Esse atributo pode ser utilizado para fornecer uma mensagem de erro personalizada caso a validação falhe.
    //O valor padrão é "Validation error".
    String message() default "Validation error";

    //Define um atributo da anotação chamado message.
    //Esse atributo pode ser utilizado para fornecer uma mensagem de erro personalizada caso a validação falhe.
    //O valor padrão é "Validation error".

    //O Class<?>[] groups() default {}; e o Class<? extends Payload> [] payload() default {};
    // são atributos que podem ser utilizados para agrupamentos de validação e para passar dados adicionais para a implementação da validação.
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

}