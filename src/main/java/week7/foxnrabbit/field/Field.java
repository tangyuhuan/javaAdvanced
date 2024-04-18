package week7.foxnrabbit.field;

import week7.foxnrabbit.cell.Cell;

import java.util.ArrayList;
/*Field类：
属性：长、宽、cell二维数组；
构造方法：生成指定大小cell二维数组；
简单方法：获取长、宽、指定cell;
获取周围细胞方法：输入现在细胞坐标，返回周围细胞数组；
获取周围空cell数组：输入现在细胞坐标，返回空cell坐标数组；
在周围空cell里放置一个cell:
输入现在细胞坐标 和 放入的cell；返回是否成功放入cell进field；
根据坐标删除cell：输入坐标，删除cell(置field数组指空)，返回删除；
根据细胞删除cell：输入细胞，细胞删除(此处可以优化)；
clear方法：删除所有细胞；
move方法：细胞移动；*/

public class Field {
	private int width;
	private int height;
	private Cell[][] field;

	public Field(int width, int height){
		this.height = height;
		this.width = width;
		field = new Cell[height][width];
	}

	public int getWidth(){ return width; }
	public int getHeight(){ return height; }

	public Cell get(int row, int col){
		return field[row][col];
	}

	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for( int i = -1; i<2; i++ ) {
			for( int j = -1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if( r>-1 && r<height && c>-1 && c<width && !(r == row && c == col)) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()-1]);
	}
	//列出周围空cell的数组
	public Location[] getFreeNeighbour(int row, int col) {
		ArrayList<Location> list = new ArrayList<Location>();
		for( int i = -1; i<2; i++ ) {
			for( int j = -1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if( r>-1 && r<height && c>-1 && c<width && field[r][c] == null ) {
					list.add(new Location(r, c));
				}
			}
		}
		return list.toArray(new Location[list.size()]);
	}

	public boolean placeRandomAdj( int row, int col, Cell cell ){
		boolean ret = false;
		Location[] FreeAdj = getFreeNeighbour(row, col);
		if( FreeAdj.length > 0 ){
			int idx = (int)(Math.random()*FreeAdj.length);//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
			field[FreeAdj[idx].getRow()][FreeAdj[idx].getCol()] = cell;
			ret = true;
		}
		return ret;
	}

	public Cell remove(int row, int col ){
		Cell ret = field[row][col];
		field[row][col] = null;
		return ret;
	}

	public void remove( Cell cell ){
		for( int row = 0; row < height; row++ ){
			for( int col = 0; col <width; col++ ){
				if( field[row][col] == cell ){
					field[row][col] = null;
					break;
				}
			}
		}
	}

	public void clear(){
		for( int i = 0; i < height; i++){
			for( int j = 0; j < width; j++){
				field[i][j] = null;
			}
		}
	}

	public void move(int row, int col, Location loc){
		field[loc.getRow()][loc.getCol()] = field[row][col];
		remove(row,col);
	}

	public Cell place(int row, int col, Cell c) {
		Cell ret = field[row][col];
		field[row][col] = c;
		return ret;
	}
}