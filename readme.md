# Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

## Esta análise propõe avaliar os seguintes temas:

- Qualidade de código
- Java, Spring boot
- API REST
- Testes

A entrega deverá ser feita da seguinte forma:

- O prazo para entrega da avaliação será de até 7 dias após envio da mesma
- Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub
- Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso

## Qualidade de código

1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?
2. Em qual etapa da implementação você considera a qualidade de software?

## Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

- Criar uma pessoa
[get](http://localhost:8080/person-manager/51)
```json
{
  "birthDate": "1975-03-20",
  "name": "José Cleiton C. Santos",
  "addresses": [
    {
        "city": "Camacari",
        "main": true,
        "number": "12",
        "publicPlace": "Vale",
        "zipCode": "12345"
      },
      {
        "city": "Aracaju",
        "main": false,
        "number": "12",
        "publicPlace": "Cabula",
        "zipCode": "12345"
      }
  ]
}
```

- Editar uma pessoa

[put] (http://localhost:8080/person-manager/5)
```json
{
  "birthDate": "1975-03-20",
  "name": "José Cleiton C. Santos",
  "addresses": [
    {
        "city": "Camacari",
        "main": true,
        "number": "12",
        "publicPlace": "Vale",
        "zipCode": "12345"
      },
      {
        "city": "Aracaju",
        "main": false,
        "number": "12",
        "publicPlace": "Cabula",
        "zipCode": "12345"
      }
  ]
}
```
- Consultar uma pessoa

[get] (http://localhost:8080/person-manager/51)


- Listar pessoas
[get] (http://localhost:8080/person-manager)


- Criar endereço para pessoa

[post] (http://localhost:8080/address?personId=1)
```json
{
  "city": "Camacari",
  "main": true,
  "number": "12",
  "publicPlace": "Vale",
  "zipCode": "12345"
}
```

- Listar endereços da pessoa
[get] (http://localhost:8080/address/51)
- Poder informar qual endereço é o principal da pessoa  
[get] (http://localhost:8080/address/main/1)
## Uma Pessoa deve ter os seguintes campos:  

- Nome
- Data de nascimento
- Endereço:
  - Logradouro
  - CEP
  - Número
  - Cidade

## Requisitos  

- Todas as respostas da API devem ser JSON  
- Banco de dados H2

## Diferencial

- Testes
- Clean Code

## Será levado em avaliação 

- Estrutura, arquitetura e organização do projeto  
- Boas práticas de programação  
- Alcance dos objetivos propostos
