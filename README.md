# challenge
Sistema Loja Microserviços

Desafio de recrutamento de maestro
A empresa ACME está migrando seu sistema monolítico para uma arquitetura de microsserviço e você é responsável por construir seu MVP (produto mínimo viável). https://en.wikipedia.org/wiki/Minimum_viable_product

Seu desafio é: Construir um aplicativo com os recursos descritos abaixo, se você acha que os requisitos não são detalhados o suficiente, deixe um comentário (português ou inglês) e proceda da melhor maneira possível.

Você pode escolher quantos recursos achar necessários para o MVP, NÃO É necessário construir todos os recursos, recomendamos enfaticamente focar na qualidade em vez da quantidade, você será avaliado pela qualidade de sua solução.

Se você acha que algo é realmente necessário, mas não tem tempo suficiente para implementar, pelo menos explique como você o implementaria.


Tecnologias utilizadas: Spring Boot, Spring Cloud, Spring Security, Spring Data, MariaDB, GIT, API Gateway Zull, Criptografia ALF2, Eureka, Postman.
IDE: Eclipse

Modo de inicialização: Baixar banco de dados MariaDB e estabeler uma conexão, logo após inicializar os microserviços.

Foi feito a implementação de 7 microserviços:
	* Loja microserviço que é responsável pelas requisições de compras de produtos da loja.
	* Fornecedor microserviço responsável por disponibilizar as informações referentes aos produtos da loja
	* Pagamento  microserviço responsável por realizar o pagamento e armazenar os dados no banco de dados referente aos pagamentos das compras.
	* ConfigServer microserviço responsável por guardar as configurações padrões de banco de dados e cloud da nossa aplicação.
	* Auth microserviço responsável por realizar a parte de segurança da nossa aplicação juntamente com Spring Security e ALF2.
	* Eureka-server Microserviço responsável por ser nosso Service Discovery da aplicação disponibilizando e organizando nossos serviços.
	* Zull microserviço responsável por ser o API Gateway da aplicação.
	


	
