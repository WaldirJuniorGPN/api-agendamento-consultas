# Sistema de Agendamento de Consultas Médicas

## Sobre o Projeto
Este projeto é uma API RESTful desenvolvida com Spring Boot para gerenciar o agendamento de consultas médicas. A aplicação conecta clientes a médicos com base em suas especialidades e gerência todo o ciclo de agendamento, incluindo alterações e cancelamentos.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Swagger
- Lombok
- ModelMapper
- Flyway
- Maven

## Funcionalidades
- **Cadastro de Auxiliares**: Permite o cadastro, alteração, listagem e delete de auxiliares.
- **Cadastro de Convênios**: Permite o cadastro, alteração, listagem e delete de convênios médicos.
- **Cadastro de Especialidades**: Permite o cadastro, alteração, listagem e delete de especialidades médicas.
- **Cadastro de Médicos**: Permite o cadastro, alteração, listagem e delete de médicos, associando-os a uma ou mais especialidades.
- **Cadastro de Pacientes**: Permite o cadastro, alteração, listagem e delete de pacientes.
- **Cadastro de Agendas médicas**: Permite criar, alter, listar e deletar agendas médicas, associando-as a um médico.
- **Cadastro de Consultas Médicas**: Permite criar, alter, listar e deletar consulta médicas, associando-os a um paciente e a um médico.

## Como Começar
Para executar esta aplicação localmente, siga os passos abaixo:

### Pré-requisitos
- Java JDK 17
- Maven
- MySQL ou Docker

### Instalação
1. Clone o repositório
2. Execute o comando `mvn clean install` na raiz do projeto
3. Banco de dados
   1. Utilizando o Docker:
      1. Tenha instalado/instale o Docker e o Docker Compose
      2. Execute o arquivo `docker-compose.yml` com o comando `docker-compose up`
   2. Utilizando o MySQL:
      1. Tenha instalado/instale o MySQL
      2. Crie um banco de dados com o nome `clinic`
      3. Configure o arquivo `application-local.yml` com as credenciais do seu banco de dados


### Execução
1. Execute a aplicação com o comando `mvn spring-boot:run`
2. Acesse a documentação da API em `http://localhost:8080/swagger-ui.html`
3. Utilize a API conforme a documentação
4. Para parar a aplicação, pressione `Ctrl + C`
5. Para reiniciar a aplicação, execute o passo 1 novamente

