package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Produto;
import com.projetojpa.entities.Usuario;
import com.projetojpa.service.ProdutoService;
import com.projetojpa.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API EXTERNA", description = "API EXTERNA")
@RestController
@RequestMapping("/apiexterna")
public class ApiExternaController {

	private final UsuarioService usuarioService;
	private final ProdutoService produtoService;

	@Autowired
	public ApiExternaController(UsuarioService usuarioService,ProdutoService produtoService) {
		this.usuarioService = usuarioService;
		this.produtoService = produtoService;

	}

	@GetMapping("/usuarios")
	@Operation(summary = "Apresenta todos os usuários ")
	public ResponseEntity<List<Usuario>> buscaTodosUsuariosControl(){
		List<Usuario> Usuarios = usuarioService.buscaTodosUsuarios();
		return ResponseEntity.ok(Usuarios);
	}

	@GetMapping("/produtos")
	@Operation(summary = "Apresenta todos os Produtos ")
	public ResponseEntity<List<Produto>> getAllProdutos() {
		List<Produto> produtos = produtoService.getAllProdutos();
		return ResponseEntity.ok(produtos);
	}

}
