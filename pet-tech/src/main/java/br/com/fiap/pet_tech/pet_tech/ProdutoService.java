package br.com.fiap.pet_tech.pet_tech;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

//essa anotação passa a inversão do controle da classe para o spring, ou seja, o spring será responsável pela instancia toda vez que for feita uma injeção de dependencia
@Service
public class ProdutoService {
    //aqui será feita toda a camada de lógica de negócio da aplicação

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Collection<Produto> findAll(){
        var produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto findById(UUID id) {
        var produto = produtoRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Produto não encontrado"));
        return produto;
    }

    public Produto save (Produto produto){
        produto = produtoRepository.save(produto);
        return produto;
    }

    public Produto update (UUID id, Produto produto) {
        try {
            //procura o produto no banco de dados pelo ID
            Produto buscaProduto = produtoRepository.getOne(id);
            //altera o atributos do produto encontrado
            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setUrlDaImagem(produto.getUrlDaImagem());
            buscaProduto.setPreco(produto.getPreco());
            //salva o produto alterado no banco de dados
            buscaProduto = produtoRepository.save(buscaProduto);

            return buscaProduto;
        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public void delete (UUID id) {
        produtoRepository.deleteById(id);
    }
}
