package hu.bomboclat.Game;

/**
 * A léptethető mezők működését megvalósító interfész.
 */
public interface Stepable{
    /**
     * a léptethető mező lépését megvalósító absztrakt függvény.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public abstract void Step(boolean rnd);
}