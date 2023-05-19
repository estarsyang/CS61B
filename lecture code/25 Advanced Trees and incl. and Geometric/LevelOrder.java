/**
 * Traverse top-to-bottom, left-to-right.
 * the nodes are visited in the given order.
 *          D
 *       B      F
 *    A    C  E   G
 */
public class LevelOrder {

    public void levelOrder(Tree T, Action toDo){
        for (int i=0;i < T.height();i++) {
            visitLevel(T, i, toDo);
        }
    }

    public void visitLevel(Tree T, int level, Action toDo) {
        if (T == null) {
            return;
        }
        if (level == 0) {
            toDo.visit(T.key);
        } else {
            visitLevel(T.left, level - 1, toDo);
            visitLevel(T.right, level - 1, toDo);
        }
    }
}
