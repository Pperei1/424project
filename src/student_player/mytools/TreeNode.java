package student_player.mytools;
import hus.HusBoardState;
import hus.HusPlayer;
import hus.HusMove;
import java.util.ArrayList;
import java.lang.Math;
public class TreeNode {

    private int move;
    private TreeNode parent;
    private ArrayList<TreeNode> childs = new ArrayList<TreeNode>;
    private int visit = 0;
    private int value = 0;

    public TreeNode(int move){
    	this.move = move;
    }

    public void addChild(TreeNode child){
    	childs.add(child);
    }

    public void setParent(TreeNode parent){
    	this.parent = parent;
    }

    public int getVisit(){
    	return visit;
    }

    public int getValue(){
    	return value;
    }

    public int getMove(){
    	return move;
    }

    public ArrayList<TreeNode> getChilds(){
    	return childs;
    }

    public int getNumberChild(){
    	return childs.size();
    }

    public TreeNode getBestChild(double C){
    	TreeNode bestNode = childs.get(0);
    	double bestvalue = ucb(bestNode,C);
    	double currenvalue;
    	TreeNode currentNode;
    	for(int i=1;i<childs.size();i++){
    		currentNode = childs.get(i);
    		currentvalue = ucb(currentNode);
    		if(currentvalue>bestvalue){
    			bestvalue = currentvalue;
    			bestNode = currentNode;
    		}
    	}
    	return bestNode;
    }

    private double ucb(TreeNode child,double C){
    	return child.getValue()+C*Math.sqrt(Math.log((double)visit)/(double)child.getVisit());
    }
}
