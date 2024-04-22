# me-adota

## Aplicação desenvolvida em Kotlin + Spring Framework
## Aplicação voltada para um ambiente de adoção de pets, relacionando a adoção entre uma pessoa/cliente e um pet a ser adotado.
### Back-end sem a implementação de testes integrados e unitários ( necessário um estudo aprofundado )


```mermaid
classDiagram
  class Interested {
    -Id: Integer
    -Nome: String
    -Cpf: String
    -Birthday: Date
    -Address: Adress
  }
   class Address{
    -Street: String
    -NumberHouse: Integer
    -ZipCode: Integer
  }

  class Pets {
    -Id: Integer
    -Name: String
    -Race: String
    -Color: String
    -LifeTime: String
  }

  Interested "1..*" -- "1" Pets
  Interested "1" -- "1" Address
```
