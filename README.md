# kiguel-api
API system to manage Bolão Bola 16 teams, players and tournaments

# TO-DO

## O que falta (está parcialmente pronto)?
- [ ] Alterar o método delete, pra somente inativar, clube, jogador;
- [ ] Delete do teamplayer deve adicionar uma data final (endDate) ao vínculo de time-jogador -> significa que o jogador pode ir para outro time;

## Parâmetros do Campeonato
- [x] Número de bolas (formato campeonato). O campeonato pode ter: 20, 40, 80 e 120 bolas;
- [ ] Número de jogadores. Quantidade de jogadores por time;
- [ ] Critério de desempate (aqui pode ser uma seleção multipla):
  - [ ] Quantidade de 9 no limpa (cancha 2 e 4);
  - [ ] Quantidade de 8 real (que fica o pino do meio em pé) no limpa (cancha 2 e 4);
  - [ ] Quantidade de 9 geral;
  - [ ] Quantidade de 8 geral;
  - [ ] Quantidade de 7 geral;
  - [ ] Assim por diante.
- [ ] Condição para pontos individuais;
