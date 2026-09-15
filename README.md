<h2>Projeto Ecomerce Spring</h2>
<hr>
<h3>Explicação do Projeto</h3>
<p>
    O projeto foi realizado visando melhorar as habilidades com Java Spring simulando um ecomerce de pequeno porque podendo adicionar novos usuários, produtos alterar a quantidade do 
    produto no estoque e também adicionar produtos ao carrinho que é único para cada usuário.
    A aplicação permite o gerenciamento de usuários, produtos e estoque, além da
    possibilidade de adicionar produtos ao carrinho de compras. Cada usuário possui
    seu próprio carrinho.
</p>
<hr>
<h3>Funcionalidades</h3>
<ul>
    <li>Cadastro de usuários</li>
    <li>Autenticação e autorização utilizando JWT</li>
    <li>Criação e gerenciamento de produtos</li>
    <li>Controle de quantidade de produtos em estoque</li>
    <li>Criação de carrinho individual para cada usuário</li>
    <li>Adição e remoção de produtos do carrinho</li>
    <li>Criação e gerenciamento de pedidos</li>
    <li>Proteção dos endpoints através de autenticação</li>
</ul>
<hr>
<h3>Estrutura</h3>
<p>
    A estrutura do projeto foi organizada seguindo uma arquitetura em camadas,
    separando as responsabilidades em cinco principais componentes:
    <ul>
        <li>
            <strong>Entity</strong> — Responsável pela representação das entidades
            e pelo mapeamento das tabelas do banco de dados.
        </li>
        <li>
            <strong>Repository</strong> — Responsável pela comunicação com o banco
            de dados utilizando Spring Data JPA.
        </li>
        <li>
            <strong>Service</strong> — Responsável pelas regras de negócio da aplicação.
        </li>
        <li>
            <strong>DTO</strong> — Responsável pelo transporte dos dados entre as
            diferentes camadas da aplicação.
        </li>
        <li>
            <strong>Controller</strong> — Responsável pela criação e exposição dos
            endpoints da API REST.
        </li>
    </ul>
</p>
<hr>

<h3>Autenticação</h3>

<p>
    A aplicação utiliza <strong>JWT (JSON Web Token)</strong> para autenticação.
    Os endpoints da API são protegidos e exigem um token válido para serem acessados,
    com exceção das rotas relacionadas à autenticação.
</p>

```text
POST /auth/login
      ↓
Validação das credenciais
      ↓
Geração do JWT
      ↓
Cliente recebe o token
      ↓
Token enviado nas próximas requisições
      ↓
SecurityFilter valida o token
      ↓
Acesso ao endpoint
```

<hr>

<h3>Banco de Dados</h3>

<p>
    O projeto utiliza <strong>PostgreSQL</strong> como banco de dados.
    Durante o desenvolvimento, o banco foi executado através de um container Docker.
</p>

<h4>Executando o PostgreSQL</h4>

```bash
docker run -d \
  --name ecommerce \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=ecommerce \
  postgres:16.3
```

<p>
    Após iniciar o container, a aplicação poderá se conectar ao banco através da
    porta <strong>5432</strong>.
</p>
<hr>
<h3>Tecnologias</h3>

<p>
    <strong>Java 21</strong> ·
    <strong>Spring Boot</strong> ·
    <strong>Spring Security</strong> ·
    <strong>Spring Data JPA</strong> ·
    <strong>PostgreSQL</strong> ·
    <strong>Docker</strong> ·
    <strong>JWT</strong> ·
    <strong>Maven</strong>
</p>
