package minesweeper

import java.util.*
import kotlin.system.exitProcess

const val mine = 'X'
const val unexploredCell = '.'
const val exploredFreeCell = '/'
const val markedCell = '*'
const val boardSize = 9

fun main() {
    val scanner = Scanner(System.`in`)

    print("How many mines do you want on the field?")

    val numberOfMines = scanner.nextInt()

//    val minesweeperGame = MinesweeperGame(1)
    val minesweeperGame = MinesweeperGame(numberOfMines)

    do {
        print("Set/unset mines marks or claim a cell as free:")
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val command = scanner.next()
        val victory = minesweeperGame.checkCoordinates(x, y, command)
    } while (!victory)

    print("Congratulations! You found all the mines!")
}


class MinesweeperGame(val numberOfMines: Int) {

    private lateinit var mineFieldWithMines : Array<CharArray>
    private lateinit var board : Array<CharArray>

    init {
        val mineFieldInitial = generateMinefield(boardSize, boardSize, numberOfMines)
//    val mineField = generateMinefield(9, 9, numberOfMines)
         mineFieldWithMines = displayNumberOfMines(mineFieldInitial)

        val mineFieldWithHiddenMines = hideMines(mineFieldWithMines)
        val mineFieldWithGrid = addGridFor(mineFieldWithHiddenMines)
        val startingBoard = emptyMinefield(mineFieldInitial)

        printMineField(mineFieldInitial)


//        printMineField(mineFieldWithMines)


//        printMineField(mineFieldWithHiddenMines)

//        printMineField(mineFieldWithGrid)

        board = startingBoard
//        board = mineFieldWithHiddenMines

    printMineField(addGridFor(board))
    }

    // Public

    fun checkCoordinates(x: Int, y: Int, command: String): Boolean {

        var mine: Boolean
        mine = checkIfMine(x,y)

        when (command) {
            "free" -> {
                if (mine) {
                    gameOver()
                }
            }
            "mine" -> {}
            else -> {}
        }
        markCoordinates(x,y)

        printMineField(addGridFor(board))

        if (mine) gameOver()

        return board.contentDeepEquals(mineFieldWithMines)
    }

    // Private methods

    private fun markCoordinates(x: Int, y: Int) {
        when (board[y-1][x-1]) {
               unexploredCell -> board[y - 1][x - 1] = markedCell
            markedCell -> board[y - 1][x - 1] = unexploredCell
            else -> println("There is a number here!")
        }
    }

    private fun checkIfMine(x: Int, y: Int): Boolean {
        return mineFieldWithMines[y-1][x-1] == mine
    }

    private fun gameOver() {
        print("You stepped on a mine and failed!")
        exitProcess(0)
    }

    private fun emptyMinefield(mineField: Array<CharArray>): Array<CharArray> {
        var board = Array(mineField.size) { CharArray(mineField[0].size) { 'W' } }

        for (yC in board.indices) {
            for (xC in board[0].indices) {
                    board[xC][yC] = unexploredCell
            }
        }

        return board
    }

    private fun hideMines(mineField: Array<CharArray>): Array<CharArray> {
        var board = Array(mineField.size) { CharArray(mineField[0].size) { 'W' } }

        for (yC in board.indices) {
            for (xC in board[0].indices) {
                if (mineField[xC][yC] == mine) {
                    board[xC][yC] = unexploredCell
                } else {
                    board[xC][yC] = mineField[xC][yC]
                }
            }
        }

        return board
    }

    private fun addGridFor(mineField: Array<CharArray>): Array<CharArray> {
        var board = Array(mineField.size+3) { CharArray(mineField[0].size+3) { '.' } }

        for (yC in board.indices) {
            when (yC) {
                // first line
                0 -> {
                    for (xC in mineField[0].indices) {
                        when (xC) {
                            0 -> {
                                board[yC][xC] = ' '
                                board[yC][xC + 1] = '│'
                                for (i in 1..mineField[0].size) {
                                    board[yC][i + 1] = i.toString()[0]
                                }
                                board[yC][board.lastIndex] = '│'
                            }
                        }
                    }
                }
                // second line
                1 -> {
                    for (xC in mineField[0].indices) {
                        when (xC) {
                            0 -> {
                                board[yC][xC] = '-'
                                board[yC][xC + 1] = '│'
                                for (i in 1..mineField[0].size) {
                                    board[yC][i + 1] = '-'
                                }
                                board[yC][board.lastIndex] = '│'
                            }
                        }
                    }
                }
                // bottom line
                board.lastIndex -> {
                    for (xC in mineField[0].indices) {
                        when (xC) {
                            0 -> {
                                board[yC][xC] = '-'
                                board[yC][xC + 1] = '│'
                                for (i in 1..mineField[0].size) {
                                    board[yC][i + 1] = '-'
                                }
                                board[yC][board.lastIndex] = '│'
                            }
                        }
                    }
                }
                // mine field lines
                else -> {
                    for (xC in board[0].indices) {
                        when (xC) {
                            0 -> {
                                board[yC][xC] = (yC-1).toString()[0]
                            }
                            1 -> {
                                board[yC][xC] = '│'
                            }
                            board[0].lastIndex -> {
                                board[yC][board.lastIndex] = '│'
                            }
                            // just copy all from mineField
                            else -> {
                                board[yC][xC] = mineField[yC-2][xC-2]
                            }
                        }
                    }
                }
            }
        }

        return board
//            .toTypedArray()
    }

