# 📁 Cadastrar Autores de Receitas

> Cadastrar autores utilizando o padrão MVC.

Antes de executar o programa você terá que fazer algumas etapas que são necessárias para se conectar com banco e fazer o sistema funcionar corretamente.

Algumas etapas podem mudar conforme a versão do seu SGBD ou a versão do Java que você está utilizando. Neste projeto eu utilizei o Java 17.0 e o MySql 8.0.27.  

Logo abaixo segue as instruções que deverão ser feitas para o correto funcionamento do sistema.

## Instrução

### Primeiramente temos que fazer a instalação do conector do SGBD com o nosso projeto, esse conector possui várias classes que permitem a conexão e a consulta de dados no SGDB. 

Para se conectar com o banco de dados é necessário instalar o driver de conexão (JDBC) do SGBD na IDE.

> Clique com o botão direito sobre a pasta do projeto, vá na opção “Open Module
Settings” para abrir as configurações do projeto. Em seguida, vá em “Libraries”, clique no sinal de “+” e em “java”, logo após adicione o .jar.

Verifique se na parte de dependências aparece a informação de que o Connector/J está realmente instalado como uma dependência do projeto. Se não aparecer a informação, copie e cole o código abaixo no seu **autores-de-receitas.iml**.

```
<orderEntry type="library" name="mysql-connector-java-8.0.27" level="project" />
```

### Agora que o driver já está instalado iremos configurar a conexão entre o SGBD e o nosso sistema.

O método *getConnection* recebe uma variável chamada de **url** que contém as informações necessárias para fazer a conexão via TCP/IP, as variáveis estáticas que estão contidas nela devem ser definidas com os valores que informam corretamente o local e a porta em que o seu SGBD está se comunicando e outros valores necessários que você deve completar.

```
    private static final String DB_NAME = "autor";
    private static final String ADDRESS = "127.0.0.1";
    private static final String PORTA = "3306";

    private static final String USUSARIO = "root";
    private static final String SENHA = "root";
```

### Por fim temos que criar a tabela no banco de dados que receberá os valores do nosso autor.
 
No seu SGBD crie um novo schema e nele crie uma tabela com os valores descritos abaixo.

```
create table Autor (

    id int auto_increment,
    nome varchar(100) default '' not null,
    email varchar(100) default '' not null,
    telefone varchar(100) default '' not null,
    receita varchar(100) default '' not null,
    
    constraint Autor_pk primary key (idAutor)
);
```

Se você conseguiu configurar as 3 etapas então já poderá executar o código que ele irá funcionar corretamente.
