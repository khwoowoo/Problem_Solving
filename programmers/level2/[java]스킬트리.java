class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(char c : skill_tree.toCharArray()){
                if(skill.contains(String.valueOf(c))){
                    sb.append(c);
                }
            
            }
            if(skill.startsWith(sb.toString())){
                answer++;
            }
        }
        
        return answer;
    }
}
