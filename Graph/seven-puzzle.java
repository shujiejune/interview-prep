/* Given eight cards with 0-7 on them, the cards are aligned to be a 4x2 board (2 rows, 4 columns).
 * In each step only card 0 can be swap with oneof its adjacent (top, right, bottom, left) card.
 * Find the minimum number of steps from the given state to the final state:
 * 0 1 2 3
 * 4 5 6 7
 * If there is no way to the final state, return -1.
 */
public int numOfSteps(int[] values)
