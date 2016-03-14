package student_player;

import hus.HusBoardState;
import hus.HusPlayer;
import hus.HusMove;

import java.util.ArrayList;

import student_player.mytools.MyTools;

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
        int bestmove = minimax((HusBoardState)board_state.clone(),true,0,4,0,73);
        return board_state.getLegalMoves().get(bestmove);

        // But since this is a placeholder algorithm, we won't act on that information.
    }

    public int minimax(HusBoardState board,boolean max,int depth,int maxdepth,int alpha,int beta){
        if(depth < maxdepth){
            ArrayList<HusMove> moves = board.getLegalMoves();
            if(moves.size()==0 && max){
                return 0;
            }
            else if(moves.size()==0 && !max){
                return 73;
            }
            HusBoardState current;
            int bestmove = 0;
            int currentvalue;
            for(int i=0;i<moves.size();i++){
                current = (HusBoardState)board.clone();
                current.move(moves.get(i));
                currentvalue = minimax(current,!max,depth+1,maxdepth,alpha,beta);
                if(max){
                    if(alpha<currentvalue){
                        alpha = currentvalue;
                        bestmove = i;
                    }
                    if(alpha>=beta){
                        if(depth == 0){
                            return i;
                        }
                        else{
                            return beta;
                        }
                    }
                }
                else{ 
                    if(beta>currentvalue){
                        beta = currentvalue;
                    }
                    if(alpha>=beta){
                        return alpha;
                    }
                }
            }
            if(depth == 0){
                return bestmove;
            }
            else{
                if(max){
                    return alpha;
                }
                else{
                    return beta;
                }
            }
        }
        else{
            return score(board.getPits()[player_id]);
        }
    }

    public int score(int[] pits){
        int score = 0;
        for(int i=0;i<pits.length;i++){
            score += pits[i];
        }
        return score;
    }
}
