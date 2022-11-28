# Gerenciamento_de_Projetos
Sistema gestor de projetos como componente curricular da disciplina de P2 - Programação 2 (Projeto de Software).


Para executar o programa:


    - instale a JDK ou a JVM do Java e;


    - no terminal/prompt rode o seguinte comando entre aspas: "java Main".



Descrição de Code Smells:


    - God class em Manager.java;


    - taskExist() na classe Manager é um método que poderia estar na classe Projeto, um método invejoso;


    - printAllinfos na classe Manager é um método invejoso. Ele pega muitas coisas das classes Projetos e Activitie;


Tratamento com Design Patterns:


    - A Large Class/God Class em Manager foi criada uma classe para cada opção do menu pelo padrão Command minimizando o tamanho da classe Manager que antes tinha 538 linhas e passou a ter com o Command 231 linhas. Dentre as classes criadas estão SetDateTime(), RemoveProjectManager() e InterchangeUser(). Isso aumentou muito o número de classes;


    - O método taskExist() foi movido para a classe Projeto() e refatorado minimizando as linhas do mesmo. Ou seja, utilizou-se o design pattern Extract Method;


    - printAllInfos() em override na classe Manager() teve código extraído em método menores utilizando o design pattern Extract Method. Os métodos criados foram os printActs() e o printInfoUser();

    