    private fun displayNumberOfMines(mineField: Array<CharArray>): Array<CharArray> {
        var board = Array(mineField.size) { CharArray(mineField[0].size) { unexploredCell } }

        for (yC in mineField.indices) {
            for (xC in mineField[0].indices) {

                var mineCount = 0

                if (mineField[xC][yC] != mine) {
                    when {
                        mineField.size == 1 -> {

                        }
                        // corners
                        yC == 0 && xC == 0 -> {
                            if (mineField[xC + 1][yC] == mine) mineCount++
                            if (mineField[xC + 1][yC + 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                        }
                        yC == 0 && xC == mineField[0].lastIndex -> {
                            if (mineField[xC - 1][yC] == mine) mineCount++
                            if (mineField[xC - 1][yC + 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                        }
                        yC == mineField.lastIndex && xC == 0 -> {
                            if (mineField[xC][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC] == mine) mineCount++
                        }
                        yC == mineField.lastIndex && xC == mineField[0].lastIndex -> {
                            if (mineField[xC - 1][yC] == mine) mineCount++
                            if (mineField[xC - 1][yC - 1] == mine) mineCount++
                            if (mineField[xC][yC - 1] == mine) mineCount++
                        }
                        // sides
                        yC == 0 -> {
                            if (mineField[xC + 1][yC] == mine) mineCount++
                            if (mineField[xC + 1][yC + 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC] == mine) mineCount++
                        }
                        yC == mineField.lastIndex -> {
                            if (mineField[xC - 1][yC - 1] == mine) mineCount++
                            if (mineField[xC][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC] == mine) mineCount++
                            if (mineField[xC - 1][yC] == mine) mineCount++
                        }
                        xC == 0 -> {
                            if (mineField[xC][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC] == mine) mineCount++
                            if (mineField[xC + 1][yC + 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                        }
                        xC == mineField[0].lastIndex -> {
                            if (mineField[xC - 1][yC - 1] == mine) mineCount++
                            if (mineField[xC][yC - 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC] == mine) mineCount++
                        }
                        else -> {
                            if (mineField[xC - 1][yC - 1] == mine) mineCount++
                            if (mineField[xC][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC - 1] == mine) mineCount++
                            if (mineField[xC + 1][yC] == mine) mineCount++
                            if (mineField[xC + 1][yC + 1] == mine) mineCount++
                            if (mineField[xC][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC + 1] == mine) mineCount++
                            if (mineField[xC - 1][yC] == mine) mineCount++
                        }
                    }

                    if (mineCount != 0) {
                        board[xC][yC] = mineCount.toString()[0]
                    }
                }
                else {
                    board[xC][yC] = mineField[xC][yC]
                }
            }
        }

        return board
    }

    private fun generateMinefield(x: Int, y: Int, mines: Int): Array<CharArray> {
        lateinit var board: Array<CharArray>

        do {
            var minesOnField = 0
            board = Array(y) { CharArray(x) { '.' } }
            for (yC in 0 until y) {
                for (xC in 0 until x) {
                    if ((0..((board.size - 1) * (board.size - 1))).random() < mines && minesOnField <= mines) {
                        minesOnField++
                        board[yC][xC] = mine
                    } else
                        board[yC][xC] = unexploredCell
                }
            }
        } while (minesOnField != mines)

        return board
    }

    private fun printMineField(mineField: Array<CharArray>) {
        for (yC in 0 until mineField.size) {
            for (xC in 0 until mineField[0].size) {
                print(mineField[yC][xC])
            }
            println()
        }
    }
}
