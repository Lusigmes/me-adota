# me-adota

## Aplicação desenvolvida em Kotlin + Spring Framework
## Aplicação voltada para um ambiente de adoção de pets, relacionando a adoção entre uma pessoa/cliente e um pet a ser adotado.



```mermaid
classDiagram
  class Interested {
    -Id: Integer
    -Nome: String
    -Cpf: String
    -Birthday: Date
    -Adress: Adress
  }
   class Adress{
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
  Interested "1" -- "1" Adress
```
