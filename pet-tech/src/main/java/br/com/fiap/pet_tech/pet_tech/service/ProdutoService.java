package br.com.fiap.pet_tech.pet_tech.service;

import br.com.fiap.pet_tech.pet_tech.controller.exception.ControllerNotFoundException;
import br.com.fiap.pet_tech.pet_tech.dto.ProdutoDTO;
import br.com.fiap.pet_tech.pet_tech.entities.Produto;
import br.com.fiap.pet_tech.pet_tech.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

//essa anotação passa a inversão do controle da classe para o spring, ou seja, o spring será responsável pela instancia toda vez que for feita uma injeção de dependencia
@Service
public class ProdutoService {
    //aqui será feita toda a camada de lógica de negócio da aplicação

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Collection<ProdutoDTO> findAll(){
        var produtos = produtoRepository.findAll();
        return produtos.stream().map(this::toProdutoDTO).collect(Collectors.toList());
    }

    public ProdutoDTO findById(UUID id) {
        var produto = produtoRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Produto não encontrado"));
        return toProdutoDTO(produto);
    }

    public ProdutoDTO save (ProdutoDTO produtoDTO){
        Produto produto = toProduto(produtoDTO);
        produto = produtoRepository.save(produto);
        return toProdutoDTO(produto);
    }

    public ProdutoDTO update (UUID id, ProdutoDTO produtoDTO) {
        try {
            //procura o produto no banco de dados pelo ID
            Produto buscaProduto = produtoRepository.getReferenceById(id);
            //altera o atributos do produto encontrado
            buscaProduto.setNome(produtoDTO.nome());
            buscaProduto.setDescricao(produtoDTO.descricao());
            buscaProduto.setUrlDaImagem(produtoDTO.urlDaImagem());
            buscaProduto.setPreco(produtoDTO.preco());
            //salva o produto alterado no banco de dados
            buscaProduto = produtoRepository.save(buscaProduto);

            return toProdutoDTO(buscaProduto);
        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public void delete (UUID id) {
        produtoRepository.deleteById(id);
    }

    //método privado que converte o produto(objeto) em dto
    private ProdutoDTO toProdutoDTO(Produto produto){
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getUrlDaImagem()
        );
    }
    //método privado que converte o dto para produto(objeto)
    private Produto toProduto(ProdutoDTO produtoDTO){
        return new Produto(
                produtoDTO.id(),
                produtoDTO.nome(),
                produtoDTO.descricao(),
                produtoDTO.preco(),
                produtoDTO.urlDaImagem()
        );
    }

}
