import java.util.ArrayList;

class Solution {
    int[][] nearIndexes = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    ArrayList<ArrayList<int[]>> boardBlocks = new ArrayList<>();
    ArrayList<ArrayList<int[]>> tableBlocks = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        getBlocks(game_board, boardBlocks, 0);
        getBlocks(table, tableBlocks, 1);
        
        // 일단 boardBlocks 시작점 0,0에 맞추자
        for (ArrayList<int[]> bB: boardBlocks) {
            setNthBlockToZero(bB, 0);
        }
        
        // tableBlocks 중에 boardBlocks 랑 블록 수 같으면
        // tableBlocks 블록 하나하나 (0,0)에 맞춰보고, 그 담에 회전 해보면서 전체 같은지 찾기
        // 찾으면 블록 수 만큼 answer에 추가 아니면 패스
        boolean matched = false;
        ArrayList<int[]> matchedBlock = new ArrayList<>();
        for (ArrayList<int[]> tb : tableBlocks) {
            for (ArrayList<int[]> bB: boardBlocks) {
                if (tb.size() == bB.size()) {
                    for (int i = 0; i<tb.size(); i++) {
                        setNthBlockToZero(tb, i);
                        
                        for (int cnt=0; cnt<4; cnt++) {
                            spinBlock(tb);
                            if(findBlocksSame(tb, bB, tb.size())){
                                matched = true;
                                matchedBlock = bB;
                                break;
                            }
                        }
                        if (matched) break;
                    }
                }
                if (matched) break;
            }
            if (matched) {
                answer += tb.size();
                boardBlocks.remove(matchedBlock);
                matched = false;
            }
        }
        
        return answer;
    }
    
    private void spinBlock(ArrayList<int[]> b) {
        for (int i = 0; i<b.size(); i++) {
            int curX = b.get(i)[0];
            int curY = b.get(i)[1];
            
            b.set(i, new int[]{curY, (-1)*curX});
        }
    }
    
    private ArrayList<int[]> sortedCopy(ArrayList<int[]> src) {
        ArrayList<int[]> copy = new ArrayList<>();
        for (int[] p : src) {
            copy.add(new int[]{p[0], p[1]});
        }

        copy.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return copy;
    }
    
    private boolean findBlocksSame(ArrayList<int[]> b1, ArrayList<int[]> b2, int size) {
        ArrayList<int[]> s1 = sortedCopy(b1);
        ArrayList<int[]> s2 = sortedCopy(b2);
        
        for (int i = 0; i<size; i++) {
            boolean xSame = s1.get(i)[0] == s2.get(i)[0];
            boolean ySame = s1.get(i)[1] == s2.get(i)[1];
            if (!xSame || !ySame) return false;
        }
        
        return true;
    }
    
    private void setNthBlockToZero(ArrayList<int[]> block, int n) {
        int length = block.size();
        if (n<0 || n>=length) return;

        int firstBlockX = block.get(n)[0];
        int firstBlockY = block.get(n)[1];

        for (int i=0; i<length; i++) {
            int newX = block.get(i)[0] - firstBlockX;
            int newY = block.get(i)[1] - firstBlockY;

            block.set(i, new int[]{newX, newY});
        }
    }
    
    private void dfsPutBlocks(
        int[][] board, int curX, int curY, int toFind, ArrayList<int[]> block
    ) {
        if (curX<0 || curY<0 || curX>=board.length || curY>=board.length) return;
        if (board[curX][curY] != toFind) return;
        
        block.add(new int[]{curX, curY});
        
        board[curX][curY] = -1;
        
        for (int[] index : nearIndexes) {
            dfsPutBlocks(board, curX+index[0], curY+index[1], toFind, block);
        }
    }
    
    private void getBlocks(int[][] board, ArrayList<ArrayList<int[]>> _Blocks, int findNum) {
        int length = board.length;
        
        for (int i = 0; i<length; i++) {
            for (int j = 0; j<length; j++) {
                if (board[i][j] != findNum) {
                    continue;
                }
                
                ArrayList<int[]> block = new ArrayList<>();
                dfsPutBlocks(board, i, j, findNum, block);
                _Blocks.add(block);
            }
        }
    }
    
    private void printBlocks(ArrayList<ArrayList<int[]>> _Blocks) {
        for (int i = 0; i < _Blocks.size(); i++) {
            ArrayList<int[]> block = _Blocks.get(i);
            System.out.print("Block " + i + ": [");
            for (int k = 0; k < block.size(); k++) {
                int[] p = block.get(k);
                System.out.print("[" + p[0] + ", " + p[1] + "]");
                if (k < block.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}