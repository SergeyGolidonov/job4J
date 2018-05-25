package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {
   private Figure[] figures = new Figure[32];
    private int numberOfFigures = 0;

   public Board() {

   }

    public void addFigure(Figure figure) {
        this.figures[numberOfFigures++] = figure;
    }

   public Figure getFigure(Cell position) {
       Figure result = null;
       int k = 0;
       while (k < this.numberOfFigures) {
           if (figures[k].getPosition().equals(position)) {
               result = figures[k];
               break;
           }
           k++;
       }
       return result;
   }

   public boolean move(Cell source, Cell dest)
           throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
       Figure figure = getFigure(source);
       if (figure == null) {
           throw new FigureNotFoundException();
       }
       int figNumber = 0;
       for(int i = 0; i < this.numberOfFigures; i++) {
           if (this.figures[i] == figure) {
               figNumber = i;
               break;
           }
       }
       Cell[] way = figure.way(dest);
       for (int i = 1; i < way.length; i++) {
           Cell cell = way[i];
           if (getFigure(cell) != null) {
               throw new OccupiedWayException();
           }
       }
       this.figures[figNumber] = figure.copy(dest);
       return true;
   }
}