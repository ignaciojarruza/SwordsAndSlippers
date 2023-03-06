package Arena;

/**
 * Battle interface. A battle supports two player objects to battle until one is the victor.
 * @author Ignacio Arruza
 */
public interface Battle {

    /**
     * Provides a summary of both players and their attributes.
     * @return summary text
     */
    public String provideSummary();

    /**
     * Begins battle between two players until one is the victor. Prints out who the winner is.
     */
    public void battle();
}
