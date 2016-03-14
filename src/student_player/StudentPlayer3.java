package student_player;

import hus.HusBoardState;
import hus.HusPlayer;
import hus.HusMove;

import java.util.ArrayList;

import student_player.mytools.TreeNode;

/** A Hus player submitted by a student. */
public class StudentPlayer3 extends HusPlayer {

    /** You must modify this constructor to return your student number.
     * This is important, because this is what the code that runs the
     * competition uses to associate you with your agent.
     * The constructor should do nothing else. */
    public StudentPlayer3() { super("xxxxxxxxx"); }

    /** This is the primary method that you need to implement.
     * The ``board_state`` object contains the current state of the game,
     * which your agent can use to make decisions. See the class hus.RandomHusPlayer
     * for another example agent. */
    public HusMove chooseMove(HusBoardState board_state)
    {
        int bestmove = mcsTree((HusBoardState)board_state.clone());
        return board_state.getLegalMoves().get(bestmove);

        // But since this is a placeholder algorithm, we won't act on that information.
    }

    public int mcsTree(HusBoardState board,int iteration){
        double C = 1;
        TreeNode head = new TreeNode(null);
        TreeNode leaf;
        HusBoardState current;
        for(int i=0;i<iteration;i++){
            current = (HusBoardState)board.clone();
            leaf = selection(current,head,C);
        }
    }

    public TreeNode selection(HusBoardState board,TreeNode node,double C){
        if(node.getNumberChild()==0){
            return node;
        }
        else{
            board.move(board.getLegalMove().get(node.getMove()));
            return selection(node.getBestChild(C));
        }
    }
}
