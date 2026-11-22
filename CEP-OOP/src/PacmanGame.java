import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Food {
    private final int row;
    private final int column;
    private final boolean powerFood;
    private boolean eaten;

    public Food(int row, int column, boolean powerFood) {
        this.row = row;
        this.column = column;
        this.powerFood = powerFood;
        this.eaten = false;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public boolean isPowerFood() {
        return powerFood;
    }
    public boolean isEaten() {
        return eaten;
    }
    public void eat() {
        eaten = true;
    }
}

class Pacman {
    private final int startRow;
    private final int startColumn;
    private int row;
    private int column;
    private int score;
    private int lives;
    private int powerMovesLeft;   // how many moves the power-up still lasts

    public Pacman(int startRow, int startColumn, int lives) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.row = startRow;
        this.column = startColumn;
        this.lives = lives;
        this.score = 0;
        this.powerMovesLeft = 0;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getScore() {
        return score;
    }
    public int getLives() {
        return lives;
    }
    public boolean isPowered() {
        return powerMovesLeft > 0;
    }
    public int getPowerMovesLeft() {
        return powerMovesLeft;
    }

    public void addScore(int points) {
        score += points;
    }
    public void loseLife() {
        lives--;
    }

    public void activatePower(int moves) {
        powerMovesLeft = moves;
    }
    public void tickPower() {
        if (powerMovesLeft > 0) powerMovesLeft--;
    }

    public void resetPosition() {
        row = startRow;
        column = startColumn;
    }

    public boolean move(char direction, GameBoard board) {
        int newRow = row;
        int newColumn = column;
        switch (direction) {
            case 'W': newRow--; break;
            case 'S': newRow++; break;
            case 'A': newColumn--; break;
            case 'D': newColumn++; break;
            default: return false;
        }
        if (!board.isWall(newRow, newColumn)) {
            row = newRow;
            column = newColumn;
            return true;
        }
        return false;
    }
}

class Ghost {
    private final int startRow;
    private final int startColumn;
    private int row;
    private int column;
    private boolean scared;
    private final Random random = new Random();

    public Ghost(int startRow, int startColumn) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.row = startRow;
        this.column = startColumn;
        this.scared = false;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return column;
    }
    public boolean isScared() {
        return scared;
    }
    public void setScared(boolean scared) {
        this.scared = scared;
    }

    public void resetPosition() {
        row = startRow;
        column = startColumn;
        scared = false;
    }

    public void move(GameBoard board, Pacman pacman) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] chosen = null;

        if (random.nextBoolean()) {
            int bestScore = scared ? -1 : Integer.MAX_VALUE;
            for (int[] d : directions) {
                int newRow = row + d[0];
                int newColumn = column + d[1];
                if (board.isWall(newRow, newColumn)) continue;
                int distance = Math.abs(newRow - pacman.getRow())
                        + Math.abs(newColumn - pacman.getColumn());
                boolean better = scared ? distance > bestScore : distance < bestScore;
                if (better) {
                    bestScore = distance;
                    chosen = d;
                }
            }
        } else {
            for (int tries = 0; tries < 10 && chosen == null; tries++) {
                int[] d = directions[random.nextInt(4)];
                if (!board.isWall(row + d[0], column + d[1])) chosen = d;
            }
        }

        if (chosen != null) {
            row += chosen[0];
            column += chosen[1];
        }
    }
}

class GameBoard {
    private static final String[] LAYOUT = {
            "#####################",
            "#.........#.........#",
            "#.###.###.#.###.###.#",
            "#...................#",
            "#.###.#.#####.#.###.#",
            "#.....#...#...#.....#",
            "#.###.###.#.###.###.#",
            "#...................#",
            "#.###.###.#.###.###.#",
            "#.........#.........#",
            "#####################"
    };

    // 5 power food positions
    private static final int[][] POWER_SPOTS = {
            {3, 1}, {3, 19}, {7, 1}, {7, 19}, {3, 10}
    };

    private final boolean[][] walls;
    private final List<Food> foods = new ArrayList<>();

    public GameBoard() {
        walls = new boolean[LAYOUT.length][LAYOUT[0].length()];
        for (int r = 0; r < LAYOUT.length; r++) {
            for (int c = 0; c < LAYOUT[r].length(); c++) {
                walls[r][c] = LAYOUT[r].charAt(c) == '#';
            }
        }
    }

    public int getRows() {
        return walls.length;
    }
    public int getCols() {
        return walls[0].length;
    }

    public boolean isWall(int r, int c) {
        return r < 0 || c < 0 || r >= getRows() || c >= getCols() || walls[r][c];
    }

    public void placeFood(List<int[]> skipCells) {
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                if (walls[r][c]) continue;
                boolean skip = false;
                for (int[] s : skipCells) {
                    if (s[0] == r && s[1] == c) skip = true;
                }
                if (skip) continue;
                foods.add(new Food(r, c, isPowerSpot(r, c)));
            }
        }
    }

    private boolean isPowerSpot(int r, int c) {
        for (int[] p : POWER_SPOTS) {
            if (p[0] == r && p[1] == c) return true;
        }
        return false;
    }

    public Food eatFoodAt(int r, int c) {
        for (Food f : foods) {
            if (!f.isEaten() && f.getRow() == r && f.getColumn() == c) {
                f.eat();
                return f;
            }
        }
        return null;
    }

    public int foodLeft() {
        int count = 0;
        for (Food f : foods) {
            if (!f.isEaten()) count++;
        }
        return count;
    }

    private Food foodAt(int r, int c) {
        for (Food f : foods) {
            if (!f.isEaten() && f.getRow() == r && f.getColumn() == c) return f;
        }
        return null;
    }

    private Ghost ghostAt(List<Ghost> ghosts, int r, int c) {
        for (Ghost g : ghosts) {
            if (g.getRow() == r && g.getCol() == c) return g;
        }
        return null;
    }

    // P = Pacman, G = ghost, g = scared ghost, # = wall, . = food, o = power food
    public void draw(Pacman pacman, List<Ghost> ghosts) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                char ch;
                Ghost g = ghostAt(ghosts, r, c);
                Food f = foodAt(r, c);
                if (r == pacman.getRow() && c == pacman.getColumn()) ch = 'P';
                else if (g != null) ch = g.isScared() ? 'g' : 'G';
                else if (walls[r][c]) ch = '#';
                else if (f != null) ch = f.isPowerFood() ? 'o' : '.';
                else ch = ' ';
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

