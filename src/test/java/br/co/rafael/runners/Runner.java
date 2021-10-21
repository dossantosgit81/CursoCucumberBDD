package br.co.rafael.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/alugar_filme.feature",
		glue = {"br.co.rafael.steps"},
		tags={},
		
		//Executa os códigos que o console(System.out) for invocado
		plugin = {"pretty"},
		
		//Não vai tentar colorir os comandos e nem usará caracteres especiais
		monochrome=true,
		
		//Cria os metodos em formato camelCase
		snippets = SnippetType.CAMELCASE,
		
		//Executa os metodos para testar o mapeamento ,
		//Ou seja, os conteúdos dos metodos não serão executados
		//Para ativar, precisar deixar o valor true
	
		
		//Quando faltar um passo no arquivo feature, no código onde foi mapeado,
		//Não será executado, ou seja o teste falhará
		strict = true
		)
public class Runner {
	
	

}
