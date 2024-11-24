# Plataforma_De_Curso_Online
 O projeto ambienta-se com base em um sistema de curso online, onde se cadastra os alunos e demonstra a disponibilidade de curso e professores, sendo eles categorizado por curso e disponibilidade (Presencial/Online).

 Sistema Da Plataforma De Curso Online:
Entidades: Aluno, Curso, CursoOnline, CursoPresencial e Instrutor;
Interfaces: Todas as entidades e Interface;
Heranças: CursoOnline e CursoPresencial;
Enums: TipoCurso (Presencial ou Online);
Repositório: Aluno, Curso e Instrutor;

Sobre o assunto:
O sistema foi criado buscando cadastrar alunos e identifica-lós com base no curso e tipo, e a listagem dos cadastrados, foi visado para ser o inicio, um rascunho, de um grande projeto ainda à ser desenvolvido.

Como Funciona:
O sistema cadastra os usuários, instrutores e curso, separando por tipos (Presencial e Online), implementando um sistema de CRUD, além disso uma listagem completa dos Instrutores, Curso e Alunos, demonstrando sua matrícula (Fornecida pelo sistema) e exibindo informações registradas anteriormente.

Classes Principais:

Aluno:
Atributos: nome, id e tipoCurso;
Metódos: criarAluno(), listarAluno(), alterarAluno(), removerAluno()

Instrutores:
Atributos: nome, id e tipoCurso;
Metódos: adicionarInstrutor(), removerInstrutor(), listarInstrutor();

Curso:
Atributos: titulo, tipoCurso, horaAula, dias, id;
Metódos: adicionarCurso(), removerCurso(), listarCurso();

Observações:
O código ainda precisa de melhorias já visadas;
O titulo referente ao Curso refere-se ao nome do curso;
O sistema ainda deve ser integrado com um Banco de Dados;