public class PacmanGame {

    private static final int START_LIVES = 3;
    private static final int DOT_POINTS = 10;
    private static final int POWER_FOOD_POINTS = 50;
    private static final int GHOST_POINTS = 10;
    private static final int POWER_MOVES = 8;   // moves the power lasts

    private enum State { RUNNING, WON, GAME_OVER }

    private final GameBoard board;
    private final Pacman pacman;
    private final List<Ghost> ghosts = new ArrayList<>();
    private State state = State.RUNNING;
    private String message = "";

    public PacmanGame() {
        board = new GameBoard();
        pacman = new Pacman(7, 10, START_LIVES);

        // 4 ghosts, one in each corner
        ghosts.add(new Ghost(1, 1));
        ghosts.add(new Ghost(1, 19));
        ghosts.add(new Ghost(9, 1));
        ghosts.add(new Ghost(9, 19));

        List<int[]> startCells = new ArrayList<>();
        startCells.add(new int[]{7, 10});
        for (Ghost g : ghosts) {
            startCells.add(new int[]{g.getRow(), g.getCol()});
        }
        board.placeFood(startCells);
    }

    // Pacman eats food on the current cell and gets points / power.
    private void handleFood() {
        Food food = board.eatFoodAt(pacman.getRow(), pacman.getColumn());
        if (food == null) return;

        if (food.isPowerFood()) {
            pacman.addScore(POWER_FOOD_POINTS);
            pacman.activatePower(POWER_MOVES);
            for (Ghost g : ghosts) g.setScared(true);
            message = "Power up! Ghosts are scared for " + POWER_MOVES + " moves.";
        } else {
            pacman.addScore(DOT_POINTS);
        }
    }

    // Check if any ghost is on Pacman's cell and react.
    private void handleCollisions() {
        for (Ghost g : ghosts) {
            if (g.getRow() != pacman.getRow() || g.getCol() != pacman.getColumn()) continue;

            if (g.isScared()) {
                pacman.addScore(GHOST_POINTS);
                g.resetPosition();
                message = "You ate a ghost! +" + GHOST_POINTS + " points.";
            } else {
                pacman.loseLife();
                message = "A ghost caught you! Lives left: " + pacman.getLives();
                if (pacman.getLives() <= 0) {
                    state = State.GAME_OVER;
                } else {
                    pacman.resetPosition();
                    for (Ghost other : ghosts) other.resetPosition();
                }
                return;
            }
        }
    }

    private void updatePowerTimer() {
        pacman.tickPower();
        if (!pacman.isPowered()) {
            for (Ghost g : ghosts) g.setScared(false);
        }
    }

    private void render() {
        System.out.print("\033[H\033[2J");   // clear the screen
        System.out.flush();
        board.draw(pacman, ghosts);
        System.out.println("Score: " + pacman.getScore()
                + "   Lives: " + pacman.getLives()
                + "   Food left: " + board.foodLeft());
        if (pacman.isPowered()) {
            System.out.println("POWER: " + pacman.getPowerMovesLeft() + " moves left");
        }
        System.out.println("State: " + state);
        if (!message.isEmpty()) System.out.println(message);
    }

    // Welcome screen: shown once before the game starts.
    private void showWelcome(Scanner scanner) {
        System.out.println("----- Welcome to Java Pac-Man game! -----");
        System.out.println("Controls : W/A/S/D + Enter to move, Q to quit");
        System.out.println("P = you, G = ghost, . = food, o = power food, # = wall");
        System.out.println("Eat all the food to win. You have " + START_LIVES + " lives.");
        System.out.println();
        System.out.print("Press Enter to start...");
        if (scanner.hasNextLine()) scanner.nextLine();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        showWelcome(scanner);
        render();

        while (state == State.RUNNING) {
            System.out.print("Move (W/A/S/D + Enter, Q to quit): ");
            if (!scanner.hasNextLine()) break;
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.isEmpty()) continue;

            char command = input.charAt(0);
            if (command == 'Q') {
                System.out.println("You quit the game.");
                return;
            }
            if ("WASD".indexOf(command) < 0) {
                message = "Invalid input! Use W, A, S, D or Q.";
                render();
                continue;
            }

            message = "";

            // 1. Pacman moves
            boolean moved = pacman.move(command, board);
            if (!moved) message = "Wall! You can't move there.";
            handleFood();
            handleCollisions();

            // 2. Ghosts move
            if (state == State.RUNNING) {
                for (Ghost g : ghosts) g.move(board, pacman);
                handleCollisions();
            }

            // 3. Power timer and win check
            if (state == State.RUNNING) {
                updatePowerTimer();
                if (board.foodLeft() == 0) state = State.WON;
            }

            render();
        }

        if (state == State.WON) {
            System.out.println("YOU WIN! Final score: " + pacman.getScore());
        } else if (state == State.GAME_OVER) {
            System.out.println("GAME OVER! Final score: " + pacman.getScore());
        }
    }

    public static void main(String[] args) {
        new PacmanGame().run();
    }
}

