# Interdisciplinar_SI


## Projeto interdisciplinar - Sistemas de Informação 4º Semestre

### 1º - Baixar Repository em sua máquina local.

Este pode ser feito de duas maneiras, via terminal/cmd, utilizando o seguinte comando:

git clone https://github.com/SchonsG/Interdisciplinar_SI.git

Ou, através do botão 'Download Zip' na opção 'Code' em verde na tela inicial do projeto. Neste caso, o arquivo deverá ser descompactado no local desejado.

### 2º - Push Repository

É importante aceitar o convite de colaboração do projeto antes de tentar puxar o projeto para sua máquina local. Do contrário será negado o acesso. Esse convite deve estar no e-mail ou no próprio github.

Adicionar 'Origin' do Repository. Deve ser feito na pasta do projeto, pode ser através da opção de terminal do VS Code, ou terminal/cmd de forma direta.

Comandos:

git remote add origin https://github.com/SchonsG/Interdisciplinar_SI.git

git branch -M main

git push -u origin main

### Só codar ;)

Lembrete:

Para iniciar o mvn spring-boot, basta usar o comando:

mvn spring-boot:run

http://localhost:8080/index.xhtml

### importante!

Lembrem-se que por hora o banco de dados está na máquina local de cada um, logo, deverá ser configurado o arquivo "application.properties" conforme suas próprias configurações.

Para auxilio nos comandos do git: https://www.youtube.com/watch?v=2alg7MQ6_sI&ab_channel=Rocketseat

Dados:

- As bibliotecas necessárias já estão inclusas no arquivo 'pom.xml'. (ServerFaces, PrimeFaces e SQL Server)
- Versão Java: 11
