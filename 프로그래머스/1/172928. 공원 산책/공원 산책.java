class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 현재 위치 저장을 위한 x, y
        int x = 0;
        int y = 0;
        
        // 시작 지점 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                // 시작 지점을 찾으면 현재 위치로 저장
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        // 명령어를 하나씩 확인
        for (int i = 0; i < routes.length; i++) {
            // 명령어를 방향, 거리로 분리
            String[] commands = routes[i].split(" ");
            String dir = commands[0];
            int dist = Integer.parseInt(commands[1]);
            
            // 현재 위치를 기준으로 이동 방향 설정
            int dx = 0;
            int dy = 0;
            
            if (dir.equals("N")) {
                dx = -1;
            } else if (dir.equals("S")) {
                dx = 1;
            } else if (dir.equals("W")) {
                dy = -1;
            } else if (dir.equals("E")) {
                dy = 1;
            }
            
            // 실제 위치를 바로 변경하지 않고 임시 위치에 저장
            int nx = x;
            int ny = y;
            
            // 해당 명령을 수행할 수 있는지 확인하기 위한 변수
            boolean possible = true;
            
            // 명령어의 거리만큼 한 칸씩 이동하면서 확인
            for (int j = 0; j < dist; j++) {
                nx += dx;
                ny += dy;
                
                // 공원 범위를 벗어나면 해당 명령 무시
                if (nx < 0 || nx >= park.length ||
                    ny < 0 || ny >= park[0].length()) {
                    possible = false;
                    break;
                }
                
                // 이동 중 장애물을 만나면 해당 명령 무시
                if (park[nx].charAt(ny) == 'X') {
                    possible = false;
                    break;
                }
            }
            
            // 모든 이동이 가능한 경우에만 실제 현재 위치 갱신
            if (possible) {
                x = nx;
                y = ny;
            }
        }
        
        // 모든 명령 수행 후 최종 위치 반환
        return new int[]{x, y};
    }
}