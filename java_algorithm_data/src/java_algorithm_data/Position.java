package java_algorithm_data;

public class Position {
 private int x; //x座標
 private int y; //y座標
 /*
  * 位置を生成する
  * @param x x座標
  * @param y y座標
  * 
  */
 public Position(int x, int y){
	 this.x = x;
	 this.y = y;
 }
 
 /*
  * x方向にxDeltaだけ移動
  * @param xDelta x方向の移動量
  * 
  */
 public void moveX(int xDelta){
	 x += xDelta;
 }
 
 /*
  * y方向にyDeltaだけ移動
  * @param yDelta y方向の移動量
  * 
  */
 public void moveY(int yDelta){
	 y += yDelta;
 }
 
 /*
  * x方向にxDelta, y方向にyDeltaだけ移動
  * @param xDelta x方向の移動量
  * @param yDelta y方向の移動量
  * 
  */
 public void moveXY(int xDelta, int yDelta){
	 x += xDelta;
	 y += yDelta;
 }
 /*
  * x座標を得る
  * @return X座標 
  */
 public int getX(){
	 return x;
 }
 
 /*
  * y座標を得る
  * @return Y座標 
  */
 public int getY(){
	 return y;
 }
 
 /*
  * 位置を表す文字列を返す
  * @return 位置を表す文字列 
  */
 public String toString(){
	 return "(" + x + ", " + y + ")";
 }
}
