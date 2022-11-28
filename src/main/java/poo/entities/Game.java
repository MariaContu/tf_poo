//ALTERAR

package poo.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private static Game game = new Game();

	Jogador p1, p2;
	Jogador vencedor;

	private int turnos;

	Scanner in = new Scanner(System.in);
	private List<GameListener> observers;
	
	public static Game getInstance() {
		return game;
	}

	private Game() {
		p1 = new Jogador("Player 1");
		p2 = new Jogador("Player 2");
		vencedor = null;
		turnos=0;
		observers = new LinkedList<>();
	}

	public void decidePrimeiroJogador() {
		int turnos = (int)Math.round(Math.random());
	}

	private boolean morto(Jogador jogador) {
		return jogador.getPokemonVivos()<=0;
	}

	public boolean checkVencedor() {
		if (morto(p1)) {
			vencedor = p2;
			return true;
		}
		if (morto(p2)) {
			vencedor = p1;
			return true;
		}
		return false;
	}

	public Jogador jogadorAtual() {
		if (turnos%2==0) return p1;
		return p2;
	}

	public void primeiroTurno(Jogador jogador) {
		System.out.println("--------Começo do Turno--------");
		System.out.println(jogador.getNome());
		System.out.println("Mão: \n" + jogador.getMao());
		for (int i=0;i<5;i++) {
			System.out.println("Escolha um pokemon para reserva");
			String escolha = in.nextLine();
			jogador.addPokeNaReserva(escolha);
			System.out.println("Deseja colocar outro? (s/n)");
			escolha = in.nextLine();
			if (escolha.equals("n")) break;
		}
		System.out.println("Escolha um pokemon principal");
		System.out.println("Reserva: \n" + jogador.getReserva());
		String escolha = in.nextLine();
		jogador.trocaPokeAtivo(escolha);
		System.out.println("Fim do turno");
		turnos++;
	}

	public void turno(Jogador jogador) {
		System.out.println("--------Começo do Turno--------");
		System.out.println(jogador.getNome());
		if (jogador.getPokemonAtivo()==null) {
			System.out.println("Escolha um novo pokemon ativo");
			System.out.println("Reserva: \n" + jogador.getReserva());
			in.nextLine();
			jogador.trocaAtivoMorto(in.nextLine());
		}
		boolean repeat = true;
		while (repeat) {
			System.out.println("Mão: \n" + jogador.getMao());
			System.out.println("Reserva: \n" + jogador.getReserva());
			System.out.println("Pokemon Ativo: \n" + jogador.pokemonAtivoString());
			System.out.println("Pilha: \n" + jogador.getPilha());
			System.out.println("Escolha uma ação: ");
			System.out.println("1 - Trocar Pokemon Ativo");
			System.out.println("2 - Colocar pokemon na reserva");
			System.out.println("3 - Trocar Pokemon da reserva");
			System.out.println("4 - Usar carta de Treinador");
			System.out.println("5 - Avançar");
			int opção = in.nextInt();
			switch (opção) {
				case 1:
					System.out.println("Escolha o pokemon ativo");
					jogador.trocaPokeAtivo(in.nextLine());
					break;
				case 2:
					System.out.println("Escolha o pokemon para reserva");
					jogador.addPokeNaReserva(in.nextLine());
					break;
				case 3:
					System.out.println("Escolha o pokemon para trocar");
					String name = in.nextLine();
					System.out.println("Escolha o pokemon para reserva");
					jogador.trocaPokeNaReserva(name, in.nextLine());
					break;
				case 4:
					System.out.println("Escolha a carta de treinador");
					jogador.usarTreinador(in.nextLine());
					break;
				case 5: repeat = false;
			}
		}
		System.out.println("Escolha uma ação: ");
		System.out.println("1 - Atacar inimigo");
		System.out.println("2 - Comprar uma carta");
		int opção = in.nextInt();
		if (opção==1) jogador.atacar(jogador.getInimigo());
		else jogador.comprarCarta();
		System.out.println("Fim do turno");
		turnos++;
	}

	public void jogar () {
		primeiroTurno(jogadorAtual());
		primeiroTurno(jogadorAtual());
		while(!checkVencedor()) {
			turno(jogadorAtual());
		}
		System.out.println("Vencedor: " + vencedor.getNome());
	}

	public void reiniciarJogo()	{
		new Game();
	}

	/*
	public void play(CardDeck deckAcionado) {
		GameEvent gameEvent = null;
		if (player == 3) {
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.MUSTCLEAN, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
			return;
		}
		if (deckAcionado == deckJ1) {
			if (player != 1) {
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				// Vira a carta
				deckJ1.getSelectedCard().flip();
				// Proximo jogador
				nextPlayer();
			}
		} else if (deckAcionado == deckJ2) {
			if (player != 2) {
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				// Vira a carta
				deckJ2.getSelectedCard().flip();
				// Verifica quem ganhou a rodada
				if (deckJ1.getSelectedCard().getValue() > deckJ2.getSelectedCard().getValue()) {
					ptsJ1++;
				} else if (deckJ1.getSelectedCard().getValue() < deckJ2.getSelectedCard().getValue()) {
					ptsJ2++;
				}
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
				// Próximo jogador
				nextPlayer();
			}
		}
	}

	// Acionada pelo botao de limpar
	public void removeSelected() {
		GameEvent gameEvent = null;
		if (player != 3) {
			return;
		}
		jogadas--;
		if (jogadas == 0) {
			gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ENDGAME, "");
			for (var observer : observers) {
				observer.notify(gameEvent);
			}
		}
		deckJ1.removeSel();
		deckJ2.removeSel();
		nextPlayer();
	}
	*/

	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}


}
