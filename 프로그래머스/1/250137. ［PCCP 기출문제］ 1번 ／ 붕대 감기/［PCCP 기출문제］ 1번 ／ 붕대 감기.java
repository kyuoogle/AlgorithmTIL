class Solution {
    // 붕대 감기: t초 동안 붕대를 감으면 초당 x만큼 체력 회복
    // 이때 t초 연속으로 붕대 감기 성공 시 추가로 y만큼 체력 회복
    // 캐릭터 별 최대 체력이 존재해 이를 넘어서는 회복은 불가능
    // 기술을 쓸 때 공격 당하면 기술 취소, 체력 회복 불가
    // 공격 당해 기술 취소나 기술이 끝날 시 즉시 붕대 감기 다시 사용 및 연속 성공 시간 0으로 초기화
    // 공격 당하면 피해량 만큼 체력 감소, 현재 체력이 0이 되면 사망
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 몬스터의 공격 시간, 피해량 attacks
        // 모든 공격이 끝난 후 남은 체력 return
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        
        int hp = health; // 현재 체력(시작할 땐 최대 체력으로 시작)
        
        int cnt = 0; // 연속으로 붕대를 감은 시간 카운트
        
        int attackIdx = 0; // 공격이 발생한 시점
        
        int lastAttack = attacks[attacks.length - 1][0]; // 마지막 공격 시간
        // 1초부터 마지막 공격시간까지 반복
        for(int time = 1; time <= lastAttack; time++) {
            // 현재 공격을 당했다면
            if(attackIdx < attacks.length && time == attacks[attackIdx][0]) {
                hp -= attacks[attackIdx][1]; // 피해량만큼 현재 체력에서 뺴기
                cnt = 0; // 스킬 시전 연속 시간 초기화
                // 체력 0되면 사망
                if(hp <= 0) return -1;
                
                attackIdx++;
            } 
            // 공격이 없다면
            else {
                hp += x;
                cnt++;
                if(cnt == t) {
                    hp += y;
                    cnt = 0;
                }
                
                if(hp > health) {
                    hp = health;
                }
            }
        }
        return hp;
    }
}