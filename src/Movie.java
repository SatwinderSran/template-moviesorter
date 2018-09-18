import java.text.DateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Stores basic movie information.
 */
public class Movie implements Comparable<Movie> {

	private final String title;
	private final double rating;

	private final Calendar released;
	private final Duration length;

	/**
	 * Initializes a new movie object.
	 *
	 * @param title the title of the movie
	 * @param released the release date of the movie
	 * @param length the length of the movie
	 * @param rating the IMDB rating of the movie
	 */
	public Movie(String title, Calendar released, Duration length, double rating) {
		this.title = title;
		this.released = released;
		this.length = length;
		this.rating = rating;
	}

	/**
	 * Returns the movie title
	 * @return movie title
	 */
	public String title() {
		return this.title;
	}

	/**
	 * Returns the movie rating from IMDB.
	 * @return IMDB rating
	 */
	public double rating() {
		return this.rating;
	}

	/**
	 * Returns the year this movie was released.
	 * @return year released
	 */
	public int year() {
		return this.released.get(Calendar.YEAR);
	}

	/**
	 * Returns the length in minutes.
	 * @return length in minutes
	 */
	public long minutes() {
		return this.length.toMinutes();
	}

	@Override
	public String toString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		String stringFormat = "\"%s\", released %s, %d minutes long, %2.1f rating";

		Object[] args = {
				this.title,
				dateFormat.format(this.released.getTime()),
				this.minutes(),
				this.rating
		};

		return String.format(stringFormat, args);
	}

	/**
	 * Compares two {@link Movie} objects first by their title ignoring case in
	 * ascending order, and if the titles are equal, then by their release date in
	 * descending order.
	 *
	 * @see String#compareToIgnoreCase(String)
	 * @see String#CASE_INSENSITIVE_ORDER
	 * @see Comparator#comparing(java.util.function.Function)
	 * @see Comparator#thenComparing(Comparator)
	 * @see Movie#title
	 * @see Movie#released
	 */
	@Override
	public int compareTo(Movie other) {
		// TODO Implement this however you want.
		return -1;
	}

	// TODO Implement by creating a private static nested class and creating an instance.
	/**
	 * A {@link Comparator} that orders {@link Movie} objects by their title in
	 * case insensitive ascending order.
	 *
	 * @see String#compareToIgnoreCase(String)
	 * @see String#CASE_INSENSITIVE_ORDER
	 * @see Movie#title
	 */
	public static final Comparator<Movie> TITLE_CASE_INSENSITIVE_ORDER = null;

	//  TODO Implement by creating an anonymous inner class.
	/**
	 * A {@link Comparator} that orders {@link Movie} objects by their length in
	 * ascending order.
	 *
	 * @see Duration#compareTo(Duration)
	 * @see Movie#length
	 */
	public static final Comparator<Movie> LENGTH_ORDER = null;

	// TODO Implement using a lambda expression.
	/**
	 * A {@link Comparator} that orders {@link Movie} objects by their release date
	 * in descending order.
	 *
	 * @see Calendar#compareTo(Calendar)
	 * @see Movie#released
	 */
	public static final Comparator<Movie> RELEASE_ORDER = null;

	// TODO Implement using Comparator.comparingDouble and a method reference.
	/**
	 * A {@link Comparator} that orders {@link Movie} objects by their rating in
	 * ascending order.
	 *
	 * @see Comparator#comparingDouble(java.util.function.ToDoubleFunction)
	 * @see Movie#rating
	 */
	public static final Comparator<Movie> RATING_ORDER = null;

	/**
	 * Creates and outputs a movie instance.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		// TODO You may modify this however you want.

		Movie m1 = new Movie(
				"The Lord of the Rings: The Fellowship of the Ring",
				new GregorianCalendar(2001, Calendar.DECEMBER, 19),
				Duration.ofHours(2).plusMinutes(58),
				8.8);

		Movie m2 = new Movie(
				"The Lord of the Rings: The Two Towers",
				new GregorianCalendar(2002, Calendar.DECEMBER, 18),
				Duration.ofHours(2).plusMinutes(59),
				8.7);

		Movie m3 = new Movie(
				"The Lord of the Rings: The Return of the King",
				new GregorianCalendar(2003, Calendar.DECEMBER, 17),
				Duration.ofHours(3).plusMinutes(21),
				8.9);

		ArrayList<Movie> movies = new ArrayList<>();
		Collections.addAll(movies, m2, m1, m3);
		Collections.sort(movies);
		movies.forEach(System.out::println);
		System.out.println();
	}
}
