
# kiguel-api
Kiguel será um programa para gerenciar times, jogadores e campeonatos de Bolão Bola 16 e Bola 23. Quando pronto permitirá a gestão completa, como se fosse a federação, gerindo as transferências de jogadores e tudo mais.
Claro sem a parte burocratica, pois isso não é sabido ao certo como funciona.

É muito provável que fique faltando funções, detalhes importantes de quem conhece o negócio a fundo. Caso tenha ideias de evoluções e melhorias, tanto no código quanto no negócio, mande as ideias, vamos implementar.

# Regras do bolão, importante saber para programar
- São sempre 4 pistas;
- Nos jogos de 20 e 40 bolas é uma vez em cada pista;
	- As canchas impares é o cheio.
		- Cheio significa que você joga e, indiferente dos pinos que ficarem em pé, a proxima jogada vem todos novamente;
- Nos jogos de 80 e 120 é duas vezes em cada pista;
	- As canchas pares é o limpa;
		- Limpa significa que você joga e, enquanto não derrubar tudo, os pinos continuam lá;
		- No limpa o pino central não conta, logo se somente ele ficar em pé, a proxima jogada voltam todos os pinos;
- É importante diferenciar o 8 do 8 real, que é quando fica o pino central em pé;
	- Tanto no limpa quanto no cheio;
	- No limpa pode ser que ele derrube só 1 pino e fique o pino central em pé, nesse caso marcar o 1 pino derrubado com a mesma marcação do 8 real;
	
# O que falta a gente fazer? 
### Que já está parcialmente pronto...

- Alterar o método delete, pra somente inativar, clube, jogador;
- Delete do teamplayer deve adicionar uma data final (endDate) ao vinculo de time-jogador -> significa que o jogador pode ir para outro time;
	
# O que falta fazer ainda?
- as entidades e crud do campeonato
- bem como os vinculos de times e jogadores ao campeonato
- criar as entidades de fase de grupos e mata-mata
- colocar as lógicas para criação do campeonato
- ter a lógica para montar os confrontos com base nos horários e datas inicias e finais do campeonato
- fazer funcionar todo o campeonato com base nos pontos feitos em cada bola por cada jogador em cada confronto
- ter os relatórios individuais e por time

# Parâmetros do campeonato
- Número de bolas (formato campeonato)
	- O campeonato pode ter: 20, 40, 80 e 120 bolas;
- Número de jogadores
	- Quantidade de jogadores por time;
- Critério de desempate (aqui pode ser uma seleção multipla)
	- Quantidade de 9 no limpa (cancha 2 e 4);
	- Quantidade de 8 real (que fica o pino do meio em pé) no limpa (cancha 2 e 4);
	- Quantidade de 9 geral;
	- Quantidade de 8 geral;
	- Quantidade de 7 geral;
	- Assim por diante;
- Condição para pontos individuais;
	- Somente finais -> Regra: total_de_pinos / 2 (semi e final);
	- Campeonato completo -> Regra: total_de_pinos / numero_de_jogos;
		- Ter um detalhe para essa regra -> número minimo de partidas para essa condição;
- Formato campeonato -> ter as opções abaixo
	- Fase de grupos (checkbox)
	- Mata-mata (chaveamento) (checkbox)
		> EM UM FUTURO: Se só tiver selecionado o mata-mata habilitar nova opção de winner e lower bracket;
- Pausa ao meio diante
	-  Um indicador se o campeonato pausa ao meio dia pra almoço
- Hora inicial e final das partidas
	- Informar que horas começam e terminam as partidas
	- Se o pausa ao meio dia for selecionado então dizer que horas pausa e retoma
- Tempo de partida
	- Quanto tempo dura o confronto entre os times
- Dia que começa e termina o campeonato
		
# Regra geração tabela campeonato
### Se tiver fase de grupos selecionado
Com base no número de times do campeonato sugerir a quantidade de grupos, vamos por enquanto com base na regra abaixo:

	< 6 = 1 grupo;
	> 6 <= 8 = 1 ou 2 grupos;
	> 8 <= 12 = 2 ou 3 grupos;
	> 12 <= 16 = 2, 3 ou 4 grupos;
	> 16 <= 20 = 3, 4 ou 5 grupos;
Daqui em diante a cada 4 times, sobe em 1 a quantidade de grupos, removendo a primera opção (valor mais baixo);
Informar quantos times passam por grupo, com base no número de grupos, vamos por enquanto com base na regra abaixo:

	1 grupo = 4;
	- Esse talvez seja o único default, depois tem que pensar
	-  Número par de grupos beleza, sabendo que o mata mata precisa de uma razão potencial sobre, entre a quantidade de times, tipo 2, 4, 8, 16 (2, 2², 2³...);
	- Quando o número de grupos for impar sugerir o melhor segundo conforme precisar de times para suprir a necessidade da tabela;
	- Se precisar sugerir o melhor terceiro, e assim por diante;
		
### Se o mata mata for selecionado
Montar a fase final com base na razão potencial de 2, final, semi, oitavas ...
> EM UM FUTURO: se a quantidade de times não combar com a razão potencial lá, fazer fases anteriores com os times de pior colocação de cada grupo;