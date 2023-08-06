package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	private String name;
	private int deckSize;
	private Card[] deckList;

	// TODO: constructor

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = deckList;
	}

	// You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		for (Card cards : this.deckList) {
			if (card.isEqual(cards)) {
				count++;
			}
		}
		if (count >= 4) {
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		} else {
			deckSize += 1;
			deckList = Arrays.copyOf(deckList, deckSize);
			deckList[deckSize - 1] = card;
			return deckSize;
		}

		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Must return new deckSize

	}

	// You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		// FILL CODE HERE
		Card removedCard = deckList[slotNumber];
		Card[] deckListRemoved = new Card[deckSize - 1];
		for (int i = 0, k = 0; i < deckSize; i++) {
			if (i == slotNumber) {
				continue;
			}
			deckListRemoved[k++] = deckList[i];
		}
		deckSize -= 1;
		deckList = Arrays.copyOf(deckListRemoved, deckSize);
		return removedCard;

		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Once card is removed, other card down the list must rearrange to the empty
		// slot
		// Must return card that was removed
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append("}").append("(").append(this.getDeckSize())
				.append(" deck size)").toString();
	}

	/* GETTERS & SETTERS */
	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public String getName() {
		return name;
	}

	public Card[] getDeckList() {
		return deckList;
	}

}
