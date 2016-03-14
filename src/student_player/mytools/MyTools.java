package student_player.mytools;
import hus.HusBoardState;
import hus.HusPlayer;
import hus.HusMove;
import java.util.ArrayList;
public class TreeNode {

    private int move;
    private TreeNode parent;
    private ArrayList<TreeNode> childs;
    private int visit = 0;
    private int value = 0;

    public TreeNode(int move){
    	this.move = move;
    	childs = new ArrayList<TreeNode>;
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
}
