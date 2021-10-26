#language: pt

@funcionais
Funcionalidade: Cadastro de contas

Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Contexto:
Dado que estou acessando a aplicação
Quando informo o usuário "rm@gmail.com"
E a senha "carreta"
E seleciono entrar
Então visualizo a página inicial
Quando seleciono Contas
E seleciono Adicionar
	
Esquema do Cenário: Deve validar cadastro contas
Quando informo a conta "<conta>"
E seleciono Salvar
Então recebo a mensagem "<mensagem>"

Exemplos:
| conta            | mensagem                          |
| Conta de teste   | Conta adicionada com sucesso!     |
|                  | Informe o nome da conta           |
| Conta mesmo nome | Já existe uma conta com esse nome!|

