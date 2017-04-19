package java_algorithm_data;

public class Robot {
 private Position	position; //現在の位置
 private String		name; //名前
 /*
  * ロボットを生成する
  * @param position ロボットがいる位置
  * @param name ロボットの名前
  */
 public Robot(Position position, String name){
	 this.name = name;
	 this.position = position;
 }
 /*
  * x方向にxDeltaだけ移動
  * @param xDelta x方向の移動量
  * 
  */
 public void moveX(int xDelta){
	 position.moveX(xDelta);;
 }
 
 /*
  * y方向にyDeltaだけ移動
  * @param yDelta y方向の移動量
  * 
  */
 public void moveY(int yDelta){
	 position.moveY(yDelta);
 }
 
 /*
  * x方向にxDelta, y方向にyDeltaだけ移動
  * @param xDelta x方向の移動量
  * @param yDelta y方向の移動量
  * 
  */
 public void moveXY(int xDelta, int yDelta){
	 position.moveXY(xDelta, yDelta);
 }
 /*
  * ロボットの名前を得る
  * @return ロボットの名前
  * 
  */ 
 public String getName(){
	 return name;
 }
 
 /*
  * ロボットの位置を得る
  * @return ロボットの位置
  * 
  */ 
 public Position getPosiotion(){
	 return position;
 }
 
 /*
  * ロボットの情報を表す文字列を返す
  * @return ロボットの情報
  * 
  */ 
 public String toString(){
	 return "name: " + name + " position: " + position;
 }
 
 /*
  * ロボットのクローンを作る
  * @return ロボットのクローン
  */
 public Robot makeClone2(){
	 return new Robot(new Position(position.getX(), position.getY()), name + "クローン");
 }
 
 
}
