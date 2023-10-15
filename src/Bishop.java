public class Bishop extends ChessPiece {
    public Bishop(Game_Record game, int index_X, int index_Y) {
        super(game, index_X, index_Y);
    }

    public boolean moveable(int index_X, int index_Y) {
        int deltaX = index_X - this.index_X;
        int deltaY = index_Y - this.index_Y;
        int value = checkIndex(index_X, index_Y);

        if (checkIndex(this.index_X, this.index_Y) > 0) {
            if (deltaX == 0 && deltaY == 0) {
                return false;
            }
            // Right down
            if (deltaX == deltaY && deltaY > 0) {
                for (int i = this.index_Y + 1; i < index_Y; i++) {
                    if (checkIndex(i, i) != 0) {
                        return false;
                    }
                }
                if (value == 0 || value == -1) {
                    return true;
                }
            }
            // Right up
            if (deltaX == -deltaY && deltaY < 0) {
                for (int i = this.index_Y - 1; i < index_Y; i--) {
                    for (int j = this.index_X + 1; j < index_X; j++) {
                        if (checkIndex(i, j) != 0) {
                            return false;
                        }
                    }
                }
                if (value == 0 || value == -1) {
                    return true;
                }
            }
            // Left down
            if (deltaX == -deltaY && deltaX < 0) {
                for (int i = this.index_Y + 1; i < index_Y; i++) {
                    if (checkIndex(7 - i, i) != 0) {
                        return false;
                    }
                }
                if (value == 0 || value == -1) {
                    return true;
                }
            }
            // Left up
            if (deltaX == deltaY && deltaX < 0) {
                for (int i = this.index_Y + 1; i < index_Y; i++) {
                    if (checkIndex(7 - i, 7 - i) != 0) {
                        return false;
                    }
                }
                if (value == 0 || value == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getImage() {
        if (game.boardData[this.index_Y][this.index_X] < 0) {
            return "/Java/src/Grade12/Culminating/images/bb.png";
        }
        return "/Java/src/Grade12/Culminating/images/wb.png";
    }

    public boolean isEmpty() {
        return false;
    }
}
