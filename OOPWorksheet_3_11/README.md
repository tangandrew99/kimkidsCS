# OOP Worksheet 4 — Java Objects & Instances

**Topics:** Instantiation · ArrayLists · Instance Methods · For-Each Loops · Objects as Arguments · Nested Objects

---

## Getting Started

### Opening in IntelliJ
1. Open IntelliJ IDEA
2. **File > Open** and select this folder (`OOPWorksheet4`)
3. Click **OK / Trust Project**
4. Go to **File > Project Structure > Project** and set your SDK to your installed JDK
5. If prompted about JUnit, let IntelliJ download it automatically

### Running Tests
- Right-click any test file in the Project panel → **Run 'XxxTest'**
- Or open a test file and click the green ▶ button next to any `@Test` method
- All tests should pass once your code is correct

---

## Problems

---

### Problem 1 — Basic Instantiation with ArrayList
📁 `Problem1_Team`

Create a `Team` class with four fields:
- `name` (String)
- `city` (String)
- `championships` (int)
- `roster` (ArrayList of Strings)

The constructor should take `name`, `city`, and `championships` as parameters and set each field. The `roster` should be initialized as a **new empty ArrayList** inside the constructor — not passed in as a parameter.

Add a method `addPlayer(String player)` that adds a player's name to the roster.

In `Main`, create **two** Team objects with different names and cities. Add a few players to each team. Print each team's name, city, championships, and roster using dot notation.

**Example output:**
```
Lakers | Los Angeles | 17 championships
Roster: [LeBron James, Anthony Davis]

Bulls | Chicago | 6 championships
Roster: [Michael Jordan, Scottie Pippen]
```

**Files to edit:** `Team.java`, `Main.java`

---

### Problem 2 — Instance Methods with For-Each
📁 `Problem2_Playlist`

Create a `Playlist` class with two fields:
- `title` (String)
- `songs` (ArrayList of Strings)

The constructor takes `title` and initializes `songs` as a new empty ArrayList.

Add two methods:
- `addSong(String song)` — adds a song to the list
- `printSongs()` — uses a **for-each loop** to print each song, prefixed with the playlist title

In `Main`, create **two** Playlist objects, add songs to each, and call `printSongs()` on both. Notice how the same method produces different output depending on the instance.

**Example output:**
```
Chill Vibes: Blinding Lights
Chill Vibes: Levitating
Chill Vibes: Stay

Workout Mix: Eye of the Tiger
Workout Mix: Lose Yourself
```

**Files to edit:** `Playlist.java`, `Main.java`

---

### Problem 3 — Object as Argument
📁 `Problem3_Player_and_ProfilePrinter`

Create a `Player` class with three fields:
- `name` (String)
- `age` (int)
- `hobbies` (ArrayList of Strings)

The constructor takes `name` and `age`. The `hobbies` list starts empty. Add an `addHobby(String hobby)` method.

Create a separate `ProfilePrinter` class with a method `printProfile(Player p)` that:
- Prints the player's name and age
- Uses a **for-each loop** to print each hobby, prefixed with `"- "`

In `Main`, create a `ProfilePrinter` instance. Create **3 different Player objects**, add hobbies to each, and use the `ProfilePrinter` to print all three profiles.

**Example output:**
```
Name: Alex | Age: 20
- Gaming
- Hiking

Name: Sam | Age: 18
- Reading
- Cooking
- Drawing
```

**Files to edit:** `Player.java`, `ProfilePrinter.java`, `Main.java`

---

### Problem 4 — ArrayList of Objects
📁 `Problem4_MovieCollection`

Create a `Movie` class with two fields:
- `title` (String)
- `rating` (int, 1–5)

Create a `MovieCollection` class with:
- A `movies` field (ArrayList of Movie objects) initialized as empty in the constructor
- `addMovie(Movie m)` — adds a movie to the list
- `printHighRated(int minRating)` — uses a **for-each loop** to print only movies where `rating >= minRating`

In `Main`, create a `MovieCollection`, add **5 movies** with a mix of ratings, then call `printHighRated(4)`.

**Example output:**
```
Inception (5/5)
Dune (4/5)
Interstellar (5/5)
```

**Files to edit:** `Movie.java`, `MovieCollection.java`, `Main.java`

---

### Problem 5 — Three Linked Objects *(Capstone)*
📁 `Problem5_Smash_Roster`

Create three classes that link together:

**`Move`**
- `name` (String)
- `damage` (int)
- Constructor sets both fields

**`Fighter`**
- `name` (String)
- `franchise` (String)
- `finalSmash` (Move) — a whole Move object!
- Constructor takes all three and sets each field

**`Roster`**
- `fighters` (ArrayList of Fighter objects) — starts empty
- `addFighter(Fighter f)` — adds a fighter to the list
- `printRoster()` — uses a for-each loop to print each fighter's name, franchise, and their final smash name + damage using **chained dot notation**: `fighter.finalSmash.name`

In `Main`, create **3 Move objects**, use them to create **3 Fighter objects**, add all three to a `Roster`, then call `printRoster()`.

**Example output:**
```
Link | The Legend of Zelda | Final Smash: Triforce Slash (37 dmg)
Pikachu | Pokemon | Final Smash: Volt Tackle (50 dmg)
Marth | Fire Emblem | Final Smash: Critical Hit (40 dmg)
```

**Files to edit:** `Move.java`, `Fighter.java`, `Roster.java`, `Main.java`

---

*Good luck!*
