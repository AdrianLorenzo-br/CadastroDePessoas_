🚀 Sistema de Gerenciamento de Colaboradores e Tarefas

📝 Descrição do Projeto

Este projeto é uma aplicação completa (Full-stack) para gerenciamento de colaboradores e suas tarefas. O sistema oferece uma API RESTful para manipulação de dados e uma interface web para visualização e interação, servindo como um projeto prático para aplicar conceitos de desenvolvimento backend com Spring Boot.

✨ Funcionalidades
A aplicação permite as seguintes operações:

Gerenciamento de Colaboradores (CRUD): Criar, visualizar, alterar e deletar informações de colaboradores.

Associação de Tarefas: Cada colaborador pode ser associado a uma tarefa específica.

Visualização Detalhada: Páginas dedicadas para exibir os detalhes de cada colaborador e suas tarefas.

Controle de Dados: Manipulação de dados de colaboradores como nome, email, idade, cargo e URL de imagem.

🛠️ Tecnologias Utilizadas
Backend: Java 24 e Spring Boot.

Web Framework: Spring MVC com Thymeleaf para renderização de views.

Banco de Dados: H2 Database (em memória, acessível via console web).

ORM: Spring Data JPA e Hibernate.

Migrações de BD: Flyway.

Ferramenta de Build: Maven.

Utilitários: Lombok (para geração de código boilerplate).

📂 Estrutura do Projeto
A estrutura do projeto segue as convenções de um projeto Spring Boot.

src/main/
├── java/
│   └── dev/Adrian/CadastroDePessoas/
│       ├── CadastrodePessoasApplication.java  (Classe principal)
│       ├── Colaboradores/  (Classes de modelo, controller, service e repositório para Colaboradores)
│       └── Tarefas/        (Classes de modelo, controller e repositório para Tarefas)
├── resources/
│   ├── application.properties    (Configurações do Spring Boot)
│   ├── migrations/               (Scripts de migração do Flyway)
│   └── templates/                (Templates HTML do Thymeleaf)
└── test/
└── ...
🚀 Como Rodar o Projeto
Pré-requisitos
Java Development Kit (JDK) 24

Maven

Instruções
Clone o repositório:

Bash

git clone https://github.com/adrianlorenzo-br/cadastrodepessoas.git
Navegue até o diretório do projeto:

Bash

cd cadastrodepessoas
Execute a aplicação usando Maven:

Bash

./mvnw spring-boot:run
A aplicação será iniciada no http://localhost:8080.

🌐 Endpoints da Aplicação
Interface Web:

http://localhost:8080/colaboradores/ui/listar - Lista todos os colaboradores.

http://localhost:8080/colaboradores/ui/adicionar - Exibe o formulário de cadastro.

API REST (Principais Endpoints):

GET /colaboradores/listar - Lista todos os colaboradores.

GET /colaboradores/listar/{id} - Busca um colaborador por ID.

POST /colaboradores/criar - Cria um novo colaborador.

PUT /colaboradores/alterar/{id} - Atualiza um colaborador existente.

DELETE /colaboradores/deletar/{id} - Deleta um colaborador por ID.

🤝 Autor
Adrian Lorenzo

Se tiver alguma dúvida, sugestão ou feedback, sinta-se à vontade para abrir uma issue ou entrar em contato.
