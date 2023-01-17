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

```
Resposta:
Durante a implementação de uma nova funcionalidade de software, eu avaliaria
e implementaria os seguintes critérios para garantia de qualidade de software:

Testes automatizados: Escreveria testes automatizados para garantir que a 
nova funcionalidade esteja funcionando corretamente e para evitar regressões 
futuras.

Documentação: Documentaria a nova funcionalidade, incluindo instruções de 
uso e exemplos, para garantir que os usuários possam entender e usar 
facilmente a funcionalidade.

Padrões de codificação: Seguiria os padrões de codificação estabelecidos 
para garantir a legibilidade e manutenibilidade do código.

Validação de entrada: Implementaria validações para garantir que a entrada 
do usuário esteja dentro dos limites esperados e evitar erros ou 
vulnerabilidades.

Performance: Mediria e otimizaria o desempenho da nova funcionalidade para 
garantir que ela seja responsiva e escalável.

Segurança: Verificaria se a nova funcionalidade está protegida contra 
possíveis ataques, como SQL Injection, XSS, entre outros.

Usuabilidade: Avaliaria a usabilidade da nova funcionalidade para garantir 
que ela seja fácil de usar e entender.

Eu sempre procuraria trabalhar em equipe e comunicar minhas preocupações e 
dúvidas com meus colegas de equipe e meus superiores para garantir que a 
qualidade do software seja alcançada e mantida.
```

2. Em qual etapa da implementação você considera a qualidade de software?

```

Resposta:

Eu considero a qualidade de software na etapa de implementação, pois é nessa
etapa que o software é desenvolvido e, portanto, é a etapa mais 
adequada para garantir a qualidade do software.

No entanto a qualidade de software é uma preocupação constante durante todo
o processo de implementação. Isso inclui desde a análise de requisitos até a 
entrega e manutenção do software. Durante a implementação, eu me certificaria
de seguir práticas de qualidade, como testes automatizados, documentação, 
padrões de codificação, validação de entrada, performance, segurança e 
usabilidade para garantir que o software seja confiável, seguro e fácil de 
usar. Eu sempre trabalharia em equipe e comunicaria minhas preocupações e 
dúvidas com meus colegas de equipe e superiores para garantir a qualidade do 
software.

```

## Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

- Criar uma pessoa

[post] http://localhost:8080/person-manager

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

[put] http://localhost:8080/person-manager/201

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

[get] http://localhost:8080/person-manager/51

- Listar pessoas
  

[get] [http://localhost:8080/person-manager]

- Criar endereço para pessoa

[post] http://localhost:8080/address?personId=1

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

[get] http://localhost:8080/address/51

- Poder informar qual endereço é o principal da pessoa  

[get] http://localhost:8080/address/main/1

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
